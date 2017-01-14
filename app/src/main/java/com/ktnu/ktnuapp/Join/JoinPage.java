package com.ktnu.ktnuapp.Join;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.ktnu.ktnuapp.Retrofit.LoginApi;
import com.ktnu.ktnuapp.DTO.MessageDTO;
import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.Retrofit.RetrofitService;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class JoinPage extends AppCompatActivity {
    EditText hnum;
    EditText username;
    EditText password;
    EditText passwordConfirm;
    EditText tel;
    EditText email;
    EditText nickname;
    Spinner spinner;
    Button join;

    LoginApi loginApi;
    Call<MessageDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_page);

        hnum = (EditText)findViewById(R.id.hnum);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        passwordConfirm = (EditText)findViewById(R.id.passwordConfirm);
        tel = (EditText)findViewById(R.id.tel);
        email = (EditText)findViewById(R.id.email);
        nickname = (EditText)findViewById(R.id.nickname);
        spinner = (Spinner) findViewById(R.id.spinner);
        join = (Button) findViewById(R.id.join);

        loginApi = new RetrofitService().getLoginService();

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list = loginApi.postJoin(nickname.getText().toString(),Integer.parseInt(hnum.getText().toString()),"컴퓨터정보공학과",username.getText().toString(),
                        password.getText().toString(),email.getText().toString(),tel.getText().toString());

                list.enqueue(new Callback<MessageDTO>() {
                    @Override
                    public void onResponse(Response<MessageDTO> response) {
                        if(response.isSuccess()){

                            if(response.body().getCode().equals("1")){
                                Toast.makeText(JoinPage.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(JoinPage.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

            }
        });
    }
}
