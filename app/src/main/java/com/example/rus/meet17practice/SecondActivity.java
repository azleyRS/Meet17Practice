package com.example.rus.meet17practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView surname;
    private TextView name;
    private TextView secondName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }

    private void init() {
        final PersonSingleton personSingleton = PersonSingleton.getInstance();
        surname = findViewById(R.id.surname_textview_second);
        name = findViewById(R.id.name_textview_second);
        secondName = findViewById(R.id.second_name_textview_second);

        surname.setText(personSingleton.getSurname());
        surname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(personSingleton.getSurname());
            }
        });
        name.setText(personSingleton.getName());
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(personSingleton.getName());
            }
        });
        secondName.setText(personSingleton.getSecondName());
        secondName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(personSingleton.getSecondName());
            }
        });
    }

    private void openActivity(String text) {
        Intent intent = ThirdActivity.newIntent(this, text);
        startActivity(intent);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        return intent;
    }


}
