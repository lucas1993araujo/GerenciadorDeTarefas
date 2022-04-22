
package model;

import java.util.Date;

/**
 *
 * @author Lucas
 */
public class Task {
    
    private int id;
    private int idProject;
    private String name;
    private String descripion;
    private String notes;
    private boolean isCompleted;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idProject, String name, String descripion, String notes, boolean isCompleted, Date deadline, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.descripion = descripion;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task(int id, int idProject, String name, String descripion, String notes, boolean isCompleted, Date deadline, Date createdAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.descripion = descripion;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
    }

    public Task(int id, int idProject, String name, String descripion, String notes, boolean isCompleted, Date deadline) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.descripion = descripion;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
    }

    public Task(int id, int idProject, String name, String descripion, String notes, boolean isCompleted) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.descripion = descripion;
        this.notes = notes;
        this.isCompleted = isCompleted;
    }

    public Task(int id, int idProject, String name, String descripion, String notes) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.descripion = descripion;
        this.notes = notes;
    }

    public Task(int id, int idProject, String name, String descripion) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.descripion = descripion;
    }

    public Task(int id, int idProject, String name) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
    }

    public Task(int id, int idProject) {
        this.id = id;
        this.idProject = idProject;
    }

    public Task(int id) {
        this.id = id;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", descripion=" + descripion + ", notes=" + notes + ", isCompleted=" + isCompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
    
    
    
}
