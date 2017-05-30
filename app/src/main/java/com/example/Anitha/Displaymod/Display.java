package com.example.Anitha.Displaymod;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Display extends AppCompatActivity {
    DBHelper myDb;
    TextView textname,textregno,textdob,textdept;
    String dbregno,dbname,dbdept,dbdob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        myDb = new DBHelper(this);


        textname=(TextView)findViewById(R.id.name);
        textregno=(TextView)findViewById(R.id.regno);
        textdob=(TextView)findViewById(R.id.dob);
        textdept=(TextView)findViewById(R.id.dept);

        Intent intent = getIntent();
        dbregno = intent.getStringExtra("sregno");

        disp();

    }

    private void disp() {
        Cursor res = myDb.getAllData(dbregno);
        if(res.getCount() == 0) {
            Toast.makeText(Display.this,"Nothing found",Toast.LENGTH_LONG).show();

            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {

            dbname=res.getString(1);
            dbdob=res.getString(3);
            dbdept=res.getString(4);

        }
        textname.setText(dbname);
        textregno.setText(dbregno);
        textdob.setText(dbdob);
        textdept.setText(dbdept);


    }




        }

