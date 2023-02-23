package ru.swamptea.edujira.entity;

import java.util.Map;

public class Update {
    Map<String, String>[] summary;

    public Map<String, String>[] getSummary() {
        return summary;
    }

    public void setSummary(Map<String, String>[] summary) {
        this.summary = summary;
    }

    public Update() {
    }

    public Update(Map<String, String>[] summary) {
        this.summary = summary;
    }
}
