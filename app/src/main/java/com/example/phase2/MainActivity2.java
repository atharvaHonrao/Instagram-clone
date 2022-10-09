package com.example.phase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView user,bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);

        user = findViewById(R.id.userName);
        Intent in = getIntent();
        String s = in.getStringExtra(MainActivity.EXTRA_NAME);
        user.setText(s);

        bio = findViewById(R.id.bioin2);
        String m = in.getStringExtra(MainActivity.EXTRA_BIO);
        bio.setText(m);

    }

}