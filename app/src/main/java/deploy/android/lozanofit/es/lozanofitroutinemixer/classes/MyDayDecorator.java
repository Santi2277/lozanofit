package deploy.android.lozanofit.es.lozanofitroutinemixer.classes;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.HashSet;

public class MyDayDecorator implements DayViewDecorator {

    private final HashSet<CalendarDay> dates;

    public MyDayDecorator(Collection<CalendarDay> dates) {
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {

        view.addSpan(new StyleSpan(Typeface.BOLD));
        //view.addSpan(new RelativeSizeSpan(2.4f));
        view.addSpan(new DotSpan(7.5f, Color.BLUE));
    }





}
