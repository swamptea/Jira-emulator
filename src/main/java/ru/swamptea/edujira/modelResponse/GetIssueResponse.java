package ru.swamptea.edujira.modelResponse;

import org.springframework.web.bind.annotation.ResponseBody;
import ru.swamptea.edujira.entity.Fields;

@ResponseBody
public class GetIssueResponse {

    int number;
    String id;
    String key;
    Fields fields;

    public GetIssueResponse(int number, String id, String key, Fields fields) {
        this.number = number;
        this.id = id;
        this.key = key;
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
}
