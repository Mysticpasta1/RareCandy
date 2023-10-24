// automatically generated by the FlatBuffers compiler, do not modify

package gg.generations.rarecandy.pokeutils.GFLib.Anim;

import com.google.flatbuffers.FlatBufferBuilder;
import org.joml.Vector3f;

public class VectorTrackUnion {
  private byte type;
  private RotationTrackUnion.TrackProcesser<Vector3f> value;

  public byte getType() { return type; }

  public void setType(byte type) { this.type = type; }

  public RotationTrackUnion.TrackProcesser<Vector3f> getValue() { return value; }

  public void setValue(RotationTrackUnion.TrackProcesser<Vector3f> value) { this.value = value; }

  public VectorTrackUnion() {
    this.type = VectorTrack.NONE;
    this.value = null;
  }

  public FixedVectorTrackT asFixedVectorTrack() { return (FixedVectorTrackT) value; }
  public DynamicVectorTrackT asDynamicVectorTrack() { return (DynamicVectorTrackT) value; }
  public Framed16VectorTrackT asFramed16VectorTrack() { return (Framed16VectorTrackT) value; }
  public Framed8VectorTrackT asFramed8VectorTrack() { return (Framed8VectorTrackT) value; }

  public static int pack(FlatBufferBuilder builder, VectorTrackUnion _o) {
    switch (_o.type) {
      case VectorTrack.FixedVectorTrack: return FixedVectorTrack.pack(builder, _o.asFixedVectorTrack());
      case VectorTrack.DynamicVectorTrack: return DynamicVectorTrack.pack(builder, _o.asDynamicVectorTrack());
      case VectorTrack.Framed16VectorTrack: return Framed16VectorTrack.pack(builder, _o.asFramed16VectorTrack());
      case VectorTrack.Framed8VectorTrack: return Framed8VectorTrack.pack(builder, _o.asFramed8VectorTrack());
      default: return 0;
    }
  }
}

