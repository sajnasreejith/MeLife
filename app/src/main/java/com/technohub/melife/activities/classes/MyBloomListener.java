package com.technohub.melife.activities.classes;

import android.view.View;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.BounceInterpolator;

public class MyBloomListener implements Boom {
    private View mTarget;

    public MyBloomListener(View target){
        mTarget = target;
    }

    @Override
    public void onBegin() {
//            Toast.makeText(getApplicationContext(), "On boom begin...", Toast.LENGTH_SHORT).show();
        mTarget.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onEnd() {
//            Toast.makeText(getApplicationContext(), "On boom end...", Toast.LENGTH_SHORT).show();

        mTarget.setScaleX(0);
        mTarget.setScaleY(0);
        mTarget.setClickable(false);
        mTarget.setVisibility(View.VISIBLE);

        mTarget.animate()
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mTarget.setClickable(true);
                    }
                })
                .scaleX(1)
                .scaleY(1)
                .setDuration(800)
                .setInterpolator(new BounceInterpolator())
                .start();
    }
}
