package com.jwl.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * author:  lujunwu
 * date:    2018/10/29 09:03
 * desc:    NoDiscription
 */
public class Behavior1 extends CoordinatorLayout.Behavior<TextView> {


    public Behavior1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull TextView child, @NonNull View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull TextView child, @NonNull View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY()+200);
        child.setText(dependency.getX()+"---"+dependency.getY());
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
