package gg.generations.rarecandy.pokeutils.smdi;// automatically generated by the FlatBuffers compiler, do not modify

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class BoneState extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static BoneState getRootAsBoneState(ByteBuffer _bb) { return getRootAsBoneState(_bb, new BoneState()); }
  public static BoneState getRootAsBoneState(ByteBuffer _bb, BoneState obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public BoneState __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int bone() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public float posX() { int o = __offset(6); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float posY() { int o = __offset(8); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float posZ() { int o = __offset(10); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float rotX() { int o = __offset(12); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float rotY() { int o = __offset(14); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float rotZ() { int o = __offset(16); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }

  public static int createBoneState(FlatBufferBuilder builder,
      int bone,
      float posX,
      float posY,
      float posZ,
      float rotX,
      float rotY,
      float rotZ) {
    builder.startTable(7);
    BoneState.addRotZ(builder, rotZ);
    BoneState.addRotY(builder, rotY);
    BoneState.addRotX(builder, rotX);
    BoneState.addPosZ(builder, posZ);
    BoneState.addPosY(builder, posY);
    BoneState.addPosX(builder, posX);
    BoneState.addBone(builder, bone);
    return BoneState.endBoneState(builder);
  }

  public static void startBoneState(FlatBufferBuilder builder) { builder.startTable(7); }
  public static void addBone(FlatBufferBuilder builder, int bone) { builder.addInt(0, bone, 0); }
  public static void addPosX(FlatBufferBuilder builder, float posX) { builder.addFloat(1, posX, 0.0f); }
  public static void addPosY(FlatBufferBuilder builder, float posY) { builder.addFloat(2, posY, 0.0f); }
  public static void addPosZ(FlatBufferBuilder builder, float posZ) { builder.addFloat(3, posZ, 0.0f); }
  public static void addRotX(FlatBufferBuilder builder, float rotX) { builder.addFloat(4, rotX, 0.0f); }
  public static void addRotY(FlatBufferBuilder builder, float rotY) { builder.addFloat(5, rotY, 0.0f); }
  public static void addRotZ(FlatBufferBuilder builder, float rotZ) { builder.addFloat(6, rotZ, 0.0f); }
  public static int endBoneState(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public BoneState get(int j) { return get(new BoneState(), j); }
    public BoneState get(BoneState obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public BoneStateT unpack() {
    BoneStateT _o = new BoneStateT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(BoneStateT _o) {
    int _oBone = bone();
    _o.setBone(_oBone);
    float _oPosX = posX();
    _o.setPosX(_oPosX);
    float _oPosY = posY();
    _o.setPosY(_oPosY);
    float _oPosZ = posZ();
    _o.setPosZ(_oPosZ);
    float _oRotX = rotX();
    _o.setRotX(_oRotX);
    float _oRotY = rotY();
    _o.setRotY(_oRotY);
    float _oRotZ = rotZ();
    _o.setRotZ(_oRotZ);
  }
  public static int pack(FlatBufferBuilder builder, BoneStateT _o) {
    if (_o == null) return 0;
    return createBoneState(
      builder,
      _o.getBone(),
      _o.getPosX(),
      _o.getPosY(),
      _o.getPosZ(),
      _o.getRotX(),
      _o.getRotY(),
      _o.getRotZ());
  }
}
