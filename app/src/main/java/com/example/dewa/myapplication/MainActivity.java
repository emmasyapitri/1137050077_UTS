package com.example.dewa.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // Session Manager Class
    SessionManager session;
    // Button Logout
    Button btnLogout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Session class instance
        session = new SessionManager(getApplicationContext());
        TextView lblName = (TextView) findViewById(R.id.lblNama);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
// Button logout
        btnLogout = (Button) findViewById(R.id.btnLogout);
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();
// Cek User apakah sudah login
        session.checkLogin();
// Mendapatkan data user dari session
        HashMap<String, String> user = session.getUserDetails();
// nama
        String name = user.get(SessionManager.KEY_NAME);
// email
        String email = user.get(SessionManager.KEY_EMAIL);
// menampilkan user data
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));
/**
 * Logout button click event
 * */
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// menghapus session data
// dan mengarahakan ke LoginActivity
                session.logoutUser();
                finish();
            }
        });
    }
}