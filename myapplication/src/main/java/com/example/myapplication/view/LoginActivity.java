package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextPersonName;
    private EditText editTextTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPersonName=findViewById(R.id.editTextPersonName);
        editTextTextPassword =findViewById(R.id.editTextTextPassword);
    }


}