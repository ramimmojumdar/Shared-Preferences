package com.example.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edName, edAge, edEmail, edPhone, edPassport;
    AppCompatButton btn1, btn2;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edEmail = findViewById(R.id.edEmail);
        edPhone= findViewById(R.id.edPhone);
        edPassport = findViewById(R.id.edPassport);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        sharedPreferences = getSharedPreferences(""+ getString(R.string.app_name), MODE_PRIVATE);
        editor= sharedPreferences.edit();

//===============================
//===============================

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveMethod();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });




//=================================
//=================================

    }

    //=============================
    //=============================
    public void saveMethod(){
        String nameStr = edName.getText().toString();
        String ageStr = edAge.getText().toString();
        String emailStr = edEmail.getText().toString();
        String phoneStr = edPhone.getText().toString();
        String passportStr = edPassport.getText().toString();

        editor.putString("name", nameStr);
        editor.putString("age", ageStr);
        editor.putString("email", emailStr);
        editor.putString("phone", phoneStr);
        editor.putString("passport", passportStr);
        editor.apply();
    }


    //==============================
    //==============================

}