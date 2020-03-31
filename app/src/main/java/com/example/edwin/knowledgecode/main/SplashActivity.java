package com.example.edwin.knowledgecode.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.edwin.knowledgecode.R;

public class SplashActivity extends Activity {

    private StartTask task = null;
    private Handler mMainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }
        setContentView(R.layout.activity_splash);
        FrameLayout linearLayout = findViewById(R.id.splash);
        linearLayout.setSystemUiVisibility(View.GONE);
        task = new StartTask();
        mMainHandler.postDelayed(task, 1000);
    }

    private class StartTask implements Runnable {

        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
