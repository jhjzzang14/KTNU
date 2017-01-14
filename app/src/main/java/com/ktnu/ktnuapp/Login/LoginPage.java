package com.ktnu.ktnuapp.Login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ktnu.ktnuapp.Join.JoinPage;
import com.ktnu.ktnuapp.Retrofit.LoginApi;
import com.ktnu.ktnuapp.DTO.MyInfoDTO;
import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.Retrofit.RetrofitService;
import com.ktnu.ktnuapp.Index.StartPage;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class LoginPage extends AppCompatActivity {

    EditText id;
    EditText pwd;
    Button login;
    Button join;

    LoginApi loginApi;
    Call<MyInfoDTO> list;

    ProgressDialog progressBar;

    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        pref = this.getSharedPreferences("pref", Context.MODE_PRIVATE);
        id = (EditText)findViewById(R.id.id);
        pwd = (EditText)findViewById(R.id.pwd);
        login = (Button)findViewById(R.id.login);
        join = (Button)findViewById(R.id.join);

        loginApi = new RetrofitService().getLoginService();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar = ProgressDialog.show(LoginPage.this,"",
                        "잠시만 기다려 주세요.",true);
                list = loginApi.postLogin(id.getText().toString(),pwd.getText().toString());

                list.enqueue(new Callback<MyInfoDTO>() {
                    @Override
                    public void onResponse(Response<MyInfoDTO> response) {
                        if(response.isSuccess()){
                            if(response.body().getMessage().equals("로그인 성공")) {
                                Toast.makeText(LoginPage.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putInt("hnum",response.body().getHnum());
                                editor.putString("nickname",response.body().getNickname());
                                editor.commit();
                                Intent intent = new Intent(LoginPage.this, StartPage.class);

                                startActivity(intent);

                                finish();
                            }else{
                                Toast.makeText(LoginPage.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                                progressBar.dismiss();
                            }
                        }else{
                            progressBar.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d("result",t.getMessage().toString()+"");
                    }
                });
            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this,JoinPage.class);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressBar.dismiss();
    }
}
