package com.mukundmurarka.messagingapp;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

   Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();



        // toolbar=(Toolbar) findViewById(R.id.tool_bar);
     //  setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        getSupportActionBar().setTitle("ChatApp");


        }

//    private void setSupportActionBar(Toolbar toolbar) {

    //}


    @Override
public void onStart() {
    super.onStart();
    // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser=mAuth.getCurrentUser();
   if(currentUser==null){
       Intent intent=new Intent(MainActivity.this,StartActivity.class);
           startActivity(intent);
           finish();
}

}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);

         getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        super.onOptionsItemSelected(menuItem);
        if(menuItem.getItemId()  ==R.id.log){
            FirebaseAuth.getInstance().signOut();
        }
        return true;

    }


}

