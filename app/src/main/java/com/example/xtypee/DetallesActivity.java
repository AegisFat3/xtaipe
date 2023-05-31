package com.example.xtypee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetallesActivity extends AppCompatActivity {
    public static String TAG = "mensaje";
    TextView detailDesc, detailTitle, detailLang, detailTipo, detailDirec, detailTam, detailHabi, detailBanos, detailEs;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        //Datos de usuario
        Intent intent = getIntent();
        String nameUser2 = intent.getStringExtra("nombrei");
        String emailUser = intent.getStringExtra("correoi");
        String usernameUser = intent.getStringExtra("usuarioi");
        String passwordUser = intent.getStringExtra("contrasenai");
        String naciUser = intent.getStringExtra("nacimi");
        String dirUser = intent.getStringExtra("direi");
        String numUser = intent.getStringExtra("telefonoi");

        detailDesc = findViewById(R.id.detailDesc);
        detailImage = findViewById(R.id.detailImage);
        detailTitle = findViewById(R.id.detailTitle);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);
        detailLang = findViewById(R.id.detailLang);
        detailTipo = findViewById(R.id.detailTipo);
        detailDirec = findViewById(R.id.detailDirec);
        detailTam = findViewById(R.id.detailTam);
        detailHabi = findViewById(R.id.detailHabi);
        detailBanos = findViewById(R.id.detailBanos);
        detailEs = findViewById(R.id.detailEs);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            detailLang.setText("$ "+bundle.getString("Language"));
            detailTipo.setText(bundle.getString("Tipo"));
            detailDirec.setText(bundle.getString("Direction"));
            detailTam.setText(bundle.getString("Tamano")+" m²");
            detailHabi.setText(bundle.getString("Habitaciones"));
            detailBanos.setText(bundle.getString("Banos"));
            detailEs.setText(bundle.getString("Estacionamiento"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String nameUser2 = intent.getStringExtra("nombrei");
                String emailUser = intent.getStringExtra("correoi");
                String usernameUser = intent.getStringExtra("usuarioi");
                String passwordUser = intent.getStringExtra("contrasenai");
                String naciUser = intent.getStringExtra("nacimi");
                String dirUser = intent.getStringExtra("direi");
                String numUser = intent.getStringExtra("telefonoi");
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Android Tutorials");
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(DetallesActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(getApplicationContext(), propiedades.class);
                        intent3.putExtra("nombrei", nameUser2);
                        Log.d("Nombre de usuario","ola"+nameUser2);
                        intent3.putExtra("correoi", emailUser);
                        Log.d("Correo","ola"+emailUser);
                        intent3.putExtra("usuarioi", usernameUser);

                        intent3.putExtra("contrasenai", passwordUser);
                        intent3.putExtra("nacimi", naciUser);
                        intent3.putExtra("direi", dirUser);
                        intent3.putExtra("telefonoi", numUser);// Agrega los extras que desees enviar
                        startActivity(intent3);
                        finish();
                    }
                });
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallesActivity.this, UpdateActivity.class)
                        .putExtra("Title", detailTitle.getText().toString())
                        .putExtra("Description", detailDesc.getText().toString())
                        .putExtra("Language", detailLang.getText().toString())
                        .putExtra("Tipo", detailTipo.getText().toString())
                        .putExtra("Direction", detailDirec.getText().toString())
                        .putExtra("Tamano", detailTam.getText().toString())
                        .putExtra("Habitaciones", detailHabi.getText().toString())
                        .putExtra("Banos", detailBanos.getText().toString())
                        .putExtra("Estacionamiento", detailEs.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Key", key);
                intent.putExtra("nombrei", nameUser2);
                intent.putExtra("correoi", emailUser);
                intent.putExtra("usuarioi", usernameUser);
                intent.putExtra("contrasenai", passwordUser);
                intent.putExtra("nacimi", naciUser);
                intent.putExtra("direi", dirUser);
                intent.putExtra("telefonoi", numUser);
                startActivity(intent);
            }
        });
    }
}







