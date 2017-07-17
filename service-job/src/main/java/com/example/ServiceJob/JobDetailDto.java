package com.example.ServiceJob;

/**
 * Created by Administrator on 2017/7/17.
 */
public class JobDetailDto {
    private long jobId;
    private String jobTitle;
    private String description;

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
