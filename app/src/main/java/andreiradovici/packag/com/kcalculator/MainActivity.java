package andreiradovici.packag.com.kcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton romanaBtn;
    RadioButton englishBtn;
    public Button pressContinue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Get radio buttons
        romanaBtn = (RadioButton) findViewById(R.id.rolanguage);
        englishBtn = (RadioButton) findViewById(R.id.englanguage);

        pressContinue = (Button) findViewById(R.id.startBtn);
        pressContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(romanaBtn.isChecked()) {
                    open_roActivity();
                }else if(englishBtn.isChecked()){
                    open_engActivity();
                }else if(!romanaBtn.isChecked() & !englishBtn.isChecked()){
                    Toast.makeText(getBaseContext(), "Please select one language and then press the button to continue",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void open_roActivity(){
        Intent intent = new Intent(this, romana.class);
        startActivity(intent);
    }

    public void open_engActivity(){
        Intent intent2 = new Intent(this, english.class);
        startActivity(intent2);
    }


}
