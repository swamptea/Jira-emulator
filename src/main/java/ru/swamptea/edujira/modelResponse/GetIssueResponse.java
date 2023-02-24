package ru.swamptea.edujira.modelResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import ru.swamptea.edujira.entity.Fields;

@ResponseBody
public class GetIssueResponse {
    int number;
    String id;
    String key;
    String self;
    Fields fields;

    public GetIssueResponse(int number, String id, String key, String self, Fields fields) {
        this.number = number;
        this.id = id;
        this.key = key;
        this.self = self;
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public Fields getFields() {
        return fields;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
