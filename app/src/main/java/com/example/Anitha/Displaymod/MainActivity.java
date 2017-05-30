package com.example.Anitha.Displaymod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
String sregno;
    DBHelper myDb;
    EditText editregno;
    Button viewbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DBHelper(this);



        viewbt = (Button) findViewById(R.id.viewbtn);
        editregno=(EditText)findViewById(R.id.regno1);
        //  final EditText editname=(EditText)findViewById(R.id.name1);
        //  final EditText editdob=(EditText)findViewById(R.id.dob1);
       // final EditText editdept=(EditText)findViewById(R.id.dept1);
        AddData();
        viewAll();
    }

    private void viewAll() {
        viewbt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoIntent = new Intent(MainActivity.this, Display.class);
                gotoIntent.putExtra("sregno", editregno.getText().toString());

                //gotoIntent.putExtra("sname", editname.getText().toString());
                //gotoIntent.putExtra("sdob", editdob.getText().toString());
                //gotoIntent.putExtra("sdept", editdept.getText().toString());

                startActivity(gotoIntent);
            }
        });
    }

    private void AddData() {

        boolean isInserted = myDb.insertData();
        if(isInserted == true)
            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

    }
}
