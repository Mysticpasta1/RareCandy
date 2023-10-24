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
public final class DynamicBooleanTrack extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static DynamicBooleanTrack getRootAsDynamicBooleanTrack(ByteBuffer _bb) { return getRootAsDynamicBooleanTrack(_bb, new DynamicBooleanTrack()); }
  public static DynamicBooleanTrack getRootAsDynamicBooleanTrack(ByteBuffer _bb, DynamicBooleanTrack obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public DynamicBooleanTrack __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public boolean bool(int j) { int o = __offset(4); return o != 0 ? 0!=bb.get(__vector(o) + j * 1) : false; }
  public int boolLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public BooleanVector boolVector() { return boolVector(new BooleanVector()); }
  public BooleanVector boolVector(BooleanVector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer boolAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer boolInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }

  public static int createDynamicBooleanTrack(FlatBufferBuilder builder,
      int boolOffset) {
    builder.startTable(1);
    DynamicBooleanTrack.addBool(builder, boolOffset);
    return DynamicBooleanTrack.endDynamicBooleanTrack(builder);
  }

  public static void startDynamicBooleanTrack(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addBool(FlatBufferBuilder builder, int boolOffset) { builder.addOffset(0, boolOffset, 0); }
  public static int createBoolVector(FlatBufferBuilder builder, boolean[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addBoolean(data[i]); return builder.endVector(); }
  public static void startBoolVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static int endDynamicBooleanTrack(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public DynamicBooleanTrack get(int j) { return get(new DynamicBooleanTrack(), j); }
    public DynamicBooleanTrack get(DynamicBooleanTrack obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public DynamicBooleanTrackT unpack() {
    DynamicBooleanTrackT _o = new DynamicBooleanTrackT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(DynamicBooleanTrackT _o) {
    boolean[] _oBool = new boolean[boolLength()];
    for (int _j = 0; _j < boolLength(); ++_j) {_oBool[_j] = bool(_j);}
    _o.setBool(_oBool);
  }
  public static int pack(FlatBufferBuilder builder, DynamicBooleanTrackT _o) {
    if (_o == null) return 0;
    int _bool = 0;
    if (_o.getBool() != null) {
      _bool = createBoolVector(builder, _o.getBool());
    }
    return createDynamicBooleanTrack(
      builder,
      _bool);
  }
}

