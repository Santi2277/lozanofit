package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

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

        name = getIntent().getStringExtra("name");
        weekdays = getIntent().getStringExtra("weekdays");
        dayminutes = getIntent().getStringExtra("dayminutes");
        strengthlevel = getIntent().getStringExtra("strengthlevel");
        objective = getIntent().getStringExtra("objective");

        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);

    }

    public void goToAct13 (View view){
        Intent intent = new Intent (this, Activity13.class);

        intent.putExtra("name", name);
        intent.putExtra("weekdays", weekdays);
        intent.putExtra("dayminutes", dayminutes);
        intent.putExtra("strengthlevel", strengthlevel);
        intent.putExtra("objective", objective);

        intent.putExtra("comingfromprofile", comingfromprofile);
        intent.putExtra("profileid", profileid);

        startActivity(intent);

    }
    public void goToAct1519 (View view){


        final Spinner methodspinner = (Spinner) findViewById(R.id.spinner70);
        method = methodspinner.getSelectedItem().toString();

        //refresh database with new profile data
        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 44);
        SQLiteDatabase db = exdb.getWritableDatabase();

        int weekdaysint =Integer.parseInt(weekdays);
        db.execSQL("UPDATE Profile SET name ='"+name+"', weekdays = "+weekdaysint+", currentday = 1, dayminutes = '"+dayminutes+"', strengthlevel ='"+strengthlevel+"', objective = '"+objective+"', method = '"+method+"', def = 0 WHERE id ="+profileid);


        if(comingfromprofile == 0){
            Toast toast1 = Toast.makeText(this,
                    "Perfil creado.", Toast.LENGTH_LONG);
            toast1.show();

            Intent intent = new Intent (this, Activity15.class);
            intent.putExtra("profileid", profileid);
            startActivity(intent);

        }else{
            Toast toast1 = Toast.makeText(this,
                    "Datos cambiados.", Toast.LENGTH_LONG);
            toast1.show();

            Intent intent = new Intent (this, Activity19.class);
            intent.putExtra("profileid", profileid);
            startActivity(intent);
        }




    }


    @Override
    public void onBackPressed() {
        //go to act 13
        Intent intent = new Intent (this, Activity13.class);

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
