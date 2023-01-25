package com.example.phase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

public class passordreset extends AppCompatActivity {

    String Appid ="practiceformongo-ofpcf";
    private App app;

    Intent in;
    String data1,data2;
    Uri data;
    EditText pass,cpass;
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passordreset);

        app = new App(new AppConfiguration.Builder(Appid).build());


        in = getIntent();
        data = in.getData();
        data1 = data.getQueryParameter("token");
        data2 = data.getQueryParameter("tokenId");

        pass = findViewById(R.id.editTextTextPassword3);
        cpass = findViewById(R.id.editTextTextPassword4);
        done = findViewById(R.id.button5);

        if(!pass.getText().toString().equals(cpass.getText().toString())){

            Toast.makeText(this,"Wrong input",Toast.LENGTH_SHORT).show();

        }
        else {
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    app.getEmailPassword().resetPasswordAsync(data1, data2, pass.getText().toString(), result -> {


                        if(result.isSuccess()){

                            Toast.makeText(getApplicationContext(),"Password Reset Successfully",Toast.LENGTH_SHORT).show();

                        }
                        else {

                            Log.e("EXAMPLE", result.getError().toString());
                            Toast.makeText(getApplicationContext(),result.getError().toString(),Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            });
        }




    }
}