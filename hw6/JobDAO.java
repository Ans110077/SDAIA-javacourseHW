package  Day6;

import org.example.dto.JobFilterDto;
import org.example.models.Job;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {

    private static final String URL = "jdbc:sqlite:C:\\Users\\Majed\\Documents\\JAVA PROJECTS\\demo\\src\\main\\java\\com\\example\\hr.db";
    private static final String SELECT_ALL_JOBS = "select * from jobs";
    private static final String SELECT_ONE_JOB = "select * from jobs where job_id = ?";
    private static final String SELECT_JOB_WITH_TITLE = "select * from jobs where job_title = ?";
    private static final String SELECT_JOB_WITH_TITLE_PAGINATION = "select * from jobs where job_title = ? order by job_id limit ? offset ?";
    private static final String SELECT_JOB_WITH_PAGINATION = "select * from jobs order by job_id limit ? offset ?";
    private static final String INSERT_JOB = "insert into jobs values (?, ?, ?)";
    private static final String UPDATE_JOB = "update jobs set job_title = ?, min_salary = ?, max_salary = ? where job_id = ?";
    private static final String DELETE_JOB = "delete from jobs where job_id = ?";

    public void insertJob(Job j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(INSERT_JOB);
        st.setString(1, j.getJobId());
        st.setString(2, j.getJobTitle());
        st.setDouble(3, j.getMinSalary());
        st.setDouble(4, j.getMaxSalary());
        st.executeUpdate();
    }

    public void updateJob(Job j) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(UPDATE_JOB);
        st.setString(1, j.getJobTitle());
        st.setDouble(2, j.getMinSalary());
        st.setDouble(3, j.getMaxSalary());
        st.setString(4, j.getJobId());
        st.executeUpdate();
    }

    public void deleteJob(String jobId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(DELETE_JOB);
        st.setString(1, jobId);
        st.executeUpdate();
    }

    public Job selectJob(String jobId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_JOB);
        st.setString(1, jobId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return new Job(rs);
        } else {
            return null;
        }
    }

    public ArrayList<Job> selectAllJobs(JobFilterDto filter) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if (filter.getJobTitle() != null && filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_TITLE_PAGINATION);
            st.setString(1, filter.getJobTitle());
            st.setInt(2, filter.getLimit());
            st.setInt(3, filter.getOffset());
        } else if (filter.getJobTitle() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_TITLE);
            st.setString(1, filter.getJobTitle());
        } else if (filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_JOB_WITH_PAGINATION);
            st.setInt(1, filter.getLimit());
            st.setInt(2, filter.getOffset());
        } else {
            st = conn.prepareStatement(SELECT_ALL_JOBS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new Job(rs));
        }

        return jobs;
    }
}
