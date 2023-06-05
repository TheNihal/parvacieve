package com.example.nihal_portfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ImageView view,github,whatsapp,gmail,facebook,youtube,linkedin;
    EditText editComment;
    Spinner mySpinner;
    Intent intent;
    Button buttonSkills, buttoneducation,btnCV,Comment,frag1,cv;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Spinner_
        mySpinner=findViewById(R.id.mySpinnerID);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (i == position) {
                    return;
                }
                else {
                    Intent intent = new Intent(MainActivity.this, skills.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        //Home Page button to go Activity/Fragment
        buttonSkills= findViewById(R.id.btnSkills);
        buttonSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, skills.class));
            }
        });
        buttoneducation = findViewById(R.id.btnCV);
        buttoneducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Education.class));
            }
        });

        btnCV=findViewById(R.id.button3);
        btnCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url("https://beige-fianna-95.tiiny.site");

            }
        });






        //Social_Image_LInk
        ImageView github = (ImageView)findViewById(R.id.github);
        ImageView facebook = (ImageView)findViewById(R.id.facebook);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView youtube = (ImageView)findViewById(R.id.youtube);
        ImageView whatsapp = (ImageView)findViewById(R.id.whatsapp);
        ImageView linkedin = findViewById(R.id.linkedin);


        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url("https://github.com/TheNihal");
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url("https://www.facebook.com/d4rk.ki113r");
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url("https://www.youtube.com/@nihal4518");
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                url("https://drive.google.com/file/d/1RtvPKSKj-vuZSdQqlCYHin6iT0U051Kn/view?usp=sharing");
            }
        });
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url("https://www.linkedin.com/in/nihal-%E3%85%A4-498210201");
            }
        });


    }

    private void url(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


    //Firebase_Comment
    public void comment(View view) {
        editComment=findViewById(R.id.editTextCmtID);

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference("comment");
        root.setValue(editComment.getText().toString());
        editComment.setText("");
        Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
    }
}