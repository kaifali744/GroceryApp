package com.example.groceryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    private List<Item> list;
    public  ItemClickListner clickListner;

    public void setClickListner(ItemClickListner clickListner) {
        this.clickListner = clickListner;
    }

    public MyCustomAdapter(List<Item> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = list.get(position);

        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDesc());
        holder.imageView.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{

        ImageView imageView;
        TextView title;
        TextView desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListner != null){
                clickListner.onCLick(v, getAdapterPosition());
            }
        }
    }
}
