package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity15;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity2;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Main2Activity;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.MainActivity;

public class Activity2AlertDialog extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¡Esta rutina será borrada!")
                .setTitle("Volver al inicio. ¿Seguro?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        int profileid = getActivity().getIntent().getIntExtra("profileid", 0);
                        if(profileid != 0){
                            Intent intent = new Intent (getActivity(), Activity15.class);
                            intent.putExtra("profileid", profileid);
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent (getActivity(), Main2Activity.class);
                            startActivity(intent);
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
