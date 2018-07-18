package com.example.rus.meet17practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        init();
    }

    private void init() {
        textView = findViewById(R.id.third_activity_textview);
        textView.setText(getIntent().getStringExtra("text"));
    }

    public static Intent newIntent(Context context, String text) {
        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra("text", text);
        return intent;
    }
}
