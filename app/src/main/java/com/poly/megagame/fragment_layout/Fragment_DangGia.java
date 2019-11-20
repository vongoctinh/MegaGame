package com.poly.megagame.fragment_layout;

import android.content.Context;
import android.media.Rating;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.poly.megagame.R;

public class Fragment_DangGia extends Fragment {
    Button danhgia, desau;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danhgia, container, false);
        final RatingBar bar = view.findViewById(R.id.sao);
        final float a = 5;
        bar.setRating(a);
        bar.setNumStars(5);
//        bar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Tổng số ngôi sao:"+bar.getNumStars()+" \nSố lượng đánh giá:"+bar.getRating(), Toast.LENGTH_LONG).show();
//            }
//        });
        return view;
    }
}
