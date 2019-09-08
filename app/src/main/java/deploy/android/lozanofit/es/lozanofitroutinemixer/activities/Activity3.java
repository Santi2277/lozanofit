package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Exercise;

import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

import static java.lang.Math.toIntExact;

public class Activity3 extends AppCompatActivity {

    public ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();
    public int counter = 0;
    public String levelstring = "";
    public String objectivestring = "";
    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // parcelable
        exercisesList = getIntent().getParcelableArrayListExtra("key");

        profileid = getIntent().getIntExtra("profileid", 0);

        final ImageView gifview;
        gifview = (ImageView)findViewById(R.id.gifview);

        TextView text = findViewById(R.id.textView);
        TextView description = findViewById(R.id.textView5);
        counter = getIntent().getIntExtra("exerciseCounter", 0);


        text.setText(exercisesList.get(counter).getName());

        Glide
                .with(this) // replace with 'this' if it's in activity
                .load(exercisesList.get(counter).getVideo_path())
                .into(gifview);


        //exercisesList.get(counter).getVideo_path());
        description.setText(exercisesList.get(counter).getDescription());


        //get level selected and objective
        levelstring = getIntent().getStringExtra("selectedLevel");
        objectivestring = getIntent().getStringExtra("selectedObjective");

        //CHRONO don't stop
        String chronoCont = getIntent().getStringExtra("chronoText");
        final TextView simpleChrono = findViewById(R.id.chrono3);
        //simpleChrono.setText(chronoCont);

        String[] parts = chronoCont.split(":");
        String minutes = parts[0];
        String seconds = parts[1];

        int milis = (Integer.parseInt(minutes) * 60 + Integer.parseInt(seconds))*1000;

        new CountDownTimer(milis, 1000) {

            public void onTick(long millisUntilFinished) {
                long longnumb = millisUntilFinished / 1000;
                int numb = (int)longnumb;
                //Integer.toString(numb)
                int minutes = numb / 60;
                int seconds = numb % 60;
                DecimalFormat twodigits = new DecimalFormat("00");
                simpleChrono.setText(Integer.toString(minutes)+":"+twodigits.format(seconds));
            }

            public void onFinish() {
                simpleChrono.setText("Champ!");
            }
        }.start();


    }



    public void goToActivity2 (View view){
        Intent intent = new Intent (this, Activity2.class);
        intent.putExtra("exerciseCounter", counter);
        //parcelable
        intent.putParcelableArrayListExtra("key", exercisesList);
        intent.putExtra("listCreated", true);

        TextView simpleChrono = findViewById(R.id.chrono3);
        String chronotext = (String) simpleChrono.getText();
        intent.putExtra("chronoText", chronotext);
        intent.putExtra("selectedLevel", levelstring);
        intent.putExtra("selectedObjective", objectivestring);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }

}
