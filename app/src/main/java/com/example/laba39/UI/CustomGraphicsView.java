package com.example.laba39.UI;

import static com.example.laba39.data.Constants.DRAW_GIFT_HEIGHT;
import static com.example.laba39.data.Constants.DRAW_GIFT_WIDTH;
import static com.example.laba39.data.Constants.DRAW_TREEBASE_WIDTH;
import static com.example.laba39.data.Constants.DRAW_TREE_HEIGHT;
import static com.example.laba39.data.Constants.DRAW_TRUNK_HEIGHT;
import static com.example.laba39.data.Constants.DRAW_TRUNK_WIDTH;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

class CustomGraphicsView extends View {
    public CustomGraphicsView(Context context) {
        super(context);
    }

    @SuppressLint("DrawAllocation")
    @Override public void onDraw(Canvas canvas) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        float height = displayMetrics.heightPixels;
        float width = displayMetrics.widthPixels;

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
        paint.setAntiAlias(true);
        canvas.drawColor(Color.BLACK);
        canvas.drawText("Happy New Year!", width / 2 - 50, 200, paint);


        Paint linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setARGB(255, 0, 255, 0);
        linePaint.setPathEffect(new DashPathEffect(new float[] { 5, 5 }, 1));
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(3.0f);

        float trunkWidth = DRAW_TRUNK_WIDTH;
        float trunkHeight = DRAW_TRUNK_HEIGHT;
        float treeBaseWidth = DRAW_TREEBASE_WIDTH;
        float treeHeight = DRAW_TREE_HEIGHT;

        // Рисуем ствол елки
        float trunkX = width / 2 + trunkWidth / 2;
        float trunkY = height / 2;
        canvas.drawLine(trunkX - trunkWidth / 2, trunkY, trunkX - trunkWidth / 2, trunkY - trunkHeight, linePaint);
        canvas.drawLine(trunkX + trunkWidth / 2, trunkY, trunkX + trunkWidth / 2, trunkY - trunkHeight, linePaint);

        // Рисуем елку
        for (int i = 0; i < 5; i++) {
            float y = trunkY - trunkHeight - (i * (treeHeight / 5));
            canvas.drawLine(trunkX - treeBaseWidth / 2 + (i * (treeBaseWidth / 10)), y, trunkX + treeBaseWidth / 2 - (i * (treeBaseWidth / 10)), y, linePaint);

            int smallRadius = 30;
            for (int j = 0; j < 4 - i; j++) {
                canvas.drawCircle(( treeBaseWidth - 2 * (i * (treeBaseWidth / 10)) - smallRadius * (4 - i) ) / 2 + trunkX - treeBaseWidth / 2 + (i * (treeBaseWidth / 10)) + smallRadius * j + smallRadius / 2, y + smallRadius / 2, smallRadius / 2, linePaint);
            }

            treeBaseWidth -= 30;
        }

        // Рисуем звезду на верхушке елки
        linePaint.setARGB(255, 255, 0, 0);

        float starX = trunkX;
        float starY = trunkY - trunkHeight - treeHeight + 30;
        canvas.drawCircle(starX, starY, 20, linePaint);

        // Рисуем подарки
        linePaint.setARGB(255, 0, 0, 255);

        float giftWidth = DRAW_GIFT_WIDTH;
        float giftHeight = DRAW_GIFT_HEIGHT;

        float giftX1 = trunkX - 75;
        float giftY1 = trunkY;
        canvas.drawLine(giftX1, giftY1, giftX1 + giftWidth, giftY1, linePaint);
        canvas.drawLine(giftX1, giftY1, giftX1, giftY1 + giftHeight, linePaint);
        canvas.drawLine(giftX1 + giftWidth, giftY1, giftX1 + giftWidth, giftY1 + giftHeight, linePaint);
        canvas.drawLine(giftX1, giftY1 + giftHeight, giftX1 + giftWidth, giftY1 + giftHeight, linePaint);

        float giftX2 = trunkX + 50;
        float giftY2 = trunkY;
        canvas.drawLine(giftX2, giftY2, giftX2 + giftWidth, giftY2, linePaint);
        canvas.drawLine(giftX2, giftY2, giftX2, giftY2 + giftHeight, linePaint);
        canvas.drawLine(giftX2 + giftWidth, giftY2, giftX2 + giftWidth, giftY2 + giftHeight, linePaint);
        canvas.drawLine(giftX2, giftY2 + giftHeight, giftX2 + giftWidth, giftY2 + giftHeight, linePaint);

        float giftX3 = trunkX - 25;
        float giftY3 = trunkY + 90;
        canvas.drawLine(giftX3, giftY3, giftX3 + giftWidth, giftY3, linePaint);
        canvas.drawLine(giftX3, giftY3, giftX3, giftY3 + giftHeight, linePaint);
        canvas.drawLine(giftX3 + giftWidth, giftY3, giftX3 + giftWidth, giftY3 + giftHeight, linePaint);
        canvas.drawLine(giftX3, giftY3 + giftHeight, giftX3 + giftWidth, giftY3 + giftHeight, linePaint);
    }
}
