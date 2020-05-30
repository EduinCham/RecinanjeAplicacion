package com.guardianrutas.recicanje.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.guardianrutas.recicanje.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerHome
        extends RecyclerView.Adapter<RecyclerHome.ViewHolderdDatos>
        implements View.OnClickListener {

    ArrayList<RecyclerClassHome> listDatos;
    private  View.OnClickListener listener;


    public RecyclerHome(ArrayList<RecyclerClassHome>listDatos) {
        this.listDatos = listDatos;
    }


    @Override
    public ViewHolderdDatos onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_recycler,null,false);

        view.setOnClickListener(this);

        return new ViewHolderdDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderdDatos holder, int position) {

        Picasso.get().load(listDatos.get(position).getImagen()).into(holder.ivHome);

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {

        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderdDatos extends RecyclerView.ViewHolder {

        ImageView ivHome ;


        public ViewHolderdDatos(@NonNull View itemView) {
            super(itemView);

            ivHome         =(ImageView)itemView.findViewById(R.id.ivHome);

        }

        public void asignarDatos(String datos) {


        }
    }
}
