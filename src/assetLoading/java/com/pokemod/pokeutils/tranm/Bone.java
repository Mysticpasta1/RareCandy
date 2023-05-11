// automatically generated by the FlatBuffers compiler, do not modify

package com.pokemod.pokeutils.tranm;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Bone extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_3_3(); }
  public static Bone getRootAsBone(ByteBuffer _bb) { return getRootAsBone(_bb, new Bone()); }
  public static Bone getRootAsBone(ByteBuffer _bb, Bone obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Bone __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public byte scaleType() { int o = __offset(6); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public Table scale(Table obj) { int o = __offset(8); return o != 0 ? __union(obj, o + bb_pos) : null; }
  public byte rotType() { int o = __offset(10); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public Table rot(Table obj) { int o = __offset(12); return o != 0 ? __union(obj, o + bb_pos) : null; }
  public byte transType() { int o = __offset(14); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public Table trans(Table obj) { int o = __offset(16); return o != 0 ? __union(obj, o + bb_pos) : null; }

  public static int createBone(FlatBufferBuilder builder,
      int nameOffset,
      byte scaleType,
      int scaleOffset,
      byte rotType,
      int rotOffset,
      byte transType,
      int transOffset) {
    builder.startTable(7);
    Bone.addTrans(builder, transOffset);
    Bone.addRot(builder, rotOffset);
    Bone.addScale(builder, scaleOffset);
    Bone.addName(builder, nameOffset);
    Bone.addTransType(builder, transType);
    Bone.addRotType(builder, rotType);
    Bone.addScaleType(builder, scaleType);
    return Bone.endBone(builder);
  }

  public static void startBone(FlatBufferBuilder builder) { builder.startTable(7); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addScaleType(FlatBufferBuilder builder, byte scaleType) { builder.addByte(1, scaleType, 0); }
  public static void addScale(FlatBufferBuilder builder, int scaleOffset) { builder.addOffset(2, scaleOffset, 0); }
  public static void addRotType(FlatBufferBuilder builder, byte rotType) { builder.addByte(3, rotType, 0); }
  public static void addRot(FlatBufferBuilder builder, int rotOffset) { builder.addOffset(4, rotOffset, 0); }
  public static void addTransType(FlatBufferBuilder builder, byte transType) { builder.addByte(5, transType, 0); }
  public static void addTrans(FlatBufferBuilder builder, int transOffset) { builder.addOffset(6, transOffset, 0); }
  public static int endBone(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Bone get(int j) { return get(new Bone(), j); }
    public Bone get(Bone obj, int j) {  return obj.__assign(Table.__indirect(__element(j), bb), bb); }
  }
}

