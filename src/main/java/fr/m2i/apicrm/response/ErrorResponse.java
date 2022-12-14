package fr.m2i.apicrm.response;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String time;
    private String error;
    private int status;
    private String path;

    public ErrorResponse(String error, int status, String path) {
        this.time = LocalDateTime.now().toString();
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
