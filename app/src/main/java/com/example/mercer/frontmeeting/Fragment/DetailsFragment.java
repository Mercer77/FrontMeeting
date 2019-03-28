package com.example.mercer.frontmeeting.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mercer.frontmeeting.R;

public class DetailsFragment extends Fragment {
    private TextView nowDate;
    private Handler mHandler;
    @SuppressLint("HandlerLeak")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);
        nowDate = view.findViewById(R.id.nowDate);
        mHandler  = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        long sysTime = System.currentTimeMillis();//获取系统时间
                        CharSequence sysTimeStr = DateFormat.format("yyyy-MM-dd hh:mm:ss", sysTime);//时间显示格式
                        nowDate.setText(sysTimeStr); //更新时间
                        break;
                    default:
                        break;

                }
            }
        };
        new TimeThread().start();
        return view;
    }
    class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;  //消息(一个整型值)
                   mHandler.sendMessage(msg);// 每隔1秒发送一个msg给mHandler
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }

    }

}


