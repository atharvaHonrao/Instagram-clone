package com.example.phase2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;

public class Login extends AppCompatActivity {

    EditText username,pass,email;
    String susername,spass,semail;
    String Appid ="practiceformongo-ofpcf";
    private App app;
    Button login,signup,reset;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_login);

        app = new App(new AppConfiguration.Builder(Appid).build());

        login = findViewById(R.id.button7);
        signup = findViewById(R.id.button8);
        username = findViewById(R.id.editTextTextPersonName3);
        email = findViewById(R.id.editTextTextEmailAddress);
        pass = findViewById(R.id.editTextTextPassword2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                semail = email.getText().toString();
                spass = pass.getText().toString();

                Credentials cre = Credentials.emailPassword(semail,spass);
                app.loginAsync(cre,result -> {

                   if(result.isSuccess()){

                       Toast.makeText(getApplicationContext(),"Sign in successful",Toast.LENGTH_SHORT).show();
                       user = app.currentUser();
                       Intent in = new Intent(getApplicationContext(),GenralPage.class);
                       startActivity(in);

                   }
                   else{
                       Toast.makeText(getApplicationContext(),result.getError().toString(),Toast.LENGTH_SHORT).show();
                   }
                });
            }
        });

        signup.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(), Rigester.class);
            startActivity(in);

        });

        reset = findViewById(R.id.button6);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getApplicationContext(), resetpasss2.class);
                startActivity(in);
            }
        });
    }
}