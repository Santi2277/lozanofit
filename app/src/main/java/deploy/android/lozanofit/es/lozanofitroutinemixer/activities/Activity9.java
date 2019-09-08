package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity9 extends AppCompatActivity {

    String name = "";
    int profileid = 0;
    int comingfromprofile = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        profileid = getIntent().getIntExtra("profileid", 0);
        comingfromprofile = getIntent().getIntExtra("comingfromprofile", 0);

        if(comingfromprofile == 1){
            TextView textviewtitle = findViewById(R.id.textView30);
            textviewtitle.setText("Nombre:");
        }



    }

    public void goToAct8 (View view){
        if(comingfromprofile == 0){
            Intent intent = new Intent (this, Activity8.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, Activity15.class);
            intent.putExtra("profileid", profileid);
            startActivity(intent);
        }


    }

    public void goToAct10 (View view){
        Intent intent = new Intent (this, Activity10.class);


        TextInputEditText nameInput = findViewById(R.id.textInput001);
        name = nameInput.getText().toString();
        intent.putExtra("name", name);
        intent.putExtra("profileid", profileid);
        intent.putExtra("comingfromprofile", comingfromprofile);
        startActivity(intent);

    }

}
