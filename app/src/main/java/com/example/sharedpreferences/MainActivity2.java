package com.example.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView saveText;
    SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        saveText = findViewById(R.id.saveText);

        sharedPreferences = getSharedPreferences(""+getString(R.string.app_name), MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "Default Value");
        String age = sharedPreferences.getString("age", "Default Value");
        String email = sharedPreferences.getString("email", "Default Value");
        String phone = sharedPreferences.getString("phone", "Default Value");
        String passport = sharedPreferences.getString("passport", "Default Value");

        String[] array = {name, age, email, phone, passport};

        for(int x=0; x<array.length; x++){
            saveText.append(array[x]+" \n");
        }




    }
}