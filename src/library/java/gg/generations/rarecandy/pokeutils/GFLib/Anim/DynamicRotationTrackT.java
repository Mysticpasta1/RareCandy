// automatically generated by the FlatBuffers compiler, do not modify

package gg.generations.rarecandy.pokeutils.GFLib.Anim;

import gg.generations.rarecandy.renderer.animation.TranmUtil;
import gg.generations.rarecandy.renderer.animation.TransformStorage;
import org.joml.Quaternionf;

public class DynamicRotationTrackT implements RotationTrackUnion.TrackProcesser<Quaternionf> {
  private sVec3T[] co;

  public sVec3T[] getCo() { return co; }

  public void setCo(sVec3T[] co) { this.co = co; }


  public DynamicRotationTrackT() {
    this.co = null;
  }

  @Override
  public void process(TransformStorage<Quaternionf> rotationKeys) {
    for (int i = 0; i < co.length; i++) {
      var vec = co[i];
      rotationKeys.add(i, TranmUtil.packedToQuat((short) vec.getX(), (short) vec.getY(), (short) vec.getZ()));
    }
  }
}

