package com.tao.progressview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 创建者     taowei
 * 创建时间   2016/6/6 18:19
 * 描述	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ProgressView extends LinearLayout {
    private  TextView mTvNote;
    private  ImageView mIcon;
    private int max;
    private int progress;

    public void setMax(int max) {
        this.max = max;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public void setIcon(int resId){
        mIcon.setImageResource(resId);
    }

    public void setNote(String note){
        mTvNote.setText(note);

    }


    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context,R.layout.inflate_progressview,this);
        mIcon = (ImageView)view.findViewById(R.id.progressview_iv_icon);
        mTvNote = (TextView)view.findViewById(R.id.progressview_tv_note);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        RectF oval = new RectF(mIcon.getLeft(), mIcon.getTop(),mIcon.getRight(),mIcon.getBottom());

        float startAngle = -90f;
        float sweepAngle = progress*1.0f/max * 360;
//        boolean useCenter = false;
        canvas.drawArc(oval,startAngle,sweepAngle,false,paint);
    }
}
