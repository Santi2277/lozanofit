package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity15;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Main2Activity;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class DeleteProfileDataAlertDialog extends DialogFragment {

    boolean exercisedtoday = false;
    int currentday;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Se eliminará la rutina de hoy del calendario de este perfil.")
                .setTitle("Borrar rutina. ¿Seguro?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //action to de done
                        //delete profile routine day, if there exists

                        int profileid = getActivity().getIntent().getIntExtra("profileid", 0);

                        ExercisesDB exdb = new ExercisesDB(getContext(), "DBExercises", null, 45);
                        SQLiteDatabase db = exdb.getWritableDatabase();

                        Date currentTime = Calendar.getInstance().getTime();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String today = dateFormat.format(currentTime);

                        String query2 = "SELECT id, profile_id, profile_name, calendardate, profile_weekdays, profile_currentday, profile_dayminutes, profile_strengthlevel, profile_objective, profile_method, profile_more, more FROM Calendar WHERE calendardate = '"+today+"' AND profile_id = "+profileid+";";
                        Cursor c2 = db.rawQuery(query2, null);
                        //note: maybe always move to first even without entries?¿ (to test)
                        if (c2.moveToFirst()) {
                            //boolean to not create new routine for today
                            exercisedtoday = true;
                            //get actual current day
                            currentday = c2.getInt(5);


                        }

                        if(exercisedtoday){
                            //delete today's routine

                            db.execSQL("DELETE FROM Calendar WHERE calendardate = '"+today+"' AND profile_id = "+profileid+";");
                            //update currentday
                            db.execSQL("UPDATE Profile SET currentday = "+currentday+" WHERE id = "+profileid+";");

                            Toast toast1 = Toast.makeText(getContext(),
                                    "Rutina borrada.", Toast.LENGTH_LONG);
                            toast1.show();

                            //go out of dialog
                            dialog.cancel();


                        }else{
                            //show message not exercised go back
                            Toast toast1 = Toast.makeText(getContext(),
                                    "No has entrenado hoy.", Toast.LENGTH_LONG);
                            toast1.show();

                            dialog.cancel();
                        }





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
