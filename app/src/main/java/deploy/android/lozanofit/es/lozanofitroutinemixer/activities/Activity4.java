package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity4 extends AppCompatActivity {

    public String timestring = "";
    public String levelstring = "";
    public String bodystring = "";
    public String objectivestring = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

    }



    public void goToMain (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }


}
