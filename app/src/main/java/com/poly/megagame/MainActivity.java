package com.poly.megagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.poly.megagame.ailatrieuphu.Manghinhchinh;
import com.squareup.picasso.Picasso;
public class MainActivity extends AppCompatActivity {
    TextView abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abc = findViewById(R.id.abc);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Manghinhchinh.class);
                startActivity(intent);
            }
        });
    }
}
