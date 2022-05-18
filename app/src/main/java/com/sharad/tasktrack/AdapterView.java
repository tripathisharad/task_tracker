package com.sharad.tasktrack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterView extends RecyclerView.Adapter<AdapterView.MyViewHolder> {

    private ArrayList<Task> myCurrentList;
    private Context context;
    int cPP = 0;
    private final OnItemClickListenerMy listener;

    public AdapterView(ArrayList<Task> tList, Context context, OnItemClickListenerMy listener) {
        this.context = context;
        this.myCurrentList = tList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        cPP = holder.getAdapterPosition();
        holder.taskname.setText(myCurrentList.get(position).taskName);
        int iV = myCurrentList.get(position).initialValue;
        int fV = myCurrentList.get(position).finalValue;
        String iVS = String.valueOf(iV);
        String fVS = String.valueOf(fV);
        holder.ifValue.setText(iVS + "/" + fVS);
        holder.progressBar.setMax(fV);
        holder.progressBar.setProgress(iV);
        holder.minimizer.setVisibility(View.INVISIBLE);
        holder.linearLayout.setVisibility(View.INVISIBLE);
        holder.minimizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.minimizer.setVisibility(View.INVISIBLE);
                holder.linearLayout.setVisibility(View.INVISIBLE);
            }
        });
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.minimizer.setVisibility(View.VISIBLE);
                holder.linearLayout.setVisibility(View.VISIBLE);

            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int iVV = myCurrentList.get(holder.getAdapterPosition()).initialValue - 1;
                Task cmt = new Task(myCurrentList.get(position).taskName,iVV,myCurrentList.get(position).finalValue);
                myCurrentList.set(position,cmt);
                String iVSs = String.valueOf(iVV);
                holder.ifValue.setText(iVSs + "/" + fVS);
                holder.progressBar.setProgress(iVV);
            }
        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int iVVP = myCurrentList.get(holder.getAdapterPosition()).initialValue + 1;
                Task cmt = new Task(myCurrentList.get(position).taskName,iVVP,myCurrentList.get(position).finalValue);
                myCurrentList.set(position,cmt);
                String iVSb = String.valueOf(iVVP);
                holder.ifValue.setText(iVSb + "/" + fVS);
                holder.progressBar.setProgress(iVVP);

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onItemClickk(position);
                myCurrentList.remove(position);

            }
        });
        


        

    }

    @Override
    public int getItemCount() {
        return myCurrentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView taskname,ifValue;
        ProgressBar progressBar;
        ConstraintLayout constraintLayout;
        ImageView minimizer,minus,plus,delete;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            taskname = itemView.findViewById(R.id.textView);
            ifValue = itemView.findViewById(R.id.textView2);
            progressBar = itemView.findViewById(R.id.progressBar);
            constraintLayout = itemView.findViewById(R.id.content2);
            minimizer = itemView.findViewById(R.id.imageView);
            linearLayout = itemView.findViewById(R.id.linearlayout);
            minus = itemView.findViewById(R.id.imageView2);
            plus = itemView.findViewById(R.id.imageView3);
            delete = itemView.findViewById(R.id.imageView4);
        }
    }

}
interface OnItemClickListenerMy {
    void onItemClickk(int item);
}

