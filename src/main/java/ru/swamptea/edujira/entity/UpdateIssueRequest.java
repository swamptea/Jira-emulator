package ru.swamptea.edujira.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateIssueRequest {
    Fields fields;
    Update update;

    public UpdateIssueRequest() {
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
