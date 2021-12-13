package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity implements MyDialogFragment.DialogListener{
private FloatingActionButton fab;
private TextView loginText,parolText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fab =findViewById(R.id.fab);
         loginText = findViewById(R.id.login);
         parolText = findViewById(R.id.parol);

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
}