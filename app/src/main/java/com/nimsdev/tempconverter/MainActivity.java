package com.nimsdev.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener  {

    // create class properties to hold widget references
    private EditText fahrenheitEditText;
    private TextView celsiusTextView;

    private String fahrenheitInputString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // establish widget references
        fahrenheitEditText = findViewById(R.id.fahrenheitEditText);
        celsiusTextView = findViewById(R.id.celsiusTextView);

        fahrenheitEditText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        calculateAndDisplay();
        return true;
    }

    private void calculateAndDisplay() {
        //gather fahrenheit degrees input
        fahrenheitInputString = fahrenheitEditText.getText().toString();
        float fahrenheitInput;
        if (fahrenheitInputString.equals("")) {
            fahrenheitInput = 0;
        } else {
            fahrenheitInput = Float.parseFloat(fahrenheitInputString);
        }

        // calculate output dergrees in celsius
        float celsiusOutput = (fahrenheitInput - 32) * 5/9;

        NumberFormat degrees = NumberFormat.getIntegerInstance();
        celsiusTextView.setText(degrees.format(celsiusOutput));
    }
}
