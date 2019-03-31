package com.example.tesapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tesapp.R;
import com.example.tesapp.home.HomeActivity;
import com.example.tesapp.model.User;
import com.example.tesapp.register.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TextView create;
    Button login;
    private EditText edtemail, edtpassword;
    private User mUser;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        create= findViewById(R.id.txt_create);
        login = findViewById(R.id.btn_login);
        mUser = new User();
        edtemail = findViewById(R.id.edt_email);
        edtpassword = findViewById(R.id.edt_Password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));


            }
        });
    }

    void validasi() {
        mUser.email = edtemail.getText().toString();
        mUser.password = edtpassword.getText().toString();



        if (TextUtils.isEmpty(mUser.email) && TextUtils.isEmpty(mUser.password)) {
            showToast("Harap isi email dan password");
        } else if (TextUtils.isEmpty(mUser.email)) {
            edtemail.setError("isi Email");

        } else if (TextUtils.isEmpty(mUser.password)) {
            edtpassword.setError("Password Salah");
        } else {



            login(mUser.email, mUser.password);
        }


    }




    void login(String email, String paswoard){
        mAuth.signInWithEmailAndPassword(email, paswoard).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                }else {
                    showToast("GAGAL LOGIN FIREBASE");
                }


            }
        });

    }
    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}


