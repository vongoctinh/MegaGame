package com.poly.megagame.fragment_layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poly.megagame.MainActivity;
import com.poly.megagame.R;
import com.poly.megagame.ailatrieuphu.Manghinhchinh;

public class Fragment_TrangChu extends Fragment {
    ImageView game,game2,game3,danhgia,chiase;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);
         game = view.findViewById(R.id.game);
         game2 = view.findViewById(R.id.game2);
         danhgia = view.findViewById(R.id.danhgia);
         chiase = view.findViewById(R.id.imgchiase);
         chiase.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(getActivity(),Fragment_ChiaSe.class);
                 startActivity(i);
             }
         });
         danhgia.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getActivity(), Fragment_DangGia.class);
                 startActivity(intent);
             }
         });
         game3 = view.findViewById(R.id.game3);
         game2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
         game.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getActivity(), Manghinhchinh.class);
                 startActivity(intent);
             }
         });
         return view;
    }
}
