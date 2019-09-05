package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity12 extends AppCompatActivity {

    String name = "";
    String weekdays = "";
    String dayminutes = "";
    String strengthlevel = "";
    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12);


        dayminutes = getIntent().getStringExtra("dayminutes");
        weekdays = getIntent().getStringExtra("weekdays");
        name = getIntent().getStringExtra("name");
        profileid = getIntent().getIntExtra("profileid", 0);

    }

    public void goToAct11 (View view){
        Intent intent = new Intent (this, Activity11.class);
        startActivity(intent);

    }

    public void goToAct13 (View view){
        Intent intent = new Intent (this, Activity13.class);

        final Spinner strengthlevelspinner = (Spinner) findViewById(R.id.spinner117);
        strengthlevel = strengthlevelspinner.getSelectedItem().toString();
        intent.putExtra("strengthlevel", strengthlevel);

        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("name", name);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }
}
