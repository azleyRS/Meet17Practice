package com.example.rus.meet17practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ForthActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(PersonListSingleton.getInstance());
        recyclerView.setAdapter(adapter);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ForthActivity.class);
        return intent;
    }
}
