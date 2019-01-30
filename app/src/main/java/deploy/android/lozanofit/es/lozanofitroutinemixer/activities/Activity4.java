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

        objectivestring = getIntent().getStringExtra("selectedObjective");
        levelstring = getIntent().getStringExtra("selectedLevel");
        timestring = getIntent().getStringExtra("selectedTime");
        bodystring = getIntent().getStringExtra("selectedBodyPart");
    }



    public void goToMain (View view){
        Intent intent = new Intent (this, MainActivity.class);
        intent.putExtra("selectedTime", timestring);
        intent.putExtra("selectedLevel", levelstring);
        intent.putExtra("selectedBodyPart", bodystring);
        intent.putExtra("selectedObjective", objectivestring);
        startActivity(intent);

    }


}
