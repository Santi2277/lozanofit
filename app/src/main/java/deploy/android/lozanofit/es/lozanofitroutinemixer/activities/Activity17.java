package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity17 extends AppCompatActivity {

    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_17);

        profileid = getIntent().getIntExtra("profileid", 0);


    }


    public void goToAct16 (View view){
        Intent intent = new Intent (this, Activity16.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


}
