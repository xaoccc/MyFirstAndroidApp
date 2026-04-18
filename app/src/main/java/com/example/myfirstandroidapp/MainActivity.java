package com.example.myfirstandroidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    public void doSomething(View button){
        Toast.makeText(this, "Button Clicked!!!", Toast.LENGTH_SHORT).show();
        System.out.println("Button Clicked");
    }

    public void toggleMainButton(View button){
        Button mainButton = findViewById(R.id.button1);
        if(button.getId() == R.id.button2) {
            mainButton.setEnabled(false);
            Toast.makeText(this, "Main Button Disabled!", Toast.LENGTH_SHORT).show();
        } else if (button.getId() == R.id.button3) {
            mainButton.setEnabled(true);
            Toast.makeText(this, "Main Button Enabled!", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeText(View v) {
        ((Button) v).setText("Text Changed!");
    }
}

