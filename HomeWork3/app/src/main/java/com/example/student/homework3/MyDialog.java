package com.example.student.homework3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyDialog extends DialogFragment {

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.item_dialog, container, false);

        TextView textView = v.findViewById(R.id.progress_text);

        if (getArguments() != null) {
            textView.setText("Please wait " + getArguments().getString(MainActivity.KEY_DIALOG) + " seconds");
        }

        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                dismiss();
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(Integer.valueOf(getArguments().getString(MainActivity.KEY_DIALOG)) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(new Message());
            }

        }).start();

        return v;
    }
}
