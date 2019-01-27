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
    public ArrayList<String> musclesSelected = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //get boolean listcreated
        listcreated = getIntent().getBooleanExtra("listCreated", false);

        //get musclesSelected list
        musclesSelected = getIntent().getStringArrayListExtra("selectedMuscles");

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 32);
        SQLiteDatabase db = exdb.getWritableDatabase();

        //get selected level and objective
        objectivestring = getIntent().getStringExtra("selectedObjective");
        levelstring = getIntent().getStringExtra("selectedLevel");

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


            //CREATE LIST
            int musclesNumb = musclesSelected.size();
            int exercNumb = 0;
            switch(timestring) {
                case "15 min":
                    exercNumb = 7;
                    break;
                case "30 min":
                    exercNumb = 15;
                    break;
                case "45 min":
                    exercNumb = 22;
                    break;
                case "1 h":
                    exercNumb = 30;
                    break;
                case "1 h 30 min":
                    exercNumb = 45;
                    break;
            }
            int exercEach = exercNumb / musclesNumb;
            int exercRemaining = exercNumb % musclesNumb;

            int idx0 = 0;
            while((idx0<musclesNumb)&&(musclesNumb!=0)){
                obtainExercices(musclesSelected.get(idx0), exercEach);
                idx0++;
            }
            //musclesselected take into account and dont repeat in exerciseslist
            obtainExercRemaining(exercRemaining);

            //
            Collections.sort(exercisesList);

            //
            superserie(exercisesList);



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
        TextView uppertext = findViewById(R.id.textView10);
        TextView uppertext2 = findViewById(R.id.textView3);
        ImageView image = findViewById(R.id.imageView);


        text.setText(exercisesList.get(counter).getName());
        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());

        //translate muscle zone to show it in its textview
        String muscleZoneEnglish = exercisesList.get(counter).getMuscle_zone();
        switch(muscleZoneEnglish){
            case "biceps":
                muscleZoneEnglish = "BICEPS";
                break;
            case "abs":
                muscleZoneEnglish = "ABS";
                break;
            case "forearm":
                muscleZoneEnglish = "ANTEBR.";
                break;
            case "chest":
                muscleZoneEnglish = "PECHO";
                break;
            case "deltoid":
                muscleZoneEnglish = "HOMBRO";
                break;
            case "calf":
                muscleZoneEnglish = "GEMELO";
                break;
            case "glute":
                muscleZoneEnglish = "GLUTEO";
                break;
            case "mid-back":
                muscleZoneEnglish = "ESP.MED.";
                break;
            case "lumbar":
                muscleZoneEnglish = "LUMBAR";
                break;
            case "thigh":
                muscleZoneEnglish = "MUSLO";
                break;
            case "triceps":
                muscleZoneEnglish = "TRICEPS";
                break;
            case "upper-back":
                muscleZoneEnglish = "ESP.SUP.";
                break;
        }
        uppertext.setText(muscleZoneEnglish);




        uppertext2.setText(exercisesList.get(counter).getSubclasses().toUpperCase());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(1078, 958)
                .into(image);

        //539 and 479

        // Set objective and level kgs and reps
        TextView repstext = findViewById(R.id.textView8);
        TextView kgstext = findViewById(R.id.textView7);
        //get reps string[]
        String reps[]= exercisesList.get(counter).getReps_obj().split("/");

        switch(objectivestring) {
            case "Salud":
                //set reps
                repstext.setText(reps[0]);
                //get hip_weight[]
                String hip_weight[]= exercisesList.get(counter).getHip_weight().split("/");
                //set kgs
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(hip_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(hip_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(hip_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(hip_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(hip_weight[4]+" kgs");
                        break;
                }
                break;
            case "Volumen":
                repstext.setText(reps[2]);
                //get vol_weight[]
                String vol_weight[]= exercisesList.get(counter).getVol_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(vol_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(vol_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(vol_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(vol_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(vol_weight[4]+" kgs");
                        break;
                }
                break;
            case "Definición":
                repstext.setText(reps[1]);
                //get res_weight[]
                String res_weight[]= exercisesList.get(counter).getRes_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(res_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(res_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(res_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(res_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(res_weight[4]+" kgs");
                        break;
                }
                break;
        }

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
            TextView uppertext = findViewById(R.id.textView10);
            TextView uppertext2 = findViewById(R.id.textView3);
            uppertext2.setText(exercisesList.get(counter).getSubclasses().toUpperCase());

            //uppertext.setText(exercisesList.get(counter).getMuscle_zone().toUpperCase());
            //translate muscle zone to show it in its textview
            String muscleZoneEnglish = exercisesList.get(counter).getMuscle_zone();
            switch(muscleZoneEnglish){
                case "biceps":
                    muscleZoneEnglish = "BICEPS";
                    break;
                case "abs":
                    muscleZoneEnglish = "ABS";
                    break;
                case "forearm":
                    muscleZoneEnglish = "ANTEBR.";
                    break;
                case "chest":
                    muscleZoneEnglish = "PECHO";
                    break;
                case "deltoid":
                    muscleZoneEnglish = "HOMBRO";
                    break;
                case "calf":
                    muscleZoneEnglish = "GEMELO";
                    break;
                case "glute":
                    muscleZoneEnglish = "GLUTEO";
                    break;
                case "mid-back":
                    muscleZoneEnglish = "ESP.MED.";
                    break;
                case "lumbar":
                    muscleZoneEnglish = "LUMBAR";
                    break;
                case "thigh":
                    muscleZoneEnglish = "MUSLO";
                    break;
                case "triceps":
                    muscleZoneEnglish = "TRICEPS";
                    break;
                case "upper-back":
                    muscleZoneEnglish = "ESP.SUP.";
                    break;
            }
            uppertext.setText(muscleZoneEnglish);


            TextView remaining = findViewById(R.id.textView6);
            remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
            Picasso
                    .with(this)
                    .load(exercisesList.get(counter).getPhoto_path())
                    .resize(539, 479)
                    .into(image);

            // Set objective and level kgs and reps
            TextView repstext = findViewById(R.id.textView8);
            TextView kgstext = findViewById(R.id.textView7);
            //get reps string[]
            String reps[]= exercisesList.get(counter).getReps_obj().split("/");

            switch(objectivestring) {
                case "Salud":
                    //set reps
                    repstext.setText(reps[0]);
                    //get hip_weight[]
                    String hip_weight[]= exercisesList.get(counter).getHip_weight().split("/");
                    //set kgs
                    switch(levelstring) {
                        case "1.- Básico":
                            kgstext.setText(hip_weight[0]+" kgs");
                            break;
                        case "2.- En forma":
                            kgstext.setText(hip_weight[1]+" kgs");
                            break;
                        case "3.- Atlético":
                            kgstext.setText(hip_weight[2]+" kgs");
                            break;
                        case "4.- Fuerte":
                            kgstext.setText(hip_weight[3]+" kgs");
                            break;
                        case "5.- Muy fuerte":
                            kgstext.setText(hip_weight[4]+" kgs");
                            break;
                    }
                    break;
                case "Volumen":
                    repstext.setText(reps[2]);
                    //get vol_weight[]
                    String vol_weight[]= exercisesList.get(counter).getVol_weight().split("/");
                    switch(levelstring) {
                        case "1.- Básico":
                            kgstext.setText(vol_weight[0]+" kgs");
                            break;
                        case "2.- En forma":
                            kgstext.setText(vol_weight[1]+" kgs");
                            break;
                        case "3.- Atlético":
                            kgstext.setText(vol_weight[2]+" kgs");
                            break;
                        case "4.- Fuerte":
                            kgstext.setText(vol_weight[3]+" kgs");
                            break;
                        case "5.- Muy fuerte":
                            kgstext.setText(vol_weight[4]+" kgs");
                            break;
                    }
                    break;
                case "Definición":
                    repstext.setText(reps[1]);
                    //get res_weight[]
                    String res_weight[]= exercisesList.get(counter).getRes_weight().split("/");
                    switch(levelstring) {
                        case "1.- Básico":
                            kgstext.setText(res_weight[0]+" kgs");
                            break;
                        case "2.- En forma":
                            kgstext.setText(res_weight[1]+" kgs");
                            break;
                        case "3.- Atlético":
                            kgstext.setText(res_weight[2]+" kgs");
                            break;
                        case "4.- Fuerte":
                            kgstext.setText(res_weight[3]+" kgs");
                            break;
                        case "5.- Muy fuerte":
                            kgstext.setText(res_weight[4]+" kgs");
                            break;
                    }
                    break;
            }

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
            TextView uppertext = findViewById(R.id.textView10);
            TextView uppertext2 = findViewById(R.id.textView3);
            uppertext2.setText(exercisesList.get(counter).getSubclasses().toUpperCase());

            //translate muscle zone to show it in its textview
            String muscleZoneEnglish = exercisesList.get(counter).getMuscle_zone();
            switch(muscleZoneEnglish){
                case "biceps":
                    muscleZoneEnglish = "BICEPS";
                    break;
                case "abs":
                    muscleZoneEnglish = "ABS";
                    break;
                case "forearm":
                    muscleZoneEnglish = "ANTEBR.";
                    break;
                case "chest":
                    muscleZoneEnglish = "PECHO";
                    break;
                case "deltoid":
                    muscleZoneEnglish = "HOMBRO";
                    break;
                case "calf":
                    muscleZoneEnglish = "GEMELO";
                    break;
                case "glute":
                    muscleZoneEnglish = "GLUTEO";
                    break;
                case "mid-back":
                    muscleZoneEnglish = "ESP.MED.";
                    break;
                case "lumbar":
                    muscleZoneEnglish = "LUMBAR";
                    break;
                case "thigh":
                    muscleZoneEnglish = "MUSLO";
                    break;
                case "triceps":
                    muscleZoneEnglish = "TRICEPS";
                    break;
                case "upper-back":
                    muscleZoneEnglish = "ESP.SUP.";
                    break;
            }
            uppertext.setText(muscleZoneEnglish);


            TextView remaining = findViewById(R.id.textView6);
            remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
            Picasso
                    .with(this)
                    .load(exercisesList.get(counter).getPhoto_path())
                    .resize(539, 479)
                    .into(image);

            // Set objective and level kgs and reps
            TextView repstext = findViewById(R.id.textView8);
            TextView kgstext = findViewById(R.id.textView7);
            //get reps string[]
            String reps[]= exercisesList.get(counter).getReps_obj().split("/");

            switch(objectivestring) {
                case "Salud":
                    //set reps
                    repstext.setText(reps[0]);
                    //get hip_weight[]
                    String hip_weight[]= exercisesList.get(counter).getHip_weight().split("/");
                    //set kgs
                    switch(levelstring) {
                        case "1.- Básico":
                            kgstext.setText(hip_weight[0]+" kgs");
                            break;
                        case "2.- En forma":
                            kgstext.setText(hip_weight[1]+" kgs");
                            break;
                        case "3.- Atlético":
                            kgstext.setText(hip_weight[2]+" kgs");
                            break;
                        case "4.- Fuerte":
                            kgstext.setText(hip_weight[3]+" kgs");
                            break;
                        case "5.- Muy fuerte":
                            kgstext.setText(hip_weight[4]+" kgs");
                            break;
                    }
                    break;
                case "Volumen":
                    repstext.setText(reps[2]);
                    //get vol_weight[]
                    String vol_weight[]= exercisesList.get(counter).getVol_weight().split("/");
                    switch(levelstring) {
                        case "1.- Básico":
                            kgstext.setText(vol_weight[0]+" kgs");
                            break;
                        case "2.- En forma":
                            kgstext.setText(vol_weight[1]+" kgs");
                            break;
                        case "3.- Atlético":
                            kgstext.setText(vol_weight[2]+" kgs");
                            break;
                        case "4.- Fuerte":
                            kgstext.setText(vol_weight[3]+" kgs");
                            break;
                        case "5.- Muy fuerte":
                            kgstext.setText(vol_weight[4]+" kgs");
                            break;
                    }
                    break;
                case "Definición":
                    repstext.setText(reps[1]);
                    //get res_weight[]
                    String res_weight[]= exercisesList.get(counter).getRes_weight().split("/");
                    switch(levelstring) {
                        case "1.- Básico":
                            kgstext.setText(res_weight[0]+" kgs");
                            break;
                        case "2.- En forma":
                            kgstext.setText(res_weight[1]+" kgs");
                            break;
                        case "3.- Atlético":
                            kgstext.setText(res_weight[2]+" kgs");
                            break;
                        case "4.- Fuerte":
                            kgstext.setText(res_weight[3]+" kgs");
                            break;
                        case "5.- Muy fuerte":
                            kgstext.setText(res_weight[4]+" kgs");
                            break;
                    }
                    break;
            }

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
        TextView uppertext = findViewById(R.id.textView10);
        TextView uppertext2 = findViewById(R.id.textView3);
        uppertext2.setText(exercisesList.get(counter).getSubclasses().toUpperCase());

        //translate muscle zone to show it in its textview
        String muscleZoneEnglish = exercisesList.get(counter).getMuscle_zone();
        switch(muscleZoneEnglish){
            case "biceps":
                muscleZoneEnglish = "BICEPS";
                break;
            case "abs":
                muscleZoneEnglish = "ABS";
                break;
            case "forearm":
                muscleZoneEnglish = "ANTEBR.";
                break;
            case "chest":
                muscleZoneEnglish = "PECHO";
                break;
            case "deltoid":
                muscleZoneEnglish = "HOMBRO";
                break;
            case "calf":
                muscleZoneEnglish = "GEMELO";
                break;
            case "glute":
                muscleZoneEnglish = "GLUTEO";
                break;
            case "mid-back":
                muscleZoneEnglish = "ESP.MED.";
                break;
            case "lumbar":
                muscleZoneEnglish = "LUMBAR";
                break;
            case "thigh":
                muscleZoneEnglish = "MUSLO";
                break;
            case "triceps":
                muscleZoneEnglish = "TRICEPS";
                break;
            case "upper-back":
                muscleZoneEnglish = "ESP.SUP.";
                break;
        }
        uppertext.setText(muscleZoneEnglish);

        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);

        // Set objective and level kgs and reps
        TextView repstext = findViewById(R.id.textView8);
        TextView kgstext = findViewById(R.id.textView7);
        //get reps string[]
        String reps[]= exercisesList.get(counter).getReps_obj().split("/");

        switch(objectivestring) {
            case "Salud":
                //set reps
                repstext.setText(reps[0]);
                //get hip_weight[]
                String hip_weight[]= exercisesList.get(counter).getHip_weight().split("/");
                //set kgs
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(hip_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(hip_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(hip_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(hip_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(hip_weight[4]+" kgs");
                        break;
                }
                break;
            case "Volumen":
                repstext.setText(reps[2]);
                //get vol_weight[]
                String vol_weight[]= exercisesList.get(counter).getVol_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(vol_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(vol_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(vol_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(vol_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(vol_weight[4]+" kgs");
                        break;
                }
                break;
            case "Definición":
                repstext.setText(reps[1]);
                //get res_weight[]
                String res_weight[]= exercisesList.get(counter).getRes_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(res_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(res_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(res_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(res_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(res_weight[4]+" kgs");
                        break;
                }
                break;
        }

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
        TextView uppertext = findViewById(R.id.textView10);
        TextView uppertext2 = findViewById(R.id.textView3);
        uppertext2.setText(exercisesList.get(counter).getSubclasses().toUpperCase());

        //translate muscle zone to show it in its textview
        String muscleZoneEnglish = exercisesList.get(counter).getMuscle_zone();
        switch(muscleZoneEnglish){
            case "biceps":
                muscleZoneEnglish = "BICEPS";
                break;
            case "abs":
                muscleZoneEnglish = "ABS";
                break;
            case "forearm":
                muscleZoneEnglish = "ANTEBR.";
                break;
            case "chest":
                muscleZoneEnglish = "PECHO";
                break;
            case "deltoid":
                muscleZoneEnglish = "HOMBRO";
                break;
            case "calf":
                muscleZoneEnglish = "GEMELO";
                break;
            case "glute":
                muscleZoneEnglish = "GLUTEO";
                break;
            case "mid-back":
                muscleZoneEnglish = "ESP.MED.";
                break;
            case "lumbar":
                muscleZoneEnglish = "LUMBAR";
                break;
            case "thigh":
                muscleZoneEnglish = "MUSLO";
                break;
            case "triceps":
                muscleZoneEnglish = "TRICEPS";
                break;
            case "upper-back":
                muscleZoneEnglish = "ESP.SUP.";
                break;
        }
        uppertext.setText(muscleZoneEnglish);


        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);

        // Set objective and level kgs and reps
        TextView repstext = findViewById(R.id.textView8);
        TextView kgstext = findViewById(R.id.textView7);
        //get reps string[]
        String reps[]= exercisesList.get(counter).getReps_obj().split("/");

        switch(objectivestring) {
            case "Salud":
                //set reps
                repstext.setText(reps[0]);
                //get hip_weight[]
                String hip_weight[]= exercisesList.get(counter).getHip_weight().split("/");
                //set kgs
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(hip_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(hip_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(hip_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(hip_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(hip_weight[4]+" kgs");
                        break;
                }
                break;
            case "Volumen":
                repstext.setText(reps[2]);
                //get vol_weight[]
                String vol_weight[]= exercisesList.get(counter).getVol_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(vol_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(vol_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(vol_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(vol_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(vol_weight[4]+" kgs");
                        break;
                }
                break;
            case "Definición":
                repstext.setText(reps[1]);
                //get res_weight[]
                String res_weight[]= exercisesList.get(counter).getRes_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(res_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(res_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(res_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(res_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(res_weight[4]+" kgs");
                        break;
                }
                break;
        }

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
        TextView uppertext = findViewById(R.id.textView10);
        TextView uppertext2 = findViewById(R.id.textView3);
        uppertext2.setText(exercisesList.get(counter).getSubclasses().toUpperCase());

        //translate muscle zone to show it in its textview
        String muscleZoneEnglish = exercisesList.get(counter).getMuscle_zone();
        switch(muscleZoneEnglish){
            case "biceps":
                muscleZoneEnglish = "BICEPS";
                break;
            case "abs":
                muscleZoneEnglish = "ABS";
                break;
            case "forearm":
                muscleZoneEnglish = "ANTEBR.";
                break;
            case "chest":
                muscleZoneEnglish = "PECHO";
                break;
            case "deltoid":
                muscleZoneEnglish = "HOMBRO";
                break;
            case "calf":
                muscleZoneEnglish = "GEMELO";
                break;
            case "glute":
                muscleZoneEnglish = "GLUTEO";
                break;
            case "mid-back":
                muscleZoneEnglish = "ESP.MED.";
                break;
            case "lumbar":
                muscleZoneEnglish = "LUMBAR";
                break;
            case "thigh":
                muscleZoneEnglish = "MUSLO";
                break;
            case "triceps":
                muscleZoneEnglish = "TRICEPS";
                break;
            case "upper-back":
                muscleZoneEnglish = "ESP.SUP.";
                break;
        }
        uppertext.setText(muscleZoneEnglish);


        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);

        // Set objective and level kgs and reps
        TextView repstext = findViewById(R.id.textView8);
        TextView kgstext = findViewById(R.id.textView7);
        //get reps string[]
        String reps[]= exercisesList.get(counter).getReps_obj().split("/");

        switch(objectivestring) {
            case "Salud":
                //set reps
                repstext.setText(reps[0]);
                //get hip_weight[]
                String hip_weight[]= exercisesList.get(counter).getHip_weight().split("/");
                //set kgs
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(hip_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(hip_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(hip_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(hip_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(hip_weight[4]+" kgs");
                        break;
                }
                break;
            case "Volumen":
                repstext.setText(reps[2]);
                //get vol_weight[]
                String vol_weight[]= exercisesList.get(counter).getVol_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(vol_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(vol_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(vol_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(vol_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(vol_weight[4]+" kgs");
                        break;
                }
                break;
            case "Definición":
                repstext.setText(reps[1]);
                //get res_weight[]
                String res_weight[]= exercisesList.get(counter).getRes_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(res_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(res_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(res_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(res_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(res_weight[4]+" kgs");
                        break;
                }
                break;
        }

        //set CheckBox
        CheckBox checkb = (CheckBox) findViewById(R.id.checkBox);
        if (exercisesList.get(counter).getDone()==1){
            //mark it
            checkb.setChecked(true);
        }else{
            checkb.setChecked(false);
        }

    }


    public void obtainExercices (String muscle1, int exNumb){


        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 32);
        SQLiteDatabase db = exdb.getWritableDatabase();

        String query="";
        String numb = Integer.toString(exNumb);

        //if objective=resistencia or level=1/2 don't get "hard" exercises
        if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
            query = "SELECT * FROM Exercises WHERE (muscle_zone LIKE '"+muscle1+"') AND level LIKE '' ORDER BY RANDOM() LIMIT "+numb;
        }else{
            query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle1+"' ORDER BY RANDOM() LIMIT "+numb;
        }

        Cursor c = db.rawQuery(query, null);
        //add exercises to array list
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }

    }



    public void obtainExercRemaining(int exNumb){

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 32);
        SQLiteDatabase db = exdb.getWritableDatabase();

        String query="";
        String numb = Integer.toString(exNumb);

        int idxAux = 0;

        //if objective=resistencia or level=1/2 don't get "hard" exercises
        if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
            //get only from selected muscles
            query = "SELECT * FROM Exercises WHERE (muscle_zone LIKE '";
            while(idxAux < musclesSelected.size()){
                //last one, add )
                if(idxAux == musclesSelected.size()-1){
                    query += musclesSelected.get(idxAux)+"') AND level LIKE '' ORDER BY RANDOM() LIMIT "+numb;
                }else{
                    query += musclesSelected.get(idxAux)+"' OR muscle_zone LIKE '";
                }
                idxAux++;
            }
        }else{
            query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '";
            while(idxAux < musclesSelected.size()){
                //last one, add )
                if(idxAux == musclesSelected.size()-1){
                    query += musclesSelected.get(idxAux)+"' ORDER BY RANDOM() LIMIT "+numb;
                }else{
                    query += musclesSelected.get(idxAux)+"' OR muscle_zone LIKE '";
                }
                idxAux++;
            }
        }

        Cursor c = db.rawQuery(query, null);
        //add exercises to array list
        if (c.moveToFirst()) {
            //go over cursor until the end
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }


    }



    public void addMuscle(String muscle){
        //get the list of that muscle we got in exerciseslist


        //
        //switch(muscle){
            //BICEPS MAXIMUM
            //case "biceps":

        //}


    }

    public void addSubMuscle(String subMuscle){


    }











    public void changeExercise (View view){



        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 32);
        SQLiteDatabase db = exdb.getWritableDatabase();

        int index = counter;
        String exerciseName = exercisesList.get(index).getName();
        String exerciseCategory = exercisesList.get(index).getMuscle_zone();

        String query="";
        //find a new exercise (different from that and not existing in the list)
        if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
            query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+exerciseCategory+"'AND level LIKE '' AND name NOT IN ('"+exerciseName+"') ORDER BY RANDOM() LIMIT 1";
        }else{
            query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+exerciseCategory+"' AND name NOT IN ('"+exerciseName+"') ORDER BY RANDOM() LIMIT 1";
        }

        Cursor c = db.rawQuery(query, null);
        //change exercise
        if (c.moveToFirst()) {
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11));
                exercisesList.set(index, currentExercise);

            } while(c.moveToNext());
        }

        //change the view
        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);


        text.setText(exercisesList.get(counter).getName());
        TextView uppertext = findViewById(R.id.textView10);
        TextView uppertext2 = findViewById(R.id.textView3);
        uppertext2.setText(exercisesList.get(counter).getSubclasses().toUpperCase());


        //translate muscle zone to show it in its textview
        String muscleZoneEnglish = exercisesList.get(counter).getMuscle_zone();
        switch(muscleZoneEnglish){
            case "biceps":
                muscleZoneEnglish = "BICEPS";
                break;
            case "abs":
                muscleZoneEnglish = "ABS";
                break;
            case "forearm":
                muscleZoneEnglish = "ANTEBR.";
                break;
            case "chest":
                muscleZoneEnglish = "PECHO";
                break;
            case "deltoid":
                muscleZoneEnglish = "HOMBRO";
                break;
            case "calf":
                muscleZoneEnglish = "GEMELO";
                break;
            case "glute":
                muscleZoneEnglish = "GLUTEO";
                break;
            case "mid-back":
                muscleZoneEnglish = "ESP.MED.";
                break;
            case "lumbar":
                muscleZoneEnglish = "LUMBAR";
                break;
            case "thigh":
                muscleZoneEnglish = "MUSLO";
                break;
            case "triceps":
                muscleZoneEnglish = "TRICEPS";
                break;
            case "upper-back":
                muscleZoneEnglish = "ESP.SUP.";
                break;
        }
        uppertext.setText(muscleZoneEnglish);


        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());
        Picasso
                .with(this)
                .load(exercisesList.get(counter).getPhoto_path())
                .resize(539, 479)
                .into(image);

        // Set objective and level kgs and reps
        TextView repstext = findViewById(R.id.textView8);
        TextView kgstext = findViewById(R.id.textView7);
        //get reps string[]
        String reps[]= exercisesList.get(counter).getReps_obj().split("/");

        switch(objectivestring) {
            case "Salud":
                //set reps
                repstext.setText(reps[0]);
                //get hip_weight[]
                String hip_weight[]= exercisesList.get(counter).getHip_weight().split("/");
                //set kgs
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(hip_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(hip_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(hip_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(hip_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(hip_weight[4]+" kgs");
                        break;
                }
                break;
            case "Volumen":
                repstext.setText(reps[2]);
                //get vol_weight[]
                String vol_weight[]= exercisesList.get(counter).getVol_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(vol_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(vol_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(vol_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(vol_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(vol_weight[4]+" kgs");
                        break;
                }
                break;
            case "Definición":
                repstext.setText(reps[1]);
                //get res_weight[]
                String res_weight[]= exercisesList.get(counter).getRes_weight().split("/");
                switch(levelstring) {
                    case "1.- Básico":
                        kgstext.setText(res_weight[0]+" kgs");
                        break;
                    case "2.- En forma":
                        kgstext.setText(res_weight[1]+" kgs");
                        break;
                    case "3.- Atlético":
                        kgstext.setText(res_weight[2]+" kgs");
                        break;
                    case "4.- Fuerte":
                        kgstext.setText(res_weight[3]+" kgs");
                        break;
                    case "5.- Muy fuerte":
                        kgstext.setText(res_weight[4]+" kgs");
                        break;
                }
                break;
        }


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


    @Override
    public void onBackPressed() {
        //go to main Activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        Activity2AlertDialog dialogo = new Activity2AlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");

    }


    public void superserie(ArrayList<Exercise> exercisesList2){
        //BICEPS-CHEST "superserie"
        int idx_biceps = 0;
        int idx_last_biceps = -1;
        boolean firstbiceps = false;
        int idx_chest = 0;
        int idx_last_chest = -1;
        boolean nextbiceps = true;
        boolean nextchest = true;
        boolean changed = false;
        boolean firstchange = false;
        int idx_limit = 100000;
        int swaps_counter = 0;
        //while there's more exercises continue swapping
        while(nextbiceps && nextchest){
            //find next biceps
            //go over all the list, get nextbiceps idx
            for (Exercise tempexercise : exercisesList2) {
                if(tempexercise.getMuscle_zone().equals("biceps") && idx_biceps > idx_last_biceps){
                    if(idx_limit == idx_biceps){
                        if(exercisesList2.get(idx_limit-1).getMuscle_zone().equals("biceps")){
                            int position1 =idx_limit;
                            int position2 =idx_limit+1;
                            while(swaps_counter != 0){
                                Collections.swap(exercisesList2, position1, position2);
                                position1 = position1+2;
                                position2 = position2 +2;
                                swaps_counter--;
                            }
                        }else{
                            break;
                        }
                    }
                    if(!firstbiceps){
                        firstbiceps = true;
                        idx_biceps++;
                    }else{
                        changed = true;
                        idx_last_biceps = idx_biceps;
                        firstbiceps = false;
                        break;
                    }
                }else{
                    idx_biceps++;
                }
            }
            if(!changed){
                nextbiceps = false;
            }else{
                changed = false;
            }
            //find next chest
            //go over all the list, get nextbiceps idx
            for (Exercise tempexercise : exercisesList2) {
                if(tempexercise.getMuscle_zone().equals("chest") && idx_chest > idx_last_chest){
                    changed = true;
                    idx_last_chest = idx_chest;
                    break;
                }else{
                    idx_chest++;
                }
            }
            if(!changed){
                nextchest = false;
            }else{
                changed = false;
            }
            if(nextbiceps && nextchest){
                Collections.swap(exercisesList2, idx_biceps, idx_chest);
                swaps_counter++;
                idx_last_chest = idx_biceps;
            }
            if(!firstchange){
               idx_limit = idx_chest;
               firstchange = true;
            }
            idx_biceps = 0;
            idx_chest = 0;
        }



        //MID-BACK-DELTOID "superserie"
        idx_biceps = 0;
        idx_last_biceps = -1;
        firstbiceps = false;
        idx_chest = 0;
        idx_last_chest = -1;
        nextbiceps = true;
        nextchest = true;
        changed = false;
        firstchange = false;
        idx_limit = 100000;
        swaps_counter = 0;
        //while there's more exercises continue swapping
        while(nextbiceps && nextchest){
            //find next biceps
            //go over all the list, get nextbiceps idx
            for (Exercise tempexercise : exercisesList2) {
                if(tempexercise.getMuscle_zone().equals("mid-back") && idx_biceps > idx_last_biceps){
                    if(idx_limit == idx_biceps){
                        if(exercisesList2.get(idx_limit-1).getMuscle_zone().equals("mid-back")){
                            int position1 =idx_limit;
                            int position2 =idx_limit+1;
                            while(swaps_counter != 0){
                                Collections.swap(exercisesList2, position1, position2);
                                position1 = position1+2;
                                position2 = position2 +2;
                                swaps_counter--;
                            }
                        }else{
                            break;
                        }
                    }
                    if(!firstbiceps){
                        firstbiceps = true;
                        idx_biceps++;
                    }else{
                        changed = true;
                        idx_last_biceps = idx_biceps;
                        firstbiceps = false;
                        break;
                    }
                }else{
                    idx_biceps++;
                }
            }
            if(!changed){
                nextbiceps = false;
            }else{
                changed = false;
            }
            //find next chest
            //go over all the list, get nextbiceps idx
            for (Exercise tempexercise : exercisesList2) {
                if(tempexercise.getMuscle_zone().equals("deltoid") && idx_chest > idx_last_chest){
                    changed = true;
                    idx_last_chest = idx_chest;
                    break;
                }else{
                    idx_chest++;
                }
            }
            if(!changed){
                nextchest = false;
            }else{
                changed = false;
            }
            if(nextbiceps && nextchest){
                Collections.swap(exercisesList2, idx_biceps, idx_chest);
                swaps_counter++;
                idx_last_chest = idx_biceps;
            }
            if(!firstchange){
                idx_limit = idx_chest;
                firstchange = true;
            }
            idx_biceps = 0;
            idx_chest = 0;
        }



        //UPPER-BACK-TRICEPS "superserie"
        idx_biceps = 0;
        idx_last_biceps = -1;
        firstbiceps = false;
        idx_chest = 0;
        idx_last_chest = -1;
        nextbiceps = true;
        nextchest = true;
        changed = false;
        firstchange = false;
        idx_limit = 100000;
        swaps_counter = 0;
        //while there's more exercises continue swapping
        while(nextbiceps && nextchest){
            //find next biceps
            //go over all the list, get nextbiceps idx
            for (Exercise tempexercise : exercisesList2) {
                if(tempexercise.getMuscle_zone().equals("upper-back") && idx_biceps > idx_last_biceps){
                    if(idx_limit == idx_biceps){
                        if(exercisesList2.get(idx_limit-1).getMuscle_zone().equals("upper-back")){
                            int position1 =idx_limit;
                            int position2 =idx_limit+1;
                            while(swaps_counter != 0){
                                Collections.swap(exercisesList2, position1, position2);
                                position1 = position1+2;
                                position2 = position2 +2;
                                swaps_counter--;
                            }
                        }else{
                            break;
                        }
                    }
                    if(!firstbiceps){
                        firstbiceps = true;
                        idx_biceps++;
                    }else{
                        changed = true;
                        idx_last_biceps = idx_biceps;
                        firstbiceps = false;
                        break;
                    }
                }else{
                    idx_biceps++;
                }
            }
            if(!changed){
                nextbiceps = false;
            }else{
                changed = false;
            }
            //find next chest
            //go over all the list, get nextbiceps idx
            for (Exercise tempexercise : exercisesList2) {
                if(tempexercise.getMuscle_zone().equals("triceps") && idx_chest > idx_last_chest){
                    changed = true;
                    idx_last_chest = idx_chest;
                    break;
                }else{
                    idx_chest++;
                }
            }
            if(!changed){
                nextchest = false;
            }else{
                changed = false;
            }
            if(nextbiceps && nextchest){
                Collections.swap(exercisesList2, idx_biceps, idx_chest);
                swaps_counter++;
                idx_last_chest = idx_biceps;
            }
            if(!firstchange){
                idx_limit = idx_chest;
                firstchange = true;
            }
            idx_biceps = 0;
            idx_chest = 0;
        }

    }

}
