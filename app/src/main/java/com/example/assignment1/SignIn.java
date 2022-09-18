package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {
    TextView show ;
    TextView hide ;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        show = findViewById(R.id.showSignIn);
        hide = findViewById(R.id.hideSignIn);
        password = findViewById(R.id.passwordSignIn);
    }
    public void onSignUpSI(View v) {
        startActivity(new Intent(SignIn.this, SignUpOptions.class));
    }
    public void onShowSignIn(View v) {
        show.setVisibility(View.INVISIBLE);
        hide.setVisibility(View.VISIBLE);
        password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }
    public void onHideSignIn(View v) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.INVISIBLE);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    public void onClickSignIn(View v) {
        startActivity(new Intent(SignIn.this, Home.class));
    }

}