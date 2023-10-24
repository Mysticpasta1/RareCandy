// automatically generated by the FlatBuffers compiler, do not modify

package gg.generations.rarecandy.pokeutils.GFLib.Anim;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Animation extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static Animation getRootAsAnimation(ByteBuffer _bb) { return getRootAsAnimation(_bb, new Animation()); }
  public static Animation getRootAsAnimation(ByteBuffer _bb, Animation obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Animation __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public Info info() { return info(new Info()); }
  public Info info(Info obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public BoneAnimation skeleton() { return skeleton(new BoneAnimation()); }
  public BoneAnimation skeleton(BoneAnimation obj) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public MaterialAnimation material() { return material(new MaterialAnimation()); }
  public MaterialAnimation material(MaterialAnimation obj) { int o = __offset(8); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public SkinAnimation visibility() { return visibility(new SkinAnimation()); }
  public SkinAnimation visibility(SkinAnimation obj) { int o = __offset(10); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public CommandAnimation eventData() { return eventData(new CommandAnimation()); }
  public CommandAnimation eventData(CommandAnimation obj) { int o = __offset(12); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createAnimation(FlatBufferBuilder builder,
      int infoOffset,
      int skeletonOffset,
      int materialOffset,
      int visibilityOffset,
      int eventDataOffset) {
    builder.startTable(5);
    Animation.addEventData(builder, eventDataOffset);
    Animation.addVisibility(builder, visibilityOffset);
    Animation.addMaterial(builder, materialOffset);
    Animation.addSkeleton(builder, skeletonOffset);
    Animation.addInfo(builder, infoOffset);
    return Animation.endAnimation(builder);
  }

  public static void startAnimation(FlatBufferBuilder builder) { builder.startTable(5); }
  public static void addInfo(FlatBufferBuilder builder, int infoOffset) { builder.addOffset(0, infoOffset, 0); }
  public static void addSkeleton(FlatBufferBuilder builder, int skeletonOffset) { builder.addOffset(1, skeletonOffset, 0); }
  public static void addMaterial(FlatBufferBuilder builder, int materialOffset) { builder.addOffset(2, materialOffset, 0); }
  public static void addVisibility(FlatBufferBuilder builder, int visibilityOffset) { builder.addOffset(3, visibilityOffset, 0); }
  public static void addEventData(FlatBufferBuilder builder, int eventDataOffset) { builder.addOffset(4, eventDataOffset, 0); }
  public static int endAnimation(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }
  public static void finishAnimationBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedAnimationBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Animation get(int j) { return get(new Animation(), j); }
    public Animation get(Animation obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public AnimationT unpack() {
    AnimationT _o = new AnimationT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(AnimationT _o) {
    if (info() != null) _o.setInfo(info().unpack());
    else _o.setInfo(null);
    if (skeleton() != null) _o.setSkeleton(skeleton().unpack());
    else _o.setSkeleton(null);
    if (material() != null) _o.setMaterial(material().unpack());
    else _o.setMaterial(null);
    if (visibility() != null) _o.setVisibility(visibility().unpack());
    else _o.setVisibility(null);
    if (eventData() != null) _o.setEventData(eventData().unpack());
    else _o.setEventData(null);
  }
  public static int pack(FlatBufferBuilder builder, AnimationT _o) {
    if (_o == null) return 0;
    int _info = _o.getInfo() == null ? 0 : Info.pack(builder, _o.getInfo());
    int _skeleton = _o.getSkeleton() == null ? 0 : BoneAnimation.pack(builder, _o.getSkeleton());
    int _material = _o.getMaterial() == null ? 0 : MaterialAnimation.pack(builder, _o.getMaterial());
    int _visibility = _o.getVisibility() == null ? 0 : SkinAnimation.pack(builder, _o.getVisibility());
    int _eventData = _o.getEventData() == null ? 0 : CommandAnimation.pack(builder, _o.getEventData());
    return createAnimation(
      builder,
      _info,
      _skeleton,
      _material,
      _visibility,
      _eventData);
  }
}

