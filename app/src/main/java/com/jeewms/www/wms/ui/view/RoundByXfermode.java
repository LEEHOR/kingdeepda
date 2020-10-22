package com.jeewms.www.wms.ui.view;

/**
 * Created by 13799 on 2018/6/2.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;


import com.jeewms.www.wms.R;

import java.lang.ref.WeakReference;

/**
 * Created by ylwang on 2017/1/23.
 */
public class RoundByXfermode extends android.support.v7.widget.AppCompatImageView {

    private Paint mPaint;
    //求交集
    private Xfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    private Bitmap mMaskBitmap;//遮罩层

    private WeakReference<Bitmap> mWeakBitmap;

    /**
     * 图片的类型，圆形or圆角
     */
    private int type;
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_ROUND = 1;
    /**
     * 圆角大小的默认值
     */
    private static final int BODER_RADIUS_DEFAULT = 10;
    /**
     * 圆角的大小
     */
    private int mBorderRadius;

    public RoundByXfermode(Context context) {
//        super(context);
        this(context, null);
    }

    //系统会默认主动调用两个参数的构造方法
    public RoundByXfermode(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//获取画笔对象并抗锯齿效果

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundByXfermode);

        /**
         * setTextSize(TypedValue.COMPLEX_UNIT_PX,22); //22像素
         *setTextSize(TypedValue.COMPLEX_UNIT_SP,22); //22SP
         *setTextSize(TypedValue.COMPLEX_UNIT_DIP,22);//22DIP
         */
        int value = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP
                , BODER_RADIUS_DEFAULT
                , getResources().getDisplayMetrics());
        mBorderRadius = a.getDimensionPixelSize(R.styleable.RoundByXfermode_borderRadius, value);// 默认为10dp

        type = a.getInt(R.styleable.RoundByXfermode_type, TYPE_CIRCLE);// 默认为Circle

        a.recycle();
    }


    public RoundByXfermode(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        Bitmap bitmap = (mWeakBitmap == null) ? null : mWeakBitmap.get();
        if (null == bitmap || bitmap.isRecycled()) {
            //拿到Drawable
            Drawable drawable = getDrawable();
            //获取drawable的宽和高
            int dWidth = drawable.getIntrinsicWidth();
            int dHeight = drawable.getIntrinsicHeight();

            if (drawable != null) {
                //创建bitmap
                bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                float scale = 1.0f;
                //创建画布
                Canvas drawCanvas = new Canvas(bitmap);
                //按照bitmap的宽高，以及view的宽高，计算缩放比例；
                // 因为设置的src宽高比例可能和imageview的宽高比例不同，这里我们不希望图片失真；
                if (type == TYPE_ROUND) {
                    // 如果图片的宽或者高与view的宽高不匹配，计算出需要缩放的比例；
                    // 缩放后的图片的宽高，一定要大于我们view的宽高；所以我们这里取大值；
                    scale = Math.max(getWidth() * 1.0f / dWidth, getHeight()
                            * 1.0f / dHeight);
                } else {
                    scale = getWidth() * 1.0F / Math.min(dWidth, dHeight);
                }
                //根据缩放比例，设置bounds，相当于缩放图片了
                drawable.setBounds(0, 0, (int) (scale * dWidth),
                        (int) (scale * dHeight));
                drawable.draw(drawCanvas);
                if (mMaskBitmap == null || mMaskBitmap.isRecycled()) {
                    mMaskBitmap = getBitmap();
                }
                // Draw Bitmap.
                mPaint.reset();
                mPaint.setFilterBitmap(false);
                mPaint.setXfermode(mXfermode);
                //绘制形状
                drawCanvas.drawBitmap(mMaskBitmap, 0, 0, mPaint);
                mPaint.setXfermode(null);
                //将准备好的bitmap绘制出来
                canvas.drawBitmap(bitmap, 0, 0, null);
                //bitmap缓存起来，避免每次调用onDraw，分配内存
                mWeakBitmap = new WeakReference<Bitmap>(bitmap);
            }
        }
        //如果bitmap还存在，则直接绘制即可
        if (bitmap != null) {
            mPaint.setXfermode(null);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, mPaint);
            return;
        }
    }

    /**
     * 绘制形状
     *
     * @return
     */
    public Bitmap getBitmap() {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);

        if (type == TYPE_ROUND) {
            canvas.drawRoundRect(new RectF(0, 0, getWidth(), getHeight()),
                    mBorderRadius, mBorderRadius, paint);
        } else {
            canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2,
                    paint);
        }

        return bitmap;
    }
}