package gg.generations.rarecandy.pokeutils.tracl;// automatically generated by the FlatBuffers compiler, do not modify

import com.google.flatbuffers.FlatBufferBuilder;

import java.nio.ByteBuffer;

public class TRACLT {
  private Node_RootT root;

  public Node_RootT getRoot() { return root; }

  public void setRoot(Node_RootT root) { this.root = root; }


  public TRACLT() {
    this.root = null;
  }
  public static TRACLT deserializeFromBinary(byte[] fbBuffer) {
    return TRACL.getRootAsTRACL(ByteBuffer.wrap(fbBuffer)).unpack();
  }
  public byte[] serializeToBinary() {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    TRACL.finishTRACLBuffer(fbb, TRACL.pack(fbb, this));
    return fbb.sizedByteArray();
  }
}

