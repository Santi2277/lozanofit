package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.Exercise;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

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
    }



    public void goToActivity2 (View view){
        Intent intent = new Intent (this, Activity2.class);
        intent.putExtra("exerciseCounter", counter);
        //parcelable
        intent.putParcelableArrayListExtra("key", exercisesList);
        intent.putExtra("listCreated", true);
        startActivity(intent);

    }

}
