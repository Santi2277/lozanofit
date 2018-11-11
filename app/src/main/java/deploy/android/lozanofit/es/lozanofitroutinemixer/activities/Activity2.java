package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Activity2AlertDialog;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Exercise;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;
import static java.lang.Math.toIntExact;

public class Activity2 extends AppCompatActivity {

    public int counter = 0;
    public String timestring = "";
    public String levelstring = "";
    public String bodystring = "";
    public String objectivestring = "";
    public boolean listcreated = false;
    public ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //get boolean listcreated
        listcreated = getIntent().getBooleanExtra("listCreated", false);

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 21);
        SQLiteDatabase db = exdb.getWritableDatabase();


        //get selected level and objective
        objectivestring = getIntent().getStringExtra("selectedObjective");
        levelstring = getIntent().getStringExtra("selectedLevel");
        // Set objective and level kgs and reps
        TextView repstext = findViewById(R.id.textView8);
        TextView kgstext = findViewById(R.id.textView7);
        switch(objectivestring) {
            case "Salud/Hipertrofia":
                //set reps
                repstext.setText("10-12 reps");
                //set kgs
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText("4-8 kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText("10-12 kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText("14 kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText("16-18 kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText("20-24 kgs");
                        break;
                }
                break;
            case "Volumen":
                repstext.setText("6-8 reps");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText("6-10 kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText("12-14 kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText("16 kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText("18-20 kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText("22-26 kgs");
                        break;
                }
                break;
            case "Resistencia/Definición":
                repstext.setText("16-20 reps");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText("1-5 kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText("6-8 kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText("10 kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText("12-14 kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText("16-20 kgs");
                        break;
                }
                break;
        }



        //if exercise list (arraylist) hasnt been created, create it
        if(!listcreated) {
            //get selected time and show it (toast)
            timestring = getIntent().getStringExtra("selectedTime");
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    timestring, Toast.LENGTH_LONG);
            toast1.show();

            //get selected body part
            bodystring = getIntent().getStringExtra("selectedBodyPart");


            //chrono
            final TextView simpleChrono = findViewById(R.id.simpleChronometer);
            int milis = 0;
            switch(timestring) {
                case "15 min":
                    milis = 900000;
                    break;
                case "30 min":
                    milis = 900000 * 2;
                    break;
                case "45 min":
                    milis = 900000 * 3;
                    break;
                case "1 h":
                    milis = 900000 * 4;
                    break;
                case "1 h 30 min":
                    milis = 900000 * 6;
                    break;
            }
            new CountDownTimer(milis, 1000) {

                public void onTick(long millisUntilFinished) {
                    int numb = toIntExact(millisUntilFinished / 1000);
                    //Integer.toString(numb)
                    int minutes = numb / 60;
                    int seconds = numb % 60;
                    DecimalFormat twodigits = new DecimalFormat("00");
                    simpleChrono.setText(Integer.toString(minutes)+":"+twodigits.format(seconds));
                }

                public void onFinish() {
                    simpleChrono.setText("Champ!");
                }
            }.start();



            // CHOOSE routine exercises number of each category (it doesnt repeat, it will be 4 if you say 5 exercises of biceps and db has only 4)
            switch(timestring) {
                case "15 min":
                    createRoutineFull(0,1,0,0,0,0,0,0,0,1,0,0);
                    createRoutineHalf("biceps","chest");
                    createRoutineHalf("mid-back","upper-back");
                    createRoutineHalf("deltoid","triceps");
                    createRoutineHalf("forearm","calf");
                    createRoutineHalf("glute","thigh");
                    createRoutineHalf("abs","lumbar");
                    createRoutineFifth("biceps", "chest", "upper-back", "mid-back", "deltoid");
                    Collections.sort(exercisesList);
                    break;
                case "30 min":
                    createRoutineFull(1,1,1,1,1,0,1,1,1,1,1,1);
                    createRoutineHalf("biceps","chest");
                    createRoutineHalf("upper-back","mid-back");
                    createRoutineHalf("deltoid","forearm");
                    createRoutineThird("triceps","calf", "lumbar");
                    createRoutineHalf("thigh","glute");
                    Collections.sort(exercisesList);
                    break;
                case "45 min":
                    createRoutineFull(2,4,2,2,2,0,2,2,2,2,2,2);
                    createRoutineHalf("thigh","calf");
                    Collections.sort(exercisesList);
                    break;
                case "1 h":
                    createRoutineFull(2,4,2,2,2,0,2,2,2,2,2,2);
                    createRoutineHalf("biceps","chest");
                    createRoutineHalf("upper-back","mid-back");
                    createRoutineHalf("deltoid","forearm");
                    createRoutineThird("triceps","calf", "lumbar");
                    createRoutineHalf("thigh","glute");
                    createRoutineHalf("biceps","chest");
                    createRoutineHalf("upper-back","mid-back");
                    createRoutineHalf("deltoid","forearm");
                    createRoutineThird("triceps","calf", "lumbar");
                    createRoutineHalf("thigh","glute");
                    Collections.sort(exercisesList);
                    break;
                case "1 h 30 min":
                    createRoutineFull(5,8,5,5,5,1,3,5,4,3,4,5);
                    Collections.sort(exercisesList);
                    break;
            }




        } else {

            //get selected body part and level
            levelstring = getIntent().getStringExtra("selectedLevel");


            String chronoCont = getIntent().getStringExtra("chronoText");
            final TextView simpleChrono = findViewById(R.id.simpleChronometer);
            //simpleChrono.setText(chronoCont);

            String[] parts = chronoCont.split(":");
            String minutes = parts[0];
            String seconds = parts[1];

            int milis = (Integer.parseInt(minutes) * 60 + Integer.parseInt(seconds))*1000;

            new CountDownTimer(milis, 1000) {

                public void onTick(long millisUntilFinished) {
                    int numb = toIntExact(millisUntilFinished / 1000);
                    //Integer.toString(numb)
                    int minutes = numb / 60;
                    int seconds = numb % 60;
                    DecimalFormat twodigits = new DecimalFormat("00");
                    simpleChrono.setText(Integer.toString(minutes)+":"+twodigits.format(seconds));
                }

                public void onFinish() {
                    simpleChrono.setText("Champ!");
                }
            }.start();





            // parcelable
            exercisesList = getIntent().getParcelableArrayListExtra("key");
        }

        // get exercise number in the arraylist (it begins with 0)
        counter = getIntent().getIntExtra("exerciseCounter", 0);

        TextView text = findViewById(R.id.textView4);
        TextView uppertext = findViewById(R.id.textView3);
        ImageView image = findViewById(R.id.imageView);


        text.setText(exercisesList.get(counter).getName());
        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(1078, 958)
                .into(image);

        //539 and 479

        //set CheckBox
        CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
        if (exercisesList.get(counter).getDone()==1){
            //mark it
            checkb.setChecked(true);

        }else{
            checkb.setChecked(false);
        }
    }


    public void goToMainActivity (View view){

        FragmentManager fragmentManager = getSupportFragmentManager();
        Activity2AlertDialog dialogo = new Activity2AlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");



        //Intent intent = new Intent (this, MainActivity.class);
        //startActivity(intent);
    }


    public void goToActivity3 (View view){
        Intent intent = new Intent (this, Activity3.class);
        intent.putExtra("exerciseCounter", counter);
        //parcelable
        intent.putParcelableArrayListExtra("key", exercisesList);

        TextView simpleChrono = findViewById(R.id.simpleChronometer);
        String chronotext = (String) simpleChrono.getText();
        intent.putExtra("chronoText", chronotext);

        intent.putExtra("selectedLevel", levelstring);
        intent.putExtra("selectedObjective", objectivestring);

        startActivity(intent);
    }







    public void nextExercise (View view){

        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        if ((counter+1) < exercisesList.size()) {
            counter++;

            text.setText(exercisesList.get(counter).getName());
            TextView uppertext = findViewById(R.id.textView3);
            uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
            TextView remaining = findViewById(R.id.textView6);
            remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
            Picasso
                    .with(this)
                    .load(exercisesList.get(counter).getPhoto_path())
                    .resize(539, 479)
                    .into(image);
            //set CheckBox
            CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
            if (exercisesList.get(counter).getDone()==1){
                //mark it
                checkb.setChecked(true);

            }else{
                checkb.setChecked(false);
            }
        }
    }

    public void previousExercise (View view){


        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        if (counter!=0) {
            counter--;

            text.setText(exercisesList.get(counter).getName());
            TextView uppertext = findViewById(R.id.textView3);
            uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
            TextView remaining = findViewById(R.id.textView6);
            remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
            Picasso
                    .with(this)
                    .load(exercisesList.get(counter).getPhoto_path())
                    .resize(539, 479)
                    .into(image);
            //set CheckBox
            CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
            if (exercisesList.get(counter).getDone()==1){
                //mark it
                checkb.setChecked(true);

            }else{
                checkb.setChecked(false);
            }
        }

    }

    public void lastExercise (View view){

        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);

        //change counter
        counter = exercisesList.size()-1;

        text.setText(exercisesList.get(counter).getName());
        TextView uppertext = findViewById(R.id.textView3);
        uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);
        //set CheckBox
        CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
        if (exercisesList.get(counter).getDone()==1){
            //mark it
            checkb.setChecked(true);
        }else{
            checkb.setChecked(false);
        }

    }

    public void firstExercise (View view){

        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);

        //change counter
        counter = 0;

        text.setText(exercisesList.get(counter).getName());
        TextView uppertext = findViewById(R.id.textView3);
        uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);
        //set CheckBox
        CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
        if (exercisesList.get(counter).getDone()==1){
            //mark it
            checkb.setChecked(true);
        }else{
            checkb.setChecked(false);
        }

    }


    public void middleExercise (View view){

        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);

        //change counter
        counter = (exercisesList.size()-1)/2;


        text.setText(exercisesList.get(counter).getName());
        TextView uppertext = findViewById(R.id.textView3);
        uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);
        //set CheckBox
        CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
        if (exercisesList.get(counter).getDone()==1){
            //mark it
            checkb.setChecked(true);
        }else{
            checkb.setChecked(false);
        }

    }


    public void createRoutineFull (int biceps, int abs, int forearm, int chest, int deltoid, int calf, int glute, int midBack, int lumbar, int thigh, int triceps, int upperBack) {

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 21);
        SQLiteDatabase db = exdb.getWritableDatabase();


        String muscle1 = "biceps";
        String muscle1count = Integer.toString(biceps);
        String muscle2 = "abs";
        String muscle2count = Integer.toString(abs);
        String muscle3 = "forearm";
        String muscle3count = Integer.toString(forearm);
        String muscle4 = "chest";
        String muscle4count = Integer.toString(chest);
        String muscle5 = "deltoid";
        String muscle5count = Integer.toString(deltoid);
        String muscle6 = "calf";
        String muscle6count = Integer.toString(calf);
        String muscle7 = "glute";
        String muscle7count = Integer.toString(glute);
        String muscle8 = "mid-back";
        String muscle8count = Integer.toString(midBack);
        String muscle9 = "lumbar";
        String muscle9count = Integer.toString(lumbar);
        String muscle10 = "thigh";
        String muscle10count = Integer.toString(thigh);
        String muscle11 = "triceps";
        String muscle11count = Integer.toString(triceps);
        String muscle12 = "upper-back";
        String muscle12count = Integer.toString(upperBack);

        //BICEPS
        //SQL binding (attacks from here?¿?¿)
        String query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle1+"' ORDER BY RANDOM() LIMIT "+muscle1count;
        Cursor c = db.rawQuery(query, null);
        //add exercises to array list
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }

        //ABS
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle2+"' ORDER BY RANDOM() LIMIT "+muscle2count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //FOREARM
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle3+"' ORDER BY RANDOM() LIMIT "+muscle3count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //CHEST
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle4+"' ORDER BY RANDOM() LIMIT "+muscle4count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //DELTOID
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle5+"' ORDER BY RANDOM() LIMIT "+muscle5count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //CALF
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle6+"' ORDER BY RANDOM() LIMIT "+muscle6count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //GLUTE
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle7+"' ORDER BY RANDOM() LIMIT "+muscle7count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //MID-BACK
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle8+"' ORDER BY RANDOM() LIMIT "+muscle8count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //LUMBAR
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle9+"' ORDER BY RANDOM() LIMIT "+muscle9count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //THIGH
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle10+"' ORDER BY RANDOM() LIMIT "+muscle10count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //TRICEPS
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle11+"' ORDER BY RANDOM() LIMIT "+muscle11count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

        //UPPER-BACK
        query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle12+"' ORDER BY RANDOM() LIMIT "+muscle12count;
        c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);
            } while(c.moveToNext());
        }

    }

    public void createRoutineHalf (String muscle1, String muscle2){


        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 21);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //Half
        //SQL binding (attacks from here?¿?¿)
        String query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle1+"' OR muscle_zone LIKE '"+muscle2+"' ORDER BY RANDOM() LIMIT 1";
        Cursor c = db.rawQuery(query, null);
        //add exercises to array list
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }

    }

    public void createRoutineThird (String muscle1, String muscle2, String muscle3){


        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 21);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //Third
        //SQL binding (attacks from here?¿?¿)
        String query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle1+"' OR muscle_zone LIKE '"+muscle2+"' OR muscle_zone LIKE '"+muscle3+"' ORDER BY RANDOM() LIMIT 1";
        Cursor c = db.rawQuery(query, null);
        //add exercises to array list
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }

    }

    public void createRoutineFourth (String muscle1, String muscle2, String muscle3, String muscle4){


        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 21);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //Third
        //SQL binding (attacks from here?¿?¿)
        String query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle1+"' OR muscle_zone LIKE '"+muscle2+"' OR muscle_zone LIKE '"+muscle3+"' OR muscle_zone LIKE '"+muscle4+"' ORDER BY RANDOM() LIMIT 1";
        Cursor c = db.rawQuery(query, null);
        //add exercises to array list
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }

    }


    public void createRoutineFifth (String muscle1, String muscle2, String muscle3, String muscle4, String muscle5){


        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 21);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //Third
        //SQL binding (attacks from here?¿?¿)
        String query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle1+"' OR muscle_zone LIKE '"+muscle2+"' OR muscle_zone LIKE '"+muscle3+"' OR muscle_zone LIKE '"+muscle4+"' OR muscle_zone LIKE '"+muscle5+"' ORDER BY RANDOM() LIMIT 1";
        Cursor c = db.rawQuery(query, null);
        //add exercises to array list
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }

    }


    public void changeExercise (View view){



        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 21);
        SQLiteDatabase db = exdb.getWritableDatabase();

        int index = counter;
        String exerciseName = exercisesList.get(index).getName();
        String exerciseCategory = exercisesList.get(index).getMuscle_zone();


        //find a new exercise (different from that and not existing in the list)
        String query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+exerciseCategory+"' AND name NOT IN ('"+exerciseName+"') ORDER BY RANDOM() LIMIT 1";
        Cursor c = db.rawQuery(query, null);
        //change exercise
        if (c.moveToFirst()) {
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                exercisesList.set(index, currentExercise);

            } while(c.moveToNext());
        }

        //change the view
        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);


        text.setText(exercisesList.get(counter).getName());
        TextView uppertext = findViewById(R.id.textView3);
        uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);

    }

    public void markDone(View view) {
        CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
        if (checkb.isChecked()){
            //puede ser que sea al reves
            exercisesList.get(counter).setDone(1);
        }else{
            exercisesList.get(counter).setDone(0);
        }
    }


}
