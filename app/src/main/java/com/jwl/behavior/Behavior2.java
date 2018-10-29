package com.jwl.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * author:  lujunwu
 * date:    2018/10/29 09:44
 * desc:    NoDiscription
 */
public class Behavior2 extends CoordinatorLayout.Behavior<TextView> {

    private final int mStatusBarHeight;
    private float mDependencyTopY;

    public Behavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
        mStatusBarHeight = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull TextView child, @NonNull View dependency) {
        if (mDependencyTopY==0f) {
            mDependencyTopY = dependency.getY();
        }
        float changePercent = (mDependencyTopY - dependency.getY()) / (mDependencyTopY-mStatusBarHeight);
        if (changePercent>0.05f) {
            child.setY(-child.getHeight()*(1-changePercent)+mStatusBarHeight);
            child.setAlpha(changePercent);
        }else{
            child.setY(-child.getHeight()*(1-changePercent));
            child.setAlpha(0);
        }
        return true;
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull TextView child, @NonNull View dependency) {
        return dependency instanceof NestedScrollView;
    }
}
