package listeners;

import org.testng.IExecutionListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExecutionTimeListener implements IExecutionListener {

    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        Date date = new Date(endTime);
        System.out.println("Inform all the suite have finished execution at"+ date);

    }

    @Override
    public void onExecutionStart() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Inform all the suite have started "+ dtf.format(now));

    }

}