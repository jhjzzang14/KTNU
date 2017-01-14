package com.ktnu.ktnuapp.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ktnu.ktnuapp.DTO.BoardListDTO;
import com.ktnu.ktnuapp.R;

import java.util.List;

/**
 * Created by hojun on 2016-10-30.
 */
public class MainBoardAdapter extends BaseAdapter{

    private LayoutInflater inflater;

    private List<BoardListDTO> boardListDTOList;

    public MainBoardAdapter(Context context,List<BoardListDTO> boardListDTOList){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.boardListDTOList = boardListDTOList;
    }

    @Override
    public int getCount() {

        //Model에서 게시글 개수 만큼 가지고 옴

        return boardListDTOList.size();
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

        if(view == null){
            view = inflater.inflate(R.layout.activity_board_list,null);
        }

        TextView title = (TextView)view.findViewById(R.id.title);
        TextView nickName = (TextView)view.findViewById(R.id.nickname);
        TextView date = (TextView)view.findViewById(R.id.date);
        TextView lookup = (TextView)view.findViewById(R.id.lookup);
        TextView content = (TextView)view.findViewById(R.id.content);

        title.setText(boardListDTOList.get(i).getSubject());
        nickName.setText(boardListDTOList.get(i).getNickname()+"님");
        date.setText(boardListDTOList.get(i).getRegdate());
        lookup.setText(boardListDTOList.get(i).getReadcnt()+"");
        content.setText(boardListDTOList.get(i).getContent());

        return view;
    }
}
