package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity15 extends AppCompatActivity {

    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_15);

        profileid = getIntent().getIntExtra("profileid", 0);

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 40);
        SQLiteDatabase db = exdb.getWritableDatabase();

        String query = "SELECT id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more FROM profile ORDER BY id";
        Cursor c = db.rawQuery(query, null);

        //check there's at least one entry
        if (c.moveToFirst()) {
            //go over cursor until there are no more entries
            do {
                int dbid= c.getInt(0);
                String name= c.getString(1);

                TextView textviewtitle = findViewById(R.id.textView133);

                if(profileid == dbid){
                    textviewtitle.setText(name);
                }

            } while(c.moveToNext());
        }


    }


    public void goToAct8 (View view){
        Intent intent = new Intent (this, Activity8.class);
        startActivity(intent);

    }


    public void goToMain2 (View view){

        Intent intent = new Intent (this, Main2Activity.class);
        startActivity(intent);

    }


}
