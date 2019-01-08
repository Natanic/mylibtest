package com.liaoinstan.springview.container;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liaoinstan.springview.R;

/**
 * Created by Administrator on 2016/3/21.
 */
public class MeituanFooter extends BaseFooter {

    private AnimationDrawable animationLoading;
    private AnimationDrawable animationPull;
    private AnimationDrawable animationPullFan;

    private Context context;
    private ImageView footer_img;
    private int[] pullAnimSrcs = new int[]{R.drawable.mt_logo2,R.drawable.mt_logo2,R.drawable.mt_logo2,R.drawable.mt_logo2,R.drawable.mt_logo2,R.drawable.mt_logo2};
    private int[] loadingAnimSrcs = new int[]{R.drawable.refreshing1,R.drawable.refreshing2, R.drawable.refreshing3, R.drawable.refreshing4, R.drawable.refreshing5,
            R.drawable.refreshing6, R.drawable.refreshing7,R.drawable.refreshing8, R.drawable.refreshing9,R.drawable.refreshing10, R.drawable.refreshing11,
            R.drawable.refreshing12, R.drawable.refreshing13,R.drawable.refreshing14};

    public MeituanFooter(Context context) {
        this(context, null);
    }

    public MeituanFooter(Context context, int[] loadingAnimSrcs) {
        this.context = context;
        if (loadingAnimSrcs != null) this.loadingAnimSrcs = loadingAnimSrcs;
        animationLoading = new AnimationDrawable();
        animationPull = new AnimationDrawable();
        animationPullFan = new AnimationDrawable();
        for (int i = 1; i < this.pullAnimSrcs.length; i++) {
            animationPull.addFrame(ContextCompat.getDrawable(context, this.pullAnimSrcs[i]), 100);
            animationPull.setOneShot(true);
        }
        for (int i = this.pullAnimSrcs.length - 1; i >= 0; i--) {
            animationPullFan.addFrame(ContextCompat.getDrawable(context, this.pullAnimSrcs[i]), 100);
            animationPullFan.setOneShot(true);
        }
        for (int src : this.loadingAnimSrcs) {
            animationLoading.addFrame(ContextCompat.getDrawable(context, src), 60);
            animationLoading.setOneShot(false);
        }
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.meituan_footer, viewGroup, true);
        footer_img = (ImageView) view.findViewById(R.id.meituan_footer_img);
        if (pullAnimSrcs != null && pullAnimSrcs.length > 0)
            footer_img.setImageResource(pullAnimSrcs[0]);
        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
//        animationLoading.stop();
//        if (animationLoading != null && animationLoading.getNumberOfFrames() > 0)
//            footer_img.setImageDrawable(animationLoading.getFrame(0));
    }

    @Override
    public void onDropAnim(View rootView, int dy) {
    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
        if (!upORdown) {
            footer_img.setImageDrawable(animationPull);
            animationPull.start();
        } else {
            footer_img.setImageDrawable(animationPullFan);
            animationPullFan.start();
        }
    }

    @Override
    public void onStartAnim() {
        if (animationLoading != null)
            footer_img.setImageDrawable(animationLoading);
        animationLoading.start();
    }

    @Override
    public void onFinishAnim() {
        animationLoading.stop();
        if (pullAnimSrcs != null && pullAnimSrcs.length > 0)
            footer_img.setImageResource(pullAnimSrcs[0]);
    }
}