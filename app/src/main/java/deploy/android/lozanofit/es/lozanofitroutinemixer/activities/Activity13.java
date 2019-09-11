package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity13 extends AppCompatActivity {

    String name = "";
    String weekdays = "";
    String dayminutes = "";
    String strengthlevel = "";
    String objective = "";

    int profileid = 0;
    int comingfromprofile = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13);

        name = getIntent().getStringExtra("name");
        weekdays = getIntent().getStringExtra("weekdays");
        dayminutes = getIntent().getStringExtra("dayminutes");
        strengthlevel = getIntent().getStringExtra("strengthlevel");

        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);


        //change text when spinner changes

        final Spinner strengthlevelspinner = (Spinner) findViewById(R.id.spinner101);
        //strengthlevel = strengthlevelspinner.getSelectedItem().toString();

        strengthlevelspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                TextView text = findViewById(R.id.textView1313);

                switch (position){
                    case 0:
                        text.setText("Número intermedio de repeticiones y peso, mantenimiento.");
                        break;
                    case 1:
                        text.setText("Pocas repeticiones y mucho peso, gran ganacia de volumen.");
                        break;
                    case 2:
                        text.setText("Muchas repeticiones y menos peso, fuerza resitencia.");
                        break;
                }





            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

            }


        });





    }

    public void goToAct12 (View view){
        Intent intent = new Intent (this, Activity12.class);
        intent.putExtra("name", name);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("objective", objective);

        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

    public void goToAct14 (View view){
        Intent intent = new Intent (this, Activity14.class);

        final Spinner objectivespinner = (Spinner) findViewById(R.id.spinner101);
        objective = objectivespinner.getSelectedItem().toString();
        intent.putExtra("objective", objective);

        intent.putExtra("name", name);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);

        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", comingfromprofile);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        //go to act 12
        Intent intent = new Intent (this, Activity12.class);
        intent.putExtra("name", name);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("objective", objective);

        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


    public void goToAct819 (View view){
        //go to profile selector or one concrete profile screen
        if(comingfromprofile == 0){
            Intent intent = new Intent (this, Activity8.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, Activity19.class);
            intent.putExtra("profileid", profileid);
            startActivity(intent);
        }

    }


}
