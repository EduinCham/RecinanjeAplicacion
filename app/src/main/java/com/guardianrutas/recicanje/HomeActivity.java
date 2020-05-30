package com.guardianrutas.recicanje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.guardianrutas.recicanje.Adapter.RecyclerClassHome;
import com.guardianrutas.recicanje.Adapter.RecyclerHome;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    private DatabaseReference databaseReference;

    RecyclerView recycler;
    ArrayList<RecyclerClassHome> listDatos;

    int categoria;
    String imagen;
    int envioCategoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        listDatos = new ArrayList<>();

        recycler= findViewById(R.id.recyclerHome);
        recycler.setLayoutManager(new LinearLayoutManager(HomeActivity.this,RecyclerView.VERTICAL,false));

        recyclerHome();


    }

    public void recyclerHome(){

        databaseReference = FirebaseDatabase.getInstance().getReference(); ///Raiz
        databaseReference.child("home").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                listDatos.clear();

                if (dataSnapshot.exists()){
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                        RecyclerClassHome recyclerClassHome = snapshot.getValue(RecyclerClassHome.class);

                        categoria       =recyclerClassHome.getCategoria();
                        imagen          =recyclerClassHome.getImagen();


                        listDatos.add(new RecyclerClassHome(categoria,imagen));

                        RecyclerHome adapter = new RecyclerHome(listDatos);

                        adapter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {



                                envioCategoria      = listDatos.get(recycler.getChildAdapterPosition(view)).getCategoria();

                                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                                intent.putExtra("categoria", envioCategoria);
                                startActivity(intent);
                                finish();


                            }
                        });
                        recycler.setAdapter(adapter);

                    }

                }else{


                    System.out.println("No existe");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
