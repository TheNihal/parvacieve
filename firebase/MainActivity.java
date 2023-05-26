package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        text=findViewById(R.id.edit1);

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference root=db.getReference();
        root.setValue(text.getText().toString());
        text.setText("");
        Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();


    }
}