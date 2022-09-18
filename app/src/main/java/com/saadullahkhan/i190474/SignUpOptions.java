package com.saadullahkhan.i190474;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_options);
    }
    public void onSignInOP(View v) {
        startActivity(new Intent(SignUpOptions.this, SignIn.class));
    }
    public void onCreateAccount(View v) {
        startActivity(new Intent(SignUpOptions.this, CreateAccount.class));
    }

}