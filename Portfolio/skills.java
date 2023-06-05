package com.example.nihal_portfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class skills extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);


        ///fragment1 in Skills activity
        Fragment1 fragment = new Fragment1();
        // Begin the transaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Replace the container with your fragment
        transaction.replace(R.id.container1, fragment);
        // Commit the transaction
        transaction.commit();




        Button button= findViewById(R.id.goid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(skills.this, MainActivity.class));
            }
        });



    }

}