package com.example.xtypee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.xtypee.Service.DbUsuarios;
import com.example.xtypee.des.MyDesUtil;
import com.example.xtypee.json.MyData;
import com.example.xtypee.json.MyInfo;
import com.example.xtypee.metodos.Metodos;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class registro extends AppCompatActivity implements View.OnClickListener {
    private Button button4,pick;
    private EditText usuarioaa, pswdaa,mail,num,fec, dir, nombreaa;
    private CheckBox box1, box2, box3;
    private Spinner spinner;
    private RadioButton r1,r2;
    private int dia, mes , ano;
    private static final String TAG = "MainActivity";
    public static final String archivo = "S.json";
    String json = null;
    public static String usr,password,email,numero,fecha,region,nom;
    public static int sw = 0;
    public static int activado;
    public static String[] box = new String[3];
    public static String box1s;
    public static String box2s;
    public static String box3s;
    EditText signupName, signupUsername, signupEmail, signupPassword;

    public static List<MyInfo> list =new ArrayList<MyInfo>();
    public static List<MyData> lista;
    public static final String KEY = "+4xij6jQRSBdCymMxweza/uMYo+o0EUg";
    public MyDesUtil myDesUtil= new MyDesUtil().addStringKeyBase64(KEY);

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Contraseñas nuevas
        lista= new ArrayList<>();
        MyData myData=null;
        String [] opciones = {"Norte","Sur","Centro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        pick = findViewById(R.id.pick);
        button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);

        signupName = findViewById(R.id.nombre);
        signupEmail = findViewById(R.id.email);
        signupUsername = findViewById(R.id.usuario);
        signupPassword = findViewById(R.id.pswd);



        num = findViewById(R.id.num);
        fec = findViewById(R.id.fec);
        dir = findViewById(R.id.ubica);

        Intent intent = getIntent();
        String nameUser3 = intent.getStringExtra("nombrei");
        String emailUser3 = intent.getStringExtra("correoi");
        String usernameUser3 = intent.getStringExtra("usuarioi");
        String passwordUser3 = intent.getStringExtra("contrasenai");
        String naciUser3 = intent.getStringExtra("nacimi");
        String dirUser3 = intent.getStringExtra("direi");
        String numUser3 = intent.getStringExtra("telefonoi");


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registro.this, login.class);
                startActivity(intent);
            }
        });
        pick.setOnClickListener(this);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String direccion = dir.getText().toString();
                String fecha = fec.getText().toString();
                String numero = num.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !fecha.isEmpty() && !numero.isEmpty() && !direccion.isEmpty()) {
                    // Los campos están llenos, realizar alguna acción
                    // Por ejemplo, enviar los datos a través de un botón de envío o realizar alguna operación
                    // ...
                    HelperClass helperClass = new HelperClass(name, email, username, password, fecha, numero, direccion);
                    reference.child(username).setValue(helperClass);

                    Toast.makeText(registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(registro.this, login.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                    // Al menos uno de los campos está vacío, mostrar un mensaje de error o realizar alguna acción
                    // Por ejemplo, mostrar un mensaje al usuario indicando que debe llenar todos los campos
                    // ...
                }


              /*  MyInfo info= new MyInfo();
                usr = String.valueOf(usuarioaa.getText());
                password = String.valueOf(pswdaa.getText());
                email= String.valueOf(mail.getText());
                numero = String.valueOf(num.getText());
                fecha = String.valueOf(fec.getText());
                //region = spinner.getSelectedItem().toString();
                nom = String.valueOf(nombreaa.getText()); */

                /*if(box1.isChecked()==true){
                    box1s="opcion1";
                }else{
                    box1s="no";
                }
                if(box2.isChecked()==true){
                    box2s="opcion2";
                }else{
                    box2s="no";
                }
                if(r1.isChecked()==true){
                    activado=1;
                }
                if(r2.isChecked()==true){
                    activado=1;
                }
                 */
                //Validaciones
            /*    if(usr.equals("")||password.equals("")||email.equals("")){
                    Log.d(TAG,"vacio");
                    Log.d(TAG,usr);
                    Log.d(TAG,password);
                    Log.d(TAG,email);
                    Toast.makeText(getApplicationContext(), "LLena los campos", Toast.LENGTH_LONG).show();
                }else{
                    if(Metodos.validarEmail(email)){
                        Metodos.fillInfo(info);
                        DbUsuarios dbUsuarios = new DbUsuarios(registro.this);
                        long id=dbUsuarios.saveUser(info);
                        if (id > 0){
                            Toast.makeText(registro.this, "REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(registro.this, "ERROR AL GUARDAR REGISTRO",Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(getApplicationContext(), "Introduzca un correo válido", Toast.LENGTH_LONG).show();
                    }

                } */
            }
        });


    }



    @Override
    public void onClick(View v) {
        if(v==pick){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    fec.setText(i2+"/"+(i1+1)+"/"+i);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
}