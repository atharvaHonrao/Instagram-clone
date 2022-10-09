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

public class MainActivity extends AppCompatActivity {

    EditText euser,efull,ebio;
//    Button done;
    String user,full,bio;
    public static final String EXTRA_NAME = "Atharva.Honrao";
    public static final String EXTRA_BIO = "Atharva.Sanjay";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


    }


    public void some(View v){

        Toast.makeText(this,"Opening page",Toast.LENGTH_LONG).show();
        Intent in = new Intent(this,MainActivity2.class);

        euser = findViewById(R.id.enterUser);
        user = euser.getText().toString();
        in.putExtra(EXTRA_NAME,user);

        ebio = findViewById(R.id.bioName);
        bio = ebio.getText().toString();

        in.putExtra(EXTRA_BIO,bio);

        startActivity(in);

    }


}