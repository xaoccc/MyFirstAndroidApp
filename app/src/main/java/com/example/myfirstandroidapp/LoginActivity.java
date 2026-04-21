package com.example.myfirstandroidapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText nameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        nameInput = findViewById(R.id.userNameInput);

    }

    public void submit(View v) {
        Intent intent = new Intent(this, AppActivity.class);
        String name = nameInput.getText().toString();

        //  Pass the name to the AppActivity
        intent.putExtra("USERNAME", name);
        startActivity(intent);
    }
}
