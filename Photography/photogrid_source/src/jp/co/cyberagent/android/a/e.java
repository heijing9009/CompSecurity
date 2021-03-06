// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.a;

import android.opengl.GLES20;
import android.util.Log;

// Referenced classes of package jp.co.cyberagent.android.a:
//            h

public final class e extends h
{

    private int A;
    private float B;
    private int C;
    private float D;
    private float E;
    private int F;
    private int y;
    private float z;

    public e()
    {
        this((byte)0);
    }

    private e(byte byte0)
    {
        super("uniform mat4 uMVPMatrix;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix*position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform lowp float brightness;\nuniform lowp float saturation;\nuniform lowp float contrast;\nuniform mediump float hueAdjust;\nconst highp vec4 kRGBToYPrime = vec4 (0.299, 0.587, 0.114, 0.0);\nconst highp vec4 kRGBToI = vec4 (0.595716, -0.274453, -0.321263, 0.0);\nconst highp vec4 kRGBToQ = vec4 (0.211456, -0.522591, 0.31135, 0.0);\n\nconst highp vec4 kYIQToR = vec4 (1.0, 0.9563, 0.6210, 0.0);\nconst highp vec4 kYIQToG = vec4 (1.0, -0.2721, -0.6474, 0.0);\nconst highp vec4 kYIQToB = vec4 (1.0, -1.1070, 1.7046, 0.0);\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main ()\n{\n    // Sample the input pixel\n    highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    vec4 colorBrightness = vec4((color.rgb + vec3(brightness)), color.w);\n    vec4 colorContrast = vec4(((colorBrightness.rgb - vec3(0.5)) * contrast + vec3(0.5)), colorBrightness.w);\n    lowp float luminance = dot(colorContrast.rgb, luminanceWeighting);\n    lowp vec3 greyScaleColor = vec3(luminance);\n    \n    color = vec4(mix(greyScaleColor, colorContrast.rgb, saturation), colorContrast.w);\n\n    // Convert to YIQ\n    highp float YPrime = dot (color, kRGBToYPrime);\n    highp float I = dot (color, kRGBToI);\n    highp float Q = dot (color, kRGBToQ);\n\n    // Calculate the hue and chroma\n    highp float hue = atan (Q, I);\n    highp float chroma = sqrt (I * I + Q * Q);\n\n    // Make the user's adjustments\n    hue += (-hueAdjust); //why negative rotation?\n\n    // Convert back to YIQ\n    Q = chroma * sin (hue);\n    I = chroma * cos (hue);\n\n    // Convert back to RGB\n    highp vec4 yIQ = vec4 (YPrime, I, Q, 0.0);\n    color.r = dot (yIQ, kYIQToR);\n    color.g = dot (yIQ, kYIQToG);\n    color.b = dot (yIQ, kYIQToB);\n\n    // Save the result\n    gl_FragColor = color;\n}\n");
        z = 0.0F;
        B = 1.0F;
        D = 1.0F;
        E = 90F;
    }

    public final void a(float f)
    {
        z = f;
        if (y != -1)
        {
            a(y, z);
        }
    }

    public final void b(float f)
    {
        B = f;
        if (A != -1)
        {
            a(A, B);
        }
    }

    public final void c()
    {
        super.c();
        y = GLES20.glGetUniformLocation(p(), "brightness");
        A = GLES20.glGetUniformLocation(p(), "contrast");
        C = GLES20.glGetUniformLocation(p(), "saturation");
        F = GLES20.glGetUniformLocation(p(), "hueAdjust");
        Log.e("GPUImage", (new StringBuilder("GPUImageColorFilter programID:")).append(p()).append(",mBrightnessLocation:").append(y).append(",mContrastLocation:").append(A).append(",mSaturationLocation:").append(C).append(",mHueLocation:").append(F).toString());
    }

    public final void c(float f)
    {
        D = f;
        if (C != -1)
        {
            a(C, D);
        }
    }

    public final void d()
    {
        super.d();
        a(z);
        b(B);
        c(D);
        d(E);
    }

    public final void d(float f)
    {
        E = f;
        f = ((E % 360F) * 3.141593F) / 180F;
        if (F != -1)
        {
            a(F, f);
        }
    }
}
