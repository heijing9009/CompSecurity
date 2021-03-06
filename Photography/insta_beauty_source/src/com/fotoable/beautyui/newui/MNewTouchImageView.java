// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import adi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import aqe;
import java.io.PrintStream;
import vo;
import vp;
import vq;
import vr;
import yp;

public class MNewTouchImageView extends ImageView
{

    static final int CLICK = 5;
    private boolean canDoZoom;
    private boolean isTwoFingerTouch;
    private PointF last;
    private vq mListener;
    private ScaleGestureDetector mScaleDetector;
    private Matrix matrix;
    private float maxScale;
    private float minScale;
    private TouchState mode;
    private int oldMeasuredHeight;
    private int oldMeasuredWidth;
    private float origHeight;
    private float origWidth;
    private float saveScale;
    private PointF start;
    private double twoFingerDistanceLas;
    private double twoFingerDistancePre;
    private int viewHeight;
    private int viewWidth;

    public MNewTouchImageView(Context context)
    {
        super(context);
        mode = TouchState.NONE;
        last = new PointF();
        start = new PointF();
        minScale = 1.0F;
        maxScale = 6F;
        saveScale = 1.0F;
        isTwoFingerTouch = false;
        twoFingerDistancePre = 0.0D;
        twoFingerDistanceLas = 0.0D;
        canDoZoom = true;
        sharedConstructing(context);
    }

