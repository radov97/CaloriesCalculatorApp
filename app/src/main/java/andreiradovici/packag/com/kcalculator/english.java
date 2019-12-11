package andreiradovici.packag.com.kcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class english extends AppCompatActivity {

    // Declare usable
    EditText insert_kg;
    RadioButton sedentarRadio;
    RadioButton activRadio;
    RadioButton foarte_activRadio;
    Button calculateBtn;
    TextView pierdCal;
    TextView pierdProt;
    TextView pierdCarb;
    TextView pierdGrasimi;
    TextView mentinCal;
    TextView mentinProt;
    TextView mentinCarb;
    TextView mentinGrasimi;
    TextView crescCal;
    TextView crescProt;
    TextView crescCarb;
    TextView crescGrasimi;

    // Declare variables
    double greutate;
    double kcal;
    double proteine;
    double grasimi;
    double carbohidrati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Get usable
        insert_kg = (EditText) findViewById(R.id.insert_kg);
        sedentarRadio = (RadioButton) findViewById(R.id.sedentar);
        activRadio = (RadioButton) findViewById(R.id.activ);
        foarte_activRadio = (RadioButton) findViewById(R.id.foarte_activ);
        calculateBtn = (Button) findViewById(R.id.calculateBtn);

        // Get textviews
        pierdCal = (TextView) findViewById(R.id.pierdCal);
        pierdProt = (TextView) findViewById(R.id.pierdProt);
        pierdCarb = (TextView) findViewById(R.id.pierdCarb);
        pierdGrasimi = (TextView) findViewById(R.id.pierdGrasimi);
        mentinCal = (TextView) findViewById(R.id.mentinCal);
        mentinProt = (TextView) findViewById(R.id.mentinProt);
        mentinCarb = (TextView) findViewById(R.id.mentinCarb);
        mentinGrasimi = (TextView) findViewById(R.id.mentinGrasimi);
        crescCal = (TextView) findViewById(R.id.crescCal);
        crescProt = (TextView) findViewById(R.id.crescProt);
        crescCarb = (TextView) findViewById(R.id.crescCarb);
        crescGrasimi = (TextView) findViewById(R.id.crescGrasimi);

        //Calculate when button is pressed
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sedentarRadio.isChecked()){
                    pierdere_greutate_sedentar();
                    mentinere_greutate_sedentar();
                    crestere_greutate_sedentar();
                }else if(activRadio.isChecked()){
                    pierdere_greutate_activ();
                    mentinere_greutate_activ();
                    crestere_greutate_activ();
                }else if(foarte_activRadio.isChecked()){
                    pierdere_greutate_foarte_activ();
                    mentinere_greutate_foarte_activ();
                    crestere_greutate_foarte_activ();
                }else if((sedentarRadio.isChecked()||activRadio.isChecked()||foarte_activRadio.isChecked()) & insert_kg.getText().length()==0){
                    Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getBaseContext(), "Please select your lifestyle", Toast.LENGTH_LONG).show();
                }
            }
        });



    }



    protected void pierdere_greutate_sedentar(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 14) - 500.0;
        proteine = 1.2 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        pierdCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        pierdCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        pierdProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        pierdGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

    protected void pierdere_greutate_activ(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 15) - 500.0;
        proteine = 1.8 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        pierdCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        pierdCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        pierdProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        pierdGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

    protected void pierdere_greutate_foarte_activ(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 16) - 500.0;
        proteine = 2.5 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        pierdCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        pierdCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        pierdProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        pierdGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

    protected void mentinere_greutate_sedentar(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 14);
        proteine = 1.2 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        mentinCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        mentinCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        mentinProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        mentinGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

    protected void mentinere_greutate_activ(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 15);
        proteine = 1.8 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        mentinCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        mentinCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        mentinProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        mentinGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

    protected void mentinere_greutate_foarte_activ(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 16);
        proteine = 2.5 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        mentinCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        mentinCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        mentinProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        mentinGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

    protected void crestere_greutate_sedentar(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 14) + 300.0;
        proteine = 1.2 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        crescCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        crescCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        crescProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        crescGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

    protected void crestere_greutate_activ(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 15) + 300.0;
        proteine = 1.8 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        crescCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        crescCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        crescProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        crescGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }
    protected void crestere_greutate_foarte_activ(){
        try
        {
            greutate = Double.parseDouble(insert_kg.getText().toString());
        }
        catch (NumberFormatException e)
        {
            //Here request a valid value
            Toast.makeText(getBaseContext(), "Please insert your weight", Toast.LENGTH_LONG).show();
            insert_kg.requestFocus();
        }
        kcal = (greutate * 2.2 * 16) + 300.0;
        proteine = 2.5 * greutate;
        grasimi = 0.3 * 2.2 * greutate;
        carbohidrati=(kcal - (proteine * 4 + grasimi * 9) ) / 4.0;
        crescCal.setText("Calories: " + String.format("%.2f", kcal) + " kcal");
        crescCarb.setText("Carbs: " + String.format("%.2f", carbohidrati) + " g");
        crescProt.setText("Proteins: " + String.format("%.2f", proteine) + " g");
        crescGrasimi.setText("Fat: " + String.format("%.2f", grasimi) + " g");
    }

}
