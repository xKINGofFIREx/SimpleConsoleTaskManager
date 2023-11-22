package model;

import java.time.LocalDateTime;

public class Task {
    private long id;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime creationDateTime;

    public Task(long id, String name, String description, Status status, LocalDateTime creationDateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDateTime = creationDateTime;
    }
    public Task() {}

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreationDateTime() {
        return this.creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }
}