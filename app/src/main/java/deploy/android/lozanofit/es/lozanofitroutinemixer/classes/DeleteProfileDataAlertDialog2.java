package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.app.Dialog;
import android.content.DialogInterface;
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

import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class DeleteProfileDataAlertDialog2 extends DialogFragment {

    boolean exercisedtoday = false;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Se eliminarán todas las rutinas del calendario de este perfil.")
                .setTitle("Borrar rutinas. ¿Seguro?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //action to de done
                        //delete profile routines, if there exists

                        int profileid = getActivity().getIntent().getIntExtra("profileid", 0);

                        ExercisesDB exdb = new ExercisesDB(getContext(), "DBExercises", null, 43);
                        SQLiteDatabase db = exdb.getWritableDatabase();

                        String query2 = "SELECT * FROM Calendar WHERE profile_id = "+profileid+";";
                        Cursor c2 = db.rawQuery(query2, null);
                        //note: maybe always move to first even without entries?¿ (to test)
                        if (c2.moveToFirst()) {
                            //boolean to not create new routine for today
                            exercisedtoday = true;

                        }

                        if(exercisedtoday){
                            //delete today's routine

                            db.execSQL("DELETE FROM Calendar WHERE profile_id = "+profileid+";");
                            //update currentday
                            db.execSQL("UPDATE Profile SET currentday = 1 WHERE id = "+profileid+";");

                            Toast toast1 = Toast.makeText(getContext(),
                                    "Rutinas borradas.", Toast.LENGTH_LONG);
                            toast1.show();

                            //go out of dialog
                            dialog.cancel();


                        }else{
                            //show message not exercised go back
                            Toast toast1 = Toast.makeText(getContext(),
                                    "No había rutinas.", Toast.LENGTH_LONG);
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
