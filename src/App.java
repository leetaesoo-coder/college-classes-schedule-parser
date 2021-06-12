import composite_lessons.Schedule;
import db.Inserter;

import java.io.IOException;
import java.sql.SQLException;

// vreo 1230 linii, ebati

public class App {
    public static void main(String[] args) {

        // parse the data
        ScheduleDirector scheduleDirector = new ScheduleDirector();
        scheduleDirector.get("P-1923", 2000);
        
        Schedule schedule = scheduleDirector.getSchedule();

        // insert into database
        Inserter inserter;

        try {

            inserter = new Inserter();
            inserter.addRows(schedule.toRows());
            
            inserter.insert();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("finished!");

    }

}

