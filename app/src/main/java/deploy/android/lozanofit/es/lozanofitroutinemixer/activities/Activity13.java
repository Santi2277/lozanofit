package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity13 extends AppCompatActivity {

    String name = "";
    String weekdays = "";
    String dayminutes = "";
    String strengthlevel = "";
    String objective = "";
    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13);

        strengthlevel = getIntent().getStringExtra("strengthlevel");
        dayminutes = getIntent().getStringExtra("dayminutes");
        weekdays = getIntent().getStringExtra("weekdays");
        name = getIntent().getStringExtra("name");
        profileid = getIntent().getIntExtra("profileid", 0);

    }

    public void goToAct12 (View view){
        Intent intent = new Intent (this, Activity12.class);
        startActivity(intent);

    }

    public void goToAct14 (View view){
        Intent intent = new Intent (this, Activity14.class);

        final Spinner objectivespinner = (Spinner) findViewById(R.id.spinner101);
        objective = objectivespinner.getSelectedItem().toString();
        intent.putExtra("objective", objective);

        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("name", name);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

}
