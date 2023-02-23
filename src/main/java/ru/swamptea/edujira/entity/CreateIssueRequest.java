package ru.swamptea.edujira.entity;

public class CreateIssueRequest {

    Fields fields;

    public CreateIssueRequest() {
    }

    public CreateIssueRequest(Fields fields) {
        this.fields = fields;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
