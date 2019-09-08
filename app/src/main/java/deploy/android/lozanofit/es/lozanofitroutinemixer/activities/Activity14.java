package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity14 extends AppCompatActivity {

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
        setContentView(R.layout.activity_14);

        objective = getIntent().getStringExtra("objective");
        strengthlevel = getIntent().getStringExtra("strengthlevel");
        dayminutes = getIntent().getStringExtra("dayminutes");
        weekdays = getIntent().getStringExtra("weekdays");
        name = getIntent().getStringExtra("name");
        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);

    }

    public void goToAct13 (View view){
        Intent intent = new Intent (this, Activity13.class);
        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }
    public void goToAct15 (View view){
        Intent intent = new Intent (this, Activity15.class);

        final Spinner methodspinner = (Spinner) findViewById(R.id.spinner70);
        method = methodspinner.getSelectedItem().toString();

        //refresh database with new profile data
        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 41);
        SQLiteDatabase db = exdb.getWritableDatabase();

        int weekdaysint =Integer.parseInt(weekdays);
        db.execSQL("UPDATE Profile SET name ='"+name+"', weekdays = "+weekdaysint+", currentday = 1, dayminutes = '"+dayminutes+"', strengthlevel ='"+strengthlevel+"', objective = '"+objective+"', method = '"+method+"', def = 0 WHERE id ="+profileid);


        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

}
