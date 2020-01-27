/**
 * 
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class Plan implements Serializable {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -5977188411679263684L;

    private Long id;

    private String description;

    private Date startDate;

    private List<Task> tasks = new ArrayList<Task>();

    /**
     * 
     */
    public Plan() {
        super();
    }

    /**
     * @param id
     * @param description
     * @param startDate
     */
    public Plan(Long id, String description, Date startDate) {
        super();
        this.id = id;
        this.description = description;
        this.startDate = startDate;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the tasks
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * @param tasks the tasks to set
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
