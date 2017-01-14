package com.ktnu.ktnuapp.Index;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ktnu.ktnuapp.DTO.BoardLargeDTO;
import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.Retrofit.BoardApi;
import com.ktnu.ktnuapp.Retrofit.RetrofitService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class StartPage extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StartAdapter adapter;
    private GridLayoutManager gridLayoutManager;
    private BoardApi boardApi;
    private Call<List<BoardLargeDTO>> list;
    private List<BoardLargeDTO> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        gridLayoutManager = new GridLayoutManager(StartPage.this,2);

        recyclerView.setLayoutManager(gridLayoutManager);

        boardApi = new RetrofitService().getService();

        list = boardApi.getBoardName();

        //
        list.enqueue(new Callback<List<BoardLargeDTO>>() {
            @Override
            public void onResponse(Response<List<BoardLargeDTO>> response) {
                if(response.isSuccess()){
                    items = response.body();
                    adapter = new StartAdapter(StartPage.this,items);
                    recyclerView.setAdapter(adapter);
                }else{
                    Log.d("error",response.errorBody()+"");
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("result",t.getLocalizedMessage()+"");
            }
        });
    }
}
