package deploy.android.lozanofit.es.lozanofitroutinemixer.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

import deploy.android.lozanofit.es.lozanofitroutinemixer.R;
import deploy.android.lozanofit.es.lozanofitroutinemixer.classes.MyDayDecorator;
import deploy.android.lozanofit.es.lozanofitroutinemixer.sqlite.ExercisesDB;

public class Activity16 extends AppCompatActivity {

    int profileid = 0;
    ArrayList<CalendarDay> caldays = new ArrayList<CalendarDay>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_16);

        profileid = getIntent().getIntExtra("profileid", 0);

        MaterialCalendarView materialcalendar = (MaterialCalendarView) findViewById(R.id.calendarView);

        //today
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(currentTime);
        String[] parts = strDate.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);


        materialcalendar.setDateSelected(CalendarDay.from(year, month, day), true);


        //get days to be selected
        ExercisesDB exdb = new ExercisesDB(this, "DBExercises", null, 43);
        SQLiteDatabase db = exdb.getWritableDatabase();
        String query3 = "SELECT * FROM Calendar WHERE profile_id = "+profileid+";";
        Cursor c3 = db.rawQuery(query3, null);
        if (c3.moveToFirst()) {
            //go over cursor until there are no more entries
            do {

                String calday = c3.getString(3);
                String[] parts2 = calday.split("-");
                int year2 = Integer.parseInt(parts2[0]);
                int month2 = Integer.parseInt(parts2[1]);
                int day2 = Integer.parseInt(parts2[2]);

                caldays.add(CalendarDay.from(year2, month2, day2));

            } while(c3.moveToNext());
        }






        //caldays.add(CalendarDay.from(2019, 9, 3));
        //caldays.add(CalendarDay.from(2019, 9, 5));

        materialcalendar.addDecorator(new MyDayDecorator( caldays));


    }



    public void goToAct15 (View view){
        Intent intent = new Intent (this, Activity15.class);
        intent.putExtra("profileid", profileid);
        startActivity(intent);

    }


}
