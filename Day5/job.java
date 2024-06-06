package Day5;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class job {

    private int jobId;
    private String title;
    private double minSalary, maxSal;

    public job() {
    }

    public job(int jobId, String title, double minSalary, double maxSalary) {
        this.jobId = jobId;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSal = maxSalary;
    }

    public job(ResultSet rs) throws SQLException {
        jobId = rs.getInt("job_id");
        title = rs.getString("job_title");
        minSalary = rs.getDouble("min_salary");
        maxSal = rs.getDouble("max_salary");
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(double maxSal) {
        this.maxSal = maxSal;
    }

    @Override
    public String toString() {
        return "job{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", minSalary=" + minSalary +
                ", maxSal=" + maxSal +
                '}';
    }
}
