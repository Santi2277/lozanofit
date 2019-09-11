package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity15;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity2;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Main2Activity;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.MainActivity;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Act2EndingAlertDialog extends DialogFragment{


    String name = "";
    int weekdays;
    int currentday;
    String dayminutes = "";
    String strengthlevel = "";
    String objective = "";
    String method = "";
    String more = "";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Volver al inicio guardando rutina en el calendario. ¿OK?")
                .setTitle("¡Felicidades! Rutina acabada")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        int profileid = getActivity().getIntent().getIntExtra("profileid", 0);

                        //add 1 to profile currentday, add routine to calendar table, go to act15 (from that profile)
                        //refresh database with new profile data
                        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
                        ExercisesDB exdb = new ExercisesDB(getContext(), "DBExercises", null, 43);
                        SQLiteDatabase db = exdb.getWritableDatabase();

                        //get data from that profile
                        String query = "SELECT id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more FROM profile ORDER BY id";
                        Cursor c = db.rawQuery(query, null);

                        //check there's at least one entry
                        if (c.moveToFirst()) {
                            //go over cursor until there are no more entries
                            do {
                                int dbid= c.getInt(0);

                                if(profileid == dbid){
                                    name= c.getString(1);
                                    weekdays = c.getInt(2);
                                    currentday = c.getInt(3);
                                    dayminutes = c.getString(4);
                                    strengthlevel = c.getString(5);
                                    objective = c.getString(6);
                                    method = c.getString(7);
                                    more = c.getString(9);

                                }

                            } while(c.moveToNext());
                        }

                        int calendarcurrentday = currentday;
                        //update currentday
                        if(currentday == weekdays){
                            currentday=0;
                        }else{
                            currentday++;
                        }


                        //update current days in database
                        db.execSQL("UPDATE Profile SET currentday = "+currentday+" WHERE id ="+profileid);

                        //add entry to calendar table

                        //calendar date
                        Date currentTime = Calendar.getInstance().getTime();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String strDate = dateFormat.format(currentTime);

                        //create calendar id
                        String calendarid;
                        calendarid = Integer.toString(profileid) +" "+ strDate;


                        db.execSQL("INSERT INTO Calendar (id, profile_id, profile_name, calendardate, profile_weekdays, profile_currentday, profile_dayminutes, profile_strengthlevel, profile_objective, profile_method, profile_more, more) VALUES ('"+calendarid+"', "+profileid+", '"+name+"', '"+strDate+"', "+weekdays+", "+calendarcurrentday+", '"+dayminutes+"', '"+strengthlevel+"', '"+objective+"', '"+method+"', '"+more+"', null)");

                        Toast toast1 = Toast.makeText(getContext(),
                                "Rutina guardada.", Toast.LENGTH_LONG);
                        toast1.show();




                        Intent intent = new Intent (getActivity(), Activity15.class);
                        intent.putExtra("profileid", profileid);
                        startActivity(intent);




                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Log.i("Dialogos", "Confirmacion Cancelada.");
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
