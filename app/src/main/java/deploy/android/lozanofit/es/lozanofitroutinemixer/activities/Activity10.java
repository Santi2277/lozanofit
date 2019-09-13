package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity9AlertDialog;

public class Activity10 extends AppCompatActivity {

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
        setContentView(R.layout.activity_10);

        name = getIntent().getStringExtra("name");
        weekdays = getIntent().getStringExtra("weekdays");
        dayminutes = getIntent().getStringExtra("dayminutes");
        strengthlevel = getIntent().getStringExtra("strengthlevel");
        objective = getIntent().getStringExtra("objective");
        method = getIntent().getStringExtra("method");

        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);


        if(weekdays!=null){
            final Spinner timespinner = (Spinner) findViewById(R.id.spinner107);
            switch (weekdays){
                case "1":
                    timespinner.setSelection(0);
                    break;
                case "2":
                    timespinner.setSelection(1);
                    break;
                case "3":
                    timespinner.setSelection(2);
                    break;
                case "4":
                    timespinner.setSelection(3);
                    break;
                case "5":
                    timespinner.setSelection(4);
                    break;
                case "6":
                    timespinner.setSelection(5);
                    break;
                case "7":
                    timespinner.setSelection(6);
                    break;
                default:
                    timespinner.setSelection(0);
                    break;
            }
        }





    }

    public void goToAct9 (View view){
        Intent intent = new Intent (this, Activity9.class);
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

    public void goToAct11 (View view){
        Intent intent = new Intent (this, Activity11.class);

        final Spinner weekdaysspinner = (Spinner) findViewById(R.id.spinner107);
        weekdays = weekdaysspinner.getSelectedItem().toString();
        intent.putExtra("weekdays", weekdays);

        intent.putExtra("name", name);

        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("objective", objective);
        intent.putExtra("method", method);

        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", comingfromprofile);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        //go to act 9
        Intent intent = new Intent (this, Activity9.class);
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
