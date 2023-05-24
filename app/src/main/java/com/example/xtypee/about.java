package com.example.xtypee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent intent = getIntent();
        String nameUser2 = intent.getStringExtra("nombrei");
        String emailUser = intent.getStringExtra("correoi");
        String usernameUser = intent.getStringExtra("usuarioi");
        String passwordUser = intent.getStringExtra("contrasenai");
        String naciUser = intent.getStringExtra("nacimi");
        String numUser = intent.getStringExtra("telefonoi");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_about);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    Intent intenthome = new Intent(getApplicationContext(), MainActivity.class);
                    intenthome.putExtra("nombrei", nameUser2);
                    intenthome.putExtra("correoi", emailUser);
                    intenthome.putExtra("usuarioi", usernameUser);
                    intenthome.putExtra("contrasenai", passwordUser);
                    intenthome.putExtra("nacimi", naciUser);
                    intenthome.putExtra("telefonoi", numUser);// Agrega los extras que desees enviar
                    startActivity(intenthome);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_propiedades:
                    Intent intentpro = new Intent(getApplicationContext(), propiedades.class);
                    intentpro.putExtra("nombrei", nameUser2);
                    intentpro.putExtra("correoi", emailUser);
                    intentpro.putExtra("usuarioi", usernameUser);
                    intentpro.putExtra("contrasenai", passwordUser);
                    intentpro.putExtra("nacimi", naciUser);
                    intentpro.putExtra("telefonoi", numUser);// Agrega los extras que desees enviar
                    startActivity(intentpro);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_foro:
                    Intent intentforo = new Intent(getApplicationContext(), foro.class);
                    intentforo.putExtra("nombrei", nameUser2);
                    intentforo.putExtra("correoi", emailUser);
                    intentforo.putExtra("usuarioi", usernameUser);
                    intentforo.putExtra("contrasenai", passwordUser);
                    intentforo.putExtra("nacimi", naciUser);
                    intentforo.putExtra("telefonoi", numUser);// Agrega los extras que desees enviar
                    startActivity(intentforo);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profile:
                    Intent intentperfil = new Intent(getApplicationContext(), perfil.class);
                    intentperfil.putExtra("nombrei", nameUser2);
                    intentperfil.putExtra("correoi", emailUser);
                    intentperfil.putExtra("usuarioi", usernameUser);
                    intentperfil.putExtra("contrasenai", passwordUser);
                    intentperfil.putExtra("nacimi", naciUser);
                    intentperfil.putExtra("telefonoi", numUser);// Agrega los extras que desees enviar
                    startActivity(intentperfil);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_about:
                    return true;
                /*case R.id.bottom_logout:
                    startActivity(new Intent(getApplicationContext(), perfil.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;*/
            }
            return false;
        });
    }
}