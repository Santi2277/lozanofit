package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity10 extends AppCompatActivity {

    String name = "";
    String weekdays = "";
    int profileid = 0;
    int comingfromprofile = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);

        name = getIntent().getStringExtra("name");
        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);

    }

    public void goToAct9 (View view){
        Intent intent = new Intent (this, Activity9.class);
        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

    public void goToAct11 (View view){
        Intent intent = new Intent (this, Activity11.class);

        final Spinner weekdaysspinner = (Spinner) findViewById(R.id.spinner107);
        weekdays = weekdaysspinner.getSelectedItem().toString();
        intent.putExtra("weekdays", weekdays);

        intent.putExtra("name", name);
        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", comingfromprofile);
        startActivity(intent);

    }


}