package com.example.zahidalikhan.task2;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText name, mclass, reg;
    private Button send;
    private Button show;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        name = (EditText) findViewById(R.id.name);
        mclass = (EditText) findViewById(R.id.secondname);
        reg = (EditText) findViewById(R.id.thirdname);

        send = (Button)findViewById(R.id.send);
        show = (Button)findViewById(R.id.retrieve);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
                Toast.makeText(MainActivity.this, "Data has been sent.",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Show(View v){
        Intent i = new Intent(MainActivity.this, DataRetrieved.class);
        startActivity(i);

    }
    public void addStudent(){
        String studentName = name.getText().toString();
        String studentClass = mclass.getText().toString();
        String studentReg = reg.getText().toString();
        if(!TextUtils.isEmpty(studentName) && !TextUtils.isEmpty(studentClass) && !TextUtils.isEmpty(studentReg))
        {
            String ID = databaseReference.push().getKey();

            Student students = new Student(studentReg, studentName, studentClass);
            databaseReference.child(ID).setValue(students);
            name.setText("");
            mclass.setText("");
        }else
        {
            Toast.makeText(MainActivity.this, "Please type students name or class or ID", Toast.LENGTH_LONG).show();
        }
    }
}
