package com.poly.megagame.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.poly.megagame.R;

public class playgame extends AppCompatActivity {
    public MediaPlayer player1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        player1 = MediaPlayer.create(playgame.this, R.raw.batdauchoi);
        player1.start();
    }
}
