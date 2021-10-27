package com.example.attendenceapps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText classEt;
    EditText subjectEt;
    ArrayList<AddClass>addClasses;
    private FloatingActionButton actionButton;
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.setHasFixedSize(true);
        manager=new LinearLayoutManager(this);
        myAdapter=new MyAdapter(addClasses,this);
        recyclerView.setAdapter(myAdapter);
        actionButton=findViewById(R.id.mainFlotinactionBtn);
        actionButton.setOnClickListener(v -> showDialog());
    }

    private void showDialog() {
        DialogClass dialogClass=new DialogClass();
        dialogClass.show(getSupportFragmentManager(),DialogClass.CLASS_ADD_DIALOG);
        dialogClass.setListener((clasName,subjectName)->addClass(clasName,subjectName));


        }

    private void addClass(String className,String subjectName) {
        addClasses.add(new AddClass(className,subjectName));
        myAdapter.notifyDataSetChanged();

    }
}