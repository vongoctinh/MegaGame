package com.poly.megagame.ailatrieuphu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.poly.megagame.R;
import com.squareup.picasso.Picasso;

import static com.poly.megagame.R.*;

public class Manghinhchinh extends AppCompatActivity {
Button star;
public MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_manghinhchinh);
        star = findViewById(id.star);
        player = MediaPlayer.create(Manghinhchinh.this, raw.background_music);
        player.start();
//        final Drawable drawable = getResources().getDrawable(R.drawable.button3);
//        drawable.setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.SRC_ATOP);
        star.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Manghinhchinh.this, playgame.class);
                player.stop();
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStop() {
        player.stop();
        super.onStop();

    }
    // play game activity
//      new Handler().postDelayed(new Runnable() {
//        @Override
//        public void run() {
//            drawable.setColorFilter(Color.parseColor("#e65100"), PorterDuff.Mode.SRC_ATOP);
//            star.setBackgroundDrawable(drawable);
//        }
//    }, 100);
}
