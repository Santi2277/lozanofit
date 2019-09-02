package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);
    }

    public void goToMain (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }

    public void goToAct9 (View view){
        Intent intent = new Intent (this, Activity9.class);
        startActivity(intent);

    }

}
