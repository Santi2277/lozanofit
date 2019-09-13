package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity9AlertDialog;

public class Activity12 extends AppCompatActivity {

    String name = "";
    String weekdays = "";
    String dayminutes = "";
    String strengthlevel = "";
    String objective = "";
    String method = "";

    int profileid = 0;
    int comingfromprofile = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12);

        name = getIntent().getStringExtra("name");
        weekdays = getIntent().getStringExtra("weekdays");
        dayminutes = getIntent().getStringExtra("dayminutes");
        strengthlevel = getIntent().getStringExtra("strengthlevel");
        objective = getIntent().getStringExtra("objective");
        method = getIntent().getStringExtra("method");

        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);


        //change text when spinner changes

        final Spinner levelspinner = (Spinner) findViewById(R.id.spinner117);
        if(strengthlevel!=null){
            switch (strengthlevel){
                case "1.- Básico":
                    levelspinner.setSelection(0);
                    break;
                case "2.- En forma":
                    levelspinner.setSelection(1);
                    break;
                case "3.- Atlético":
                    levelspinner.setSelection(2);
                    break;
                case "4.- Fuerte":
                    levelspinner.setSelection(3);
                    break;
                case "5.- Muy fuerte":
                    levelspinner.setSelection(4);
                    break;
                default:
                    levelspinner.setSelection(0);
                    break;
            }
        }



        //strengthlevel = strengthlevelspinner.getSelectedItem().toString();

        levelspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                TextView text = findViewById(R.id.textView1212);

                switch (position){
                    case 0:
                        text.setText("Nivel más básico, levantar una mancuerna de 6 kg (curl de bíceps).");
                        break;
                    case 1:
                        text.setText("Nivel suave, levantar una mancuerna de 10 kg (curl de bíceps).");
                        break;
                    case 2:
                        text.setText("Nivel medio, levantar una mancuerna de 14 kg (curl de bíceps).");
                        break;
                    case 3:
                        text.setText("Nivel avanzado, levantar una mancuerna de 16 kg (curl de bíceps).");
                        break;
                    case 4:
                        text.setText("Nivel más alto, levantar una mancuerna de 20 kg (curl de bíceps).");
                        break;
                }





            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

            }


        });

    }

    public void goToAct11 (View view){
        Intent intent = new Intent (this, Activity11.class);
        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);

        intent.putExtra("name", name);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("objective", objective);
        intent.putExtra("method", method);
        startActivity(intent);

    }

    public void goToAct13 (View view){
        Intent intent = new Intent (this, Activity13.class);

        final Spinner strengthlevelspinner = (Spinner) findViewById(R.id.spinner117);
        strengthlevel = strengthlevelspinner.getSelectedItem().toString();
        intent.putExtra("strengthlevel", strengthlevel);

        intent.putExtra("name", name);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);

        intent.putExtra("objective", objective);
        intent.putExtra("method", method);

        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", comingfromprofile);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        //go to act 11
        Intent intent = new Intent (this, Activity11.class);
        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);

        intent.putExtra("name", name);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("objective", objective);
        intent.putExtra("method", method);
        startActivity(intent);

    }


    public void goToAct819 (View view){
        //go to profile selector or one concrete profile screen
        FragmentManager fragmentManager = getSupportFragmentManager();
        Activity9AlertDialog dialogo = new Activity9AlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");

    }


}
