package com.example.testdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private TextView loginText;
    private EditText loginTextEdit;
    private EditText passwordTextEdit;
    private Button loginButton;
    private String mail="egonau@mail.ru";
    private String psw="qwerty";

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginText = (TextView) findViewById(R.id.loginText);
        loginTextEdit = (EditText) findViewById(R.id.loginTextEdit);
        passwordTextEdit = (EditText) findViewById(R.id.passwordTextEdit);
        loginButton = (Button) findViewById(R.id.loginButton);
        auth = FirebaseAuth.getInstance();
    }
    public void Login(View view){
        loginUser(mail, psw);

//        if (!String.valueOf(loginTextEdit.getText()).isEmpty() || !String.valueOf(passwordTextEdit.getText()).isEmpty()) {
//            Toast.makeText(getApplicationContext(), "Логинюсь", Toast.LENGTH_SHORT).show();
//            loginUser(String.valueOf(loginTextEdit.getText()), String.valueOf(passwordTextEdit.getText()));
//        } else {
//            Toast.makeText(getApplicationContext(), "Вход запрещен!", Toast.LENGTH_SHORT).show();
//        }
    }

    private void loginUser(String login, String password) {
        auth.signInWithEmailAndPassword(login, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Successfully logged in",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}