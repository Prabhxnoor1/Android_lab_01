package com.example.prabhsandroidlab;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Main Activity Class
 * @author prabh
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /**
     * holder for text view
     */
    TextView tv;
    /**
     * holder for Edit text
     */
    EditText et;
    /**
     * holder for Button widget
     */
    Button btn;

    /**
     * override method for on create
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener( clk ->{
            String password = et.getText().toString();
            if (checkPasswordComplexity( password )==true){
                tv.setText("Your password meets the requirements");
            }else {
                tv.setText("You shall not pass!");
            }
        });

    }

    /**
     * method for checking password complexity
     * @param pw parameter for containing password
     * @return returns true if password meets the requirements
     */
    Boolean checkPasswordComplexity( String pw ){
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isDigit(c)){
                foundNumber = true;
            } else if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else {
                foundSpecial = true;
            }
        }
        if(!foundUpperCase) {
            Toast.makeText(MainActivity.this,"missing upper case letter",Toast.LENGTH_SHORT).show();
            return false;
        } else if( ! foundLowerCase) {
            Toast.makeText(MainActivity.this,"missing lower case letter",Toast.LENGTH_SHORT).show();
            return false;
        } else if( ! foundNumber) {
            Toast.makeText(MainActivity.this,"missing Number",Toast.LENGTH_SHORT).show();
            return false;
        } else if(! foundSpecial) {
            Toast.makeText(MainActivity.this,"missing Special Character",Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    /**
     * method to setting requirements for password's speacial character
     * @param c character of a complex string
     * @return returns true if special character exits in password
     */
    boolean isSpecialCharacter( char c){
        switch (c){
            case '#':
            case '$':
            case '%':
            case '*':
            case '?':
            case '^':
            case '&':
            case '!':
            case '@':
                return true;
            default:
                return false;
        }
    }
}