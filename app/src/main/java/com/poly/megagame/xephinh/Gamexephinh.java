package com.poly.megagame.xephinh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.transition.Transition;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.poly.megagame.R;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class Gamexephinh extends AppCompatActivity {

    private String mPathImage = null;
    private RecyclerView mRecyclerView;
    private GameAdapter mAdapter;
    private LinkedList<GamesModel> mBitmapList;
    private TextView mStep;
    private int mCountClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamexephinh);

        initView();
        initUI();
        initShowDialog();
    }

    public void setStep(){
        mCountClick++;
        mStep.setText("Bước: "+mCountClick);
    }

    private void initShowDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Chọn Hình Ảnh")
                .setMessage("Bạn có muốn tự chọn hình ảnh của bạn để chơi trò chơi này không ?")
                .setCancelable(false)
                .setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                        photoPickerIntent.setType("image/*");
                        startActivityForResult(photoPickerIntent, 123);
                    }
                })
                .setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        playGame();
                    }
                }).show();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.mRecyclerView);
        mStep = findViewById(R.id.mStep);

        mBitmapList = new LinkedList<>();
    }

    private void initUI() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new CustomGridLayoutManager(getApplicationContext(),3,RecyclerView.VERTICAL,false,false));
        mAdapter = new GameAdapter(this,mBitmapList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void playGame(){
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.image1)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        final int width = resource.getWidth();
                        final int height = resource.getHeight();

                        final int pixelByCol = width / 3;
                        final int pixelByRow = height / 3;

                        mBitmapList.clear();

                        int index = 0;
                        for (int i = 0; i < 3;i++) {
                            for (int j = 0; j < 3;j++) {
                                int startX = pixelByCol * j;
                                int startY = pixelByRow * i;

                                Bitmap mBitmap = Bitmap.createBitmap(resource, startX, startY, pixelByCol, pixelByRow);

                                mBitmapList.add(new GamesModel(mBitmap, String.valueOf(index)));
                                index ++;
                            }
                        }
                        Collections.shuffle(mBitmapList);
                        mBitmapList.set(2,new GamesModel(null,mBitmapList.get(2).getmIndex()));
                        mAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });
    }

    private void playGame(Bitmap bitmap){
        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();

        final int pixelByCol = width / 3;
        final int pixelByRow = height / 3;

        mBitmapList.clear();

        int index = 0;
        for (int i = 0; i < 3;i++) {
            for (int j = 0; j < 3;j++) {
                int startX = pixelByCol * j;
                int startY = pixelByRow * i;

                Bitmap mBitmap = Bitmap.createBitmap(bitmap, startX, startY, pixelByCol, pixelByRow);

                mBitmapList.add(new GamesModel(mBitmap, String.valueOf(index)));
                index ++;
            }
        }
        Collections.shuffle(mBitmapList);
        mBitmapList.set(2,new GamesModel(null,mBitmapList.get(2).getmIndex()));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==123&&resultCode==RESULT_OK&&data!=null){
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());

                int height = bitmap.getHeight();
                int width = bitmap.getWidth();

                if (height==width){
                    playGame(bitmap);
                }else {
                    Toast.makeText(getApplicationContext(), "Vui lòng chọn ảnh có kích thước vuông", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
