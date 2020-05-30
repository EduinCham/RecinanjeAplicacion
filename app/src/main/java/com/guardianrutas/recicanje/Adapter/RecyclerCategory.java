package com.guardianrutas.recicanje.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.guardianrutas.recicanje.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerCategory
        extends RecyclerView.Adapter<RecyclerCategory.ViewHolderdDatos>
        implements View.OnClickListener {

    ArrayList<RecyclerClassCategory> listDatos;


    private  View.OnClickListener listener;
    int cantidad;
    private DatabaseReference databaseReference;

    String idusuario;
    int campo=0;
    String producto;



    public RecyclerCategory(ArrayList<RecyclerClassCategory> listDatos) {
        this.listDatos = listDatos;
    }


    @Override
    public ViewHolderdDatos onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_recycler,null,false);



        databaseReference = FirebaseDatabase.getInstance().getReference(); ///Raiz
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//Para extraeerr el Uid del cliente
        idusuario=user.getUid(); //Guardamos Uid en variable

        view.setOnClickListener(this);



        return new ViewHolderdDatos(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderdDatos holder, final int position) {


        holder.txQuantity.setText(String.valueOf(listDatos.get(position).getCantidad()));
        Picasso.get().load(listDatos.get(position).getImagen()).into(holder.ivImage);


        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                holder.txQuantity.setText(String.valueOf(listDatos.get(position).getCantidad()+1));
                //databaseReference = FirebaseDatabase.getInstance().getReference(); ///Raiz
                //databaseReference.child("pedidopreliminar").child(idusuario).child(listDatos.get(position).getIdproducto()).child("cantidad").setValue(listDatos.get(position).getCantidad()+1);



            }
        });

        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                holder.txQuantity.setText(String.valueOf(listDatos.get(position).getCantidad()-1));
                //databaseReference = FirebaseDatabase.getInstance().getReference(); ///Raiz
                //databaseReference.child("pedidopreliminar").child(idusuario).child(listDatos.get(position).getIdproducto()).child("cantidad").setValue(listDatos.get(position).getCantidad()-1);



            }
        });

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


        ImageView ivInfo;
        ImageView ivImage;
        Button    btnPlus;
        Button    btnMinus;
        TextView  txQuantity;





        public ViewHolderdDatos(@NonNull View itemView) {
            super(itemView);


            ImageView ivInfo;
            ImageView ivImage;
            Button    btnPlus;
            Button    btnMinus;
            TextView  txQuantity;

        }

        public void asignarDatos(String datos) {

            txQuantity.setText(datos);
        }
    }
}