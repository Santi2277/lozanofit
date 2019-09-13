package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity19AlertDialog;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity9AlertDialog;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity19 extends AppCompatActivity {

    int profileid = 0;

    String name = "";
    int weekdays;
    int currentday;
    String dayminutes;
    String strengthlevel;
    String objective;
    String method;
    int def;
    String more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_19);

        profileid = getIntent().getIntExtra("profileid", 0);


        //connect db
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 47);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //get profile data
        String query = "SELECT id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more FROM profile WHERE id = "+profileid;
        Cursor c = db.rawQuery(query, null);

        //check there's at least one entry
        if (c.moveToFirst()) {
            //go over cursor until there are no more entries
            do {

                name= c.getString(1);
                weekdays = c.getInt(2);
                currentday = c.getInt(3);
                dayminutes = c.getString(4);
                strengthlevel = c.getString(5);
                objective = c.getString(6);
                method = c.getString(7);
                def = c.getInt(8);
                more = c.getString(9);

            } while(c.moveToNext());
        }




        TextView text = findViewById(R.id.textView1995);
        text.setText("Nombre: "+name+"\nDías a la semana: "+weekdays+".\nDía actual nº: "+currentday+".\nMinutos: "+dayminutes+".\nNivel de fuerza: "+strengthlevel+".\nObjetivo: "+objective+".\nMétodo: "+method+".");

    }




    public void goToAct15 (View view){

        Intent intent = new Intent (this, Activity15.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);
    }

    public void goToAct18 (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Activity19AlertDialog dialogo = new Activity19AlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");

    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent (this, Activity15.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

    public void goToAct9 (View view){
        Intent intent = new Intent (this, Activity9.class);
        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", 1);
        startActivity(intent);

    }


}
