package com.saadullahkhan.i190474;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class CreateAccount extends AppCompatActivity {
    TextView show ;
    TextView hide ;
    EditText password,name,number,otpText;
    TextView signIn;
    Button signUp,otp;
    FirebaseAuth mAuth;
    PhoneAuthCredential credentials;
    String codeGot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        show = findViewById(R.id.showCreateAccount);
        hide = findViewById(R.id.hideCreateAccount);
        password = findViewById(R.id.passwordCreateAccount);
        name = findViewById(R.id.nameSignUp);
        otpText = findViewById(R.id.otpSignUp);
        number = findViewById(R.id.numberSignUp);
        password = findViewById(R.id.passwordCreateAccount);
        signIn=findViewById(R.id.signInSignUp);
        signUp = findViewById(R.id.signUpButton);
        otp = findViewById(R.id.otpGenerate);
        mAuth = FirebaseAuth.getInstance();
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(number.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Enter Valid Phone Number", Toast.LENGTH_LONG).show();
                }
                else
                {
                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber(number.getText().toString())       // Phone number to verify
                                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                    .setActivity(CreateAccount.this)                 // Activity (for callback binding)
                                    .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                        @Override
                                        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                            super.onCodeSent(s, forceResendingToken);
                                            codeGot = s;

                                        }

                                        @Override
                                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                            final String code = phoneAuthCredential.getSmsCode();
                                            if(code != null)
                                            {
                                                verifyCode(code);
                                            }
                                        }

                                        @Override
                                        public void onVerificationFailed(@NonNull FirebaseException e) {
                                            Toast.makeText(getApplicationContext(),"other fail "+e.getMessage(),Toast.LENGTH_LONG).show();
                                        }})          // OnVerificationStateChangedCallbacks
                                    .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);

                }
            }
        });


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setVisibility(View.VISIBLE);
                hide.setVisibility(View.INVISIBLE);
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setVisibility(View.INVISIBLE);
                hide.setVisibility(View.VISIBLE);
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(otpText.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Wrong OTP Entered ", Toast.LENGTH_LONG).show();
                }else if(TextUtils.isEmpty(name.getText().toString())||TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Enter Complete Details ", Toast.LENGTH_LONG).show();
                }
                else {
                    verifyCode(otpText.getText().toString());
                    if (credentials!=null) {

                        mAuth.createUserWithEmailAndPassword(number.getText().toString()+"@xyz.com",password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseDatabase.getInstance().getReference("Users").child(mAuth.getCurrentUser().getUid()).setValue(new User(name.getText().toString(), number.getText().toString(), password.getText().toString())).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(getApplicationContext(), "User have been Successfully Registered", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(CreateAccount.this, Home.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(), "User not created because " + e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "sign up fail " + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                }

            }
        });
    }
    void verifyCode(String Code)
    {
        credentials = PhoneAuthProvider.getCredential(codeGot,Code);
    }

}