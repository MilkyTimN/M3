package com.example.m3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(view -> {
            sendMessage();
        });
    }

    private void sendMessage() {
        TextInputLayout emailTIL = findViewById(R.id.ti_layout_email);
        String email = emailTIL.getEditText().getText().toString();

        TextInputLayout themeTIL = findViewById(R.id.ti_layout_theme);
        String theme = themeTIL.getEditText().getText().toString();

        TextInputLayout messageTIL = findViewById(R.id.ti_layout_message);
        String message = messageTIL.getEditText().getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        emailIntent.setData(Uri.parse("mailto:" + email));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, theme);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {
            Toast.makeText(this, "No mail senders", Toast.LENGTH_LONG).show();
        }

    }
}