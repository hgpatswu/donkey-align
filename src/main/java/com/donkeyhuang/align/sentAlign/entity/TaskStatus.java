package com.donkeyhuang.align.sentAlign.entity;

public class TaskStatus {

    private Boolean finished;

    private Boolean error;

    private Boolean canceled;

    private String stage;

    private String message;

    private Double percent;

    public TaskStatus() {

    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "finished=" + finished +
                ", error=" + error +
                ", Canceled=" + canceled +
                ", stage='" + stage + '\'' +
                ", message='" + message + '\'' +
                ", percent=" + percent +
                '}';
    }
}
