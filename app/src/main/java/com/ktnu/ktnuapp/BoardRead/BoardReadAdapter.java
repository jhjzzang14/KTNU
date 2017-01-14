package com.ktnu.ktnuapp.BoardRead;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ktnu.ktnuapp.R;
import com.ktnu.ktnuapp.DTO.ReplyDTO;

import java.util.List;

/**
 * Created by hojun on 2016-11-10.
 */
public class BoardReadAdapter extends BaseAdapter{
    private Context context;
    List<ReplyDTO> list;
    LayoutInflater inflater;
    public BoardReadAdapter(Context context,List<ReplyDTO> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null) {
            view = inflater.inflate(R.layout.reply_list_item, null);
        }

        TextView nickname = (TextView)view.findViewById(R.id.nickname);
        TextView content = (TextView)view.findViewById(R.id.content);
        TextView date = (TextView)view.findViewById(R.id.date);


        nickname.setText(list.get(i).getNickname()+":");

        content.setText(list.get(i).getComment());

        date.setText("작성일: "+list.get(i).getRegdate().split("T")[0]);

        return view;
    }
}
