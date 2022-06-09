package com.fcu.mid_hw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class RegitserActivity extends AppCompatActivity implements OnCompleteListener{

    private EditText etEmail;
    private EditText etPassword;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regitser);

        etEmail = findViewById(R.id.re_email);
        etPassword = findViewById(R.id.re_pass);

        firebaseAuth = firebaseAuth.getInstance();
    }

    public void onregister(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,this);
    }

    @Override
    public void onComplete(@NonNull Task task) {

        if(task.isSuccessful()){
            Toast.makeText(this,"註冊成功",Toast.LENGTH_LONG).show();
            addUser();
            Intent intent = new Intent();
            intent.setClass(RegitserActivity.this, regitser2.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }

    }

    private void addUser() {
        String email = etEmail.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = firebaseDatabase.getReference("users");
        Map<String,Object> user = new HashMap<>();
        user.put("email",email);


    }
}