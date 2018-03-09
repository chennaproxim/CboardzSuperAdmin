package com.cboadz.app.cboardzsuperadmin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by chinn on 02/09/18.
 */

public class RadioCheck extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio0:
                if (checked)
                    Toast.makeText(this, "Radio Button 1 is selected buy onClick from xml layout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio1:
                if (checked)
                    Toast.makeText(this, "Radio Button 2 is selected buy onClick from xml layout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio2:
                if (checked)
                    Toast.makeText(this, "Radio Button 3 is selected buy onClick from xml layout", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
