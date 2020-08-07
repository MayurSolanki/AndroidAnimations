package com.android.androidanimation;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;



public class ConstraintSet extends AppCompatActivity {

    // Use to copy constraint of one layout to another layout
    // Its copy layout by replacing it.


    Button btnStart;
    ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_set);

        btnStart = findViewById(R.id.button);
        rootLayout =findViewById(R.id.root_layout);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.GONE);

                androidx.constraintlayout.widget.ConstraintSet constraintSet = new androidx.constraintlayout.widget.ConstraintSet();
                constraintSet.clone(ConstraintSet.this,R.layout.constraint_set_another);
                constraintSet.applyTo(rootLayout);

                Transition transition = new ChangeBounds();
                transition.setInterpolator(new OvershootInterpolator());
                transition.setDuration(500);
                TransitionManager.beginDelayedTransition(rootLayout,transition);

            }
        });
    }
}