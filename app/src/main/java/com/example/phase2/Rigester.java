package com.example.phase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import android.widget.Toast;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;


public class Rigester extends AppCompatActivity {



    String Appid ="practiceformongo-ofpcf";
    private App app;

    String susernaem,spassword,semail,sfullname;
    User user;

    EditText username, password, fullname,email;
    Button createacc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_rigester);

        Toast.makeText(getApplicationContext(),"Sign up page",Toast.LENGTH_LONG).show();
        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        fullname = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextEmailAddress2);
        createacc = findViewById(R.id.button4);

        app = new App(new AppConfiguration.Builder(Appid).build());

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                semail = email.getText().toString();
                susernaem = username.getText().toString();
                sfullname = fullname.getText().toString();
                spassword = password.getText().toString();

                Credentials cre = Credentials.emailPassword(semail, spassword);
                app.getEmailPassword().registerUserAsync(semail,spassword,result -> {

                    if(result.isSuccess()){

                        Toast.makeText(getApplicationContext(),"Sign up succesfull!!",Toast.LENGTH_SHORT).show();
                        user = app.currentUser();
                        Intent in = new Intent(getApplicationContext(),Login.class);
                        startActivity(in);
                        Toast.makeText(getApplicationContext(),"Now confirm user in Gmail and then Login",Toast.LENGTH_LONG).show();

                    }
                    else{

                        Log.v("Signup", String.valueOf(result.getError()));
                        Toast.makeText(getApplicationContext(),"Sign up not  succesfull!!",Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });

    }



}

