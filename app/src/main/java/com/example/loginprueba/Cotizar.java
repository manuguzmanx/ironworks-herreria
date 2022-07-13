package com.example.loginprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Cotizar extends AppCompatActivity {

    private Spinner spinnerProducto, spinnerMaterial;
    private EditText etLargo, etAncho, etAlto, detallesProducto, etNumero;
    private TextView tvResultado;

    private DatabaseReference BaseIronworks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizar);

        BaseIronworks = FirebaseDatabase.getInstance().getReference("BaseIronworks");

        spinnerProducto = (Spinner) findViewById(R.id.spinnerProducto);
        spinnerMaterial = (Spinner) findViewById(R.id.spinnerMaterial);
        etLargo = (EditText) findViewById(R.id.etLargo);
        etAncho = (EditText) findViewById(R.id.etAncho);
        etAlto = (EditText) findViewById(R.id.etAlto);
        etNumero =(EditText) findViewById(R.id.etNumero);
        detallesProducto = (EditText) findViewById(R.id.detallesProducto);

        String[] productos = {"Cancel","Puerta","Escalera","Barandal","Ventana", "Reja"};
        ArrayAdapter<String> adapterProducto = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productos);
        spinnerProducto.setAdapter(adapterProducto);

        String[] materiales = {"Acero","Acero inoxidable","Aluminio", "Hierro"};
        ArrayAdapter<String> adapterMateriales = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, materiales);
        spinnerMaterial.setAdapter(adapterMateriales);
    }

    public void solicitarCotizacion(View v){
        String tipoProducto = spinnerProducto.getSelectedItem().toString();
        String tipoMaterial = spinnerMaterial.getSelectedItem().toString();
        String largo = etLargo.getText().toString();
        String ancho = etAncho.getText().toString();
        String alto = etAlto.getText().toString();
        String detalles = detallesProducto.getText().toString();
        String numero = etNumero.getText().toString();

        if(!TextUtils.isEmpty(detalles)){
            String id = BaseIronworks.push().getKey();
            Cotizacion miCotizacion = new Cotizacion(id, tipoProducto, tipoMaterial, detalles, largo, ancho, alto, numero);

            BaseIronworks.child("Cotizaciones").child(id).setValue(miCotizacion);
            Toast.makeText(this, "Cotización solicitada! En breve nos comunicaremos con usted", Toast.LENGTH_LONG).show();
            limpiarCampos();
        } else{
            Toast.makeText(this, "Solicite una cotización", Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiarCampos(){
        etAlto.setText("");
        etLargo.setText("");
        etAncho.setText("");
        detallesProducto.setText("");
        etNumero.setText("");
    }
    /*
    public void calcularCotizacion(View view){
        String seleccionProducto = spinnerProducto.getSelectedItem().toString();
        String seleccionMaterial = spinnerMaterial.getSelectedItem().toString();

        String etLargoS = etLargo.getText().toString();
        double etLargoD = Double.parseDouble(etLargoS);

        String etAnchoS = etLargo.getText().toString();
        double etAnchoD = Double.parseDouble(etAnchoS);

        String etAltoS = etLargo.getText().toString();
        double etAltoD = Double.parseDouble(etAltoS);

    }

    */
}