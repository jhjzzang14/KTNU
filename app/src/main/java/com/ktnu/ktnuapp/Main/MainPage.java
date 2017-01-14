package com.ktnu.ktnuapp.Main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ktnu.ktnuapp.Retrofit.BoardApi;
import com.ktnu.ktnuapp.DTO.BoardMediumDTO;
import com.ktnu.ktnuapp.BoardWrite.BoardWritePage;
import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.Retrofit.RetrofitService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainPage extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    MainAdapter adapter;
    Toolbar toolbar;
    TextView write;
    BoardApi boardApi;
    Call<List<BoardMediumDTO>> list;
    List<BoardMediumDTO> results;
    SharedPreferences mPref;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           getWindow().setStatusBarColor(Color.BLACK);
        }
        mPref = this.getSharedPreferences("pref", Context.MODE_PRIVATE);


        toolbar = (Toolbar)findViewById(R.id.toolBar);
        write = (TextView)findViewById(R.id.write);
        title = (TextView)findViewById(R.id.title);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        boardApi = new RetrofitService().getService();

        list = boardApi.getBoardMiddleName(mPref.getString("id",""));

        list.enqueue(new Callback<List<BoardMediumDTO>>() {
            @Override
            public void onResponse(Response<List<BoardMediumDTO>> response) {
                if(response.isSuccess()){
                    results = response.body();

                    adapter = new MainAdapter(getSupportFragmentManager(),results);

                    viewPager.setAdapter(adapter);

                    tabLayout.setupWithViewPager(viewPager);
                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainPage.this,BoardWritePage.class);

                intent.putExtra("bdcode",mPref.getString("bdcode",""));

                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);

        title.setText(mPref.getString("name",""));

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }
}
