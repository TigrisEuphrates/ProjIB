package autotest.core.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class CurrentDayFormatter {
    public static String addDaysToCurrentDate(int numberOfDates){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, numberOfDates); // Adding days
        return sdf.format(c.getTime());
    }
}
