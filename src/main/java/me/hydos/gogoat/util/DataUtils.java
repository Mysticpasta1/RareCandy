package me.hydos.gogoat.util;

import de.javagl.jgltf.model.*;
import de.javagl.jgltf.model.impl.DefaultBufferModel;
import de.javagl.jgltf.model.impl.DefaultBufferViewModel;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL15;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class DataUtils {
    private static final Map<BufferViewModel, Integer> BUFFER_VIEW_MODEL_TO_GL_BUFFER_VIEW = new IdentityHashMap<>();
    private static final List<Integer> bufferViews = new ArrayList<>();

    public static Matrix4fc convert(float[] translation, float[] rotation, float[] scale) {
        Matrix4f transformMatrix = new Matrix4f().identity();
        if (translation != null) transformMatrix.translate(translation[0], translation[1], translation[2]);
        if (rotation != null) transformMatrix.rotate(rotation[0], rotation[1], rotation[2], rotation[3]);
        if (scale != null) transformMatrix.scale(scale[0], scale[1], scale[2]);

        return transformMatrix;
    }

    public static Matrix4f convert(float[] arr) {
        if (arr == null) return new Matrix4f().identity();

        if (arr.length == 16) {
            return new Matrix4f()
                    .m00(arr[0])
                    .m01(arr[1])
                    .m02(arr[2])
                    .m03(arr[3])

                    .m10(arr[4])
                    .m11(arr[5])
                    .m12(arr[6])
                    .m13(arr[7])

                    .m20(arr[8])
                    .m21(arr[9])
                    .m22(arr[10])
                    .m23(arr[11])

                    .m30(arr[12])
                    .m31(arr[13])
                    .m32(arr[14])
                    .m33(arr[15]);
        }

        throw new RuntimeException("Cant handle transformation with " + arr.length + " floats. Need 16");
    }

    public static void bindArrayBuffer(BufferViewModel bufferViewModel) {
        var glBufferView = BUFFER_VIEW_MODEL_TO_GL_BUFFER_VIEW.get(bufferViewModel);

        if (glBufferView == null) {
            glBufferView = GL15.glGenBuffers();
            bufferViews.add(glBufferView);
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, glBufferView);
            GL15.glBufferData(GL15.GL_ARRAY_BUFFER, makeDirect(bufferViewModel.getBufferViewData()), GL15.GL_STATIC_DRAW);
            BUFFER_VIEW_MODEL_TO_GL_BUFFER_VIEW.put(bufferViewModel, glBufferView);
        } else {
            GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, glBufferView);
        }
    }

    public static ByteBuffer makeDirect(ByteBuffer javaBuffer) {
        var directBuffer = MemoryUtil.memAlloc(javaBuffer.capacity());

        for (var i = 0; i < javaBuffer.capacity(); i++) {
            directBuffer.put(javaBuffer.get());
        }

        directBuffer.flip();
        return directBuffer;
    }

    private static DefaultBufferViewModel createBufferViewModel(String uriString, ByteBuffer bufferData) {
        var bufferModel = new DefaultBufferModel();
        bufferModel.setUri(uriString);
        bufferModel.setBufferData(bufferData);

        var bufferViewModel = new DefaultBufferViewModel(null);
        bufferViewModel.setByteOffset(0);
        bufferViewModel.setByteLength(bufferData.capacity());
        bufferViewModel.setBufferModel(bufferModel);

        return bufferViewModel;
    }

    public static float[] scale(float[] arr, float factor) {
        var result = new float[arr.length];

        for (var i = 0; i < arr.length; i++) {
            result[i] = arr[i] * factor;
        }

        return result;
    }

    public static float computeLength(float arr[]) {
        float sum = 0;
        for (var v : arr) {
            sum += v * v;
        }
        return (float) Math.sqrt(sum);
    }

    public void close() {
        for (var bufferId : bufferViews) GL15.glDeleteBuffers(bufferId);
    }
}