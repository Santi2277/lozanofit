package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity15;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity19;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Activity8;
import deploy.android.lozanofit.es.lozanofitroutinemixer.activities.Main2Activity;

public class Activity9AlertDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("Los datos introducidos no serán guardados")
                .setTitle("Volver a perfil/es. ¿Seguro?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        int profileid = getActivity().getIntent().getIntExtra("profileid", 0);
                        int comingfromprofile = getActivity().getIntent().getIntExtra("comingfromprofile", 0);
                        //go to profile selector or one concrete profile screen
                        if(comingfromprofile == 0){
                            Intent intent = new Intent (getContext(), Activity8.class);
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent (getContext(), Activity19.class);
                            intent.putExtra("profileid", profileid);
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
