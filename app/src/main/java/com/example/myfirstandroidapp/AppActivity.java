package com.example.myfirstandroidapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app);

        TextView greeting = findViewById(R.id.greeting);
        //  Get the username from the previous Activity
        String name = getIntent().getStringExtra("USERNAME");
        greeting.setText(String.format("Welcome, %s", name));
    }

}
