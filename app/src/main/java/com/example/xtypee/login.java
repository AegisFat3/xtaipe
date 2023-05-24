package com.example.xtypee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    EditText loginUsername, loginPassword;
    Button loginButton, button2, buttonfeis, buttonIG, buttonTT, buttonGIT;
    String _url="https://www.instagram.com/technoswamp/";
    String _urlT="https://twitter.com/Technoswam";
    String _urlfb="https://www.facebook.com/profile.php?id=100086036944709&mibextid=ZbWKwL";
    String _urlgit="https://github.com/Technoswamp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUsername = findViewById(R.id.mail);
        loginPassword = findViewById(R.id.pswds);
        loginButton = findViewById(R.id.buttonL2);
        button2 = findViewById(R.id.buttonR2);
        buttonfeis = findViewById(R.id.buttonfeis);
        buttonIG = findViewById(R.id.buttonIG);
        buttonTT = findViewById(R.id.buttonTT);
        buttonGIT = findViewById(R.id.buttonGIT);

        buttonGIT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_urlgit);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        buttonfeis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_urlfb);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        buttonTT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_urlT);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        buttonIG.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()) {
                } else {
                    checkUser();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, registro.class);
                startActivity(intent);
            }
        });
    }
    public Boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if (val.isEmpty()) {
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("usuarioi").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("contrasenai").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)) {
                        loginUsername.setError(null);
                        String nameFromDB = snapshot.child(userUsername).child("nombrei").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("correoi").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("usuarioi").getValue(String.class);
                        String fecFromDB = snapshot.child(userUsername).child("nacimi").getValue(String.class);
                        String telFromDB = snapshot.child(userUsername).child("telefonoi").getValue(String.class);
                        Intent intent = new Intent(login.this, MainActivity.class);
                        intent.putExtra("nombrei", nameFromDB);
                        intent.putExtra("correoi", emailFromDB);
                        intent.putExtra("usuarioi", usernameFromDB);
                        intent.putExtra("contrasenai", passwordFromDB);
                        intent.putExtra("nacimi", fecFromDB);
                        intent.putExtra("telefonoi", telFromDB);
                        startActivity(intent);
                    } else {
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("No existe el usuario");
                    loginUsername.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}