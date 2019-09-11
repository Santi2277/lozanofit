package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity17 extends AppCompatActivity {

    int profileid = 0;
    String routineday = "";

    String calendardate = "";
    int profileweekdays;
    int profilecurrentday;
    String profiledayminutes = "";
    String profilestrengthlevel = "";
    String profileobjective = "";
    String profilemethod = "";
    String calendarmore = "";

    ArrayList<String> musclesSelected = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_17);

        profileid = getIntent().getIntExtra("profileid", 0);


        //get database data for that calendar day entry
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 43);
        SQLiteDatabase db = exdb.getWritableDatabase();

        routineday = getIntent().getStringExtra("calendarDay");

        String query2 = "SELECT id, profile_id, profile_name, calendardate, profile_weekdays, profile_currentday, profile_dayminutes, profile_strengthlevel, profile_objective, profile_method, profile_more, more FROM Calendar WHERE calendardate = '"+routineday+"' AND profile_id = "+profileid+";";
        Cursor c2 = db.rawQuery(query2, null);
        if (c2.moveToFirst()) {
            //get data
            calendardate= c2.getString(3);
            profileweekdays = c2.getInt(4);
            profilecurrentday = c2.getInt(5);
            profiledayminutes = c2.getString(6);
            profilestrengthlevel = c2.getString(7);
            profileobjective = c2.getString(8);
            profilemethod = c2.getString(9);
            //for muscle groups done (for now done with the later method not this)
            calendarmore = c2.getString(10);

        }

        whichMuscles(profileweekdays, profilecurrentday, profilemethod);
        calendarmore = musclesSelected.toString();

        TextView text = findViewById(R.id.textView175);
        text.setText("Fecha: "+calendardate+".\nDías a la semana: "+profileweekdays+".\nDía actual nº: "+profilecurrentday+".\nMinutos: "+profiledayminutes+".\nNivel de fuerza: "+profilestrengthlevel+".\nObjetivo: "+profileobjective+".\nMétodo: "+profilemethod+".\nMúsculos trabajados: "+calendarmore+".");


    }


    public void goToAct16 (View view){
        Intent intent = new Intent (this, Activity16.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        //go to act16
        Intent intent = new Intent (this, Activity16.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


    public void whichMuscles (int weekdays, int currentday, String method) {

        musclesSelected = new ArrayList<String>();

        switch(weekdays){
            case 1:
                musclesSelected.add("biceps");
                musclesSelected.add("pecho");
                musclesSelected.add("espalda media");
                musclesSelected.add("hombro");
                musclesSelected.add("espalda superior");
                musclesSelected.add("tríceps");
                musclesSelected.add("antebrazos");
                musclesSelected.add("lumbar");
                musclesSelected.add("abdominal");
                musclesSelected.add("glúteo");
                musclesSelected.add("pierna");
                musclesSelected.add("gemelos");
                break;
            case 2:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        break;
                    case 2:
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                }
                break;
            case 3:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        break;
                    case 2:
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        break;
                    case 3:
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                }
                break;
            case 4:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        break;
                    case 2:
                        musclesSelected.add("hombro");
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        break;
                    case 3:
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abdominal");
                        break;
                    case 4:
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                }
                break;
            case 5:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        break;
                    case 2:
                        musclesSelected.add("hombro");
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        break;
                    case 3:
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abdominal");
                        break;
                    case 4:
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                    case 5:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        break;
                }
                break;
            case 6:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        break;
                    case 2:
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        break;
                    case 3:
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                    case 4:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        break;
                    case 5:
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        break;
                    case 6:
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                }
                break;
            case 7:
                switch(currentday){
                    case 1:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        break;
                    case 2:
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        break;
                    case 3:
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                    case 4:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        break;
                    case 5:
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        musclesSelected.add("antebrazos");
                        musclesSelected.add("lumbar");
                        break;
                    case 6:
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        musclesSelected.add("gemelos");
                        break;
                    case 7:
                        musclesSelected.add("biceps");
                        musclesSelected.add("pecho");
                        musclesSelected.add("espalda media");
                        musclesSelected.add("hombro");
                        musclesSelected.add("espalda superior");
                        musclesSelected.add("tríceps");
                        musclesSelected.add("lumbar");
                        musclesSelected.add("abdominal");
                        musclesSelected.add("glúteo");
                        musclesSelected.add("pierna");
                        break;
                }
                break;
        }

        if(method.equals("Todos los músculos cada día")){
            musclesSelected = new ArrayList<String>();
            musclesSelected.add("biceps");
            musclesSelected.add("pecho");
            musclesSelected.add("espalda media");
            musclesSelected.add("hombro");
            musclesSelected.add("espalda superior");
            musclesSelected.add("tríceps");
            musclesSelected.add("antebrazos");
            musclesSelected.add("lumbar");
            musclesSelected.add("abdominal");
            musclesSelected.add("glúteo");
            musclesSelected.add("pierna");
            musclesSelected.add("gemelos");
        }





    }













}
