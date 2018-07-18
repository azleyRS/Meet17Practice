package com.example.rus.meet17practice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView surname;
    private TextView name;
    private TextView secondName;
    private Button sendButton;

    private Button addButton;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        surname = findViewById(R.id.surname_edittext);
        name = findViewById(R.id.name_edittext);
        secondName = findViewById(R.id.second_name_edittext);
        sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doButtonStaff();
            }
        });

        addButton = findViewById(R.id.add_to_list_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();
                person.setSurname(surname.getText().toString());
                person.setName(name.getText().toString());
                person.setSecondName(secondName.getText().toString());
                PersonListSingleton.addPerson(person);

                InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

                surname.setHint(surname.getText());
                name.setHint(name.getText());
                secondName.setHint(secondName.getText());

                surname.setText("");
                name.setText("");
                secondName.setText("");
            }
        });

        checkButton = findViewById(R.id.check_list_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = ForthActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private void doButtonStaff() {
        PersonSingleton personSingleton = PersonSingleton.getInstance();
        personSingleton.setName(name.getText().toString());
        personSingleton.setSurname(surname.getText().toString());
        personSingleton.setSecondName(secondName.getText().toString());
        Intent intent = SecondActivity.newIntent(this);
        startActivity(intent);
    }
}
