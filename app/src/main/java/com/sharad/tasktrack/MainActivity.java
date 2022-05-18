package com.sharad.tasktrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListenerMy {

    RecyclerView recyclerView;
    AdapterView adapterView;
    FloatingActionButton addTask;
    static ArrayList<Task> currentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTask = findViewById(R.id.floatingActionButton2);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterView = new AdapterView(currentList,this, this);
        recyclerView.setAdapter(adapterView);


        try{
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            currentList = (ArrayList) bundle.getParcelableArrayList("tasName");
            adapterView.notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }



        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddTask.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onItemClickk(int item) {


        try{
            currentList.remove(item);
            adapterView.notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}