package com.pixelmongenerations.rarecandy.rendering.shader;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;

public class Uniform {
    private static final FloatBuffer MAT4_TRANSFER_BUFFER = MemoryUtil.memAllocFloat(16);
    private static final FloatBuffer VEC3_TRANSFER_BUFFER = MemoryUtil.memAllocFloat(3);
    public final int type;
    public final int count;
    private final int[] uniformLocations;

    public Uniform(int program, String name, int type, int count) {
        this.type = type;
        this.count = count;
        this.uniformLocations = new int[count];

        if (count > 1) {
            for (int i = 0; i < count; i++) {
                uniformLocations[i] = GL20C.glGetUniformLocation(program, name + "[" + i + "]");
            }
        } else {
            uniformLocations[0] = GL20C.glGetUniformLocation(program, name);
        }
    }

    public void uploadMat4f(Matrix4f value) {
        value.get(MAT4_TRANSFER_BUFFER);
        GL20C.glUniformMatrix4fv(getLocation(), false, MAT4_TRANSFER_BUFFER);
    }

    public void uploadMat4fs(Matrix4f[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i].get(MAT4_TRANSFER_BUFFER);
            GL20C.glUniformMatrix4fv(getArrayLocation(i), false, MAT4_TRANSFER_BUFFER);
        }
    }

    public void uploadVec3f(Vector3f value) {
        value.get(VEC3_TRANSFER_BUFFER);
        GL20C.glUniform3fv(getLocation(), VEC3_TRANSFER_BUFFER);
    }

    public void uploadInt(int value) {
        GL20C.glUniform1i(getLocation(), value);
    }

    public void uploadFloat(float value) {
        GL20C.glUniform1f(getLocation(), value);
    }

    private int getArrayLocation(int offset) {
        if (offset > uniformLocations.length) {
            throw new RuntimeException("Tried to get a uniform location for a place outside of the array. Array length is " + uniformLocations.length + ", But we got " + offset);
        }

        return uniformLocations[offset];
    }

    private int getLocation() {
        if (uniformLocations.length > 1) {
            throw new RuntimeException("Tried to get single uniform location when the Uniform is an array? This is most likely an error.");
        }

        return uniformLocations[0];
    }
}
