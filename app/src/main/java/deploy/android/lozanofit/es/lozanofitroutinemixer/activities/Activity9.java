package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Act2EndingAlertDialog;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity9AlertDialog;

public class Activity9 extends AppCompatActivity {

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
        setContentView(R.layout.activity_9);

        weekdays = getIntent().getStringExtra("weekdays");
        dayminutes = getIntent().getStringExtra("dayminutes");
        strengthlevel = getIntent().getStringExtra("strengthlevel");
        objective = getIntent().getStringExtra("objective");

        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);

        if(comingfromprofile == 1){
            TextView textviewtitle = findViewById(R.id.textView30);
            textviewtitle.setText("Nombre:");
        }



    }

    public void goToAct8 (View view){
        if(comingfromprofile == 0){
            Intent intent = new Intent (this, Activity8.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, Activity15.class);
            intent.putExtra("profileid", profileid);
            startActivity(intent);
        }


    }

    public void goToAct10 (View view){
        Intent intent = new Intent (this, Activity10.class);


        TextInputEditText nameInput = findViewById(R.id.textInput001);
        name = nameInput.getText().toString();
        intent.putExtra("name", name);

        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("objective", objective);

        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", comingfromprofile);

        if(name.equals("")){
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Introduce un nombre", Toast.LENGTH_LONG);
            toast1.show();
        }else{
            startActivity(intent);
        }


    }

    @Override
    public void onBackPressed() {
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


    public void goToAct819 (View view){
        //go to profile selector or one concrete profile screen
        FragmentManager fragmentManager = getSupportFragmentManager();
        Activity9AlertDialog dialogo = new Activity9AlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");

    }

}
