package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity9 extends AppCompatActivity {

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
        setContentView(R.layout.activity_9);

        weekdays = getIntent().getStringExtra("weekdays");
        dayminutes = getIntent().getStringExtra("dayminutes");
        strengthlevel = getIntent().getStringExtra("strengthlevel");
        objective = getIntent().getStringExtra("objective");
        name = getIntent().getStringExtra("name");
        method = getIntent().getStringExtra("method");

        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);

        if(comingfromprofile == 1){
            TextView textviewtitle = findViewById(R.id.textView30);
            textviewtitle.setText("Nombre:");
            TextView textviewtitle2 = findViewById(R.id.textView9info);
            textviewtitle2.setText("Para guardar los cambios sigue hasta el final.");



            //get that profile saved data, you will have to reset spinners with that
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
                    weekdays = Integer.toString(c.getInt(2));
                    //currentday = c.getInt(3);
                    dayminutes = c.getString(4);
                    strengthlevel = c.getString(5);
                    objective = c.getString(6);
                    method = c.getString(7);

                } while(c.moveToNext());
            }




        }


        TextInputEditText nameforInput = findViewById(R.id.textInput001);
        nameforInput.setText(name);


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
        intent.putExtra("method", method);

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
        FragmentManager fragmentManager = getSupportFragmentManager();
        Activity9AlertDialog dialogo = new Activity9AlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");

    }


    public void goToAct819 (View view){
        //go to profile selector or one concrete profile screen
        FragmentManager fragmentManager = getSupportFragmentManager();
        Activity9AlertDialog dialogo = new Activity9AlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");

    }

}
