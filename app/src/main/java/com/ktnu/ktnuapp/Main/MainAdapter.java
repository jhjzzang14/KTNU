package com.ktnu.ktnuapp.Main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ktnu.ktnuapp.DTO.BoardMediumDTO;

import java.util.List;

/**
 * Created by hojun on 2016-10-29.
 */
public class MainAdapter extends FragmentStatePagerAdapter {
    private List<BoardMediumDTO> results;
    public MainAdapter(FragmentManager fm, List<BoardMediumDTO> results) {
        super(fm);
        this.results = results;
    }

    @Override
    public Fragment getItem(int position) {
        //Fragment 하나에서 관리
        MainBoardPage mainBoardPage = new MainBoardPage();

        Bundle bundle = new Bundle();

        bundle.putString("bdcode",results.get(position).getId());

        mainBoardPage.setArguments(bundle);

        return mainBoardPage;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        //Model에서 getTitle을 가져옴
        //ex)model.getTitle(position) 해당 되는 네임을 가지고 올수 있음
        return results.get(position).getName();
    }

    @Override
    public int getCount() {
        //게시판 개수 만큼
        //ex)정보 게시판 5개 count = 5
        return results.size();
    }
}
