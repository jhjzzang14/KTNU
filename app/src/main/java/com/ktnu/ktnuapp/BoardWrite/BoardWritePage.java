package com.ktnu.ktnuapp.BoardWrite;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ktnu.ktnuapp.Retrofit.BoardApi;
import com.ktnu.ktnuapp.DTO.MessageDTO;
import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.Retrofit.RetrofitService;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by hojun on 2016-10-30.
 */
public class BoardWritePage extends Activity {
    private SharedPreferences pref;
    private EditText title;
    private EditText content;
    private TextView submit;
    private Call<MessageDTO> list;
    private BoardApi boardApi;
    private String cgcode;
    private String bdcode;
    private String subject;
    private String nickname;
    private String contents;
    private ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }

        pref = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);

        title = (EditText)findViewById(R.id.title);
        Log.d("title",title.getText().toString());
        content = (EditText)findViewById(R.id.content);
        Log.d("title",content.getText().toString());
        submit = (TextView)findViewById(R.id.submit);

        boardApi = new RetrofitService().getService();

        cgcode =  pref.getString("id","");
        bdcode = pref.getString("bdcode","");
        subject = title.getText().toString();
        nickname =  pref.getString("nickname","");
        contents = content.getText().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar = ProgressDialog.show(BoardWritePage.this,"",
                        "잠시만 기다려 주세요.",true);
                list = boardApi.postBoardContents(cgcode,bdcode,subject,nickname,contents);
                list.enqueue(new Callback<MessageDTO>() {
                    @Override
                    public void onResponse(Response<MessageDTO> response) {
                        if(response.isSuccess()){
                            Log.d("result","success");
                            Toast.makeText(getApplicationContext(),"글 저장",Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),"입력값 오류",Toast.LENGTH_SHORT).show();
                        }
                        progressBar.dismiss();
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
        });

    }

}
