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

public class MainActivity extends AppCompatActivity {

    EditText edText;
    AppCompatButton btn1, btn2;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
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
        String myString = edText.getText().toString();
        editor.putString("name", myString);
        editor.apply();
    }


    //==============================
    //==============================

}