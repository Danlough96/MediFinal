package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.sql.*;

import static com.example.medical.DBConnect.runSelectQuery;

public class LoginPage extends AppCompatActivity {



    EditText loginUserName,loginPassword;
    Button loginbtn,registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        loginUserName = (EditText) findViewById(R.id.loginUserName);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        registerbtn = (Button) findViewById(R.id.registerbtn);
       final String username = loginUserName.getText().toString();
       final String password = loginPassword.getText().toString();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginPage.this, "Wrong username or password please re enter", Toast.LENGTH_LONG).show();
                   // startActivity(new Intent(v.getContext(), MainActivity.class));

            /*
                try {
                    User myUser = new User(username, password);

                    startActivity(new Intent(v.getContext(), MainActivity.class));

                } catch (Exception e) {
                    Toast unauthorised = Toast.makeText(getApplicationContext(),
                            "Wrong username or password", Toast.LENGTH_SHORT);
                    unauthorised.show();
                }
                String search = "SELECT username FROM tblusers WHERE username='" + username + "SELECT userpassword FROM tblusers WHERE userpassword='" + password + "';";
                try{
                    ResultSet resset = runSelectQuery(search);
                    if(resset.first() == true) {
                        startActivity(new Intent(v.getContext(), MainActivity.class));
                    }
                    else{
                        Toast unauthorised = Toast.makeText(getApplicationContext(),
                                "Wrong username or password", Toast.LENGTH_SHORT);
                        unauthorised.show();
                    }
                }catch(Exception e){
                    Toast error = Toast.makeText( getApplicationContext(), "Woops something has gone wrong", Toast.LENGTH_SHORT);
                    error.show();
                }*/
            }

        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Register.class));
            }

        });
    }



}
