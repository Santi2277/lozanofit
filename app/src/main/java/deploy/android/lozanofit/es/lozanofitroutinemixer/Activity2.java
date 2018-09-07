package deploy.android.lozanofit.es.lozanofitroutinemixer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }


    public void goToMainActivity (View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    public void nextExercise (View view){
        TextView text = findViewById(R.id.textView4);
        if (counter<3) {
            counter++;
            switch (counter) {
                case 0:

                    break;
                case 1:
                    text.setText("CONC CURL");
                    break;
                case 2:
                    text.setText("DUMB SCOTT B");
                    break;
                case 3:
                    text.setText("DUMB SC. B Z");
                    break;
            }
        }
    }

    public void previousExercise (View view){
        TextView text = findViewById(R.id.textView4);
        if (counter!=0) {
            counter--;
            switch (counter) {
                case 0:
                    text.setText("biceps curl");
                    break;
                case 1:
                    text.setText("CONC CURL");
                    break;
                case 2:
                    text.setText("DUMB SCOTT B");
                    break;
                case 3:

                    break;
            }
        }
    }


}
