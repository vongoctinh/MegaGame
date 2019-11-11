package com.poly.megagame.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poly.megagame.R;

public class playgame extends AppCompatActivity {
    public MediaPlayer player1;
    Button A, B, C, D;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);
        final Drawable drawable1 = getResources().getDrawable(R.drawable.answer);
        drawable1.setColorFilter(Color.parseColor("#246bce"), PorterDuff.Mode.SRC_ATOP);
        player1 = MediaPlayer.create(playgame.this, R.raw.batdauchoi);
        player1.start();
        A.setBackgroundDrawable(drawable1);
        B.setBackgroundDrawable(drawable1);
        C.setBackgroundDrawable(drawable1);
        D.setBackgroundDrawable(drawable1);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(view);
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(view);
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(view);
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick(view);
            }
        });
    }
    public void onclick(View view){
        int id = view.getId();
       if (id == R.id.A){
           A.setBackgroundResource(R.drawable.button3);
           B.setBackgroundResource(R.drawable.answer);
           C.setBackgroundResource(R.drawable.answer);
           D.setBackgroundResource(R.drawable.answer);
       }  if (id == R.id.B){
           B.setBackgroundResource(R.drawable.button3);
           A.setBackgroundResource(R.drawable.answer);
            C.setBackgroundResource(R.drawable.answer);
            D.setBackgroundResource(R.drawable.answer);
       } if (id == R.id.C){
           C.setBackgroundResource(R.drawable.button3);
            A.setBackgroundResource(R.drawable.answer);
            B.setBackgroundResource(R.drawable.answer);
            D.setBackgroundResource(R.drawable.answer);
       } if (id == R.id.D){
           D.setBackgroundResource(R.drawable.button3);
            A.setBackgroundResource(R.drawable.answer);
            B.setBackgroundResource(R.drawable.answer);
            C.setBackgroundResource(R.drawable.answer);
       }
    }
}
