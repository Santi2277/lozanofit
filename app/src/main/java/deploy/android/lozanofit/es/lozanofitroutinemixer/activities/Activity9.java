package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity9 extends AppCompatActivity {

    String name = "";
    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9);

        profileid = getIntent().getIntExtra("profileid", 0);

    }

    public void goToAct8 (View view){
        Intent intent = new Intent (this, Activity8.class);
        startActivity(intent);

    }

    public void goToAct10 (View view){
        Intent intent = new Intent (this, Activity10.class);


        TextInputEditText nameInput = findViewById(R.id.textInput001);
        name = nameInput.getText().toString();
        intent.putExtra("name", name);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

}
