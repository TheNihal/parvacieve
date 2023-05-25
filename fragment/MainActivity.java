package com.example.myapplication;

import static android.text.TextUtils.replace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button frag1,frag2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1=findViewById(R.id.Fragment1);
        frag2=findViewById(R.id.Fragment2);
        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(new Fragment1());

            }

        });
        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(new Fragment2());

            }
        });


    }

    private void replace(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }

}