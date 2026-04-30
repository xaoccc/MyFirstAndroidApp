package com.example.myfirstandroidapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

public class LoginActivity extends BaseActivity {
    private EditText userNameInput;
    private EditText passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        userNameInput = findViewById(R.id.userNameInput);
        passwordInput = findViewById(R.id.passwordInput);

    }

    public void submit(View v) {
        SharedPreferences prefs;

        try {
            MasterKey masterKey = new MasterKey.Builder(this)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build();

            prefs = EncryptedSharedPreferences.create(
                    this,
                    "secure_prefs", // SAME NAME
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        String savedUsername = prefs.getString("username", null);
        String savedPassword = prefs.getString("password", null);

        String inputUsername = userNameInput.getText().toString();
        String inputPassword = passwordInput.getText().toString();

        if (savedUsername != null && savedPassword != null &&
                savedUsername.equals(inputUsername) &&
                savedPassword.equals(inputPassword)) {

            Intent intent = new Intent(this, AppActivity.class);

            //  Pass the name to the AppActivity
            intent.putExtra("USERNAME", inputUsername);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
