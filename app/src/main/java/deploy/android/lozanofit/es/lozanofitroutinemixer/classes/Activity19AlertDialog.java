package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity15;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity18;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Main2Activity;

public class Activity19AlertDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Ten cuidado, podrás borrar las rutinas guardadas y el perfil")
                .setTitle("Acceder a la pantalla para borrar datos. ¿Seguro?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        int profileid = getActivity().getIntent().getIntExtra("profileid", 0);

                        Intent intent = new Intent (getActivity(), Activity18.class);
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
