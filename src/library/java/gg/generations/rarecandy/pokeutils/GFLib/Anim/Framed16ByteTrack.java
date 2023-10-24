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
public final class Framed16ByteTrack extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static Framed16ByteTrack getRootAsFramed16ByteTrack(ByteBuffer _bb) { return getRootAsFramed16ByteTrack(_bb, new Framed16ByteTrack()); }
  public static Framed16ByteTrack getRootAsFramed16ByteTrack(ByteBuffer _bb, Framed16ByteTrack obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Framed16ByteTrack __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int frames(int j) { int o = __offset(4); return o != 0 ? bb.getShort(__vector(o) + j * 2) & 0xFFFF : 0; }
  public int framesLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public ShortVector framesVector() { return framesVector(new ShortVector()); }
  public ShortVector framesVector(ShortVector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer framesAsByteBuffer() { return __vector_as_bytebuffer(4, 2); }
  public ByteBuffer framesInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 2); }
  public int byte_(int j) { int o = __offset(6); return o != 0 ? bb.get(__vector(o) + j * 1) & 0xFF : 0; }
  public int byte_Length() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public ByteVector byteVector() { return byteVector(new ByteVector()); }
  public ByteVector byteVector(ByteVector obj) { int o = __offset(6); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer byte_AsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer byte_InByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }

  public static int createFramed16ByteTrack(FlatBufferBuilder builder,
      int framesOffset,
      int byte_Offset) {
    builder.startTable(2);
    Framed16ByteTrack.addByte(builder, byte_Offset);
    Framed16ByteTrack.addFrames(builder, framesOffset);
    return Framed16ByteTrack.endFramed16ByteTrack(builder);
  }

  public static void startFramed16ByteTrack(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addFrames(FlatBufferBuilder builder, int framesOffset) { builder.addOffset(0, framesOffset, 0); }
  public static int createFramesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(2, data.length, 2); for (int i = data.length - 1; i >= 0; i--) builder.addShort((short) data[i]); return builder.endVector(); }
  public static void startFramesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(2, numElems, 2); }
  public static void addByte(FlatBufferBuilder builder, int byte_Offset) { builder.addOffset(1, byte_Offset, 0); }
  public static int createByteVector(FlatBufferBuilder builder, byte[] data) { return builder.createByteVector(data); }
  public static int createByteVector(FlatBufferBuilder builder, ByteBuffer data) { return builder.createByteVector(data); }
  public static void startByteVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static int endFramed16ByteTrack(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Framed16ByteTrack get(int j) { return get(new Framed16ByteTrack(), j); }
    public Framed16ByteTrack get(Framed16ByteTrack obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
  public Framed16ByteTrackT unpack() {
    Framed16ByteTrackT _o = new Framed16ByteTrackT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(Framed16ByteTrackT _o) {
    int[] _oFrames = new int[framesLength()];
    for (int _j = 0; _j < framesLength(); ++_j) {_oFrames[_j] = frames(_j);}
    _o.setFrames(_oFrames);
    int[] _oByte = new int[byte_Length()];
    for (int _j = 0; _j < byte_Length(); ++_j) {_oByte[_j] = byte_(_j);}
    _o.setByte(_oByte);
  }
  public static int pack(FlatBufferBuilder builder, Framed16ByteTrackT _o) {
    if (_o == null) return 0;
    int _frames = 0;
    if (_o.getFrames() != null) {
      _frames = createFramesVector(builder, _o.getFrames());
    }
    int _byte_ = 0;
    if (_o.getByte() != null) {
      byte[] __byte_ = new byte[_o.getByte().length];
      int _j = 0;
      for (int _e : _o.getByte()) { __byte_[_j] = (byte) _e; _j++;}
      _byte_ = createByteVector(builder, __byte_);
    }
    return createFramed16ByteTrack(
      builder,
      _frames,
      _byte_);
  }
}

