// automatically generated by the FlatBuffers compiler, do not modify

package com.pokemod.miraidon;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Struct;

import java.nio.ByteBuffer;

@SuppressWarnings("unused")
public final class Transform extends Struct {
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Transform __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public com.pokemod.miraidon.Vec3f scale() { return scale(new com.pokemod.miraidon.Vec3f()); }
  public com.pokemod.miraidon.Vec3f scale(com.pokemod.miraidon.Vec3f obj) { return obj.__assign(bb_pos + 0, bb); }
  public com.pokemod.miraidon.Vec4f rotate() { return rotate(new com.pokemod.miraidon.Vec4f()); }
  public com.pokemod.miraidon.Vec4f rotate(com.pokemod.miraidon.Vec4f obj) { return obj.__assign(bb_pos + 12, bb); }
  public com.pokemod.miraidon.Vec3f translate() { return translate(new com.pokemod.miraidon.Vec3f()); }
  public com.pokemod.miraidon.Vec3f translate(com.pokemod.miraidon.Vec3f obj) { return obj.__assign(bb_pos + 28, bb); }

  public static int createTransform(FlatBufferBuilder builder, float scale_x, float scale_y, float scale_z, float rotate_x, float rotate_y, float rotate_z, float rotate_w, float translate_x, float translate_y, float translate_z) {
    builder.prep(4, 40);
    builder.prep(4, 12);
    builder.putFloat(translate_z);
    builder.putFloat(translate_y);
    builder.putFloat(translate_x);
    builder.prep(4, 16);
    builder.putFloat(rotate_w);
    builder.putFloat(rotate_z);
    builder.putFloat(rotate_y);
    builder.putFloat(rotate_x);
    builder.prep(4, 12);
    builder.putFloat(scale_z);
    builder.putFloat(scale_y);
    builder.putFloat(scale_x);
    return builder.offset();
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Transform get(int j) { return get(new Transform(), j); }
    public Transform get(Transform obj, int j) {  return obj.__assign(__element(j), bb); }
  }
}

