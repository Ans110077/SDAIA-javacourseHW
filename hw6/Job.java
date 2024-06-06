package com.example;
package  Day6;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Job {
    private String jobId;
    private String jobTitle;
    private double minSalary;
    private double maxSalary;

    public Job(String jobId, String jobTitle, double minSalary, double maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Job(ResultSet rs) throws SQLException {
        this.jobId = rs.getString("job_id");
        this.jobTitle = rs.getString("job_title");
        this.minSalary = rs.getDouble("min_salary");
        this.maxSalary = rs.getDouble("max_salary");
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }
}
