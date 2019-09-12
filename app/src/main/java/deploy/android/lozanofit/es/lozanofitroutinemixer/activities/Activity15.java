package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity15 extends AppCompatActivity {

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
    boolean exercisedtoday = false;

    public String timestring = "";
    public String levelstring = "";
    public String bodystring = "";
    public String objectivestring = "";
    int count = 0;
    public ArrayList<String> musclesSelected = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_15);

        profileid = getIntent().getIntExtra("profileid", 0);

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 45);
        SQLiteDatabase db = exdb.getWritableDatabase();

        String query = "SELECT id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more FROM profile ORDER BY id";
        Cursor c = db.rawQuery(query, null);

        TextView textviewtitle = findViewById(R.id.textView133);

        //check there's at least one entry
        if (c.moveToFirst()) {
            //go over cursor until there are no more entries
            do {
                int dbid= c.getInt(0);

                if(profileid == dbid){
                    name= c.getString(1);
                    textviewtitle.setText(name);
                    weekdays = c.getInt(2);
                    currentday = c.getInt(3);
                    dayminutes = c.getString(4);
                    strengthlevel = c.getString(5);
                    objective = c.getString(6);
                    method = c.getString(7);
                    def = c.getInt(8);
                    more = c.getString(9);

                }

            } while(c.moveToNext());
        }


        //Check if it has already trained today

            //today is
        //calendar date
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(currentTime);

        String query2 = "SELECT * FROM Calendar WHERE calendardate = '"+today+"' AND profile_id = "+profileid+";";
        Cursor c2 = db.rawQuery(query2, null);
        //note: maybe always move to first even without entries?¿ (to test)
        if (c2.moveToFirst()) {
            //boolean to not create new routine for today
            exercisedtoday = true;
        }





    }


    public void goToAct8 (View view){
        Intent intent = new Intent (this, Activity8.class);
        startActivity(intent);

    }

    public void goToAct19 (View view){

        Intent intent = new Intent (this, Activity19.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);
    }


    public void goToMain2 (View view){

        Intent intent = new Intent (this, Main2Activity.class);
        startActivity(intent);

    }

    public void goToMain (View view){

        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        //go to profile selector activity
        Intent intent = new Intent (this, Activity8.class);
        startActivity(intent);

    }


    public void goToAct2 (View view){


        //get values for that profile
        //String[] minutesarray = dayminutes.split("/");

        switch(weekdays){
            case 1:
                musclesSelected.add("biceps");
                musclesSelected.add("chest");
                musclesSelected.add("mid-back");
                musclesSelected.add("deltoid");
                musclesSelected.add("upper-back");
                musclesSelected.add("triceps");
                musclesSelected.add("forearm");
                musclesSelected.add("lumbar");
                musclesSelected.add("abs");
                musclesSelected.add("glute");
                musclesSelected.add("thigh");
                musclesSelected.add("calf");
                break;
            case 2:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        break;
                    case 2:
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                }
                break;
            case 3:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        break;
                    case 2:
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        break;
                    case 3:
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                }
                break;
            case 4:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        break;
                    case 2:
                        musclesSelected.add("deltoid");
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        break;
                    case 3:
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abs");
                        break;
                    case 4:
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                }
                break;
            case 5:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        break;
                    case 2:
                        musclesSelected.add("deltoid");
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        break;
                    case 3:
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abs");
                        break;
                    case 4:
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                    case 5:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        break;
                }
                break;
            case 6:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        break;
                    case 2:
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        break;
                    case 3:
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                    case 4:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        break;
                    case 5:
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        break;
                    case 6:
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                }
                break;
            case 7:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        break;
                    case 2:
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        break;
                    case 3:
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                    case 4:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        break;
                    case 5:
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        musclesSelected.add("forearm");
                        musclesSelected.add("lumbar");
                        break;
                    case 6:
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        musclesSelected.add("calf");
                        break;
                    case 7:
                        musclesSelected.add("biceps");
                        musclesSelected.add("chest");
                        musclesSelected.add("mid-back");
                        musclesSelected.add("deltoid");
                        musclesSelected.add("upper-back");
                        musclesSelected.add("triceps");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abs");
                        musclesSelected.add("glute");
                        musclesSelected.add("thigh");
                        break;
                }
                break;
        }

        if(method.equals("Todos los músculos cada día")){
            musclesSelected = new ArrayList<String>();
            musclesSelected.add("biceps");
            musclesSelected.add("chest");
            musclesSelected.add("mid-back");
            musclesSelected.add("deltoid");
            musclesSelected.add("upper-back");
            musclesSelected.add("triceps");
            musclesSelected.add("forearm");
            musclesSelected.add("lumbar");
            musclesSelected.add("abs");
            musclesSelected.add("glute");
            musclesSelected.add("thigh");
            musclesSelected.add("calf");
        }


        if(!exercisedtoday){
            Intent intent = new Intent (this, Activity2.class);
            intent.putExtra("exerciseCounter", count);
            intent.putExtra("selectedTime", dayminutes);
            intent.putExtra("selectedLevel", strengthlevel);

            if(method.equals("Todos los músculos cada día")){
                intent.putExtra("selectedBodyPart", "Todo");
            }else{
                intent.putExtra("selectedBodyPart", "Músculo");
            }

            intent.putExtra("selectedObjective", objective);
            intent.putExtra("listCreated", false);
            intent.putExtra("musclesSelected", musclesSelected);
            intent.putExtra("profileid", profileid);
            startActivity(intent);
        }else{
            //no more routines for today
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Descansa. 1 rutina por día.", Toast.LENGTH_LONG);
            toast1.show();

        }

    }


    public void goToAct18 (View view){
        Intent intent = new Intent (this, Activity18.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


    public void goToAct16 (View view){
        Intent intent = new Intent (this, Activity16.class);
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
