package com.example.tesapp.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tesapp.R;
import com.example.tesapp.database.DatabaseHelper;
import com.example.tesapp.login.LoginActivity;
import com.example.tesapp.model.User;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    TextView txt_login;
    Button signup;
    private EditText edtemail, edtpassword, edtrytype;
    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        txt_login = findViewById(R.id.txt_btnlogin);
        signup = findViewById(R.id.btn_signup);
        mUser = new User();
        edtemail = findViewById(R.id.txt_emailregister);
        edtpassword = findViewById(R.id.txt_passwordregister);
        edtrytype = findViewById(R.id.txt_retyperegister);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasiBaru();
            }
        });
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));


            }
        });
    }

    void validasi() {
        mUser.email = edtemail.getText().toString();
        mUser.password = edtpassword.getText().toString();
        mUser.rytpepassword = edtrytype.getText().toString();



        if (TextUtils.isEmpty(mUser.email) && TextUtils.isEmpty(mUser.password)) {
            showToast("Harap isi email dan password");
        } else if (TextUtils.isEmpty(mUser.email)) {
            edtemail.setError("isi Email");

        } else if (TextUtils.isEmpty(mUser.password)) {
            edtpassword.setError("Password Salah");
        } else if (TextUtils.isEmpty(mUser.rytpepassword)){
            edtrytype.setError("Harap masukan password kembali");
        }

        else if (mUser.password.equals(mUser.rytpepassword)){
            edtrytype.setError("Harap Masukan Password Kembali");
            showToast("Harap isi kembali password yang sama");

        }



        else {
            signup();
        }


    }

    void startActivity() {
        if(edtpassword.equals(edtrytype))
            startActivity();
    }

    void signup(){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }
    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    void validasi2(){
        String s1 = edtemail.getText().toString();
        String s2 = edtpassword.getText().toString();
        String s3 = edtrytype.getText().toString();

        if (s1.equals("")|| s2.equals("") || s3.equals("")){
            Toast.makeText(getApplicationContext(), "Harap Masukan Email Dan Password",Toast.LENGTH_SHORT).show();
        }
        else{
            if(s2.equals(s3)){
                boolean chkemail = db.chkemail(s1);
                if (chkemail == true){
                    boolean insert = db.insert(s1,s2);
                    if(insert == true){
                        signup();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Email Already exists",Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
    void validasiBaru(){

        mUser.email = edtemail.getText().toString();
        mUser.password = edtpassword.getText().toString();
        mUser.rytpepassword = edtrytype.getText().toString();

        // jika email, password dan retry password kosong maka akan ada pesan peringantan "Harap isi email dan password"
        if (TextUtils.isEmpty(mUser.email) && TextUtils.isEmpty(mUser.password) && TextUtils.isEmpty(mUser.rytpepassword)) {
            showToast("Harap isi email dan password");

            //jika email kosong maka edittext email eror
        } else if (TextUtils.isEmpty(mUser.email)) {
            edtemail.setError("isi Email");

            //jika email kosong maka edittext password eror
        } else if (TextUtils.isEmpty(mUser.password)) {
            edtpassword.setError("Password Salah");

            // jika kondisi tidak terpenuhi maka akan menjalankan else ini
            // else ini akan menghandle 2 kondisi jika edittext email, password, retypePassword terisi dan
            // jika retypePassword kosong atau beda dengan password
            // jadi di dalam else bikin lg if untuk menghandle 2 kondisi tersebut
        } else {

            // nah if ini akan memvalidasi value reptyPassword kosong dan beda jika sama value dengan password maka akan login
            // jika tidak akan ada toast tidak sama
            if (mUser.rytpepassword.equals(mUser.password)) {
                signup();
            } else {
                showToast("Tidak sama");
            }
        }

    }

}
