// automatically generated by the FlatBuffers compiler, do not modify

package gg.generations.rarecandy.pokeutils.GFLib.Anim;

import gg.generations.rarecandy.renderer.animation.TransformStorage;

public class Framed8FloatTrackT implements TrackProcesser<Float> {
  private int[] frames;
  private float[] float_;

  public int[] getFrames() { return frames; }

  public void setFrames(int[] frames) { this.frames = frames; }

  public float[] getFloat() { return float_; }

  public void setFloat(float[] float_) { this.float_ = float_; }


  public Framed8FloatTrackT() {
    this.frames = null;
    this.float_ = null;
  }

  @Override
  public void process(TransformStorage<Float> rotationKeys) {
    var frames = getFrames();
    for (int i = 0; i < getFrames().length; i++) {
      var vec = getFloat()[i];
      rotationKeys.add(frames[i], vec);
    }
  }
}

