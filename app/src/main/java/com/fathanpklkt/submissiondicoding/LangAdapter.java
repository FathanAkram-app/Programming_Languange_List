package com.fathanpklkt.submissiondicoding;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class LangAdapter extends RecyclerView.Adapter<LangAdapter.CardViewViewHolder> {
    public ArrayList<Lang> listLang;


    public LangAdapter(ArrayList<Lang> list) {
        this.listLang = list;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_program, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, final int position) {
        final Lang lang = listLang.get(position);

        Glide.with(holder.itemView.getContext())
                .load(lang.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);

        holder.tvName.setText(lang.getName());
        holder.tvDetail.setText(lang.getDetail());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentL = new Intent(v.getContext(), LangDetail.class);
                intentL.putExtra("objek", listLang.get(position));
                v.getContext().startActivity(intentL);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listLang.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);

        }
    }
}
