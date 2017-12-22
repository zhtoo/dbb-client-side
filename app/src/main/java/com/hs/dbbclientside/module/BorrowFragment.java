package com.hs.dbbclientside.module;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hs.dbbclientside.base.BaseFragment;

/**
 * @author： Tom on 2017/12/18 23:41
 * @email： 820159571@qq.com
 *  
 */
public class BorrowFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  View view = inflater.inflate(setLayout(), container, false);
        TextView view =new TextView(getContext());
        view.setText(getClass().getSimpleName());

        return view;
    }


}
