package gg.generations.rarecandy.pokeutils.tracs;// automatically generated by the FlatBuffers compiler, do not modify

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class TopState extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static TopState getRootAsTopState(ByteBuffer _bb) { return getRootAsTopState(_bb, new TopState()); }
  public static TopState getRootAsTopState(ByteBuffer _bb, TopState obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public TopState __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public State payload() { return payload(new State()); }
  public State payload(State obj) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createTopState(FlatBufferBuilder builder,
      int nameOffset,
      int payloadOffset) {
    builder.startTable(2);
    TopState.addPayload(builder, payloadOffset);
    TopState.addName(builder, nameOffset);
    return TopState.endTopState(builder);
  }

  public static void startTopState(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addPayload(FlatBufferBuilder builder, int payloadOffset) { builder.addOffset(1, payloadOffset, 0); }
  public static int endTopState(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public TopState get(int j) { return get(new TopState(), j); }
    public TopState get(TopState obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public TopStateT unpack() {
    TopStateT _o = new TopStateT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(TopStateT _o) {
    String _oName = name();
    _o.setName(_oName);
    if (payload() != null) _o.setPayload(payload().unpack());
    else _o.setPayload(null);
  }
  public static int pack(FlatBufferBuilder builder, TopStateT _o) {
    if (_o == null) return 0;
    int _name = _o.getName() == null ? 0 : builder.createString(_o.getName());
    int _payload = _o.getPayload() == null ? 0 : State.pack(builder, _o.getPayload());
    return createTopState(
      builder,
      _name,
      _payload);
  }
}
