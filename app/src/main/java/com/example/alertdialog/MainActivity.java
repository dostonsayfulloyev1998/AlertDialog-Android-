package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private EditText name,surname;
private FloatingActionButton fab,fab1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Message");
                builder.setMessage("siz shu shartga rozimisiz");

                builder.setIcon(R.drawable.ic_launcher_background);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Ok clicked",Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNeutralButton("okcancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(true);
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder customBuilder = new AlertDialog.Builder(MainActivity.this);

                customBuilder.setTitle("register");

                View view  = getLayoutInflater().inflate(R.layout.custom_layout,null);


                customBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     name=view.findViewById(R.id.name);
                     surname=view.findViewById(R.id.surname);
                     String n=name.getText().toString();
                     String s=surname.getText().toString();
                     Toast.makeText(MainActivity.this, n+s,Toast.LENGTH_LONG).show();
                    }
                });

                customBuilder.setView(view);

                AlertDialog dialog = customBuilder.create();

                dialog.show();
            }
        });
    }


}