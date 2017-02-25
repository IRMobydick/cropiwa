package com.steelkiwi.cropiwa.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * @author arolegovich
 * 25.02.2017.
 */

public class CropArea {

    public static CropArea create(RectF coordinateSystem, RectF imageRect, RectF cropRect) {
        return new CropArea(
                moveRectToCoordinateSystem(coordinateSystem, imageRect),
                moveRectToCoordinateSystem(coordinateSystem, cropRect));
    }

    private static Rect moveRectToCoordinateSystem(RectF system, RectF rect) {
        float originX = system.left, originY = system.top;
        return new Rect(
                Math.round(rect.left - originX), Math.round(rect.top - originY),
                Math.round(rect.right - originX), Math.round(rect.bottom - originY));
    }

    private Rect imageRect;
    private Rect cropRect;

    public CropArea(Rect imageRect, Rect cropRect) {
        this.imageRect = imageRect;
        this.cropRect = cropRect;
    }

    public Bitmap applyCropTo(Bitmap bitmap) {
        float slopeX = imageRect.width() / bitmap.getWidth();
        float slopeY = imageRect.height() / bitmap.getHeight();
        return Bitmap.createBitmap(bitmap,
                map(slopeX, cropRect.left), map(slopeY, cropRect.top),
                map(slopeX, cropRect.width()), map(slopeY, cropRect.height()));
    }

    private int map(float slope, int coord) {
        return Math.round(coord / slope);
    }

}

