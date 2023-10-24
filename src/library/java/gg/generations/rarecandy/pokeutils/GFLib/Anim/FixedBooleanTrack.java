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
public final class FixedBooleanTrack extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static FixedBooleanTrack getRootAsFixedBooleanTrack(ByteBuffer _bb) { return getRootAsFixedBooleanTrack(_bb, new FixedBooleanTrack()); }
  public static FixedBooleanTrack getRootAsFixedBooleanTrack(ByteBuffer _bb, FixedBooleanTrack obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public FixedBooleanTrack __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean bool() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static int createFixedBooleanTrack(FlatBufferBuilder builder,
      boolean bool) {
    builder.startTable(1);
    FixedBooleanTrack.addBool(builder, bool);
    return FixedBooleanTrack.endFixedBooleanTrack(builder);
  }

  public static void startFixedBooleanTrack(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addBool(FlatBufferBuilder builder, boolean bool) { builder.addBoolean(0, bool, false); }
  public static int endFixedBooleanTrack(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public FixedBooleanTrack get(int j) { return get(new FixedBooleanTrack(), j); }
    public FixedBooleanTrack get(FixedBooleanTrack obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public FixedBooleanTrackT unpack() {
    FixedBooleanTrackT _o = new FixedBooleanTrackT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(FixedBooleanTrackT _o) {
    boolean _oBool = bool();
    _o.setBool(_oBool);
  }
  public static int pack(FlatBufferBuilder builder, FixedBooleanTrackT _o) {
    if (_o == null) return 0;
    return createFixedBooleanTrack(
      builder,
      _o.getBool());
  }
}

