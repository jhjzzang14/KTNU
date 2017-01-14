package com.ktnu.ktnuapp.Index;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ktnu.ktnuapp.DTO.BoardLargeDTO;
import com.ktnu.ktnuapp.Main.MainPage;
import com.ktnu.ktnuapp.R;

import java.util.List;

/**
 * Created by hojun on 2016-10-30.
 */
public class StartAdapter extends RecyclerView.Adapter<StartAdapter.ViewHolder> {

    private LayoutInflater inflater;
    static SharedPreferences mPref;
    static List<BoardLargeDTO> list;


    public StartAdapter(Context context,List<BoardLargeDTO> list){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPref = context.getSharedPreferences("pref",Context.MODE_PRIVATE);
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_start_list_item,parent,false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
          holder.title.setText(list.get(position).getName());
    }

    // 필수로 Generate 되어야 하는 메소드 3
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView img;
        public TextView title;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView)view.findViewById(R.id.image);
            title = (TextView)view.findViewById(R.id.title);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    SharedPreferences.Editor editor = mPref.edit();
                    editor.putString("id", list.get(getAdapterPosition()).getId());
                    editor.putString("name", list.get(getAdapterPosition()).getName());
                    editor.commit();

                    Intent intent = new Intent(view.getContext(),MainPage.class);

                    view.getContext().startActivity(intent);
                }
            });

        }
    }
}
