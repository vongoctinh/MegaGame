package com.poly.megagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.poly.megagame.ailatrieuphu.Manghinhchinh;
import com.squareup.picasso.Picasso;
public class MainActivity extends AppCompatActivity {
    Button game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Manghinhchinh.class);
                startActivity(intent);
            }
        });
    }
}
