// automatically generated by the FlatBuffers compiler, do not modify

package gg.generations.rarecandy.pokeutils.tracn;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class TRACN extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static TRACN getRootAsTRACN(ByteBuffer _bb) { return getRootAsTRACN(_bb, new TRACN()); }
  public static TRACN getRootAsTRACN(ByteBuffer _bb, TRACN obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public TRACN __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public AnimationEntry list(int j) { return list(new AnimationEntry(), j); }
  public AnimationEntry list(AnimationEntry obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int listLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public AnimationEntry.Vector listVector() { return listVector(new AnimationEntry.Vector()); }
  public AnimationEntry.Vector listVector(AnimationEntry.Vector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }

  public static int createTRACN(FlatBufferBuilder builder,
      int listOffset) {
    builder.startTable(1);
    TRACN.addList(builder, listOffset);
    return TRACN.endTRACN(builder);
  }

  public static void startTRACN(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addList(FlatBufferBuilder builder, int listOffset) { builder.addOffset(0, listOffset, 0); }
  public static int createListVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startListVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endTRACN(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }
  public static void finishTRACNBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedTRACNBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public TRACN get(int j) { return get(new TRACN(), j); }
    public TRACN get(TRACN obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public TRACNT unpack() {
    TRACNT _o = new TRACNT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(TRACNT _o) {
    AnimationEntryT[] _oList = new AnimationEntryT[listLength()];
    for (int _j = 0; _j < listLength(); ++_j) {_oList[_j] = (list(_j) != null ? list(_j).unpack() : null);}
    _o.setList(_oList);
  }
  public static int pack(FlatBufferBuilder builder, TRACNT _o) {
    if (_o == null) return 0;
    int _list = 0;
    if (_o.getList() != null) {
      int[] __list = new int[_o.getList().length];
      int _j = 0;
      for (AnimationEntryT _e : _o.getList()) { __list[_j] = AnimationEntry.pack(builder, _e); _j++;}
      _list = createListVector(builder, __list);
    }
    return createTRACN(
      builder,
      _list);
  }
}

