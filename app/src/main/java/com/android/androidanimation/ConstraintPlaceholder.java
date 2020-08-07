package com.android.androidanimation;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Placeholder;


public class ConstraintPlaceholder extends AppCompatActivity implements View.OnClickListener {

    // Apply animation to reference view from ConstraintGroup


    ConstraintLayout rootLayout;
    Placeholder placeholder;
    ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_placeholder);

        placeholder = findViewById(R.id.place_holder);
        img1 = findViewById(R.id.img_1);
        img2 = findViewById(R.id.img_2);
        img3 = findViewById(R.id.img_3);
        rootLayout =findViewById(R.id.root_layout);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new BounceInterpolator());
        transition.setDuration(2000);


        TransitionManager.beginDelayedTransition(rootLayout,transition);
         placeholder.setContentId(v.getId());
    }
}