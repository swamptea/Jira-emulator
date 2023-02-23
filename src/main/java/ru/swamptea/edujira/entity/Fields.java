package ru.swamptea.edujira.entity;

import java.util.Map;

public class Fields {
    String summary;
    Map<String, String> issuetype;
    String description;
    Map<String, String> project;
    String[] labels;
    Map<String, String> priority;

    public Fields(){}

    public Fields(String summary, Map<String, String> issuetype, String description, Map<String, String> project,
                  String[] labels, Map<String, String> priority) {
        this.summary = summary;
        this.issuetype = issuetype;
        this.description = description;
        this.project = project;
        this.labels = labels;
        this.priority = priority;
    }

    public String getSummary(){
        return summary;
    }
    public Map<String, String> getIssuetype(){
        return issuetype;
    }
    public String getDescription(){
        return description;
    }
    public Map<String, String> getProject(){
        return project;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIssuetype(Map<String, String> issuetype) {
        this.issuetype = issuetype;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Map<String, String> project) {
        this.project = project;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Map<String, String> getPriority() {
        return priority;
    }

    public void setPriority(Map<String, String> priority) {
        this.priority = priority;
    }
}
