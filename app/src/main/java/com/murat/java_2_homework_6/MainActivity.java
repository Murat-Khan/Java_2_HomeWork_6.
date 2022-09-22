package com.murat.java_2_homework_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private TextView forgot, textView, input;
    private EditText email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        logic();
    }


    private void init() {
        login = findViewById(R.id.login);
        forgot = findViewById(R.id.forgot);
        textView = findViewById(R.id.text_view);
        input = findViewById(R.id.input);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }

    private void logic() {
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onLoginButtonEnable();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                onLoginButtonEnable();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.getText().toString().equals("admin") || password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались",
                            Toast.LENGTH_SHORT).show();
                    email.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    login.setVisibility(View.GONE);
                    input.setVisibility(View.GONE);
                    forgot.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();

                }
            }

        });


    }

    private void onLoginButtonEnable() {
        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            login.setBackgroundColor(getResources().getColor(R.color.grey));
            login.setEnabled(false);
        } else {
            login.setBackgroundColor(getResources().getColor(R.color.brown));
            login.setEnabled(true);
        }
    }
}