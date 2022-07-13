package com.example.loginprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class QuejasSugerencias extends AppCompatActivity {
    
    EditText txtQueja;
    Button btnEnviarQueja;

    private DatabaseReference BaseIronworks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quejas_sugerencias);
        BaseIronworks = FirebaseDatabase.getInstance().getReference("BaseIronworks");

        txtQueja = (EditText) findViewById(R.id.txtQuejas);
        btnEnviarQueja = (Button) findViewById(R.id.btnEnviarQueja);
    }

    public void enviarQueja(View v){
        String queja =  txtQueja.getText().toString();
        if(!TextUtils.isEmpty(queja)){
            String id = BaseIronworks.push().getKey();
            Quejas miQueja = new Quejas(id, queja);
            BaseIronworks.child("Quejas").child(id).setValue(miQueja);
            Toast.makeText(this, "Gracias por su queja o sugerencia!", Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(this, "Introduzca una queja o sugerencia", Toast.LENGTH_SHORT).show();
        }
    }
}