package ru.swamptea.edujira.modelResponse;

import java.util.List;
import java.util.Map;

public class CreateIssueFailedResponse extends CreateIssueResponse {
    List<String> errorMessages;
    Map<String, String> errors;


    public CreateIssueFailedResponse() {
    }

    public CreateIssueFailedResponse(Map<String, String> errors, List<String> errorMessages) {
        this.errors = errors;
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
