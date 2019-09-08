package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity11 extends AppCompatActivity {

    String name = "";
    String weekdays = "";
    String dayminutes = "";
    int profileid = 0;
    int comingfromprofile = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11);

        weekdays = getIntent().getStringExtra("weekdays");
        name = getIntent().getStringExtra("name");
        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);

    }

    public void goToAct10 (View view){
        Intent intent = new Intent (this, Activity10.class);
        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

    public void goToAct12 (View view){
        Intent intent = new Intent (this, Activity12.class);

        final Spinner dayminutesspinner = (Spinner) findViewById(R.id.spinner108);
        dayminutes = dayminutesspinner.getSelectedItem().toString();
        intent.putExtra("dayminutes", dayminutes);

        intent.putExtra("weekdays", weekdays);
        intent.putExtra("name", name);
        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", comingfromprofile);
        startActivity(intent);

    }

}
