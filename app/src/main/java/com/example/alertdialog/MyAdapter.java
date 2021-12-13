package com.example.alertdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<ModelKlass>list;
    private Context context;
    private OnItemClick listener;

    public MyAdapter(ArrayList<ModelKlass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setListener(OnItemClick listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);

        return new MyViewHolder(view);
    }

    public void addItem(String login,String parol){
        list.add(new ModelKlass(login,parol));
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String login=list.get(position).getLogin();
        String parol=list.get(position).getParol();

        holder.parol1.setText(parol);
        holder.login1.setText(login);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView login1, parol1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            login1=itemView.findViewById(R.id.tv1);
            parol1=itemView.findViewById(R.id.tv2);
        }


    }
    interface OnItemClick{
        void onItemClick(int i, View v);
    }
}
