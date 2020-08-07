package com.android.androidanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;


public class ConstraintGroup extends AppCompatActivity {

    // Apply animation to reference view from ConstraintGroup


    Group group;
    Button btnStart;
    ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_group);

        group = findViewById(R.id.group);
        btnStart = findViewById(R.id.button);
        rootLayout =findViewById(R.id.root_layout);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.GONE);
                group.setVisibility(View.VISIBLE);

                Transition fade = new Fade();
                fade.setDuration(1000);
                TransitionManager.beginDelayedTransition(rootLayout,fade);

            }
        });
    }
}