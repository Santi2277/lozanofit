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
import java.util.Random;
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
    public Random randomGenerator = new Random();
    public String muscleNow = "";
    public boolean fromAct2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //get boolean listcreated
        listcreated = getIntent().getBooleanExtra("listCreated", false);

        //get musclesSelected list
        musclesSelected = getIntent().getStringArrayListExtra("musclesSelected");

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 37);
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
                    long longnumb = millisUntilFinished / 1000;
                    int numb = (int)longnumb;
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
            //ADD, number of exercises per each muscle
            int idx0 = 0;
            while((idx0<musclesNumb)&&(musclesNumb!=0)){
                //obtainExercices(musclesSelected.get(idx0), exercEach);
                for(int i=1; i<exercEach+1; i++){
                    addMuscle(musclesSelected.get(idx0));
                }
                idx0++;
            }
            //musclesselected take into account and dont repeat in exerciseslist
            //obtainExercRemaining(exercRemaining);
            //Add, exercises of muscles remaining
            ArrayList<String> musclesArray = new ArrayList<>();
            int indexAux = 0;
            while(indexAux<musclesSelected.size()){
                musclesArray.add(musclesSelected.get(indexAux));
                indexAux++;
            }

            int randomIndex;
            //while remaining (WHILE put)
            int idxA = 0;
            while(idxA<exercRemaining){
                randomIndex = randomGenerator.nextInt(musclesArray.size());
                addMuscle(musclesArray.get(randomIndex));
                musclesArray.remove(randomIndex);
                idxA++;
            }
            if(bodystring.equals("Todo")||(bodystring.equals("Inferior"))){
                if((timestring.equals("1 h"))||(timestring.equals("1 h 30 min"))){
                    addMuscle("abs");
                }
            }


            Collections.sort(exercisesList);
            //
            if(musclesSelected.size()==2){
                superserie2(musclesSelected.get(0), musclesSelected.get(1));
            }else{
                superserie(exercisesList);
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
                    long longnumb = millisUntilFinished / 1000;
                    int numb = (int)longnumb;
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
        final TextView uppertext = findViewById(R.id.textView10);
        TextView uppertext2 = findViewById(R.id.textView3);
        ImageView image = findViewById(R.id.imageView);

        TextView uppertext3 = findViewById(R.id.textView13);
        uppertext3.setText(exercisesList.get(counter).getSeries()+" SERIE");

        text.setText(exercisesList.get(counter).getName());
        TextView remaining = findViewById(R.id.textView6);
        remaining.setText(Integer.toString(counter+1)+" / "+exercisesList.size());

        //link to activity6
        uppertext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);
                intent.putExtra("exerciseCounter", counter);
                //parcelable
                intent.putParcelableArrayListExtra("key", exercisesList);

                TextView simpleChrono = findViewById(R.id.simpleChronometer);
                String chronotext = (String) simpleChrono.getText();
                intent.putExtra("chronoText", chronotext);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                muscleNow = uppertext.getText().toString();
                intent.putExtra("muscleNow", muscleNow);

                intent.putExtra("fromAct2", fromAct2);

                startActivity(intent);
            }
        });

        //link to activity6
        uppertext2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Activity6.class);
                intent.putExtra("exerciseCounter", counter);
                //parcelable
                intent.putParcelableArrayListExtra("key", exercisesList);

                TextView simpleChrono = findViewById(R.id.simpleChronometer);
                String chronotext = (String) simpleChrono.getText();
                intent.putExtra("chronoText", chronotext);

                intent.putExtra("selectedLevel", levelstring);
                intent.putExtra("selectedObjective", objectivestring);

                muscleNow = uppertext.getText().toString();
                intent.putExtra("muscleNow", muscleNow);
                intent.putExtra("fromAct2", fromAct2);
                startActivity(intent);
            }
        });


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
            TextView uppertext3 = findViewById(R.id.textView13);
            uppertext3.setText(exercisesList.get(counter).getSeries()+" SERIE");

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
            TextView uppertext3 = findViewById(R.id.textView13);
            uppertext3.setText(exercisesList.get(counter).getSeries()+" SERIE");

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
        TextView uppertext3 = findViewById(R.id.textView13);
        uppertext3.setText(exercisesList.get(counter).getSeries()+" SERIE");

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
        TextView uppertext3 = findViewById(R.id.textView13);
        uppertext3.setText(exercisesList.get(counter).getSeries()+" SERIE");

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
        TextView uppertext3 = findViewById(R.id.textView13);
        uppertext3.setText(exercisesList.get(counter).getSeries()+" SERIE");

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
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 37);
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
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11), c.getString(12));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }

    }



    public void obtainExercRemaining(int exNumb){

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 37);
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
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11), c.getString(12));
                exercisesList.add(currentExercise);

            } while(c.moveToNext());
        }


    }



    public void addMuscle(String muscle){
        //find subclasses that could be
        //count subclasses you have, then obtain possible ones next
        int idx0;
        int minRep;
        ArrayList<String> subclPass = new ArrayList<>();
        switch(muscle){
            case "biceps":
                int braCount = 0;
                int corCount = 0;
                int larCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "braquial":
                                braCount = braCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "c.corta":
                                corCount = corCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "c.larga":
                                larCount = larCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(braCount, Math.min(corCount, larCount));
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==braCount){
                    subclPass.add("braquial");
                }
                if(minRep==corCount){
                    subclPass.add("c.corta");
                }
                if(minRep==larCount){
                    subclPass.add("c.larga");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "abs":
                int infCount = 0;
                int isoCount = 0;
                int isoLatCount = 0;
                int medCount = 0;
                int oblCount = 0;
                int supCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "inferior":
                                infCount = infCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "isom.":
                                isoCount = isoCount +Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "isom.lat.":
                                isoLatCount = isoLatCount +Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "medio":
                                medCount = medCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "oblicuos":
                                oblCount = oblCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "superior":
                                supCount=supCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(supCount, Math.min(oblCount, Math.min(medCount, Math.min(infCount, Math.min(isoCount, isoLatCount)))));
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==medCount){
                    subclPass.add("medio");
                }else{
                    if((minRep==infCount)||(minRep==oblCount)||(minRep==supCount)){
                        if(minRep==infCount){
                            subclPass.add("inferior");
                        }
                        if(minRep==oblCount){
                            subclPass.add("oblicuos");
                        }
                        if(minRep==supCount){
                            subclPass.add("superior");
                        }
                    }else{
                        if(minRep==isoCount){
                            subclPass.add("isom.");
                        }else{
                            subclPass.add("isom.lat.");
                        }
                    }
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "forearm":
                int carCount = 0;
                int dedCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "carpo":
                                carCount = carCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "dedos":
                                dedCount=dedCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(carCount, dedCount);
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==carCount){
                    subclPass.add("carpo");
                }
                if(minRep==dedCount){
                    subclPass.add("dedos");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "chest":
                int medInfCount = 0;
                int sup7Count = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "med.-inf.":
                                medInfCount=medInfCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "superior":
                                sup7Count=sup7Count+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(medInfCount, sup7Count);
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==medInfCount){
                    subclPass.add("med.-inf.");
                }
                if(minRep==sup7Count){
                    subclPass.add("superior");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "deltoid":
                int antCount = 0;
                int med2Count = 0;
                int posCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "anterior":
                                antCount=antCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "medio":
                                med2Count=med2Count+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "posterior":
                                posCount=posCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(antCount, Math.min(med2Count, posCount));
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==antCount){
                    subclPass.add("anterior");
                }
                if(minRep==med2Count){
                    subclPass.add("medio");
                }
                if(minRep==posCount){
                    subclPass.add("posterior");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "calf":
                int gemCount = 0;
                int solCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "gemelo":
                                gemCount=gemCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "soleo":
                                solCount=solCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(gemCount, solCount);
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==gemCount){
                    subclPass.add("gemelo");
                }
                if(minRep==solCount){
                    subclPass.add("soleo");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "glute":
                int mayCount = 0;
                int med3Count = 0;
                int menCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "mayor":
                                mayCount=mayCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "medio":
                                med3Count=med3Count+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "menor":
                                menCount=menCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                //minRep = Math.min(mayCount, Math.min(med3Count, menCount));
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(mayCount==med3Count+menCount){
                    subclPass.add("mayor");
                }else{
                    if(Math.min(med3Count, menCount)==med3Count){
                        subclPass.add("medio");
                    }else{
                        subclPass.add("menor");
                    }
                }

                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "mid-back":
                subclPass.clear();
                subclPass.add("esp.med.");
                addSubMuscle(muscle, subclPass);
                break;
            case "lumbar":
                int latCount = 0;
                int norCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "lateral":
                                latCount=latCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "normal":
                                norCount=norCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(latCount, norCount);
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                int division = 0;
                int module = 0;
                if(latCount==0){
                    if(norCount>2){
                        subclPass.add("lateral");
                    }else{
                        subclPass.add("normal");
                    }
                }else{
                    division =norCount/latCount;
                    module =norCount%latCount;
                    if((division>2)||(division==2 && module>0)){
                        subclPass.add("lateral");
                    }else{
                        subclPass.add("normal");
                    }
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "thigh":
                int gloCount = 0;
                int locCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "global":
                                gloCount=gloCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "local":
                                locCount=locCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(gloCount, locCount);
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==gloCount){
                    subclPass.add("global");
                }
                if(minRep==locCount){
                    subclPass.add("local");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "triceps":
                int lar2Count = 0;
                int lat2Count = 0;
                int med4Count = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "c.larga":
                                lar2Count=lar2Count+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "c.lateral":
                                lat2Count=lat2Count+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "c.media":
                                med4Count=med4Count+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(lar2Count, Math.min(lat2Count, med4Count));
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==lar2Count){
                    subclPass.add("c.larga");
                }
                if(minRep==lat2Count){
                    subclPass.add("c.lateral");
                }
                if(minRep==med4Count){
                    subclPass.add("c.media");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
            case "upper-back":
                //TRAPECIO not included
                int extCount = 0;
                int intCount = 0;
                int supraCount = 0;
                //which subclasses turn will be next
                idx0 = 0;
                //go over exercisesList
                while ((idx0 < exercisesList.size())&&(exercisesList.size()!=0)){
                    //count subclasses you have
                    if(exercisesList.get(idx0).getMuscle_zone().equals(muscle)){
                        switch (exercisesList.get(idx0).getSubclasses()){
                            case "rot.ext.":
                                extCount=extCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "rot.int.":
                                intCount=intCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                            case "supraesp.":
                                supraCount=supraCount+Integer.parseInt(exercisesList.get(idx0).getSeries());
                                break;
                        }
                    }
                    idx0++;
                }
                //get minimum repetion number
                minRep = Math.min(extCount, Math.min(intCount, supraCount));
                subclPass.clear();
                //get subclasses with minimum reps (the ones which turn could be next)
                if(minRep==extCount){
                    subclPass.add("rot.ext.");
                }
                if(minRep==intCount){
                    subclPass.add("rot.int.");
                }
                if(minRep==supraCount){
                    subclPass.add("supraesp.");
                }
                //add submuscle then
                addSubMuscle(muscle, subclPass);
                break;
        }





    }

    public void addSubMuscle(String muscle, ArrayList<String> submuscles){
        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 37);
        SQLiteDatabase db = exdb.getWritableDatabase();
        String query="";

        //001 GET 1 EXERCISE (of one of that submuscles)
        //--if objective=resistencia or level=1/2 don't get "hard" exercises
        int idxAux = 0;
        if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
            query = "SELECT * FROM Exercises WHERE (subclasses LIKE '";
            //add all the submuscles candidates to the query
            while(idxAux < submuscles.size()){
                if(idxAux == submuscles.size()-1){
                    query += submuscles.get(idxAux)+"') AND level LIKE '' AND muscle_zone LIKE '"+muscle+"' ORDER BY RANDOM() LIMIT 1";
                }else{
                    query += submuscles.get(idxAux)+"' OR subclasses LIKE '";
                }
                idxAux++;
            }
        }else{
            query = "SELECT * FROM Exercises WHERE (subclasses LIKE '";
            while(idxAux < submuscles.size()){
                if(idxAux == submuscles.size()-1){
                    query += submuscles.get(idxAux)+"') AND muscle_zone LIKE '"+muscle+"' ORDER BY RANDOM() LIMIT 1";
                }else{
                    query += submuscles.get(idxAux)+"' OR subclasses LIKE '";
                }
                idxAux++;
            }
        }
        //002 CHECK REPEATED (on the exercisesList made)
        Cursor c = db.rawQuery(query, null);
        int idx2 = 0;
        boolean found = false;
        int foundPosition = 0;
        if (c.moveToFirst()) {
            do {
                //go over exercisesList to check if it exists on it
                while((idx2<exercisesList.size())&&(exercisesList.size()!=0)){
                    if(c.getString(1).equals(exercisesList.get(idx2).getName())){
                        found = true;
                        foundPosition = idx2;
                        break;
                    }
                    idx2++;
                }
                //003 IF NOT REPEATED, ADD EXERCISE (doesn't exist on exercisesList)
                if(!found){
                    Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11), c.getString(12));
                    exercisesList.add(currentExercise);
                }
            } while(c.moveToNext());
        }
        //004 IF REPEATED
        if(found){
            String subcl = exercisesList.get(foundPosition).getSubclasses();
            int idx3 = 0;
            int countEx = 0;
            ArrayList<String> exercNames = new ArrayList<>();
            int submuscleMax = 100;

            //005 CHECK SUBCLASS MAXIMUM (full or not)
            switch(muscle){
                case "biceps":
                    switch (subcl){
                        case "braquial":
                            //MAX 5 (and 3)
                            if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                                submuscleMax = 3;
                            }else{
                                submuscleMax = 5;
                            }
                            break;
                        case "c.corta":
                            //MAX 6 (and 6)
                            submuscleMax = 6;
                            break;
                        case "c.larga":
                            //MAX 6 (and 5)
                            if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                                submuscleMax = 5;
                            }else{
                                submuscleMax = 6;
                            }
                            break;
                    }
                    break;
                case "abs":
                    switch (subcl){
                        case "inferior":
                            //MAX
                            if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                                submuscleMax = 2;
                            }else{
                                submuscleMax = 3;
                            }
                            break;
                        case "isom.":
                            //MAX
                            submuscleMax = 2;
                            break;
                        case "isom.lat.":
                            //MAX
                            submuscleMax = 3;
                            break;
                        case "medio":
                            //MAX
                            submuscleMax = 6;
                            break;
                        case "oblicuos":
                            //MAX
                            submuscleMax = 5;
                            break;
                        case "superior":
                            //MAX
                            submuscleMax = 3;
                            break;
                    }
                    break;
                case "forearm":
                    switch (subcl){
                        case "carpo":
                            //MAX
                            submuscleMax = 1;
                            break;
                        case "dedos":
                            //MAX
                            submuscleMax = 1;
                            break;
                    }
                    break;
                case "chest":
                    switch (subcl){
                        case "med.-inf.":
                            //MAX
                            if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                                submuscleMax = 10;
                            }else{
                                submuscleMax = 11;
                            }
                            break;
                        case "superior":
                            //MAX
                            submuscleMax = 6;
                            break;
                    }
                    break;
                case "deltoid":
                    switch (subcl){
                        case "anterior":
                            //MAX
                            submuscleMax = 6;
                            break;
                        case "medio":
                            //MAX
                            submuscleMax = 4;
                            break;
                        case "posterior":
                            //MAX
                            if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                                submuscleMax = 4;
                            }else{
                                submuscleMax = 5;
                            }
                            break;
                    }
                    break;
                case "calf":
                    switch (subcl){
                        case "gemelo":
                            //MAX
                            submuscleMax = 3;
                            break;
                        case "soleo":
                            //MAX
                            submuscleMax = 3;
                            break;
                    }
                    break;
                case "glute":
                    switch (subcl){
                        case "mayor":
                            //MAX
                            submuscleMax = 10;
                            break;
                        case "medio":
                            //MAX
                            submuscleMax = 4;
                            break;
                        case "menor":
                            //MAX
                            submuscleMax = 3;
                            break;
                    }
                    break;
                case "mid-back":
                    switch (subcl){
                        case "esp.med.":
                            //MAX
                            if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                                submuscleMax = 7;
                            }else{
                                submuscleMax = 10;
                            }
                            break;
                    }
                    break;
                case "lumbar":
                    switch (subcl){
                        case "lateral":
                            //MAX
                            if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                                submuscleMax = 2;
                            }else{
                                submuscleMax = 3;
                            }
                            break;
                        case "normal":
                            //MAX
                            submuscleMax = 7;
                            break;
                    }
                    break;
                case "thigh":
                    switch (subcl){
                        case "global":
                            //MAX
                            submuscleMax = 4;
                            break;
                        case "local":
                            //MAX
                            submuscleMax = 7;
                            break;
                    }
                    break;
                case "triceps":
                    switch (subcl){
                        case "c.larga":
                            //MAX
                            submuscleMax = 6;
                            break;
                        case "c.lateral":
                            //MAX
                            submuscleMax = 5;
                            break;
                        case "c.media":
                            //MAX
                            submuscleMax = 2;
                            break;
                    }
                    break;
                case "upper-back":
                    switch (subcl){
                        case "rot.ext.":
                            //MAX
                            submuscleMax = 4;
                            break;
                        case "rot.int.":
                            //MAX
                            submuscleMax = 3;
                            break;
                        case "supraesp.":
                            //MAX
                            submuscleMax = 2;
                            break;
                    }
                    break;
            }
            //count exercises of that subclass to compare with maximum
            while(idx3<exercisesList.size()){
                if(exercisesList.get(idx3).getSubclasses().equals(subcl)){
                    //add in a list(x) exercises name of that submuscle we have in exercisesList
                    exercNames.add(exercisesList.get(idx3).getName());
                    countEx++;
                }
                idx3++;
            }
            //006 IF FULL, ADD SERIE
            int idx4 = 0;
            int minimum=1;
            boolean first = true;
            if(!(countEx<submuscleMax)){
                //check MINIMUM SERIES (to add to first minimum) subcl
                //get minimum
                while(idx4<exercisesList.size()){
                    if(muscle.equals(exercisesList.get(idx4).getMuscle_zone())){
                        if(subcl.equals(exercisesList.get(idx4).getSubclasses())){
                            if(first){
                                minimum = Integer.parseInt(exercisesList.get(idx4).getSeries());
                                first = false;
                            }else{
                                minimum = Math.min(minimum, Integer.parseInt(exercisesList.get(idx4).getSeries()));
                            }
                        }
                    }
                    idx4++;
                }
                //get first with minimum, add a serie
                idx4 = 0;
                while(idx4<exercisesList.size()){
                    if(muscle.equals(exercisesList.get(idx4).getMuscle_zone())){
                        if(subcl.equals(exercisesList.get(idx4).getSubclasses())){
                            if(Integer.parseInt(exercisesList.get(idx4).getSeries())==minimum){
                                minimum++;
                                exercisesList.get(idx4).setSeries(Integer.toString(minimum));
                                break;
                            }
                        }
                    }
                    idx4++;
                }

            //007 ELSE, ADD EXERCISE "NEW" FROM THAT SUBCLASS (else)
                //"NEW" exercise of that subclass without muscle name in that list(x)
            }else{
                String query2 = "";
                //if objective=resistencia or level=1/2 don't get "hard" exercises
                int idxAux2 = 0;
                if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
                    //get only from selected submuscle and muscle and exercises names list
                    query2 = "SELECT * FROM Exercises WHERE level LIKE '' AND muscle_zone LIKE '"+muscle+"' AND subclasses LIKE '"+subcl+"' AND ";
                    query2 += "name NOT IN ('";
                    while(idxAux2 < exercNames.size()){
                        //last one, add )
                        if(idxAux2 == exercNames.size()-1){
                            query2 += exercNames.get(idxAux2)+"') ORDER BY RANDOM() LIMIT 1";
                        }else{
                            query2 += exercNames.get(idxAux2)+"', '";
                        }
                        idxAux2++;
                    }
                }else{
                    query2 = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+muscle+"' AND subclasses LIKE '"+subcl+"' AND ";
                    query2 += "name NOT IN ('";
                    while(idxAux2 < exercNames.size()){
                        //last one, add )
                        if(idxAux2 == exercNames.size()-1){
                            query2 += exercNames.get(idxAux2)+"') ORDER BY RANDOM() LIMIT 1";
                        }else{
                            query2 += exercNames.get(idxAux2)+"', '";
                        }
                        idxAux2++;
                    }
                }

                Cursor c2 = db.rawQuery(query2, null);
                //add exercises to array list
                if (c2.moveToFirst()) {
                    //go over cursor until the end
                    do {
                        Exercise currentExercise = new Exercise(c2.getInt(0), c2.getString(1), c2.getString(2), c2.getString(3), c2.getString(4), c2.getString(5), c2.getString(6), c2.getString(7), c2.getString(8), c2.getString(9), c2.getString(10), c2.getString(11), c2.getString(12));
                        exercisesList.add(currentExercise);

                    } while(c2.moveToNext());
                }
            }


        }


    }





    public void addMuscleRemaining(){
        //get the list of that muscle we got in exerciseslist



    }









    public void changeExercise (View view){



        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 37);
        SQLiteDatabase db = exdb.getWritableDatabase();

        int index = counter;
        String exerciseName = exercisesList.get(index).getName();
        String exerciseCategory = exercisesList.get(index).getMuscle_zone();
        String exercSubmuscle = exercisesList.get(index).getSubclasses();
        int series = Integer.parseInt(exercisesList.get(index).getSeries());

        String query="";
        //find a new exercise (different from that) (and not existing in the list)
        if(objectivestring.equals("Definición")|| levelstring.equals("1.- Básico")||levelstring.equals("2.- En forma")){
            query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+exerciseCategory+"'AND subclasses LIKE '"+exercSubmuscle+"' AND level LIKE '' AND name NOT IN ('"+exerciseName+"') ORDER BY RANDOM() LIMIT 1";
        }else{
            query = "SELECT * FROM Exercises WHERE muscle_zone LIKE '"+exerciseCategory+"' AND subclasses LIKE '"+exercSubmuscle+"' AND name NOT IN ('"+exerciseName+"') ORDER BY RANDOM() LIMIT 1";
        }

        Cursor c = db.rawQuery(query, null);
        //change exercise
        if (c.moveToFirst()) {
            do {
                Exercise currentExercise = new Exercise(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getString(6), c.getString(7), c.getString(8), c.getString(9), c.getString(10), c.getString(11), Integer.toString(series));
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
        TextView uppertext3 = findViewById(R.id.textView13);
        uppertext3.setText(exercisesList.get(counter).getSeries()+" SERIE");


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

    //initial condition: only 2 muscles in exercisesList
    public void superserie2(String muscle1, String muscle2) {

        //001 split in two arraylists, one of each muscle
        ArrayList<Exercise> muscle1List = new ArrayList<>();
        ArrayList<Exercise> muscle2List = new ArrayList<>();

        int idx8 = 0;
        while(idx8<exercisesList.size()){
            if(exercisesList.get(idx8).getMuscle_zone().equals(muscle1)){
                muscle1List.add(exercisesList.get(idx8));
            }else{
                muscle2List.add(exercisesList.get(idx8));
            }
            idx8++;
        }

        //002 combine 2 lists alterned
        exercisesList.clear();
        int idxMusc1 = 0;
        int idxMusc2= 0;
        int idxAlternate = 1;
        while ((idxMusc1<muscle1List.size())&&(idxMusc2<muscle2List.size())){
            if(idxAlternate==1){
                exercisesList.add(muscle1List.get(idxMusc1));
                idxMusc1++;
                idxAlternate = 2;
            }else{
                exercisesList.add(muscle2List.get(idxMusc2));
                idxMusc2++;
                idxAlternate=1;
            }
        }
        //remaining, not alternating, just last ones
        if(idxMusc1<muscle1List.size()){
            while(idxMusc1<muscle1List.size()){
                exercisesList.add(muscle1List.get(idxMusc1));
                idxMusc1++;
            }
        }else{
            while(idxMusc2<muscle2List.size()){
                exercisesList.add(muscle2List.get(idxMusc2));
                idxMusc2++;
            }
        }

    }

}
