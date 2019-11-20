//package com.poly.megagame.xephinh;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.graphics.Bitmap;
//import android.util.Log;
//import android.view.Display;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.poly.megagame.MainActivity;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//
//import static android.content.Context.WINDOW_SERVICE;
//
//public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {
//
//    private Context mContext;
//    private LinkedList<GamesModel> mBitmap;
//
//    private int mSpacePosition = 0;
//
//    public GameAdapter(Context mContext, LinkedList<GamesModel> mBitmap) {
//        this.mContext = mContext;
//        this.mBitmap = mBitmap;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        ImageView mImageView = new ImageView(mContext);
//        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//        return new ViewHolder(mImageView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        if (mBitmap.get(position).getmBitmap()!=null) {
//            Glide.with(mContext).load(mBitmap.get(position).getmBitmap()).into(holder.mImageView);
//            holder.mImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    int Swipe = GameUtil.getSwipeImage(getSpacePosition(),holder.getAdapterPosition());
//
//                    if (Swipe>0){
//                        SwapData(getSpacePosition(),holder.getAdapterPosition());
//                        ((Gamexephinh)mContext).setStep();
//                    }
//                }
//            });
//        }else {
//            Glide.with(mContext).load(android.R.color.white).into(holder.mImageView);
//        }
//    }
//
//    private void SwapData(int position1,int position2){
//        Collections.swap(mBitmap, position1, position2);
//        notifyItemChanged(position1);
//        notifyItemChanged(position2);
//        if (isComplete()){
//            new AlertDialog.Builder(mContext)
//                    .setTitle("Hoàn Thành")
//                    .setMessage("Bạn đã hoàn thành xuất sắc trò chơi")
//                    .setPositiveButton("Trở lại", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            dialogInterface.cancel();
//                        }
//                    }).show();
//        }
//    }
//
//    private boolean isComplete(){
//        int check = 0;
//        for (int i=0;i<mBitmap.size();i++){
//            if (mBitmap.get(i).getmIndex().equals(check+"")){
//                check++;
//            }
//        }
//        if (check==8){
//            return true;
//        }
//        return false;
//    }
//
//    public int getSpacePosition(){
//        for (int i=0; i<mBitmap.size();i++){
//            if (mBitmap.get(i).getmBitmap()==null){
//                mSpacePosition = i;
//            }
//        }
//        return mSpacePosition;
//    }
//
//    @Override
//    public int getItemCount() {
//        return mBitmap.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView mImageView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mImageView = (ImageView)itemView;
//
//            Display display = ((WindowManager) mContext.getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
//            int width = (display.getWidth()/3) - 3;
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, width);
//            mImageView.setLayoutParams(layoutParams);
//        }
//    }
//}
