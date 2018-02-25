package com.example.yudiprasetya.yudiprasetya_1106130060_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MinumanViewHolder>{
    private List<tiga> minumanList;
    private Context context;

    public RecyclerViewAdapter(List<tiga> minumanList) {
        this.minumanList = minumanList;
    }

    public class MinumanViewHolder extends RecyclerView.ViewHolder {
        public ImageView foto;
        public TextView nama, detail, komposisi;

        public MinumanViewHolder(View view) {
            super(view);
            context = itemView.getContext();
            foto = (ImageView)itemView.findViewById(R.id.gambar);
            nama = (TextView)view.findViewById(R.id.nama);
            detail = (TextView)view.findViewById(R.id.detail);
            komposisi = (TextView)view.findViewById(R.id.komposisi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posisi = getAdapterPosition();
                    tiga klikMenu = minumanList.get(posisi);
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("gambar", minumanList.get(posisi).getFoto());
                    intent.putExtra("nama", minumanList.get(posisi).getNamaMinuman());
                    intent.putExtra("detail", minumanList.get(posisi).getDetailMinuman());
                    intent.putExtra("komposisi", minumanList.get(posisi).getKomposisiMinuman());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(view.getContext(), "you clicked " + klikMenu.getNamaMinuman(), Toast.LENGTH_LONG).show();
                }

            });
        }
    }

    @Override
    public MinumanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_empat, parent, false);

        return new MinumanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MinumanViewHolder holder, int position) {
        holder.foto.setImageResource(minumanList.get(position).getFoto());
        holder.nama.setText(minumanList.get(position).getNamaMinuman());
        holder.detail.setText(minumanList.get(position).getDetailMinuman());
        holder.komposisi.setText(minumanList.get(position).getKomposisiMinuman());
    }

    @Override
    public int getItemCount() {
        return minumanList.size();
    }
}
