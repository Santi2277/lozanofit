package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Act2EndingAlertDialog;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.DeleteProfileDataAlertDialog;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.DeleteProfileDataAlertDialog2;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.DeleteProfileDataAlertDialog3;

public class Activity18 extends AppCompatActivity {

    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_18);

        profileid = getIntent().getIntExtra("profileid", 0);

    }





    public void goToAct19 (View view){

        Intent intent = new Intent (this, Activity19.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {

        Intent intent = new Intent (this, Activity19.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


    public void DeleteRoutineDay (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DeleteProfileDataAlertDialog dialogo = new DeleteProfileDataAlertDialog();
        dialogo.show(fragmentManager, "tagAlerta");

    }

    public void DeleteRoutines (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DeleteProfileDataAlertDialog2 dialogo = new DeleteProfileDataAlertDialog2();
        dialogo.show(fragmentManager, "tagAlerta");

    }

    public void DeleteProfile (View view){

        FragmentManager fragmentManager = getSupportFragmentManager();
        DeleteProfileDataAlertDialog3 dialogo = new DeleteProfileDataAlertDialog3();
        dialogo.show(fragmentManager, "tagAlerta");
    }





}
