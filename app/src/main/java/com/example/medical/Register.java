package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;

public class Register extends AppCompatActivity {
    EditText fNametxt, lNametxt, emailAddress, Password, userNametxt, phoneNumber;
    Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fNametxt = (EditText) findViewById(R.id.fNametxt);
        lNametxt = (EditText) findViewById(R.id.lNametxt);
        emailAddress = (EditText) findViewById(R.id.emailAddresstxt);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        userNametxt = (EditText) findViewById(R.id.userNametxt);
        Password = (EditText) findViewById(R.id.Password);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = fNametxt.getText().toString();
                String lastName = lNametxt.getText().toString();
                String email = emailAddress.getText().toString();

                String password = CryptWithMD5.cryptWithMD5(Password.getText().toString());

                String phonenumber = phoneNumber.getText().toString();
                String username = userNametxt.getText().toString();



                try{
                UserRegister newUser = new UserRegister(firstName,lastName,email,phonenumber,username,password);
                startActivity(new Intent(v.getContext(), LoginPage.class));

                Toast.makeText(Register.this, "Thank you for registering a new user", Toast.LENGTH_SHORT).show();

            }
                catch (Exception e){
                    Toast error = Toast.makeText( getApplicationContext(), e.toString() + " Woops something has gone wrong", Toast.LENGTH_SHORT);
                    error.show();
                }

            }
        });

    }
}
