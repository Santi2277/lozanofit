package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        final VideoView videoView;
        videoView = (VideoView)findViewById(R.id.videoView);


        TextView text = findViewById(R.id.textView);
        TextView description = findViewById(R.id.textView5);
        int id = getIntent().getIntExtra("exerciseCounter", 2);
        id = id +1;
        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 9);
        SQLiteDatabase db = exdb.getWritableDatabase();
        String[] args = new String[] {String.valueOf(id)};
        Cursor c = db.rawQuery(" SELECT * FROM Exercises WHERE id=? ", args);
        if (c.moveToFirst()) {
            text.setText(c.getString(1));
            videoView.setVideoPath(c.getString(3));
            videoView.start();
            description.setText(c.getString(4));
        }
    }



    public void goToActivity2 (View view){
        Intent intent = new Intent (this, Activity2.class);
        int count = getIntent().getIntExtra("exerciseCounter", 2);
        intent.putExtra("exerciseCounter", count);
        startActivity(intent);

    }

}
