package com.example.xtypee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class perfil extends AppCompatActivity {

    TextView profileName, profileEmail, profileUsername, profilePassword, profileFec, profileNum, profileDir;
    TextView titleName, titleUsername;
    Button editProfile, salButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Intent intent = getIntent();
        String nameUser3 = intent.getStringExtra("nombrei");
        String emailUser3 = intent.getStringExtra("correoi");
        String usernameUser3 = intent.getStringExtra("usuarioi");
        String passwordUser3 = intent.getStringExtra("contrasenai");
        String naciUser3 = intent.getStringExtra("nacimi");
        String dirUser3 = intent.getStringExtra("direi");
        String numUser3 = intent.getStringExtra("telefonoi");
        salButton = findViewById(R.id.salBut);
        salButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(perfil.this, login.class);
                intent.putExtra("nombrei", nameUser3);
                intent.putExtra("correoi", emailUser3);
                intent.putExtra("usuarioi", usernameUser3);
                intent.putExtra("contrasenai", passwordUser3);
                intent.putExtra("nacimi", naciUser3);
                intent.putExtra("direi", dirUser3);
                intent.putExtra("telefonoi", numUser3);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    Intent intenthome = new Intent(getApplicationContext(), MainActivity.class);
                    intenthome.putExtra("nombrei", nameUser3);
                    intenthome.putExtra("correoi", emailUser3);
                    intenthome.putExtra("usuarioi", usernameUser3);
                    intenthome.putExtra("contrasenai", passwordUser3);
                    intenthome.putExtra("nacimi", naciUser3);
                    intenthome.putExtra("direi", dirUser3);
                    intenthome.putExtra("telefonoi", numUser3);// Agrega los extras que desees enviar
                    startActivity(intenthome);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_propiedades:
                    Intent intentpro = new Intent(getApplicationContext(), propiedades.class);
                    intentpro.putExtra("nombrei", nameUser3);
                    intentpro.putExtra("correoi", emailUser3);
                    intentpro.putExtra("usuarioi", usernameUser3);
                    intentpro.putExtra("contrasenai", passwordUser3);
                    intentpro.putExtra("nacimi", naciUser3);
                    intentpro.putExtra("direi", dirUser3);
                    intentpro.putExtra("telefonoi", numUser3);// Agrega los extras que desees enviar
                    startActivity(intentpro);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_foro:
                    Intent intentforo = new Intent(getApplicationContext(), foro.class);
                    intentforo.putExtra("nombrei", nameUser3);
                    intentforo.putExtra("correoi", emailUser3);
                    intentforo.putExtra("usuarioi", usernameUser3);
                    intentforo.putExtra("contrasenai", passwordUser3);
                    intentforo.putExtra("nacimi", naciUser3);
                    intentforo.putExtra("direi", dirUser3);
                    intentforo.putExtra("telefonoi", numUser3);// Agrega los extras que desees enviar
                    startActivity(intentforo);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profile:
                    return true;
                case R.id.bottom_about:
                    Intent intentabout = new Intent(getApplicationContext(), about.class);
                    intentabout.putExtra("nombrei", nameUser3);
                    intentabout.putExtra("correoi", emailUser3);
                    intentabout.putExtra("usuarioi", usernameUser3);
                    intentabout.putExtra("contrasenai", passwordUser3);
                    intentabout.putExtra("nacimi", naciUser3);
                    intentabout.putExtra("direi", dirUser3);
                    intentabout.putExtra("telefonoi", numUser3);// Agrega los extras que desees enviar
                    startActivity(intentabout);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                /*case R.id.bottom_logout:
                    startActivity(new Intent(getApplicationContext(), perfil.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;*/
            }
            return false;
        });
        profileName = findViewById(R.id.profilename);
        profileEmail = findViewById(R.id.profilecorreo);
        profileUsername = findViewById(R.id.profileuser);
        profilePassword = findViewById(R.id.profilecontra);
        profileFec = findViewById(R.id.profilefec);
        profileDir = findViewById(R.id.profiledir);
        profileNum = findViewById(R.id.profilenum);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleEmail);
        editProfile = findViewById(R.id.editBut);
        showAllUserData();
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passUserData();
            }
        });


    }

    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("nombrei");
        String emailUser = intent.getStringExtra("correoi");
        String usernameUser = intent.getStringExtra("usuarioi");
        String passwordUser = intent.getStringExtra("contrasenai");
        String naciUser = intent.getStringExtra("nacimi");
        String dirUser = intent.getStringExtra("direi");
        String numUser = intent.getStringExtra("telefonoi");
        titleName.setText(nameUser);
        titleUsername.setText(emailUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profilePassword.setText(passwordUser);
        profileFec.setText(naciUser);
        profileDir.setText(dirUser);
        profileNum.setText(numUser);
    }
    public void passUserData(){
        String userUsername = profileUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("usuarioi").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String nameFromDB = snapshot.child(userUsername).child("nombrei").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("correoi").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("usuarioi").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("contrasenai").getValue(String.class);
                    String fecFromDB = snapshot.child(userUsername).child("nacimi").getValue(String.class);
                    String dirFromDB = snapshot.child(userUsername).child("direi").getValue(String.class);
                    String telFromDB = snapshot.child(userUsername).child("telefonoi").getValue(String.class);
                    Intent intent = new Intent(perfil.this, editar.class);
                    intent.putExtra("nombrei", nameFromDB);
                    intent.putExtra("correoi", emailFromDB);
                    intent.putExtra("usuarioi", usernameFromDB);
                    intent.putExtra("contrasenai", passwordFromDB);
                    intent.putExtra("nacimi", fecFromDB);
                    intent.putExtra("direi", dirFromDB);
                    intent.putExtra("telefonoi", telFromDB);
                    startActivity(intent);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}


