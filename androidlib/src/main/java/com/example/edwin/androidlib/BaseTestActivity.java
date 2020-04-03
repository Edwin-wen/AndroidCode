package com.example.edwin.androidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BaseTestActivity extends AppCompatActivity implements View.OnClickListener {

    protected List<Button> mBtnList = new ArrayList<>();
    private IClickProxy mClickProxy;
    private LinearLayout mContatiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_func_test);
        initButton();
    }

    protected void initFunc(String[] buttonTexts, IClickProxy proxy) {
        mClickProxy = proxy;
        int needAdd = buttonTexts.length;
        for (int i = 0; i < mBtnList.size(); i++) {
            needAdd--;
            Button button = mBtnList.get(i);
            if (needAdd < 0) {
                mBtnList.get(i).setVisibility(View.GONE);
            } else {
                mBtnList.get(i).setVisibility(View.VISIBLE);
                button.setText(buttonTexts[i]);
            }
        }
    }

    private void initButton() {
        mContatiner = findViewById(R.id.func_container);
        Button button = findViewById(R.id.func_btn1);
        button.setOnClickListener(this);
        mBtnList.add(button);
        button = findViewById(R.id.func_btn2);
        button.setOnClickListener(this);
        mBtnList.add(button);
        button = findViewById(R.id.func_btn3);
        button.setOnClickListener(this);
        mBtnList.add(button);
        button = findViewById(R.id.func_btn4);
        button.setOnClickListener(this);
        mBtnList.add(button);
        button = findViewById(R.id.func_btn5);
        button.setOnClickListener(this);
        mBtnList.add(button);
        button = findViewById(R.id.func_btn6);
        button.setOnClickListener(this);
        mBtnList.add(button);
        button = findViewById(R.id.func_btn7);
        button.setOnClickListener(this);
        mBtnList.add(button);
        button = findViewById(R.id.func_btn8);
        button.setOnClickListener(this);
        mBtnList.add(button);

    }

    protected TextView addShowTextView() {
        TextView view = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        view.setGravity(Gravity.CENTER);
        view.setLayoutParams(params);
        view.setHint("初始文本");
        mContatiner.addView(view);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.func_btn1) {
            mClickProxy.handleFunc1();
        } else if (id == R.id.func_btn2) {
            mClickProxy.handleFunc2();
        } else if (id == R.id.func_btn3) {
            mClickProxy.handleFunc3();
        } else if (id == R.id.func_btn4) {
            mClickProxy.handleFunc4();
        } else if (id == R.id.func_btn5) {
            mClickProxy.handleFunc5();
        } else if (id == R.id.func_btn6) {
            mClickProxy.handleFunc6();
        } else if (id == R.id.func_btn7) {
            mClickProxy.handleFunc7();
        } else if (id == R.id.func_btn8) {
            mClickProxy.handleFunc8();
        }
    }

    public interface IClickProxy {
        void handleFunc1();
        void handleFunc2();
        void handleFunc3();
        void handleFunc4();
        void handleFunc5();
        void handleFunc6();
        void handleFunc7();
        void handleFunc8();
    }
}
