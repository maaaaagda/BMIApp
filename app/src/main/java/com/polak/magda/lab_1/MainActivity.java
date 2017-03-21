package com.polak.magda.lab_1;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public static CountBMIForKGM countBMIForKGM = new CountBMIForKGM();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.buttonCountBMI);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextHeight = (EditText)findViewById(R.id.editHeight);
                EditText editTextWeight = (EditText)findViewById(R.id.editWeight);
                TextView BMIResultText = (TextView) findViewById(R.id.textViewResultText);
                TextView EDBmi = (TextView) findViewById(R.id.textViewResult);
                float weight = Float.parseFloat(editTextWeight.getText().toString());
                float height = Float.parseFloat(editTextHeight.getText().toString());
                float BMI = countBMIForKGM.countBMI(weight,height);
                DecimalFormat df = new DecimalFormat("#.##");
                String dBMI = df.format(BMI);
                BMIResultText.setVisibility(View.VISIBLE);
                EDBmi.setTextColor(Color.GREEN);
                EDBmi.setText(dBMI );


            }
        });
    }

    //ButterKnife
    //Testy UI
}
