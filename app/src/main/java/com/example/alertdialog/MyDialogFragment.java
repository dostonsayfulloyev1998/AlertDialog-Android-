package com.example.alertdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragment extends AppCompatDialogFragment {

    DialogListener listener;
    EditText username,password;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Login");
        LayoutInflater inflater =getActivity().getLayoutInflater();

        View view =  inflater.inflate(R.layout.custom_dialog,null);
        builder.setView(view);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.applyText(username.getText()+"",password.getText()+"");
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);

        return builder.create();
    }


    @Override
    public void onAttach(@NonNull Context context) {////onCreate dan oldin ishlash

        try {
            listener = (DialogListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }

        super.onAttach(context);
    }

    interface DialogListener{
        void applyText(String login, String parol);
   }

}
