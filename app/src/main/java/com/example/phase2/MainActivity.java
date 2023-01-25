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

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.exceptions.RealmFileException;
import io.realm.mongodb.App;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoDatabase;
import io.realm.mongodb.sync.SyncConfiguration;

public class MainActivity extends AppCompatActivity {

    EditText euser,efull,ebio;
//    Button done;
    String user,full,bio;
    public static final String EXTRA_NAME = "Atharva.Honrao";
    public static final String EXTRA_BIO = "Atharva.Sanjay";
    static int v =0;
    App app;
    User uuser;

    MongoClient client;
    MongoDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_main);

        Realm.init(this);

        if(v==0) {
            startActivity(new Intent(MainActivity.this, Login.class));
            v++;
        }


        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();

        Realm realm;
//        try {
            realm = Realm.getInstance(config);
            Log.v("EXAMPLE", "Successfully opened a realm at: " + realm.getPath());
//        } catch (RealmFileException ex) {
//            Log.v("EXAMPLE", "Error opening the realm.");
//            Log.v("EXAMPLE", ex.toString());
//        }


        RealmQuery<users> tasksQuery = realm.where(users.class);

        Log.i("EXAMPLE", "High priority tasks: " + tasksQuery.count());

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

    public void toregister(View v){

        Toast.makeText(this,"Sign up page",Toast.LENGTH_LONG).show();
        Intent in = new Intent(this,Rigester.class);

//        euser = findViewById(R.id.enterUser);
//        user = euser.getText().toString();
//        in.putExtra(EXTRA_NAME,user);
//
//        ebio = findViewById(R.id.bioName);
//        bio = ebio.getText().toString();
//
//        in.putExtra(EXTRA_BIO,bio);
        startActivity(in);
    }
}

