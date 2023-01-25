package com.example.phase2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

public class resetpasss2 extends AppCompatActivity {

    String Appid ="practiceformongo-ofpcf";
    private App app;

    EditText email;
    Button send;
    String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_resetpasss2);

        app = new App(new AppConfiguration.Builder(Appid).build());

        email = (EditText) findViewById(R.id.editTextTextEmailAddress3);
//        pass = (EditText) findViewById(R.id.editTextTextPassword5);
        send = (Button) findViewById(R.id.button9);





        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Email = email.getText().toString();
//                Pass = pass.getText().toString();
//                Credentials credentials = Credentials.emailPassword(Email,Pass);


//                app.loginAsync(credentials,result -> {

//                    if(result.isSuccess()){

                        Log.i("EXAMPLE", "Successfully sent the user a reset password link");
//                        user = app.currentUser();


                        app.getEmailPassword().sendResetPasswordEmailAsync(String.valueOf(Email), it -> {
                            if (it.isSuccess()) {
                                Log.i("EXAMPLE", "Successfully sent the user a reset password link");
                            } else {
                                Log.e("EXAMPLE", it.getError().toString());
                                Toast.makeText(getApplicationContext(),it.getError().toString(),Toast.LENGTH_SHORT).show();
                            }
                        });


//                    }
//                    else{
//
//
//                        Toast.makeText(getApplicationContext(),result.getError().toString(),Toast.LENGTH_SHORT);
//                        Log.e("EXAMPLE", result.getError().toString() );
//                    }





//                });


            }
        });













    }
}