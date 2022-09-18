package com.saadullahkhan.i190474;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateAccount extends AppCompatActivity {
    TextView show ;
    TextView hide ;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        show = findViewById(R.id.showCreateAccount);
        hide = findViewById(R.id.hideCreateAccount);
        password = findViewById(R.id.passwordCreateAccount);
    }
    public void onSignInCA(View v) {
        startActivity(new Intent(CreateAccount.this, SignIn.class));
    }
    public void onShowCreateAccount(View v) {
        show.setVisibility(View.INVISIBLE);
        hide.setVisibility(View.VISIBLE);
        password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

    }
    public void onHideCreateAccount(View v) {
        show.setVisibility(View.VISIBLE);
        hide.setVisibility(View.INVISIBLE);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

    }
}