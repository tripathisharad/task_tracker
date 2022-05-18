package com.sharad.tasktrack;


import static com.sharad.tasktrack.MainActivity.currentList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity {

    TextView tName;
    EditText iV,fV;
    Button saveB;
    ArrayList<Task> currentList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        tName = findViewById(R.id.editTextTextPersonName);
        iV = findViewById(R.id.editTextTextPersonName2);
        fV = findViewById(R.id.editTextTextPersonName3);
        saveB  = findViewById(R.id.button);
        currentList2 = currentList;







        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String taskName = tName.getText().toString();
                String iValue = iV.getText().toString();
                String fValue = fV.getText().toString();
//
                if(TextUtils.isEmpty(taskName)){
                    tName.setError("Name is required");
                }else if(TextUtils.isEmpty(iValue)){
                    iV.setError("Required");
                }else if(TextUtils.isEmpty(fValue)){
                    fV.setError("Required");
                }else{

                    String taskNameH = tName.getText().toString();
                    int iValueH = Integer.parseInt(iV.getText().toString());
                    int fValueH = Integer.parseInt(fV.getText().toString());
//
                    Task tObject = new Task(taskName,iValueH,fValueH);
                    currentList2.add(tObject);
                    Intent tI = new Intent(AddTask.this,MainActivity.class);
                    tI.putExtra("tasName",currentList2);
                    startActivity(tI);
                    Toast.makeText(AddTask.this, "Task Added Successfully", Toast.LENGTH_SHORT).show();
                    finish();

                }



            }
        });


    }
}