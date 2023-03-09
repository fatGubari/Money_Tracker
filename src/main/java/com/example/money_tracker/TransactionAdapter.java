package com.example.money_tracker;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder>{
    ArrayList<Transaction> arrayList;
    Context context;
    DB db;
    public TransactionAdapter(ArrayList<Transaction> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.amount.setText(arrayList.get(position).getAmount());
        holder.note.setText(arrayList.get(position).getNote());
        holder.type.setText(arrayList.get(position).getType());
        holder.category.setText(arrayList.get(position).getCategory());
        holder.amount.setTag(position);

        Glide
                .with(context)
                .load(arrayList.get(position).getImage())
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView amount,note,type,category;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.money);
            note = itemView.findViewById(R.id.note);
            type = itemView.findViewById(R.id.type);
            category = itemView.findViewById(R.id.category);
            image = itemView.findViewById(R.id.image);
            db=new DB(context);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Deletion");
                    alert.setMessage("Are You Sure You Want To Delete This Transaction");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            int position = Integer.parseInt(String.valueOf(amount.getTag()));
                            Transaction transaction = arrayList.get(position);
                            db.Delete(transaction.getID());
                            notifyItemRemoved(position);
                            arrayList.remove(position);
                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(context, "Transaction Won't Be Deleted", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.setCancelable(false);
                    alert.create();
                    alert.show();
                    return true;
                }
            });

        }
    }
}
