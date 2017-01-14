package com.ktnu.ktnuapp.BoardRead;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ktnu.ktnuapp.Retrofit.BoardApi;
import com.ktnu.ktnuapp.DTO.BoardListDTO;
import com.ktnu.ktnuapp.DTO.MessageDTO;
import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.Retrofit.ReplyApi;
import com.ktnu.ktnuapp.DTO.ReplyDTO;
import com.ktnu.ktnuapp.Retrofit.RetrofitService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by hojun on 2016-10-30.
 */
public class BoardReadPage extends Activity{

    private BoardApi boardApi;
    private ReplyApi replyApi;
    private Call<List<BoardListDTO>> list;
    private Call<List<ReplyDTO>> replyList;
    private TextView title;
    private TextView nickname;
    private TextView date;
    private TextView lookup;
    private TextView content;
    private TextView reply;
    int writenum;
    AlertDialog.Builder builder;
    List<ReplyDTO> replyReadList;
    Call<MessageDTO> replyInsert;
    ListView listView;
    BoardReadAdapter adapter;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_read_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }
        pref = getApplicationContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        title = (TextView)findViewById(R.id.title);
        nickname = (TextView)findViewById(R.id.nickname);
        date = (TextView)findViewById(R.id.date);
        lookup = (TextView)findViewById(R.id.lookup);
        content = (TextView)findViewById(R.id.content);
        reply = (TextView)findViewById(R.id.reply);
        boardApi = new RetrofitService().getService();

        writenum = getIntent().getIntExtra("writenum",0);

        list = boardApi.getBoardReadList(writenum);

        list.enqueue(new Callback<List<BoardListDTO>>() {
            @Override
            public void onResponse(Response<List<BoardListDTO>> response) {
                if(response.isSuccess()){
                    title.setText(response.body().get(0).getSubject());
                    nickname.setText(response.body().get(0).getNickname()+"님");
                    date.setText(response.body().get(0).getRegdate().split("T")[0]+"");
                    lookup.setText("조회수 "+response.body().get(0).getReadcnt()+"");
                    content.setText(response.body().get(0).getContent());
                    reply.setText("댓글: "+response.body().get(0).getReplycnt()+"개");
                }else{
                    Log.d("error",response.body()+"");
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Log.d("error",t.getMessage());
            }
        });

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(BoardReadPage.this);

                replyApi = new RetrofitService().getReplyService();

                replyList = replyApi.getReplyList(writenum);

                //댓글 정보 요청
                replyList.enqueue(new Callback<List<ReplyDTO>>() {
                    @Override
                    public void onResponse(final Response<List<ReplyDTO>> response) {
                        replyReadList = response.body();
                        //설정한 값으로 AlertDialog 객체 생성
                        final AlertDialog dialog=builder.create();

                        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                        View v = inflater.inflate(R.layout.activity_reply_list,null);

                        final EditText replyComment = (EditText)v.findViewById(R.id.replyComment);

                        v.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               //Toast.makeText(BoardReadPage.this,replyComment.getText().toString(),Toast.LENGTH_SHORT).show();

                               replyInsert = replyApi.postReplyList(writenum,pref.getString("nickname",""),pref.getString("bdcode",""),replyComment.getText().toString(),"");

                               //입력한 댓글 내용 서버에 저장
                               replyInsert.enqueue(new Callback<MessageDTO>() {
                                   @Override
                                   public void onResponse(Response<MessageDTO> response) {
                                       if (response.isSuccess()){
                                           replyComment.setText("");
                                           dialog.dismiss();
                                           adapter.notifyDataSetChanged();
                                       }

                                   }

                                   @Override
                                   public void onFailure(Throwable t) {

                                   }
                               });

                           }
                       });
                        listView = (ListView)v.findViewById(R.id.listView);

                        adapter = new BoardReadAdapter(BoardReadPage.this,replyReadList);

                        listView.setAdapter(adapter);

                        dialog.setView(v);
                        dialog.getWindow().setGravity(Gravity.BOTTOM);
                        //Dialog 보이기
                        dialog.show();
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });

            }
        });
    }
}
