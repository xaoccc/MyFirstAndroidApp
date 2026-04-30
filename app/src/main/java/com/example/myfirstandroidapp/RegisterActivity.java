package com.example.myfirstandroidapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;


public class RegisterActivity extends BaseActivity {
    private EditText nameInput;
    private EditText password1Input;
    private EditText password2Input;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_register);

            nameInput = findViewById(R.id.registerUserUserName);
            password1Input = findViewById(R.id.password1);
            password2Input = findViewById(R.id.password2);
        }

    public void registerActivity(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        SharedPreferences prefs;

        try {
            MasterKey masterKey = new MasterKey.Builder(this)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build();

            prefs = EncryptedSharedPreferences.create(
                    this,
                    "secure_prefs",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (nameInput == null || password1Input == null || password2Input == null) {
            throw new RuntimeException("View not initialized properly");
        }

        String name = nameInput.getText().toString();
        String password1 = password1Input.getText().toString();
        String password2 = password2Input.getText().toString();

        if (password1.equals(password2)) {
            prefs.edit()
                    .putString("username", name)
                    .putString("password", password1)
                    .apply();

            startActivity(intent);
        } else {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
        }
    }


}