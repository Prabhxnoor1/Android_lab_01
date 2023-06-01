package UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabhsandroidlab.databinding.ActivityMainBinding;

import data.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        model = new ViewModelProvider(this).get(MainViewModel.class);
        setContentView(variableBinding.getRoot());
        variableBinding.Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variableBinding.textview.setText("Your edit text has: "+ variableBinding.myedittext.getText().toString());
            }
        });
        variableBinding.switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        variableBinding.radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        variableBinding.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });
        model.isSelected.observe(this, selected->{
            variableBinding.checkBox.setChecked((Boolean) selected);
            variableBinding.radioButton.setChecked((Boolean) selected);
            variableBinding.switch1.setChecked((Boolean) selected);
            CharSequence text = "The value is now: isChecked.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this , text, duration);
            toast.show();
        });
        variableBinding.imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = variableBinding.imgbtn.getWidth();
                int height = variableBinding.imgbtn.getHeight();
                Toast.makeText(getApplicationContext(),"The width: "+width+" and height: "+height,Toast.LENGTH_SHORT).show();
            }       });
    }
}
