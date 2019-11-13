package com.poly.megagame.fragment_layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poly.megagame.R;
import com.poly.megagame.ailatrieuphu.Manghinhchinh;

public class Fragment_TrangChu extends Fragment {
    ImageView game;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trangchu, container, false);
         game = view.findViewById(R.id.game);
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
