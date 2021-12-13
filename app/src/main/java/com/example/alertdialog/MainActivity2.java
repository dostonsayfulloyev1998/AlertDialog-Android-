package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements MyDialogFragment.DialogListener{

    private ArrayList<ModelKlass> list;
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;

private FloatingActionButton fab;
private TextView loginText,parolText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fab =findViewById(R.id.fab);
        recyclerView=findViewById(R.id.res);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(getSupportFragmentManager(),"fragment");
            }
        });
    }

    @Override
    public void applyText(String login, String parol) {
          loginText.setText(login);
          parolText.setText(parol);
    }
    private void loaddata(){
        list=new ArrayList<>();
        list.add(new ModelKlass("login1", "parol1"));
        list.add(new ModelKlass("login2", "parol2"));
        list.add(new ModelKlass("login3", "parol3"));
    }
}