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
public final class BoneAnimation extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static BoneAnimation getRootAsBoneAnimation(ByteBuffer _bb) { return getRootAsBoneAnimation(_bb, new BoneAnimation()); }
  public static BoneAnimation getRootAsBoneAnimation(ByteBuffer _bb, BoneAnimation obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public BoneAnimation __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public BoneTrack tracks(int j) { return tracks(new BoneTrack(), j); }
  public BoneTrack tracks(BoneTrack obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int tracksLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public BoneTrack.Vector tracksVector() { return tracksVector(new BoneTrack.Vector()); }
  public BoneTrack.Vector tracksVector(BoneTrack.Vector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }
  public BoneInit initData() { return initData(new BoneInit()); }
  public BoneInit initData(BoneInit obj) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createBoneAnimation(FlatBufferBuilder builder,
      int tracksOffset,
      int initDataOffset) {
    builder.startTable(2);
    BoneAnimation.addInitData(builder, initDataOffset);
    BoneAnimation.addTracks(builder, tracksOffset);
    return BoneAnimation.endBoneAnimation(builder);
  }

  public static void startBoneAnimation(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addTracks(FlatBufferBuilder builder, int tracksOffset) { builder.addOffset(0, tracksOffset, 0); }
  public static int createTracksVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startTracksVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addInitData(FlatBufferBuilder builder, int initDataOffset) { builder.addOffset(1, initDataOffset, 0); }
  public static int endBoneAnimation(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public BoneAnimation get(int j) { return get(new BoneAnimation(), j); }
    public BoneAnimation get(BoneAnimation obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public BoneAnimationT unpack() {
    BoneAnimationT _o = new BoneAnimationT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(BoneAnimationT _o) {
    BoneTrackT[] _oTracks = new BoneTrackT[tracksLength()];
    for (int _j = 0; _j < tracksLength(); ++_j) {_oTracks[_j] = (tracks(_j) != null ? tracks(_j).unpack() : null);}
    _o.setTracks(_oTracks);
    if (initData() != null) _o.setInitData(initData().unpack());
    else _o.setInitData(null);
  }
  public static int pack(FlatBufferBuilder builder, BoneAnimationT _o) {
    if (_o == null) return 0;
    int _tracks = 0;
    if (_o.getTracks() != null) {
      int[] __tracks = new int[_o.getTracks().length];
      int _j = 0;
      for (BoneTrackT _e : _o.getTracks()) { __tracks[_j] = BoneTrack.pack(builder, _e); _j++;}
      _tracks = createTracksVector(builder, __tracks);
    }
    int _initData = _o.getInitData() == null ? 0 : BoneInit.pack(builder, _o.getInitData());
    return createBoneAnimation(
      builder,
      _tracks,
      _initData);
  }
}

