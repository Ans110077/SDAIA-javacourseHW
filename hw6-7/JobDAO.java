package org.example.dao;




import org.example.modle.Job;

import java.sql.*;
import java.util.ArrayList;

public class JobDAO {
    private static final String url = "jdbc:sqlite:C:\\Users\\dev\\IdeaProjects\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_JOBS = "SELECT * FROM jobs";
    private static final String SELECT_ONE_JOB = "SELECT * FROM jobs WHERE job_id = ?";
    private static final String INSERT_JOB = "INSERT INTO jobs VALUES (?, ?, ?, ?)";
    private static final String UPDATE_JOB = "UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";
    private static final String DELETE_JOB = "DELETE FROM jobs WHERE job_id = ?";
    private static final String SELECT_JOB_WITH_min_salary = "select * from jobs where main_salary = ? order by job_id limit ? offset ?";
    private static final String SELECT_JOB_WITH_max_salary = "select * from jobs order by job limit ? offset ?";

    public void insertJob(Job job) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement st = connection.prepareStatement(INSERT_JOB)) {
            st.setInt(1, job.getJob_id());
            st.setString(2, job.getJob_title());
            st.setDouble(3, job.getMin_salary());
            st.setDouble(4, job.getMax_salary());
            st.executeUpdate();
        }
    }

    public void updateJob(Job job) throws SQLException , ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement st = connection.prepareStatement(UPDATE_JOB)) {
            st.setString(1, job.getJob_title());
            st.setDouble(2, job.getMin_salary());
            st.setDouble(3, job.getMax_salary());
            st.setInt(4, job.getJob_id());
            st.executeUpdate();
        }
    }

    public void deleteJob(int job_id) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement st = connection.prepareStatement(DELETE_JOB)) {
            st.setInt(1, job_id);
            st.executeUpdate();
        }
    }

    public ArrayList<Job> selectAll() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement st = connection.prepareStatement(SELECT_ALL_JOBS);
             ResultSet rs = st.executeQuery()) {
            ArrayList<Job> jobs = new ArrayList<>();
            while (rs.next()) {
                jobs.add(new Job(rs));
            }
            return jobs;
        }
    }

    public Job selectJob(int job_id) throws SQLException , ClassNotFoundException{
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement st = connection.prepareStatement(SELECT_ONE_JOB)) {
            st.setInt(1, job_id);
            try (ResultSet rs = st.executeQuery()) {

                if (rs.next()) {
                    return new Job(rs);
                }
            }
        }
        return null;
    }

}
