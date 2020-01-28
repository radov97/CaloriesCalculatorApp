package andreiradovici.packag.com.kcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class romana extends AppCompatActivity {

    // Declare usable
    private EditText insertKg;
    private RadioButton sedentaryRadio, activeRadio, veryActiveRadio;
    private Button calculateButton;
    private TextView caloriesToLose, loseProtein, loseCarb, loseFat;
    private TextView caloriesToKeep, keepProtein, keepCarb, keepFat;
    private TextView caloriesToIncrease, increaseProtein, increaseCarb, increaseFat;

    // Declare variables
    private double weight, kcal, protein, fat, carbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romana);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Get usable
        insertKg = (EditText) findViewById(R.id.insertKg);
        sedentaryRadio = (RadioButton) findViewById(R.id.sedentar);
        activeRadio = (RadioButton) findViewById(R.id.activ);
        veryActiveRadio = (RadioButton) findViewById(R.id.veryActive);
        calculateButton = (Button) findViewById(R.id.calculateButton);

        // Get textviews
        caloriesToLose = (TextView) findViewById(R.id.caloriesToLose);
        loseProtein = (TextView) findViewById(R.id.loseProtein);
        loseCarb = (TextView) findViewById(R.id.loseCarb);
        loseFat = (TextView) findViewById(R.id.loseFat);
        caloriesToKeep = (TextView) findViewById(R.id.caloriesToKeep);
        keepProtein = (TextView) findViewById(R.id.keepProtein);
        keepCarb = (TextView) findViewById(R.id.keepCarb);
        keepFat = (TextView) findViewById(R.id.keepFat);
        caloriesToIncrease = (TextView) findViewById(R.id.caloriesToIncrease);
        increaseProtein = (TextView) findViewById(R.id.increaseProtein);
        increaseCarb = (TextView) findViewById(R.id.increaseCarb);
        increaseFat = (TextView) findViewById(R.id.increaseFat);

        //Calculate when button is pressed
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (sedentaryRadio.isChecked()) {
                  loseWeightSedentary();
                  keepWeightSedentary();
                  gainWeightSedentary();
              } else if (activeRadio.isChecked()) {
                  loseWeightActive();
                  keepWeightActive();
                  gainWeightActive();
              }else if (veryActiveRadio.isChecked()) {
                  loseWeightVeryActive();
                  keepWeightVeryActive();
                  gainWeightVeryActive();
              } else if ((sedentaryRadio.isChecked() || activeRadio.isChecked() || veryActiveRadio.isChecked()) & insertKg.getText().length() == 0)
                  Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
              else
                  Toast.makeText(getBaseContext(), "Selectează modul de viaţă preferat", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loseWeightSedentary() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 14) - 500.0;
        protein = 1.2 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToLose.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        loseCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        loseProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        loseFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }

    private void loseWeightActive() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 15) - 500.0;
        protein = 1.8 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToLose.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        loseCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        loseProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        loseFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }

    private void loseWeightVeryActive() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 16) - 500.0;
        protein = 2.5 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToLose.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        loseCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        loseProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        loseFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }

    private void keepWeightSedentary() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 14);
        protein = 1.2 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToKeep.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        keepCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        keepProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        keepFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }

    private void keepWeightActive() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 15);
        protein = 1.8 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToKeep.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        keepCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        keepProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        keepFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }

    private void keepWeightVeryActive() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 16);
        protein = 2.5 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToKeep.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        keepCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        keepProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        keepFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }

    private void gainWeightSedentary() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 14) + 300.0;
        protein = 1.2 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToIncrease.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        increaseCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        increaseProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        increaseFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }

    private void gainWeightActive() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        }
        catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 15) + 300.0;
        protein = 1.8 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToIncrease.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        increaseCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        increaseProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        increaseFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }
    private void gainWeightVeryActive() {
        try {
            weight = Double.parseDouble(insertKg.getText().toString());
        } catch (NumberFormatException e) {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Te rog să introduci greutatea", Toast.LENGTH_LONG).show();
            insertKg.requestFocus();
        }
        kcal = (weight * 2.2 * 16) + 300.0;
        protein = 2.5 * weight;
        fat = 0.3 * 2.2 * weight;
        carbs=(kcal - (protein * 4 + fat * 9) ) / 4.0;
        caloriesToIncrease.setText("Calorii: " + String.format("%.2f", kcal) + " kcal");
        increaseCarb.setText("Carbohraţi: " + String.format("%.2f", carbs) + " g");
        increaseProtein.setText("Proteine: " + String.format("%.2f", protein) + " g");
        increaseFat.setText("Grăsimi: " + String.format("%.2f", fat) + " g");
    }
}