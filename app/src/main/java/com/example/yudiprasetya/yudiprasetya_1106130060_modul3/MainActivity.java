package com.example.yudiprasetya.yudiprasetya_1106130060_modul3;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.Password);
        btnLogin = (Button) findViewById(R.id.login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();


                if (usernameKey.equals("EAD") && passwordKey.equals("MOBILE")) {

                    Toast.makeText(getApplicationContext(), "Login Sukses...!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, empat.class);
                    intent.putExtra("username",usernameKey);
                    intent.putExtra("password",passwordKey);
                    MainActivity.this.startActivity(intent);
                }
                else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Username Atau Password Anda Salah...!")
                            .setNegativeButton("Retry...", null).create().show();

                }
            }
        });
    }}
