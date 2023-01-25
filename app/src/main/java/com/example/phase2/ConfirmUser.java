package com.example.phase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toast.*;

import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;

//import com.example.phase2.R;

public class ConfirmUser extends AppCompatActivity {

    String Appid ="practiceformongo-ofpcf";
    private App app;
    String data1,data2;
    Button b;
    Intent in;
    Uri data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_user);

        b = findViewById(R.id.button10);

        in = getIntent();
        data = in.getData();
        data1 = data.getQueryParameter("token");
        data2 = data.getQueryParameter("tokenId");

//        startActivity(in);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                app = new App(new AppConfiguration.Builder(Appid).build());

                app.getEmailPassword().confirmUserAsync(data1, data2, it -> {
                    if (it.isSuccess()) {
                        Toast.makeText(getApplicationContext(),"User COnfirmed!!",Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("EXAMPLE", "Failed to confirm user: " + it.getError().getErrorMessage());
                        Toast.makeText(getApplicationContext(),"User NOT confirmed!!!",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }
}