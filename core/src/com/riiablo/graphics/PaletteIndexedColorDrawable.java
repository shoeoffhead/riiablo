package com.riiablo.graphics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.riiablo.Riiablo;

public class PaletteIndexedColorDrawable extends TextureRegionDrawable {
  public static final PaletteIndexedColorDrawable MODAL_FONT16 = new PaletteIndexedColorDrawable(Riiablo.colors.modal75) {{
    final float PADDING = 6;
    setLeftWidth(PADDING);
    setTopHeight(PADDING - 2); // font16 has extra top padding, changing this would require propagating elsewhere
    setRightWidth(PADDING);
    setBottomHeight(PADDING);
  }};

  public Color tint;

  public PaletteIndexedColorDrawable(Color color) {
    super(Riiablo.textures.white);
    this.tint = color;
  }

  @Override
  public void setLeftWidth(float leftWidth) {
    super.setLeftWidth(leftWidth);
    setMinWidth(getLeftWidth() + getRightWidth());
  }

  @Override
  public void setRightWidth(float rightWidth) {
    super.setRightWidth(rightWidth);
    setMinWidth(getLeftWidth() + getRightWidth());
  }

  @Override
  public void setTopHeight(float topHeight) {
    super.setTopHeight(topHeight);
    setMinHeight(getTopHeight() + getBottomHeight());
  }

  @Override
  public void setBottomHeight(float bottomHeight) {
    super.setBottomHeight(bottomHeight);
    setMinHeight(getTopHeight() + getBottomHeight());
  }

  @Override
  public void draw(Batch batch, float x, float y, float width, float height) {
    if (!(batch instanceof PaletteIndexedBatch)) {
      // unsupported, will draw white for now
      super.draw(batch, x, y, width, height);
      return;
    }

    PaletteIndexedBatch b = (PaletteIndexedBatch) batch;
    b.setBlendMode(BlendMode.SOLID, tint);
    super.draw(batch, x, y, width, height);
    b.resetBlendMode();
  }

  @Override
  public void draw(Batch batch, float x, float y, float originX, float originY, float width,
                   float height, float scaleX, float scaleY, float rotation) {
    if (!(batch instanceof PaletteIndexedBatch)) {
      // unsupported, will draw white for now
      super.draw(batch, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
      return;
    }

    PaletteIndexedBatch b = (PaletteIndexedBatch) batch;
    b.setBlendMode(BlendMode.SOLID, tint);
    super.draw(batch, x, y, originX, originY, width, height, scaleX, scaleY, rotation);
    b.resetBlendMode();
  }
}
