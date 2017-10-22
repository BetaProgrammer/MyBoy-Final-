package yass.tawakadziruni.com.myboyremake;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by T on 2017/10/21.
 */

class Photo extends Drawable {
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mPhotoId = NO_IMAGE_PROVIDED;
    private Drawable mThePhoto;


    public Photo(int PhotoId, Drawable ThePhoto) {
        mThePhoto = ThePhoto;
        mPhotoId = PhotoId;

    }

    public Photo(Drawable ThePhoto) {
        mThePhoto = ThePhoto;
    }

    public Photo(int PhotoId) {
        mPhotoId = PhotoId;
    }

    public Drawable getThePhoto() {
        return mThePhoto;
    }

    public int getPhotoId() {
        return mPhotoId;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {

    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
