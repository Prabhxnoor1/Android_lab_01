package com.example.prabhsandroidlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mytext = findViewById(R.id.textview);
        Button btn = findViewById(R.id.Button);
        EditText myedit = findViewById(R.id.myedittext);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String editString = myedit.getText().toString();
        mytext.setText( "Your edit text has: " + editString);


    }
});
    }
}