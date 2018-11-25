package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Spinner;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 25);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //if db is opened correctly
        if(db != null)
        {
            //CLOSE db
            db.close();
        }


    }


    public void goToActivity2 (View view){
        Intent intent = new Intent (this, Activity2.class);
        int count = 0;
        intent.putExtra("exerciseCounter", count);

        final Spinner timespinner = (Spinner) findViewById(R.id.spinner);
        String selectedtimestring = timespinner.getSelectedItem().toString();
        intent.putExtra("selectedTime", selectedtimestring);

        final Spinner levelspinner = (Spinner) findViewById(R.id.spinner2);
        String selectedlevelstring = levelspinner.getSelectedItem().toString();
        intent.putExtra("selectedLevel", selectedlevelstring);

        final Spinner bodyspinner = (Spinner) findViewById(R.id.spinner3);
        String selectedbodypartstring = bodyspinner.getSelectedItem().toString();
        intent.putExtra("selectedBodyPart", selectedbodypartstring);

        final Spinner objectivespinner = (Spinner) findViewById(R.id.spinner5);
        String selectedobjectivestring = objectivespinner.getSelectedItem().toString();
        intent.putExtra("selectedObjective", selectedobjectivestring);

        intent.putExtra("listCreated", false);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {
        //does nothing in this activity
    }

}
