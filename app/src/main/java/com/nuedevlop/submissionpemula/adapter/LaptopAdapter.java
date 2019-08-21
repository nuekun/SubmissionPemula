package com.nuedevlop.submissionpemula.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nuedevlop.submissionpemula.DetailActivity;
import com.nuedevlop.submissionpemula.R;
import com.nuedevlop.submissionpemula.model.LaptopModel;

import java.util.ArrayList;

public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.ViewHolder>{


    ArrayList<LaptopModel> listlaptop;
    Context context;

    public LaptopAdapter(Context context,ArrayList<LaptopModel> listLaptop) {

        this.listlaptop = listLaptop;
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        LaptopModel laptop = listlaptop.get(position);
        final String tipe,harga,spek,gambar;
        tipe = laptop.getTipe();
        harga=laptop.getHarga();
        spek=laptop.getSpek();
        gambar=laptop.getGambar();

        Glide.with(context).load(gambar).into(holder.gbrPriview);


        holder.txtTipe.setText(laptop.getTipe());
        holder.txtHarga.setText(laptop.getHarga());




        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("tipe",tipe);
                intent.putExtra("harga",harga);
                intent.putExtra("spek",spek);
                intent.putExtra("gambar",gambar);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return listlaptop.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTipe,txtHarga;
        ImageView gbrPriview;
        RelativeLayout root;



        public ViewHolder(View itemView) {
            super(itemView);

            txtTipe = itemView.findViewById(R.id.txtListTipe);
            txtHarga = itemView.findViewById(R.id.txtListHarga);
            gbrPriview = itemView.findViewById(R.id.gbrListPriview);
            root = itemView.findViewById(R.id.root);


        }
    }


}