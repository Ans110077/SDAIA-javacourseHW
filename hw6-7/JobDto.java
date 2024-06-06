package org.example.dto;
//import jakarta.x.bind.annotation.XmlRootElement;
import org.glassfish.jersey.message.XmlHeader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//@XmlRootElement
public class JobDto {

    private int job_id;
    private String job_title;
    private double min_salary;
    private double max_salary;

    private ArrayList<LinkDto> links = new ArrayList<>();

    public JobDto(){

    }
    public JobDto(int job_id, String job_title ,Double min_salary , Double max_salary){
        this.job_id = job_id;
        this.job_title = job_title;
        this.min_salary = min_salary;
        this.max_salary = max_salary;
    }

    public int getJob_id() {
        return job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public double getMin_salary() {
        return min_salary;
    }

    public double getMax_salary() {
        return max_salary;
    }

    public ArrayList<LinkDto> getLinks() {
        return links;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setMin_salary(double min_salary) {
        this.min_salary = min_salary;
    }

    public void setMax_salary(double max_salary) {
        this.max_salary = max_salary;
    }

    public void setLinks(ArrayList<LinkDto> links) {
        this.links = links;
    }
    public void addLink(String url, String rel){
        LinkDto link = new LinkDto();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }


    @Override
    public String toString() {
        return "JobDto{" +
                "job_id=" + job_id +
                ", job_title='" + job_title + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                ", links=" + links +
                '}';
    }
}
