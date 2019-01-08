package com.liaoinstan.springview.container;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liaoinstan.springview.R;
import com.liaoinstan.springview.utils.DensityUtil;

/**
 * Created by Administrator on 2016/3/21.
 */
public class MeituanHeader extends BaseHeader {

    private AnimationDrawable animationPull;
    private AnimationDrawable animationPullFan;
    private AnimationDrawable animationRefresh;

    private Context context;
    private ImageView header_img;
    private int[] pullAnimSrcs = new int[]{R.drawable.mt_logo,R.drawable.mt_logo,R.drawable.mt_logo,R.drawable.mt_logo,R.drawable.mt_logo,R.drawable.mt_logo};
    private int[] refreshAnimSrcs = new int[]{R.drawable.refreshing1,R.drawable.refreshing2, R.drawable.refreshing3, R.drawable.refreshing4, R.drawable.refreshing5,
            R.drawable.refreshing6, R.drawable.refreshing7,R.drawable.refreshing8, R.drawable.refreshing9,R.drawable.refreshing10, R.drawable.refreshing11,
            R.drawable.refreshing12, R.drawable.refreshing13,R.drawable.refreshing14};
    public MeituanHeader(Context context) {
        this(context, null, null);
    }

    public MeituanHeader(Context context, int[] pullAnimSrcs, int[] refreshAnimSrcs) {
        this.context = context;
        if (pullAnimSrcs != null) this.pullAnimSrcs = pullAnimSrcs;
        if (refreshAnimSrcs != null) this.refreshAnimSrcs = refreshAnimSrcs;
        animationPull = new AnimationDrawable();
        animationPullFan = new AnimationDrawable();
        animationRefresh = new AnimationDrawable();
        for (int i = 1; i < this.pullAnimSrcs.length; i++) {
            animationPull.addFrame(ContextCompat.getDrawable(context, this.pullAnimSrcs[i]), 100);
            animationPull.setOneShot(true);
        }
        for (int i = this.pullAnimSrcs.length - 1; i >= 0; i--) {
            animationPullFan.addFrame(ContextCompat.getDrawable(context, this.pullAnimSrcs[i]), 100);
            animationPullFan.setOneShot(true);
        }
        for (int src : this.refreshAnimSrcs) {
            animationRefresh.addFrame(ContextCompat.getDrawable(context, src), 60);
            animationRefresh.setOneShot(false);
        }
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.meituan_header, viewGroup, true);
        header_img = (ImageView) view.findViewById(R.id.meituan_header_img);
        if (pullAnimSrcs != null && pullAnimSrcs.length > 0)
            header_img.setImageResource(pullAnimSrcs[0]);
        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
    }

    @Override
    public void onDropAnim(View rootView, int dy) {
//        int maxw = DensityUtil.dp2px(45);
//        float w = maxw * Math.abs(dy) / rootView.getMeasuredHeight();
//        if (w > maxw) return;
//        ViewGroup.LayoutParams layoutParams = header_img.getLayoutParams();
//        layoutParams.width = (int) w;
//        header_img.setLayoutParams(layoutParams);
    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
        if (!upORdown) {
            header_img.setImageDrawable(animationPull);
            animationPull.start();
        } else {
            header_img.setImageDrawable(animationPullFan);
            animationPullFan.start();
        }
    }

    @Override
    public void onStartAnim() {
        header_img.setImageDrawable(animationRefresh);
        animationRefresh.start();
    }

    @Override
    public void onFinishAnim() {
        if (pullAnimSrcs != null && pullAnimSrcs.length > 0)
            header_img.setImageResource(pullAnimSrcs[0]);
    }
}