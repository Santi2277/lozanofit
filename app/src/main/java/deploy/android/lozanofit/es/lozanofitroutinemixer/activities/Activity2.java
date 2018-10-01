package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Exercise;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;
import static java.lang.Math.toIntExact;

public class Activity2 extends AppCompatActivity {

    public int counter = 0;
    public String timestring = "";
    public boolean listcreated = false;
    public ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //get boolean listcreated
        listcreated = getIntent().getBooleanExtra("listCreated", false);

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 6);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //if exercise list (arraylist) hasnt been created, create it
        if(!listcreated) {
            //get selected time and show it (toast)
            timestring = getIntent().getStringExtra("selectedTime");
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    timestring, Toast.LENGTH_LONG);
            toast1.show();

            //chrono
            final TextView simpleChrono = findViewById(R.id.simpleChronometer);
            int milis = 0;
            switch(timestring) {
                case "15 minutes":
                    milis = 900000;
                    break;
                case "30 minutes":
                    milis = 900000 * 2;
                    break;
                case "45 minutes":
                    milis = 900000 * 3;
                    break;
                case "1 hour":
                    milis = 900000 * 4;
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




            String muscle1 = "biceps";
            String muscle1count = "";
            String muscle2 = "abs";
            String muscle2count = "";
            String muscle3 = "forearm";
            String muscle3count = "";
            String muscle4 = "chest";
            String muscle4count = "";
            String muscle5 = "deltoid";
            String muscle5count = "";
            String muscle6 = "calf";
            String muscle6count = "";
            String muscle7 = "glute";
            String muscle7count = "";
            String muscle8 = "mid-back";
            String muscle8count = "";
            String muscle9 = "lumbar";
            String muscle9count = "";
            String muscle10 = "thigh";
            String muscle10count = "";
            String muscle11 = "triceps";
            String muscle11count = "";
            String muscle12 = "upper-back";
            String muscle12count = "";
            // CHOOSE routine exercises number of each category (it doesnt repeat, it will be 4 if you say 5 exercises of biceps and db has only 4)
            switch(timestring) {
                case "15 minutes":
                    muscle1count = "1";
                    muscle2count = "1";
                    muscle3count = "1";
                    muscle4count = "1";
                    muscle5count = "1";
                    muscle6count = "1";
                    muscle7count = "1";
                    muscle8count = "1";
                    muscle9count = "1";
                    muscle10count = "1";
                    muscle11count = "1";
                    muscle12count = "1";
                    break;
                case "30 minutes":
                    muscle1count = "2";
                    muscle2count = "2";
                    muscle3count = "1";
                    muscle4count = "2";
                    muscle5count = "2";
                    muscle6count = "1";
                    muscle7count = "2";
                    muscle8count = "2";
                    muscle9count = "2";
                    muscle10count = "2";
                    muscle11count = "2";
                    muscle12count = "2";
                    break;
                case "45 minutes":
                    muscle1count = "3";
                    muscle2count = "3";
                    muscle3count = "2";
                    muscle4count = "3";
                    muscle5count = "3";
                    muscle6count = "2";
                    muscle7count = "3";
                    muscle8count = "3";
                    muscle9count = "3";
                    muscle10count = "3";
                    muscle11count = "3";
                    muscle12count = "3";
                    break;
                case "1 hour":
                    muscle1count = "4";
                    muscle2count = "4";
                    muscle3count = "2";
                    muscle4count = "4";
                    muscle5count = "4";
                    muscle6count = "2";
                    muscle7count = "4";
                    muscle8count = "4";
                    muscle9count = "4";
                    muscle10count = "4";
                    muscle11count = "4";
                    muscle12count = "4";
                    break;
            }

            //BICEPS
            //String[] args = new String[] {muscle3, muscle3count};
            //SQL binding (attacks from here?¿?¿)
            String query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle1+"' ORDER BY RANDOM() LIMIT "+muscle1count;
            //random query with selected options (!!!MUST CHANGE ? method to work with args)
            //Cursor c = db.rawQuery("SELECT * FROM Exercises WHERE muscle_zone LIKE 'abs' ORDER BY RANDOM() LIMIT 3", null);
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











        } else {
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


    }


    public void goToMainActivity (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }


    public void goToActivity3 (View view){
        Intent intent = new Intent (this, Activity3.class);
        intent.putExtra("exerciseCounter", counter);
        //parcelable
        intent.putParcelableArrayListExtra("key", exercisesList);

        TextView simpleChrono = findViewById(R.id.simpleChronometer);
        String chronotext = (String) simpleChrono.getText();
        intent.putExtra("chronoText", chronotext);

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

        }

    }


}
