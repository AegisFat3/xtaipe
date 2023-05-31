package com.example.xtypee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class about extends AppCompatActivity {
    Button buttonfeis, buttonIG, buttonTT, buttonGIT;
    String _url="https://www.instagram.com/technoswamp/";
    String _urlT="https://twitter.com/Technoswam";
    String _urlfb="https://www.facebook.com/profile.php?id=100086036944709&mibextid=ZbWKwL";
    String _urlgit="https://github.com/Technoswamp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        buttonfeis = findViewById(R.id.buttonfeis);
        buttonIG = findViewById(R.id.buttonIG);
        buttonTT = findViewById(R.id.buttonTT);
        buttonGIT = findViewById(R.id.buttonGIT);
        buttonGIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(_urlgit);
                Intent i = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(i);
            }
        });

        buttonfeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(_urlfb);
                Intent i = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(i);
            }
        });

        buttonTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(_urlT);
                Intent i = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(i);
            }
        });

        buttonIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        String nameUser2 = intent.getStringExtra("nombrei");
        String emailUser = intent.getStringExtra("correoi");
        String usernameUser = intent.getStringExtra("usuarioi");
        String passwordUser = intent.getStringExtra("contrasenai");
        String naciUser = intent.getStringExtra("nacimi");
        String dirUser = intent.getStringExtra("direi");
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
                    intenthome.putExtra("direi", dirUser);
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
                    intentpro.putExtra("direi", dirUser);
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
                    intentforo.putExtra("direi", dirUser);
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
                    intentperfil.putExtra("direi", dirUser);
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