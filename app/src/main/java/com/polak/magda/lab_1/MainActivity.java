package com.polak.magda.lab_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.description;
import static android.R.attr.titleMarginTop;

public class MainActivity extends AppCompatActivity {

    public static BMIInterface countBMI;

    @BindView(R.id.editHeight)  EditText editTextHeight;
    @BindView(R.id.editWeight)  EditText editTextWeight;
    @BindView(R.id.textViewResultText)  TextView BMIResultText;
    @BindView(R.id.textViewResult) TextView EDBmi;
    @BindView(R.id.buttonCountBMI) Button countBMIButton;
    @BindView(R.id.textViewHeightUnit) TextView heightUnit;
    @BindView(R.id.textViewWeightUnit)  TextView weightUnit;
    @BindView(R.id.radio_kg_m) RadioButton radio_kg_m;
    @BindView(R.id.radio_Ib_feet) RadioButton radio_Ib_feet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.MI_About){
            Intent intent = new Intent(this, AuthorActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.MI_Restore)
        {
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
            editTextHeight.setText(sharedPref.getString("heightKey", ""));
            editTextWeight.setText(sharedPref.getString("weightKey", ""));
            Toast.makeText(getApplication(), "Restored!", Toast.LENGTH_LONG).show();
            if(sharedPref.getBoolean("unitKey", false))
                radio_kg_m.setChecked(true);
            else
                radio_Ib_feet.setChecked(true);
            return true;
        }
        else if(id == R.id.MI_Save) {
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("MyPref", 0);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("heightKey", editTextHeight.getText().toString());
            editor.putString("weightKey", editTextWeight.getText().toString());
            Toast.makeText(getApplication(), "Saved", Toast.LENGTH_LONG).show();
            editor.putBoolean("unitKey", radio_kg_m.isChecked());
            editor.commit();
            return true;
        }
        else if(id == R.id.MI_Share){
            String message = "My Bmi is " + EDBmi.getText().toString();
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, message);

            startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("BMIResultKey", EDBmi.getText().toString());
        outState.putString("weightKey", editTextWeight.getText().toString());
        outState.putString("heightKey", editTextHeight.getText().toString());
        outState.putBoolean("unitKey", radio_kg_m.isChecked());
        outState.putInt("color",  EDBmi.getCurrentTextColor());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EDBmi.setTextColor(savedInstanceState.getInt("color"));
        EDBmi.setText(savedInstanceState.getString("BMIResultKey"));
        editTextWeight.setText(savedInstanceState.getString("weightKey"));
        editTextHeight.setText(savedInstanceState.getString("heightKey"));
            if(savedInstanceState.getBoolean("unitKey"))
                radio_kg_m.setChecked(true);
            else
                radio_Ib_feet.setChecked(true);
    }

    protected int BMIColor (float BMI)    {
        if(BMI<18.5)
            return Color.BLUE;
        else if(BMI>30)
            return Color.RED;
        else if(BMI>25 && BMI <30)
            return Color.YELLOW;
        else
            return Color.GREEN;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_kg_m:
                if (checked)
                {
                    heightUnit.setText(R.string.unitMeter);
                    weightUnit.setText(R.string.unitKg);
                }
                    break;
            case R.id.radio_Ib_feet:
                if (checked)
                {
                    heightUnit.setText(R.string.unitFeet);
                    weightUnit.setText(R.string.unitIb);
                }
                   break;
        }
    }

    @OnClick(R2.id.buttonCountBMI)
    public void onBMIButtonClicked()    {
        if (radio_kg_m.isChecked())
            countBMI = new CountBMIForKgM();
        else
            countBMI = new CountBMIForIbFeet();

        try {
            float weight = Float.parseFloat(editTextWeight.getText().toString());
            float height = Float.parseFloat(editTextHeight.getText().toString());
            float BMI = countBMI.countBMI(weight, height);
            DecimalFormat df = new DecimalFormat("#.##");
            String dBMI = df.format(BMI);
            InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            BMIResultText.setVisibility(View.VISIBLE);
            EDBmi.setTextColor(BMIColor(BMI));
            EDBmi.setText(dBMI);
        } catch (NumberFormatException ex) {
            Toast.makeText(getApplication(), "Fill neccessary fields!",
                    Toast.LENGTH_LONG).show();
        } catch (IllegalArgumentException ex) {
            Toast.makeText(getApplication(), "Enter valid numbers!",
                    Toast.LENGTH_LONG).show();
        }

    }

}
