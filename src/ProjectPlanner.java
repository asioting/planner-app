import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Audiebert Sioting
 *
 */
public class ProjectPlanner {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Plan plan = new Plan(1L, "Plan 1", DATE_FORMAT.parse("2020-01-27"));
        List<Task> tasks = plan.getTasks();
        tasks.add(new Task(1L, "Task 1", 1));
        tasks.add(new Task(2L, "Task 2", 5, Arrays.asList(1L)));
        tasks.add(new Task(3L, "Task 3", 3, Arrays.asList(1L)));
        tasks.add(new Task(4L, "Task 4", 2, Arrays.asList(1L, 2L)));
        tasks.add(new Task(5L, "Task 5", 2, Arrays.asList(2L, 3L)));
        tasks.add(new Task(6L, "Task 6", 2));
        tasks.add(new Task(7L, "Task 7", 4, Arrays.asList(2L, 3L, 4L)));
        tasks.add(new Task(8L, "Task 8", 3, Arrays.asList(6L, 7L)));
        generateSchedule(plan);
        plan.getTasks().stream().filter(t -> t.getStartDate() != null && t.getEndDate() != null)
                .forEach(t -> System.out.println("Task ID = " + t.getId() + "; description = " + t.getDescription()
                        + "; duration = " + t.getDuration() + "; dependencies = "
                        + Arrays.toString(t.getDependencies().toArray()) + "; startDate = "
                        + DATE_FORMAT.format(t.getStartDate()) + "; endDate = " + DATE_FORMAT.format(t.getEndDate())));
    }

    /**
     * @param plan
     */
    private static void generateSchedule(Plan plan) {
        Calendar calendar = Calendar.getInstance();
        for (Task task : plan.getTasks()) {
            if (task.getDependencies().isEmpty()) {
                calendar.setTime(plan.getStartDate());
                calendar.add(Calendar.DATE, task.getDuration() - 1);
                task.setStartDate(plan.getStartDate());
                task.setEndDate(calendar.getTime());
            } else {
                Date latestEndDate = null;
                for (Long id : task.getDependencies()) {
                    Date endDate = plan.getTasks().stream().filter(t -> t.getId().equals(id)).findFirst().get()
                            .getEndDate();
                    if (latestEndDate == null || endDate.compareTo(latestEndDate) >= 0) {
                        latestEndDate = endDate;
                    }
                }
                calendar.setTime(latestEndDate);
                calendar.add(Calendar.DATE, 1);
                task.setStartDate(calendar.getTime());
                calendar.setTime(latestEndDate);
                calendar.add(Calendar.DATE, task.getDuration());
                task.setEndDate(calendar.getTime());
            }
        }
    }

}
