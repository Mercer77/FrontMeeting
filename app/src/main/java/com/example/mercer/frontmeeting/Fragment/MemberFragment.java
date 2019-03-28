package com.example.mercer.frontmeeting.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mercer.frontmeeting.R;

public class MemberFragment extends Fragment {
 private ImageView wangwu;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member,container,false);
        wangwu = view.findViewById(R.id.wangwu);
//        wangwu.setImageResource(R.drawable.select);

        return view;

    }

}
