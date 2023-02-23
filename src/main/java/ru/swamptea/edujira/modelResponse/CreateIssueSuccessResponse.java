package ru.swamptea.edujira.modelResponse;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class CreateIssueSuccessResponse extends CreateIssueResponse {

    String id;
    String key;

    public CreateIssueSuccessResponse() {
    }

    public CreateIssueSuccessResponse(String id, String key) {
        this.id = id;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
