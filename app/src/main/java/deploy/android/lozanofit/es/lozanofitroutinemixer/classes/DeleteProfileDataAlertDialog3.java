package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity8;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class DeleteProfileDataAlertDialog3 extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Este perfil y todas sus rutinas serán borradas.")
                .setTitle("Borrar perfil. ¿Seguro?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //action to de done
                        //delete profile, leave default profile, go back to profile selector page

                        int profileid = getActivity().getIntent().getIntExtra("profileid", 0);

                        ExercisesDB exdb = new ExercisesDB(getContext(), "DBExercises", null, 43);
                        SQLiteDatabase db = exdb.getWritableDatabase();


                        //delete and create (new default profile with same id)
                        switch(profileid){
                            case 1:
                                db.execSQL("UPDATE Profile SET name = 'perfil 1', weekdays= null, currentday = null, dayminutes = null, strengthlevel = null, objective = null, method = null, def = 1, more = null WHERE id = "+profileid+";");
                                break;
                            case 2:
                                db.execSQL("UPDATE Profile SET name = 'perfil 2', weekdays= null, currentday = null, dayminutes = null, strengthlevel = null, objective = null, method = null, def = 1, more = null WHERE id = "+profileid+";");
                                break;
                            case 3:
                                db.execSQL("UPDATE Profile SET name = 'perfil 3', weekdays= null, currentday = null, dayminutes = null, strengthlevel = null, objective = null, method = null, def = 1, more = null WHERE id = "+profileid+";");
                                break;
                            case 4:
                                db.execSQL("UPDATE Profile SET name = 'perfil 4', weekdays= null, currentday = null, dayminutes = null, strengthlevel = null, objective = null, method = null, def = 1, more = null WHERE id = "+profileid+";");
                                break;
                        }

                        //delete calendar entries
                        db.execSQL("DELETE FROM Calendar WHERE profile_id = "+profileid+";");

                        Toast toast1 = Toast.makeText(getContext(),
                                "Perfil borrado.", Toast.LENGTH_LONG);
                        toast1.show();

                        //go back to profile selector page (act8)
                        Intent intent = new Intent (getContext(), Activity8.class);
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
