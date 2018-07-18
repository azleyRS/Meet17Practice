package com.example.rus.meet17practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {

    private TextView surname;
    private TextView name;
    private TextView secondName;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        position = getIntent().getIntExtra("position",0);

        init();
    }

    private void init() {
        Person person = PersonListSingleton.getInstance().get(position);
        surname = findViewById(R.id.surname_textview_second);
        name = findViewById(R.id.name_textview_second);
        secondName = findViewById(R.id.second_name_textview_second);

        surname.setText(person.getSurname());
        name.setText(person.getName());
        secondName.setText(person.getSecondName());
    }


    public static Intent newIntent(Context context, int position) {
        Intent intent = new Intent(context, FifthActivity.class);
        intent.putExtra("position", position);
        return intent;
    }
}
