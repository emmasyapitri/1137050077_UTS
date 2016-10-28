package com.example.dewa.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DEWA on 10/27/2016.
 */
public class LoginActivity extends android.support.v7.app.AppCompatActivity {
    // Email, password edittext
    EditText txtUsername, txtPassword;
    // isi Shared Preferences
    private final String NAMA = "Belajar Sessions";
    private final String EMAIL = "email@gmail.com";
    // Username dan password
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";
    // login button
    Button btnLogin;
    // Session Manager Class
    SessionManager session;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
// Session Manager
        session = new SessionManager(getApplicationContext());
// Email, Password input text
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
// Menampilkan Status Login dengan Toast
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// Get username, password from EditText
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
// cek jika username dan password terisi
                if(username.trim().length() > 0 && password.trim().length() >
                        0){
// jika username dan password sesuai dengan data
                    if(username.equals(USERNAME) && password.equals(PASSWORD)){
// membuat user login session
// menyimpan data nama dan email
                        session.createLoginSession(NAMA, EMAIL);
// Mengarahkan ke MainActivity
                        Intent i = new Intent(getApplicationContext(),
                                MainActivity.class);
                        startActivity(i);
                        finish();
                    }else{
// username / password tidak sesuai
                        Toast.makeText(getApplicationContext(), "Login Gagal..\n"
                                + "Username/Password anda salah", Toast.LENGTH_LONG).show();
                    }
                }else{
// user tidak memasukan username atau password
                    Toast.makeText(getApplicationContext(), "Login Gagal..\n" +
                            "Silahlkan masukan username dan password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
