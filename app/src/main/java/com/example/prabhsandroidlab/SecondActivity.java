package com.example.prabhsandroidlab;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txt = findViewById(R.id.textView3);
        Button bt = findViewById(R.id.button5);
        EditText edittxt = findViewById(R.id.editTextPhone);
        ImageView pic = findViewById(R.id.imageView);
        Button btimg = findViewById(R.id.button6);
        Intent fromPrevious = getIntent();
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");
        txt.setText("Welcome Back: " + emailAddress);

        String PhoneNumber = prefs.getString("PhoneNumber", "");
        edittxt.setText(PhoneNumber);

        Intent call = new Intent(Intent.ACTION_DIAL);

        bt.setOnClickListener(clk -> {
            String phoneNumber = edittxt.getText().toString();
            call.setData(Uri.parse("tel:" + edittxt));
            startActivity(call);
        });

        File file = new File(getFilesDir(), "Picture.png");

        if (file.exists()) {
            Bitmap theImage = BitmapFactory.decodeFile(file.getAbsolutePath());
            pic.setImageBitmap(theImage);
        }

        ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {

                            Intent data = result.getData();
                            Bitmap thumbnail = data.getParcelableExtra("data");
                            pic.setImageBitmap(thumbnail);

                            FileOutputStream fOut = null;

                            try {
                                fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);
                                thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                                fOut.flush();
                                fOut.close();

                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

        btimg.setOnClickListener(clk -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraResult.launch(cameraIntent);
        });
    }
    @Override
    protected void onPause() {
        super.onPause();

        EditText phone = findViewById(R.id.editTextPhone);

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        String phoneNumber = phone.getText().toString();

        editor.putString("PhoneNumber",phoneNumber);
        editor.apply();
    }
}

