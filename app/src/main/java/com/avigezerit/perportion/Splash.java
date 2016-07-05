package com.avigezerit.perportion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Shaharli on 23/06/2016.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final ImageView iv = (ImageView) findViewById(R.id.splash_spinner);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);

        Log.d("PERPORTION", "wtf");

        iv.setAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent i = new Intent(getBaseContext() , com.avigezerit.perportion.CategoriesActivity.class);
                startActivity(i);
                Log.d("PERPORTION", "end");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
