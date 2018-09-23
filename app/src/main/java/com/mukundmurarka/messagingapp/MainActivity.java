package com.mukundmurarka.messagingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private com.google.firebase.auth.FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        }
        @Override
public void onStart() {
    super.onStart();
    // Check if user is signed in (non-null) and update UI accordingly.
    com.google.firebase.auth.FirebaseUser currentUser = mAuth.getCurrentUser();
   if(currentUser==null){
       android.content.Intent intent=new android.content.Intent(MainActivity.this,StartActivity.class);
           startActivity(intent);



}else{



}


}

    }

