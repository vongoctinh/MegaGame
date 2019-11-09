package com.poly.megagame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText edUserName, edPassword;
    ImageView img;
    Button btnLogin, btnCancel, btndagky;
    CheckBox chkRememberPass;
    String strUser, strPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ánh xạ
        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btndagky = (Button) findViewById(R.id.btndangky);
        img = findViewById(R.id.img);
        chkRememberPass = (CheckBox) findViewById(R.id.chkRememberPass);
        chkRememberPass.setOnCheckedChangeListener(ck);
        edUserName.setText("admin");
        edPassword.setText("123456");
        // animation
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.aninn_button);
//        btndagky.startAnimation(animation);
//        edUserName.startAnimation(animation);
//        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.button);
//        edPassword.startAnimation(animation1);
//        btnLogin.startAnimation(animation1);
//        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.aninn_img);
//        img.startAnimation(animation2);

    }
    public void checkLogin(View v){
        strUser = edUserName.getText().toString();
        strPass = edPassword.getText().toString();
        if (checkFrom() == 1){
            if (strUser.equals("admin") && strPass.equals("123456")){
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }
    // sự kiện lưu mật khẩu
    CompoundButton.OnCheckedChangeListener ck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                Toast.makeText(Login.this, "Lưu Tài Khoản " + compoundButton.getText().toString(), Toast.LENGTH_LONG).show();
            }
        }

    };

    // sự liện exit
    public void exit(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Xác nhận");
        alertDialogBuilder.setIcon(R.drawable.ifo);
        alertDialogBuilder.setMessage("Bạn có muốn thoát?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //Khoi tao lai Activity main
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Login.this,"Bạn đã click vào nút không đồng ý",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    // check from
    public int checkFrom(){
        int check = 1;
        strUser = edUserName.getText().toString();
        strPass = edPassword.getText().toString();
        if (strPass.length() == 0){
            Toast.makeText(Login.this, "Tên đăng nhập trống", Toast.LENGTH_SHORT).show();
            check = -1;
        } else if (strPass.length() == 0){
            Toast.makeText(Login.this, "Mật khẩu trống", Toast.LENGTH_SHORT).show();
            check = -1;
        } else if (strPass.length() <  6){
            Toast.makeText(Login.this, "Mật khẩu phải lớn hơn 6 ký tự", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
