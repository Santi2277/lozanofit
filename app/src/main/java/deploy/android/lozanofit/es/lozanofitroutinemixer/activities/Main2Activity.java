package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Main2Activity extends AppCompatActivity {

    public String timestring = "";
    public String levelstring = "";
    public String bodystring = "";
    public String objectivestring = "";
    public String defaultValue = "";
    //list created is sended with false value
    public ArrayList<String> musclesSelected = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 43);
        SQLiteDatabase db = exdb.getWritableDatabase();
        //if db is opened correctly
        if(db != null)
        {
            //CLOSE db
            db.close();
        }

        //check if we came from activity5, if so put values in spinner

        if(getIntent()!=null && getIntent().getExtras()!=null){

            objectivestring = getIntent().getStringExtra("selectedObjective");
            levelstring = getIntent().getStringExtra("selectedLevel");
            timestring = getIntent().getStringExtra("selectedTime");
            bodystring = getIntent().getStringExtra("selectedBodyPart");

            //check if null values (if so put blank string)
            if(timestring == null){timestring = "";}
            if(objectivestring == null){objectivestring = "";}
            if(levelstring == null){levelstring = "";}
            if(bodystring == null){bodystring = "";}

            final Spinner timespinner = (Spinner) findViewById(R.id.spinner);
            switch (timestring){
                case "15 min":
                    timespinner.setSelection(0);
                    break;
                case "30 min":
                    timespinner.setSelection(1);
                    break;
                case "45 min":
                    timespinner.setSelection(2);
                    break;
                case "1 h":
                    timespinner.setSelection(3);
                    break;
                case "1h 30 min":
                    timespinner.setSelection(4);
                    break;
                default:
                    timespinner.setSelection(0);
                    break;
            }

            final Spinner levelspinner = (Spinner) findViewById(R.id.spinner2);
            switch (levelstring){
                case "1.- Básico":
                    levelspinner.setSelection(0);
                    break;
                case "2.- En forma":
                    levelspinner.setSelection(1);
                    break;
                case "3.- Atlético":
                    levelspinner.setSelection(2);
                    break;
                case "4.- Fuerte":
                    levelspinner.setSelection(3);
                    break;
                case "5.- Muy fuerte":
                    levelspinner.setSelection(4);
                    break;
                default:
                    levelspinner.setSelection(0);
                    break;
            }

            final Spinner bodyspinner = (Spinner) findViewById(R.id.spinner3);
            switch (bodystring){
                case "Todo":
                    bodyspinner.setSelection(0);
                    break;
                case "Superior":
                    bodyspinner.setSelection(1);
                    break;
                case "Inferior":
                    bodyspinner.setSelection(2);
                    break;
                case "Músculo":
                    bodyspinner.setSelection(3);
                    break;
                default:
                    bodyspinner.setSelection(0);
                    break;
            }

            final Spinner objectivespinner = (Spinner) findViewById(R.id.spinner5);
            switch (objectivestring){
                case "Salud":
                    objectivespinner.setSelection(0);
                    break;
                case "Volumen":
                    objectivespinner.setSelection(1);
                    break;
                case "Definición":
                    objectivespinner.setSelection(2);
                    break;
                default:
                    objectivespinner.setSelection(0);
                    break;
            }

        }


    }


    public void goToActivity2 (View view){

        int count = 0;
        final Spinner timespinner = (Spinner) findViewById(R.id.spinner);
        String selectedtimestring = timespinner.getSelectedItem().toString();
        final Spinner levelspinner = (Spinner) findViewById(R.id.spinner2);
        String selectedlevelstring = levelspinner.getSelectedItem().toString();
        final Spinner bodyspinner = (Spinner) findViewById(R.id.spinner3);
        String selectedbodypartstring = bodyspinner.getSelectedItem().toString();
        final Spinner objectivespinner = (Spinner) findViewById(R.id.spinner5);
        String selectedobjectivestring = objectivespinner.getSelectedItem().toString();

        switch(selectedbodypartstring){
            case "Todo":
                musclesSelected.add("biceps");
                musclesSelected.add("abs");
                musclesSelected.add("forearm");
                musclesSelected.add("chest");
                musclesSelected.add("deltoid");
                musclesSelected.add("calf");
                musclesSelected.add("glute");
                musclesSelected.add("mid-back");
                musclesSelected.add("lumbar");
                musclesSelected.add("thigh");
                musclesSelected.add("triceps");
                musclesSelected.add("upper-back");
                break;
            case "Superior":
                musclesSelected.add("biceps");
                musclesSelected.add("forearm");
                musclesSelected.add("chest");
                musclesSelected.add("deltoid");
                musclesSelected.add("mid-back");
                musclesSelected.add("triceps");
                musclesSelected.add("upper-back");
                break;
            case "Inferior":
                musclesSelected.add("abs");
                musclesSelected.add("calf");
                musclesSelected.add("glute");
                musclesSelected.add("lumbar");
                musclesSelected.add("thigh");
                break;
        }

        //go to activity 5 if musculo is selected
        if(selectedbodypartstring.equals("Músculo")){
            Intent intent = new Intent (this, Activity5.class);
            intent.putExtra("exerciseCounter", count);
            intent.putExtra("selectedTime", selectedtimestring);
            intent.putExtra("selectedLevel", selectedlevelstring);
            intent.putExtra("selectedBodyPart", selectedbodypartstring);
            intent.putExtra("selectedObjective", selectedobjectivestring);
            intent.putExtra("listCreated", false);
            intent.putExtra("musclesSelected", musclesSelected);
            startActivity(intent);
        }else{
            //else, go to activity 2
            Intent intent = new Intent (this, Activity2.class);
            intent.putExtra("exerciseCounter", count);
            intent.putExtra("selectedTime", selectedtimestring);
            intent.putExtra("selectedLevel", selectedlevelstring);
            intent.putExtra("selectedBodyPart", selectedbodypartstring);
            intent.putExtra("selectedObjective", selectedobjectivestring);
            intent.putExtra("listCreated", false);
            intent.putExtra("musclesSelected", musclesSelected);
            startActivity(intent);
        }

    }

    public void goToAct4 (View view){

        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        //does nothing in this activity
    }

}
