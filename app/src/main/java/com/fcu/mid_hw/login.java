package com.fcu.mid_hw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login extends AppCompatActivity
    implements OnCompleteListener<AuthResult> {

    private EditText etEmail;
    private EditText etPassword;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etEmail = findViewById(R.id.lo_email);
        etPassword = findViewById(R.id.lo_password);
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void onLogin(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,this);
    }

    public void onBack(View view){
        Intent intent = new Intent();
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Toast.makeText(this,"Successful",Toast.LENGTH_LONG).show();
            MainActivity.VALID_USER = true;
            finish();
        }else{
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
        }

    }
}