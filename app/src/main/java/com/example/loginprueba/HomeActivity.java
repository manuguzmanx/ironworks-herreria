package com.example.loginprueba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {

    private Button btnCerrarSesion;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }

    public void cierraSesion(View view){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this,"Sesión cerrada", Toast.LENGTH_LONG).show();
        finishAffinity();
        System.exit(0);

    }

    public void irCatalogo(View view){
        Intent irCatalogo = new Intent(this, Catalogo.class);
        startActivity(irCatalogo);
    }

    public void irCotizar(View view){
        Intent irCotizar = new Intent(this, Cotizar.class);
        startActivity(irCotizar);
    }

    public void irContactanos(View view){
        Intent irContactanos = new Intent(this, Contactanos.class);
        startActivity(irContactanos);
    }

    public void irQuejas(View view){
        Intent irQuejas = new Intent(this, QuejasSugerencias.class);
        startActivity(irQuejas);
    }

    public void irAcerca(View view){
        Intent irAcerca = new Intent(this, Acerca.class);
        startActivity(irAcerca);
    }

}