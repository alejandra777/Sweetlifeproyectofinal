package com.example.ejemplofire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class RECETARIO extends AppCompatActivity {

    EditText nom, ing, pre;
    Button btn_agregar;
    ListView listareceta;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetario);

        nom = (EditText) findViewById(R.id.nom);
        ing = (EditText) findViewById(R.id.ing);
        pre =(EditText) findViewById(R.id.pre);
        btn_agregar = (Button) findViewById(R.id.btn_agregar);



        FirebaseDatabase Datos = FirebaseDatabase.getInstance();
        mDatabase = Datos.getReference(Referencias.producto_referencias);

        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RECETA MIRECETA = new RECETA(nom.getText().toString().toUpperCase().trim(), ing.getText().toString().toUpperCase().trim(),pre.getText().toString().toUpperCase().trim());
                mDatabase.child("").push().setValue(MIRECETA);
                limpiarcaja();

            }
        });
    }

    private void limpiarcaja(){
        nom.setText("");
        ing.setText("");
        pre.setText("");

    }
}
