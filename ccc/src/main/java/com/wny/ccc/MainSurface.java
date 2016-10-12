package com.wny.ccc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by mathcoder23 on 10/11/16.
 */
public class MainSurface extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder surfaceHolder;
    private RenderThread renderThread;
    private boolean isDraw = false;
    public MainSurface(Context context) {
        super(context);
        surfaceHolder = this.getHolder();
        surfaceHolder.addCallback(this);
        renderThread = new RenderThread();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        isDraw = true;
        renderThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isDraw = false;
    }

    private class RenderThread extends Thread
    {
        @Override
        public void run() {
            while (isDraw) {
                drawUI();
            }
            super.run();
        }
    }
    public void drawUI() {
        Canvas canvas = surfaceHolder.lockCanvas();
        try {
            Bitmap back = BitmapFactory.decodeResource(
                    this.getResources(), R.mipmap.bg);
            canvas.drawBitmap(back, 0, 0, null);
            drawCanvas(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawCanvas(Canvas canvas) {
        // 在 canvas 上绘制需要的图形
    }
}
