package com.ktnu.ktnuapp.Main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ktnu.ktnuapp.BoardRead.BoardReadPage;
import com.ktnu.ktnuapp.DTO.BoardListDTO;
import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.Retrofit.BoardApi;
import com.ktnu.ktnuapp.Retrofit.RetrofitService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by hojun on 2016-10-30.
 */
public class MainBoardPage extends Fragment {

    ListView listView;
    MainBoardAdapter adapter;
    SharedPreferences pref;
    Call<List<BoardListDTO>> boardList;
    BoardApi boardApi;
    List<BoardListDTO> results;

    String bdcode;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        bdcode = args.getString("bdcode");
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        pref = inflater.getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        View view = inflater.inflate(R.layout.activity_board_layout,null);

        listView = (ListView)view.findViewById(R.id.listView);

        boardApi = new RetrofitService().getService();

        boardList = boardApi.getBoardList(bdcode);

        boardList.enqueue(new Callback<List<BoardListDTO>>() {
            @Override
            public void onResponse(final Response<List<BoardListDTO>> response) {
                if(response.isSuccess()){
                    results = response.body();

                    adapter = new MainBoardAdapter(inflater.getContext(),results);

                    listView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("bdcode", response.body().get(i).getBdcode());
                            editor.commit();
                            Intent intent = new Intent(inflater.getContext(),BoardReadPage.class);
                            intent.putExtra("writenum", results.get(i).getWritenum());
                            startActivity(intent);
                        }
                    });


                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


        return view;
    }

}
