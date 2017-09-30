package com.khilman.customrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 9/28/17.
 */

class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder> {
    // buat data menjadi global
    Context context;
    String[] namabuah;
    int[] gambarbuah;
    int[] suarabuah;

    public CustomRecyclerAdapter(Context context, String[] namabuah, int[] gambarbuah, int[] suarabuah) {
        this.context = context;
        this.namabuah = namabuah;
        this.gambarbuah = gambarbuah;
        this.suarabuah = suarabuah;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txtBuah.setText(namabuah[position]);
        holder.imgBuah.setImageResource(gambarbuah[position]);
        // beri event OnClick untuk CardView
        holder.itemCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "" + namabuah[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailActivity.class);
                // bawa data
                intent.putExtra("nb", namabuah[position]);
                intent.putExtra("gb", gambarbuah[position]);
                intent.putExtra("sb", suarabuah[position]);
                // start new Activity
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        // menghitung panjang array
        return namabuah.length; // acuan looping item
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // deklarasi
        TextView txtBuah;
        ImageView imgBuah;
        CardView itemCard;
        public MyViewHolder(View itemView) {
            super(itemView);
            // inisialisasi
            txtBuah = (TextView) itemView.findViewById(R.id.txtBuah);
            imgBuah = (ImageView) itemView.findViewById(R.id.imgBuah);
            itemCard = (CardView) itemView.findViewById(R.id.itemCard);
        }
    }
}
