package com.pixelmongenerations.rarecandy.components;

import com.pixelmongenerations.pkl.scene.material.Texture;
import com.pixelmongenerations.pkl.scene.objects.Mesh;
import com.pixelmongenerations.rarecandy.rendering.VertexLayout;
import com.pixelmongenerations.rarecandy.pipeline.Pipeline;
import com.pixelmongenerations.rarecandy.rendering.InstanceState;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.GL15C;

import java.util.List;

public class Solid extends MeshRenderObject {

    private VertexLayout layout;

    @Override
    public void upload(Mesh mesh, Pipeline pipeline, List<Texture> diffuseTextures) {
        super.upload(mesh, pipeline, diffuseTextures);

        this.layout = new VertexLayout(vao,
                new VertexLayout.AttribLayout(3, GL11C.GL_FLOAT, "inPosition"),
                new VertexLayout.AttribLayout(2, GL11C.GL_FLOAT, "inTexCoords"),
                new VertexLayout.AttribLayout(3, GL11C.GL_FLOAT, "inNormal")
        );
    }

    @Override
    public void render(List<InstanceState> instances) {
        this.pipeline.bind();
        this.layout.bind();
        GL15C.glBindBuffer(GL15C.GL_ELEMENT_ARRAY_BUFFER, this.ebo);

        for (InstanceState instance : instances) {
            pipeline.updateUniforms(instance, this);
            GL11C.glDrawElements(GL11C.GL_TRIANGLES, this.indexCount, GL11C.GL_UNSIGNED_INT, 0);
        }
    }
}
