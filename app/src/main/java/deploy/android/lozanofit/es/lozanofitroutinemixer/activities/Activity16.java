package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;

public class Activity16 extends AppCompatActivity {

    int profileid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_16);

        profileid = getIntent().getIntExtra("profileid", 0);

        // get the reference of CalendarView and set Monday as the first day of the week
        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.calendarView01);
        simpleCalendarView.setFirstDayOfWeek(2);


    }



    public void goToAct15 (View view){
        Intent intent = new Intent (this, Activity15.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


}
