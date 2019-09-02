package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);
    }

    public void goToAct8 (View view){
        Intent intent = new Intent (this, Activity8.class);
        startActivity(intent);

    }

}
