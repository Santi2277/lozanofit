package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class MainActivity extends AppCompatActivity {

    public String timestring = "";
    public String levelstring = "";
    public String bodystring = "";
    public String objectivestring = "";
    public String defaultValue = "";
    public ArrayList<String> musclesSelected = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 41);
        SQLiteDatabase db = exdb.getWritableDatabase();
        //if db is opened correctly
        if(db != null)
        {
            //CLOSE db
            db.close();
        }




    }

    public void goToAct8 (View view){
        Intent intent = new Intent (this, Activity8.class);
        startActivity(intent);

    }

    public void goToMain2 (View view){

        Intent intent = new Intent (this, Main2Activity.class);
        startActivity(intent);

    }



    public void goToAct4 (View view){

        Intent intent = new Intent (this, Activity4.class);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        //does nothing in this activity
    }

}
