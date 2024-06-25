package edu.csueb.android.temperature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText);
    }

    // this method is called at button click because we assigned the name to
    // the "OnClick property" of the button
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            RadioButton celsiusButton = (RadioButton) findViewById(R.id.radioButton);
            RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radioButton1);
            String input = text.getText().toString();

            // Check if the input is empty
            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                return;
            }

            // we add this to make sure when a letter is inputed it does not break the program
            float inputValue;
            try {
                inputValue = Float.parseFloat(input);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
                return;
            }

            if (celsiusButton.isChecked()) {
                text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                celsiusButton.setChecked(false);
                fahrenheitButton.setChecked(true);
            } else {
                text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                fahrenheitButton.setChecked(false);
                celsiusButton.setChecked(true);
            }
        }
    }
}
