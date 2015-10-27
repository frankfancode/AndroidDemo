package com.frankfancode.androiddemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.frankfancode.androiddemo.R;
import com.frankfancode.androiddemo.entity.Lrc;
import com.frankfancode.androiddemo.utils.Utils;

import java.util.List;

/**
 * Created by Frank on 2015/10/25.
 */
public class LrcView extends View {


    private float sw;

    private int progress_start_color = getResources().getColor(R.color.gray_silver);
    private int progress_end_color = getResources().getColor(R.color.gray_gainsboro);
    private int lrc_focus_color;
    private int lrc_unfocus_color;

    private float pvSpace = Utils.dpToPx(getContext(), 1);
    private Paint endPaint;
    private Paint startPaint;
    private Paint unFocusPaint;
    private Paint focusPaint;

    private int position;
    private int intervalTime;

    public LrcView(Context context) {
        super(context);
    }

    public LrcView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LrcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.lrcview, 0, 0);
        progress_start_color = t.getColor(R.styleable.lrcview_progress_start_color, progress_start_color);
        progress_end_color = t.getColor(R.styleable.lrcview_progress_end_color, progress_end_color);
        lrc_focus_color = t.getColor(R.styleable.lrcview_lrc_focus_color, lrc_focus_color);
        lrc_unfocus_color = t.getColor(R.styleable.lrcview_lrc_unfocus_color, lrc_unfocus_color);


        endPaint = new Paint();
        endPaint.setAntiAlias(true);
        endPaint.setColor(progress_end_color);
        endPaint.setStrokeWidth(pvSpace);

        startPaint = new Paint();
        startPaint.setAntiAlias(true);
        startPaint.setColor(progress_start_color);
        startPaint.setStrokeWidth(pvSpace + Utils.dpToPx(getContext(), 1.0f));


        unFocusPaint = new TextPaint();
        unFocusPaint.setAntiAlias(true);
        unFocusPaint.setTextSize(Utils.spTopx(getContext(), 14.0f));
        unFocusPaint.setColor(lrc_unfocus_color);
        unFocusPaint.setStrokeWidth(pvSpace);

        focusPaint = new TextPaint();
        focusPaint.setTextSize(Utils.spTopx(getContext(), 16.0f));
        focusPaint.setAntiAlias(true);
        focusPaint.setColor(lrc_focus_color);
        focusPaint.setStrokeWidth(pvSpace);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sw = this.getMeasuredWidth();
        canvas.drawLine(10f, 10f, sw, 10f, endPaint);
        canvas.drawLine(10f, 10f, sw / 3.0f, 10f, startPaint);

        //canvas.drawText("This is", sw / 2.0f - unFocusPaint.measureText("multi-line") / 2.0f, 100, unFocusPaint);
        drawTextCenter(canvas, "Picking at a worried seam", 100, unFocusPaint);
        drawTextCenter(canvas, "I'm taken by a nursery rhyme",150,unFocusPaint);
        drawTextCenter(canvas, "I want to make a ray of sunshine and never leave home",200,unFocusPaint);
        drawTextCenter(canvas, "I want to make a ray of sunshine and never leave home",250,focusPaint);
        drawTextCenter(canvas, "There's no spring in the middle this year", 300, unFocusPaint);
        drawTextCenter(canvas, "I'm the new chicken clucking open hearts and ears",350,unFocusPaint);

        //drawMultiline(canvas, "I want to make a ray of sunshine\n and never leave home\n", 350, unFocusPaint);


//        invalidate();

    }

    public void setLrc(List<Lrc> lrcList) {

    }

    private void drawTextCenter(Canvas canvas,String s,float hight,Paint paint){
        canvas.drawText(s, sw/2.0f-paint.measureText(s)/2.0f, hight, paint);

    }
    public void drawMultiline(Canvas canvas,String str,  int y, Paint paint) {
        for (String line: str.split("\n"))
        {
            drawTextCenter(canvas,line,y,paint);
            y += -paint.ascent() + paint.descent();
        }
    }
}
