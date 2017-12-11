package com.example.navadroid.androidimplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// Ideas from https://www.formget.com/android-intent/
// and https://developer.android.com/guide/components/intents-common.html

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_intent_1).setOnClickListener(this);
        findViewById(R.id.btn_intent_2).setOnClickListener(this);
        findViewById(R.id.btn_intent_3).setOnClickListener(this);
        findViewById(R.id.btn_intent_4).setOnClickListener(this);
        findViewById(R.id.btn_intent_5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_intent_1:
                // TODO: Open media gallery
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(intent);
                break;
            case R.id.btn_intent_2:
                // TODO: Call Me
                intent.setAction(intent.ACTION_CALL);
                intent.setData(Uri.parse("Tel:0843693735"));
                startActivity(intent);
                break;
            case R.id.btn_intent_3:
                // TODO: Open URL in browser
                intent.setAction(intent.ACTION_VIEW);
                intent.setData(Uri.parse("https:www.facebook.com"));
                startActivity(intent);
                break;
            case R.id.btn_intent_4:
                // TODO: Camera
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.withAppendedPath(Uri.parse("content://media/external/images/media/"), "photo.jpg"));
                startActivity(intent);
                break;
            case R.id.btn_intent_5:
                // TODO: ???
                break;

        }
    }
}
