package tn.esprit.spring.payload.request;

import tn.esprit.spring.entity.ClassType;

import java.sql.Timestamp;

public class EvalRequest {
    private int id;
    private String description;
    private Timestamp evaldate;
    private ClassType classes;
    private int evalUser;

    public EvalRequest() {
    }

    public EvalRequest(int id, String description, Timestamp evaldate, ClassType classes, int evalUser) {
        this.id = id;
        this.description = description;
        this.evaldate = evaldate;
        this.classes = classes;
        this.evalUser = evalUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getEvaldate() {
        return evaldate;
    }

    public void setEvaldate(Timestamp evaldate) {
        this.evaldate = evaldate;
    }

    public ClassType getClasses() {
        return classes;
    }

    public void setClasses(ClassType classes) {
        this.classes = classes;
    }

    public int getEvalUser() {
        return evalUser;
    }

    public void setEvalUser(int evalUser) {
        this.evalUser = evalUser;
    }
}