package de.vogella.android.touch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SignatureView1First extends View {
  private Paint paint = new Paint();
  private Path path = new Path();

  public SignatureView1First(Context context, AttributeSet attrs) {
    super(context, attrs);

    paint.setAntiAlias(true);
    paint.setColor(Color.WHITE);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
    paint.setStrokeWidth(5f);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.drawPath(path, paint);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    float eventX = event.getX();
    float eventY = event.getY();

    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        path.moveTo(eventX, eventY);
        return true;
      case MotionEvent.ACTION_MOVE:
      case MotionEvent.ACTION_UP:
        path.lineTo(eventX, eventY);
        break;
      default:
        return false;
    }

    // Schedules a repaint.
    invalidate();
    return true;
  }
}
