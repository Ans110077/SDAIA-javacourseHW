package com.example;
package  Day6;

import jakarta.ws.rs.QueryParam;

public class JobFilterDto {
    private @QueryParam("jobTitle") String jobTitle;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}

