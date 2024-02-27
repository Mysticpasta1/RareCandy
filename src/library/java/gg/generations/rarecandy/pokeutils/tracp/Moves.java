package gg.generations.rarecandy.pokeutils.tracp;// automatically generated by the FlatBuffers compiler, do not modify

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
public final class Moves extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static Moves getRootAsMoves(ByteBuffer _bb) { return getRootAsMoves(_bb, new Moves()); }
  public static Moves getRootAsMoves(ByteBuffer _bb, Moves obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Moves __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public float x() { int o = __offset(6); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float y() { int o = __offset(8); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float z() { int o = __offset(10); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }

  public static int createMoves(FlatBufferBuilder builder,
      int nameOffset,
      float x,
      float y,
      float z) {
    builder.startTable(4);
    Moves.addZ(builder, z);
    Moves.addY(builder, y);
    Moves.addX(builder, x);
    Moves.addName(builder, nameOffset);
    return Moves.endMoves(builder);
  }

  public static void startMoves(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addX(FlatBufferBuilder builder, float x) { builder.addFloat(1, x, 0.0f); }
  public static void addY(FlatBufferBuilder builder, float y) { builder.addFloat(2, y, 0.0f); }
  public static void addZ(FlatBufferBuilder builder, float z) { builder.addFloat(3, z, 0.0f); }
  public static int endMoves(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Moves get(int j) { return get(new Moves(), j); }
    public Moves get(Moves obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public MovesT unpack() {
    MovesT _o = new MovesT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(MovesT _o) {
    String _oName = name();
    _o.setName(_oName);
    float _oX = x();
    _o.setX(_oX);
    float _oY = y();
    _o.setY(_oY);
    float _oZ = z();
    _o.setZ(_oZ);
  }
  public static int pack(FlatBufferBuilder builder, MovesT _o) {
    if (_o == null) return 0;
    int _name = _o.getName() == null ? 0 : builder.createString(_o.getName());
    return createMoves(
      builder,
      _name,
      _o.getX(),
      _o.getY(),
      _o.getZ());
  }
}

