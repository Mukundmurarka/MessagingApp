package com.mukundmurarka.messagingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RagisterPage extends AppCompatActivity {
    EditText display_name;
    EditText email_id;
    EditText password;
    Button login;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister_page);

        mAuth = FirebaseAuth.getInstance();


        display_name=findViewById(R.id.editText2);
        email_id=findViewById(R.id.editText3);
        password=findViewById(R.id.editText);
        login =  findViewById(R.id.button3);






        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display_nm=display_name.getText().toString();
                String display_em=email_id.getText().toString();
                String display_ps=password.getText().toString();
                

                login_user(display_nm,display_em,display_ps);

            }

        });


    }

    private void login_user(String display_nm, String display_em, String display_ps) {

        mAuth.createUserWithEmailAndPassword(display_em,display_ps).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                                   Intent intent= new Intent(RagisterPage.this,MainActivity.class);
                                    startActivity(intent);

                } else{
                    Toast.makeText(RagisterPage.this,"YOU ARE NOT LOGGED IN ",Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
}
