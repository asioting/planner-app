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
public class Task implements Serializable {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = -4598255091796275629L;

    private Long id;

    private Long planId;
    
    private String description;

    private Integer duration;

    private List<Long> dependencies = new ArrayList<Long>();

    private Date startDate;

    private Date endDate;

    /**
     * 
     */
    public Task() {
        super();
    }

    /**
     * @param id
     * @param description
     * @param duration
     */
    public Task(Long id, String description, Integer duration) {
        super();
        this.id = id;
        this.description = description;
        this.duration = duration;
    }

    /**
     * @param id
     * @param description
     * @param duration
     * @param dependencies
     */
    public Task(Long id, String description, Integer duration, List<Long> dependencies) {
        super();
        this.id = id;
        this.description = description;
        this.duration = duration;
        this.dependencies = dependencies;
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
     * @return the planId
     */
    public Long getPlanId() {
        return planId;
    }

    /**
     * @param planId the planId to set
     */
    public void setPlanId(Long planId) {
        this.planId = planId;
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
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return the dependencies
     */
    public List<Long> getDependencies() {
        return dependencies;
    }

    /**
     * @param dependencies the dependencies to set
     */
    public void setDependencies(List<Long> dependencies) {
        this.dependencies = dependencies;
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
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