    public MNewTouchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mode = TouchState.NONE;
        last = new PointF();
        start = new PointF();
        minScale = 1.0F;
        maxScale = 6F;
        saveScale = 1.0F;
        isTwoFingerTouch = false;
        twoFingerDistancePre = 0.0D;
        twoFingerDistanceLas = 0.0D;
        canDoZoom = true;
        sharedConstructing(context);
    }

    private PointF getCurRectSpace()
    {
        PointF pointf = new PointF(0.0F, 0.0F);
        RectF rectf = getDisplayRect(matrix);
        float f = rectf.bottom - rectf.top;
        float f1 = rectf.right - rectf.left;
        if (f1 < (float)viewWidth)
        {
            pointf.x = ((float)viewWidth - f1) / 2.0F;
        }
        if (f < (float)viewHeight)
        {
            pointf.y = ((float)viewHeight - f) / 2.0F;
        }
        return pointf;
    }

    private PointF getOutEdgePOint()
    {
        boolean flag3 = true;
        PointF pointf = getCurRectSpace();
        RectF rectf = getDisplayRect(getImageMatrix());
        float f;
        float f1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (rectf.left > pointf.x)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (rectf.top > pointf.y)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (rectf.bottom < (float)viewHeight - pointf.y)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (rectf.right >= (float)viewWidth - pointf.x)
        {
            flag3 = false;
        }
        if (flag)
        {
            f = rectf.left - getCurRectSpace().x;
        } else
        {
            f = 0.0F;
        }
        if (flag3)
        {
            f1 = (rectf.right - (float)viewWidth) + getCurRectSpace().x;
        } else
        {
            f1 = f;
        }
        if (flag2)
        {
            f = (rectf.bottom - (float)viewHeight) + getCurRectSpace().y;
        } else
        {
            f = 0.0F;
        }
        if (flag1)
        {
            f = rectf.top - getCurRectSpace().y;
        }
        return new PointF(f1, f);
    }

    private void setOriginState(float f)
    {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0)
        {
            return;
        } else
        {
            int i = drawable.getIntrinsicWidth();
            int j = drawable.getIntrinsicHeight();
            matrix.reset();
            matrix.postScale(f, f);
            float f3 = viewHeight;
            float f4 = j;
            float f1 = viewWidth;
            float f2 = i;
            f3 = (f3 - f4 * f) / 2.0F;
            f = (f1 - f2 * f) / 2.0F;
            matrix.postTranslate(f, f3);
            origWidth = (float)viewWidth - f * 2.0F;
            origHeight = (float)viewHeight - f3 * 2.0F;
            setImageMatrix(matrix);
            invalidate();
            return;
        }
    }

    private void sharedConstructing(Context context)
    {
        super.setClickable(true);
        mScaleDetector = new ScaleGestureDetector(context, new vp(this, null));
        matrix = new Matrix();
        setImageMatrix(matrix);
        setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
    }

    public float getCurImageScale()
    {
        float af[] = new float[9];
        matrix.getValues(af);
        System.out.println((new StringBuilder()).append("matrixscale:").append(af[0]).toString());
        return af[0];
    }

    public RectF getDisplayRect(Matrix matrix1)
    {
        RectF rectf = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            rectf.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix1.mapRect(rectf);
            return rectf;
        } else
        {
            return null;
        }
    }

    public aqe getDisplaySize()
    {
        RectF rectf = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            rectf.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectf);
            return new aqe((int)rectf.width(), (int)rectf.height());
        } else
        {
            return new aqe(0, 0);
        }
    }

    public adi getImagePt(Point point)
    {
        if (getDrawable() != null)
        {
            Object obj = ((BitmapDrawable)getDrawable()).getBitmap();
            int i = ((Bitmap) (obj)).getWidth();
            int j = ((Bitmap) (obj)).getHeight();
            obj = new RectF(0.0F, 0.0F, i, j);
            getImageMatrix().mapRect(((RectF) (obj)));
            point = new PointF((float)point.x - ((RectF) (obj)).left, (float)point.y - ((RectF) (obj)).top);
            float f = (float)i / ((RectF) (obj)).width();
            obj = new adi();
            ((adi) (obj)).a(((PointF) (point)).x * f);
            ((adi) (obj)).b(f * ((PointF) (point)).y);
            return ((adi) (obj));
        } else
        {
            return new adi();
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        viewWidth = getWidth();
        viewHeight = getHeight();
        if (oldMeasuredHeight == viewWidth && oldMeasuredHeight == viewHeight || viewWidth == 0 || viewHeight == 0)
        {
            return;
        } else
        {
            oldMeasuredHeight = viewHeight;
            oldMeasuredWidth = viewWidth;
            return;
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        viewWidth = getWidth();
        viewHeight = getHeight();
        if ((oldMeasuredHeight != viewWidth || oldMeasuredHeight != viewHeight) && viewWidth != 0 && viewHeight != 0)
        {
            oldMeasuredHeight = viewHeight;
            oldMeasuredWidth = viewWidth;
            if (saveScale == 1.0F)
            {
                Drawable drawable = getDrawable();
                if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0)
                {
                    setOriginState(Math.min((float)viewWidth / (float)getDrawable().getIntrinsicWidth(), (float)viewHeight / (float)getDrawable().getIntrinsicHeight()));
                    return;
                }
            }
        }
    }

    public void resetSaveScale()
    {
        saveScale = 1.0F;
    }

    public void setCanZoom(boolean flag)
    {
        canDoZoom = flag;
    }

    public void setListener(vq vq1)
    {
        mListener = vq1;
    }

    public void setMaxZoom(float f)
    {
        maxScale = f;
    }

    public void setMinZoom(float f)
    {
        saveScale = saveScale * f;
        minScale = f;
        setOriginState(f);
    }

    public void setViewTouchEvent(MotionEvent motionevent)
    {
        PointF pointf;
        Object obj;
        mScaleDetector.onTouchEvent(motionevent);
        pointf = new PointF(motionevent.getX(), motionevent.getY());
        obj = new Matrix();
        getImageMatrix().invert(((Matrix) (obj)));
        float af[] = new float[2];
        af[0] = motionevent.getX();
        af[1] = motionevent.getY();
        ((Matrix) (obj)).mapPoints(af);
        obj = new PointF(af[0], af[1]);
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 120
    //                   0 140
    //                   1 545
    //                   2 218;
           goto _L1 _L2 _L3 _L4
_L1:
        mode = TouchState.NONE;
_L6:
        setImageMatrix(matrix);
        invalidate();
        return;
_L2:
        last.set(pointf);
        start.set(last);
        mode = TouchState.DRAG;
        isTwoFingerTouch = false;
        if (motionevent.getPointerCount() == 1)
        {
            if (!canDoZoom && mListener != null)
            {
                mListener.b(pointf, ((PointF) (obj)));
            }
        } else
        {
            isTwoFingerTouch = true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        float f = pointf.x - last.x;
        float f1 = pointf.y - last.y;
        if (mode == TouchState.DRAG)
        {
            if (motionevent.getPointerCount() >= 2)
            {
                isTwoFingerTouch = true;
                if (twoFingerDistancePre == 0.0D)
                {
                    twoFingerDistancePre = Math.sqrt((motionevent.getX(0) - motionevent.getX(1)) * (motionevent.getX(0) - motionevent.getX(1)) + (motionevent.getY(0) - motionevent.getY(1)) * (motionevent.getY(0) - motionevent.getY(1)));
                } else
                {
                    twoFingerDistanceLas = Math.sqrt((motionevent.getX(0) - motionevent.getX(1)) * (motionevent.getX(0) - motionevent.getX(1)) + (motionevent.getY(0) - motionevent.getY(1)) * (motionevent.getY(0) - motionevent.getY(1)));
                }
                if (twoFingerDistanceLas != 0.0D && Math.abs(twoFingerDistanceLas - twoFingerDistancePre) < (double)yp.a(getContext(), 2.0F))
                {
                    matrix.postTranslate(f, f1);
                }
                if (twoFingerDistanceLas != 0.0D)
                {
                    twoFingerDistancePre = twoFingerDistanceLas;
                }
                if (mListener != null && !canDoZoom)
                {
                    mListener.a();
                }
            } else
            if (!isTwoFingerTouch)
            {
                if (canDoZoom)
                {
                    matrix.postTranslate(f, f1);
                } else
                if (mListener != null)
                {
                    mListener.a(pointf, ((PointF) (obj)));
                }
            }
            last.set(pointf.x, pointf.y);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        mode = TouchState.NONE;
        if (getCurImageScale() >= minScale || getCurRectSpace().x == 0.0F && getCurRectSpace().y == 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        motionevent = getDisplayRect(matrix);
        post(new vo(this, getCurImageScale(), minScale, motionevent.centerX(), motionevent.centerY()));
_L7:
        int i = (int)Math.abs(pointf.x - start.x);
        int j = (int)Math.abs(pointf.y - start.y);
        if (i < 5 && j < 5)
        {
            performClick();
        }
        if (!isTwoFingerTouch && !canDoZoom)
        {
            mListener.b(pointf, ((PointF) (obj)));
        }
        if (true) goto _L6; else goto _L5
_L5:
        motionevent = getOutEdgePOint();
        if (((PointF) (motionevent)).x != 0.0F || ((PointF) (motionevent)).y != 0.0F)
        {
            post(new vr(this, ((PointF) (motionevent)).x, ((PointF) (motionevent)).y));
        }
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
    }




/*
    public static TouchState access$102(MNewTouchImageView mnewtouchimageview, TouchState touchstate)
    {
        mnewtouchimageview.mode = touchstate;
        return touchstate;
    }

*/



/*
    public static float access$202(MNewTouchImageView mnewtouchimageview, float f)
    {
        mnewtouchimageview.saveScale = f;
        return f;
    }

*/








    private class TouchState extends Enum
    {

        private static final TouchState $VALUES[];
        public static final TouchState DRAG;
        public static final TouchState NONE;
        public static final TouchState ZOOM;

        public static TouchState valueOf(String s)
        {
            return (TouchState)Enum.valueOf(com/fotoable/beautyui/newui/MNewTouchImageView$TouchState, s);
        }

        public static TouchState[] values()
        {
            return (TouchState[])$VALUES.clone();
        }

        static 
        {
            NONE = new TouchState("NONE", 0);
            DRAG = new TouchState("DRAG", 1);
            ZOOM = new TouchState("ZOOM", 2);
            $VALUES = (new TouchState[] {
                NONE, DRAG, ZOOM
            });
        }

        private TouchState(String s, int i)
        {
            super(s, i);
        }
    }

}
