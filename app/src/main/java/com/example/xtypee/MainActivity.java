package com.example.xtypee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider;
    TextView textView, textView22;
    DatabaseReference miBDFirebase;

    private static final String[] TEXTOS = {
            "Según datos de la plataforma inmobiliaria Propiedades.com, el precio promedio por metro cuadrado de una propiedad en la Ciudad de México es de alrededor de 32,000 pesos mexicanos.",
            "Las alcaldías de la Ciudad de México que tuvieron el mayor número de transacciones inmobiliarias durante el primer semestre de 2021 fueron Cuauhtémoc, Benito Juárez y Miguel Hidalgo, según datos de la AMPI.",
            "De acuerdo con un estudio de la plataforma inmobiliaria Lamudi, los compradores de vivienda en la Ciudad de México tienen en promedio entre 35 y 44 años de edad y buscan principalmente propiedades de dos o tres habitaciones.",
            "Según un estudio de la plataforma inmobiliaria Vivanuncios, el 90% de los mexicanos que compran una casa o departamento lo hacen para vivir en ella, mientras que sólo el 10% lo hace como inversión.",
            "En 2021, la pandemia de COVID-19 provocó una disminución del 25% en la venta de viviendas en la Ciudad de México durante el primer semestre del año, en comparación con el mismo período del año anterior, según datos de la Asociación Mexicana de Profesionales Inmobiliarios (AMPI).",
            "La Ciudad de México tiene el mayor número de viviendas del país: De acuerdo con el INEGI, la Ciudad de México cuenta con más de 7 millones de viviendas, lo que representa cerca del 20% del total de viviendas en México.",
            "Según datos de la Asociación Mexicana de Profesionales Inmobiliarios (AMPI), el tiempo promedio para vender una casa en la Ciudad de México es de entre 6 y 9 meses. Sin embargo, este tiempo puede variar considerablemente según la zona y el tipo de propiedad.",
            "La escrituración de una casa en la Ciudad de México puede ser un proceso largo y complejo. En promedio, el trámite puede tardar entre 2 y 3 meses, y requiere de la intervención de un notario público y de diversas autoridades municipales y federales.",
            "Según datos de la plataforma Inmuebles24, el costo promedio de la renta de una casa en la Ciudad de México ha disminuido en un 10% en comparación con los precios pre-pandemia. Esto se debe a una mayor oferta de viviendas disponibles en el mercado.",
            "Según datos de la plataforma Propiedades.com, el 70% de los compradores de vivienda en la Ciudad de México son jóvenes entre 25 y 44 años. Esto se debe en gran parte al aumento en la población joven que busca independizarse y adquirir su propia vivienda.",
            "La Ciudad de México es un centro importante para la educación superior en el país, y atrae a estudiantes de todo México. El 40% de los estudiantes foráneos en la ciudad provienen de otros estados de la república.",
            "Aunque la Ciudad de México es una metrópoli de gran tamaño, el costo de vida en la ciudad es más bajo que en otras ciudades latinoamericanas como São Paulo o Buenos Aires. Esto hace que sea una opción atractiva para los estudiantes foráneos.",
            "Según datos del Instituto Nacional de Estadística y Geografía (INEGI), en la Ciudad de México, el 64% de la población vive en viviendas rentadas, mientras que el 34% vive en viviendas propias.",
            "Según datos de 2021 de la plataforma inmobiliaria Propiedades.com, la colonia de la Ciudad de México con el precio promedio de renta más alto es Polanco, con un promedio de alrededor de $40,000 pesos mexicanos al mes.",
            "Según datos de 2021 de la plataforma inmobiliaria Propiedades.com, la colonia de la Ciudad de México con el precio promedio de venta más alto es Lomas de Chapultepec, con un promedio de alrededor de $43 millones de pesos mexicanos.",
            "Según un estudio realizado por el portal inmobiliario Propiedades.com, en 2021 los departamentos de 2 recámaras fueron los más buscados para comprar en la Ciudad de México."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener nombre del usuario
        textView22 = findViewById(R.id.textView333);

        // Obtener una referencia al TextView
        textView = findViewById(R.id.textView2);

        // Generar un índice aleatorio
        Random random = new Random();
        int indiceAleatorio = random.nextInt(TEXTOS.length);

        // Establecer el texto del TextView con el texto aleatorio
        textView.setText(TEXTOS[indiceAleatorio]);

        imageSlider = findViewById(R.id.imageSlider);
        showAllUserData();

        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add( new SlideModel(R.drawable.huno, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.hdos, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.htres, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.hcuatro, ScaleTypes.FIT));
        imageList.add( new SlideModel(R.drawable.hcinco, ScaleTypes.FIT));

        Intent intent = getIntent();
        String nameUser2 = intent.getStringExtra("nombrei");
        String emailUser = intent.getStringExtra("correoi");
        String usernameUser = intent.getStringExtra("usuarioi");
        String passwordUser = intent.getStringExtra("contrasenai");
        String naciUser = intent.getStringExtra("nacimi");
        String dirUser = intent.getStringExtra("direi");
        String numUser = intent.getStringExtra("telefonoi");

        imageSlider.setImageList(imageList);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
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
                    Intent intentabout = new Intent(getApplicationContext(), about.class);
                    intentabout.putExtra("nombrei", nameUser2);
                    intentabout.putExtra("correoi", emailUser);
                    intentabout.putExtra("usuarioi", usernameUser);
                    intentabout.putExtra("contrasenai", passwordUser);
                    intentabout.putExtra("nacimi", naciUser);
                    intentabout.putExtra("direi", dirUser);
                    intentabout.putExtra("telefonoi", numUser);// Agrega los extras que desees enviar
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
    }
    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("nombrei");
        textView22.setText(nameUser);

    }

}