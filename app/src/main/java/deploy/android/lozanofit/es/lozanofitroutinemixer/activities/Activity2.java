package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity2 extends AppCompatActivity {

    public int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        counter = getIntent().getIntExtra("exerciseCounter", 2);

        int count = getIntent().getIntExtra("exerciseCounter", 2);
        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 3);
        SQLiteDatabase db = exdb.getWritableDatabase();
        if (count<13) {
            int counter2 = count +1;
            String[] args = new String[] {String.valueOf(counter2)};
            Cursor c = db.rawQuery(" SELECT * FROM Exercises WHERE id=? ", args);
            if (c.moveToFirst()) {
                text.setText(c.getString(1));
                Picasso
                        .with(this)
                        .load(c.getString(2))
                        .resize(1078, 958)
                        .into(image);
            }
        //539 and 479
        }



    }


    public void goToMainActivity (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }


    public void goToActivity3 (View view){
        Intent intent = new Intent (this, Activity3.class);
        intent.putExtra("exerciseCounter", counter);
        startActivity(intent);
    }







    public void nextExercise (View view){
        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 3);
        SQLiteDatabase db = exdb.getWritableDatabase();

        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        if (counter<12) {
            counter++;
            int counter2 = counter +1;
            String[] args = new String[] {String.valueOf(counter2)};
            Cursor c = db.rawQuery(" SELECT * FROM Exercises WHERE id=? ", args);
            if (c.moveToFirst()) {
                text.setText(c.getString(1));
                Picasso
                        .with(this)
                        .load(c.getString(2))
                        .resize(539, 479)
                        .into(image);
            }

        }
    }

    public void previousExercise (View view){
        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 3);
        SQLiteDatabase db = exdb.getWritableDatabase();

        TextView text = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        if (counter!=0) {
            counter--;
            int counter2 = counter +1;
            String[] args = new String[] {String.valueOf(counter2)};
            Cursor c = db.rawQuery(" SELECT * FROM Exercises WHERE id=? ", args);
            if (c.moveToFirst()) {
                text.setText(c.getString(1));
                Picasso
                        .with(this)
                        .load(c.getString(2))
                        .resize(539, 479)
                        .into(image);
            }
        }

    }


}
