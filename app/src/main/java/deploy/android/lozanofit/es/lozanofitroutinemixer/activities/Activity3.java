package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Exercise;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

import static java.lang.Math.toIntExact;

public class Activity3 extends AppCompatActivity {

    public ArrayList<Exercise> exercisesList = new ArrayList<Exercise>();
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // parcelable
        exercisesList = getIntent().getParcelableArrayListExtra("key");

        final VideoView videoView;
        videoView = (VideoView)findViewById(R.id.videoView);

        TextView text = findViewById(R.id.textView);
        TextView description = findViewById(R.id.textView5);
        counter = getIntent().getIntExtra("exerciseCounter", 0);


        text.setText(exercisesList.get(counter).getName());
        videoView.setVideoPath(exercisesList.get(counter).getVideo_path());
        description.setText(exercisesList.get(counter).getDescription());
        videoView.start();


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
                int numb = toIntExact(millisUntilFinished / 1000);
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

        startActivity(intent);

    }

}
