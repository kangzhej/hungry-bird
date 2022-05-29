package com.fcu.mid_hw;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fcu.mid_hw.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.view.View;

import java.util.HashMap;
import java.util.Map;

public class regitser2 extends AppCompatActivity implements OnCompleteListener {

    private EditText etEmail;
    private EditText etPassword;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        firebaseAuth = firebaseAuth.getInstance();
    }

    public void onRegister(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this,this);
    }

    @Override
    public void onComplete(@NonNull Task task) {

        if(task.isSuccessful()){
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
            addUser();
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