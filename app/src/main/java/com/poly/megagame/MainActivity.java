package com.poly.megagame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.poly.megagame.ailatrieuphu.Manghinhchinh;
import com.poly.megagame.fragment_layout.Fragment_CaNhan;
import com.poly.megagame.fragment_layout.Fragment_ChiaSe;
import com.poly.megagame.fragment_layout.Fragment_DangGia;
import com.poly.megagame.fragment_layout.Fragment_TrangChu;
import com.squareup.picasso.Picasso;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout,  new Fragment_TrangChu()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment = null;
            switch (menuItem.getItemId()){
                case R.id.trangchu:   fragment = new Fragment_TrangChu();
                break;
                case R.id.canhan:   fragment = new Fragment_CaNhan();
                    break;
                case R.id.danhgia:   fragment = new Fragment_DangGia();
                    break;
                case R.id.chiase:   fragment = new Fragment_ChiaSe();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout, fragment).commit();
            return true;
        }
    };
}
