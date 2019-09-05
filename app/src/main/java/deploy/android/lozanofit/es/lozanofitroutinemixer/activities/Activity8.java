package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity8 extends AppCompatActivity {

    int default1 = 1;
    int default2 = 1;
    int default3 = 1;
    int default4 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);

        //OPEN db in writable mode (it CREATES db if it doesnt exist or UPGRADES if version is lower)
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 40);
        SQLiteDatabase db = exdb.getWritableDatabase();

        String query = "SELECT id, name, weekdays, currentday, dayminutes, strengthlevel, objective, method, def, more FROM profile ORDER BY id";
        Cursor c = db.rawQuery(query, null);

        int idx = 1;

        //check there's at least one entry
        if (c.moveToFirst()) {
            //go over cursor until there are no more entries
            do {
                String name= c.getString(1);

                Button buttonIdx = findViewById(R.id.button881);

                switch(idx){
                    case 1:
                        buttonIdx = findViewById(R.id.button881);
                        default1 = c.getInt(8);
                        break;
                    case 2:
                        buttonIdx = findViewById(R.id.button882);
                        default2 = c.getInt(8);
                        break;
                    case 3:
                        buttonIdx = findViewById(R.id.button883);
                        default3 = c.getInt(8);
                        break;
                    case 4:
                        buttonIdx = findViewById(R.id.button884);
                        default4 = c.getInt(8);
                        break;
                    default:
                        break;
                }
                buttonIdx.setText(name);
                idx++;

            } while(c.moveToNext());
        }


    }

    public void goToMain (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }

    public void goToAct91 (View view){

        if(default1==1){
            Intent intent = new Intent (this, Activity9.class);
            intent.putExtra("profileid", 1);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, Activity15.class);
            intent.putExtra("profileid", 1);
            startActivity(intent);
        }

    }

    public void goToAct92 (View view){

        if(default2==1){
            Intent intent = new Intent (this, Activity9.class);
            intent.putExtra("profileid", 2);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, Activity15.class);
            intent.putExtra("profileid", 2);
            startActivity(intent);
        }


    }

    public void goToAct93 (View view){

        if(default3==1){
            Intent intent = new Intent (this, Activity9.class);
            intent.putExtra("profileid", 3);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, Activity15.class);
            intent.putExtra("profileid", 3);
            startActivity(intent);
        }



    }

    public void goToAct94 (View view){

        if(default4==1){
            Intent intent = new Intent (this, Activity9.class);
            intent.putExtra("profileid", 4);
            startActivity(intent);
        }else{
            Intent intent = new Intent (this, Activity15.class);
            intent.putExtra("profileid", 4);
            startActivity(intent);
        }



    }

}
