// automatically generated by the FlatBuffers compiler, do not modify

package com.riiablo.net.packet.d2gs;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class PositionP extends Table {
  public static PositionP getRootAsPositionP(ByteBuffer _bb) { return getRootAsPositionP(_bb, new PositionP()); }
  public static PositionP getRootAsPositionP(ByteBuffer _bb, PositionP obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public PositionP __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public float x() { int o = __offset(4); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float y() { int o = __offset(6); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }

  public static int createPositionP(FlatBufferBuilder builder,
      float x,
      float y) {
    builder.startObject(2);
    PositionP.addY(builder, y);
    PositionP.addX(builder, x);
    return PositionP.endPositionP(builder);
  }

  public static void startPositionP(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addX(FlatBufferBuilder builder, float x) { builder.addFloat(0, x, 0.0f); }
  public static void addY(FlatBufferBuilder builder, float y) { builder.addFloat(1, y, 0.0f); }
  public static int endPositionP(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

