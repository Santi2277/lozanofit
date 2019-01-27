package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity2AlertDialog;

public class Activity5 extends AppCompatActivity {

    public int counter = 0;
    public String timestring = "";
    public String levelstring = "";
    public String bodystring = "";
    public String objectivestring = "";
    public boolean listcreated = false;
    public ArrayList<String> musclesSelected = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        listcreated = getIntent().getBooleanExtra("listCreated", false);
        objectivestring = getIntent().getStringExtra("selectedObjective");
        levelstring = getIntent().getStringExtra("selectedLevel");
        timestring = getIntent().getStringExtra("selectedTime");
        bodystring = getIntent().getStringExtra("selectedBodyPart");


    }


    public void goToActivity2(View view) {

        //add selected muscles
        CheckBox checkb2 = (CheckBox) findViewById(R.id.checkBox2);
        if (checkb2.isChecked()) {
            musclesSelected.add("biceps");
        }
        CheckBox checkb3 = (CheckBox) findViewById(R.id.checkBox3);
        if (checkb3.isChecked()) {
            musclesSelected.add("chest");
        }
        CheckBox checkb4 = (CheckBox) findViewById(R.id.checkBox4);
        if (checkb4.isChecked()) {
            musclesSelected.add("mid-back");
        }
        CheckBox checkb5 = (CheckBox) findViewById(R.id.checkBox5);
        if (checkb5.isChecked()) {
            musclesSelected.add("deltoid");
        }
        CheckBox checkb6 = (CheckBox) findViewById(R.id.checkBox6);
        if (checkb6.isChecked()) {
            musclesSelected.add("upper-back");
        }
        CheckBox checkb7 = (CheckBox) findViewById(R.id.checkBox7);
        if (checkb7.isChecked()) {
            musclesSelected.add("triceps");
        }
        CheckBox checkb8 = (CheckBox) findViewById(R.id.checkBox8);
        if (checkb8.isChecked()) {
            musclesSelected.add("forearm");
        }
        CheckBox checkb9 = (CheckBox) findViewById(R.id.checkBox9);
        if (checkb9.isChecked()) {
            musclesSelected.add("lumbar");
        }
        CheckBox checkb10 = (CheckBox) findViewById(R.id.checkBox10);
        if (checkb10.isChecked()) {
            musclesSelected.add("abs");
        }
        CheckBox checkb11 = (CheckBox) findViewById(R.id.checkBox11);
        if (checkb11.isChecked()) {
            musclesSelected.add("glute");
        }
        CheckBox checkb12 = (CheckBox) findViewById(R.id.checkBox12);
        if (checkb12.isChecked()) {
            musclesSelected.add("thigh");
        }
        CheckBox checkb13 = (CheckBox) findViewById(R.id.checkBox13);
        if (checkb13.isChecked()) {
            musclesSelected.add("calf");
        }


        //warning, select at least 1 muscle (toast?)
        if (musclesSelected.size() == 0) {
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Mínimo 1 músculo", Toast.LENGTH_LONG);
            toast1.show();

        } else {
            //NOT WORKING go to activity 2 directly, then go to activity1 first
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("exerciseCounter", counter);
            intent.putExtra("selectedTime", timestring);
            intent.putExtra("selectedLevel", levelstring);
            intent.putExtra("selectedBodyPart", bodystring);
            intent.putExtra("selectedObjective", objectivestring);
            intent.putExtra("listCreated", false);
            intent.putExtra("selectedMuscles", musclesSelected);
            startActivity(intent);
        }


    }


    public void goToMain(View view) {

        //NOT WORKING go to activity 2 directly, then go to activity1 first
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("exerciseCounter", counter);
        intent.putExtra("selectedTime", timestring);
        intent.putExtra("selectedLevel", levelstring);
        intent.putExtra("selectedBodyPart", bodystring);
        intent.putExtra("selectedObjective", objectivestring);
        intent.putExtra("listCreated", false);
        startActivity(intent);

    }

}




