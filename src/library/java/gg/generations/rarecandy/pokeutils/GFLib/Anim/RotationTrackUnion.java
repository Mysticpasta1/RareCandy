// automatically generated by the FlatBuffers compiler, do not modify

package gg.generations.rarecandy.pokeutils.GFLib.Anim;

import com.google.flatbuffers.FlatBufferBuilder;
import org.joml.Quaternionf;

public class RotationTrackUnion {
  private byte type;
  private TrackProcesser<Quaternionf> value;

  public byte getType() { return type; }

  public void setType(byte type) { this.type = type; }

  public TrackProcesser<Quaternionf> getValue() { return value; }

  public void setValue(TrackProcesser<Quaternionf> value) { this.value = value; }

  public RotationTrackUnion() {
    this.type = RotationTrack.NONE;
    this.value = null;
  }

  public FixedRotationTrackT asFixedRotationTrack() { return (FixedRotationTrackT) value; }
  public DynamicRotationTrackT asDynamicRotationTrack() { return (DynamicRotationTrackT) value; }
  public Framed16RotationTrackT asFramed16RotationTrack() { return (Framed16RotationTrackT) value; }
  public Framed8RotationTrackT asFramed8RotationTrack() { return (Framed8RotationTrackT) value; }

  public static int pack(FlatBufferBuilder builder, RotationTrackUnion _o) {
      return switch (_o.type) {
          case RotationTrack.FixedRotationTrack -> FixedRotationTrack.pack(builder, _o.asFixedRotationTrack());
          case RotationTrack.DynamicRotationTrack -> DynamicRotationTrack.pack(builder, _o.asDynamicRotationTrack());
          case RotationTrack.Framed16RotationTrack -> Framed16RotationTrack.pack(builder, _o.asFramed16RotationTrack());
          case RotationTrack.Framed8RotationTrack -> Framed8RotationTrack.pack(builder, _o.asFramed8RotationTrack());
          default -> 0;
      };
  }

}

