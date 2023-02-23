package ru.swamptea.edujira.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import ru.swamptea.edujira.entity.Issues;
import ru.swamptea.edujira.entity.UpdateIssueRequest;

import java.util.Date;

@RestController
@RequestMapping("/rest/api/2/issue/{issueIdOrKey}")
public class UpdateIssueController {

    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UpdateIssueController.class);
    @PutMapping
    public ResponseEntity<UpdateIssueRequest> updateIssue(@PathVariable String issueIdOrKey, @RequestBody UpdateIssueRequest request) {

        Date date = new Date();
        if (Issues.issues.containsKey(issueIdOrKey)) {

            int number = Issues.issues.get(issueIdOrKey).getNumber();
            if (request.getFields().getProject().get("id") != null)
                Issues.issues.get(issueIdOrKey).getFields().getProject().put("id", request.getFields().getProject().get("id"));
            if (request.getUpdate().getSummary()[0].get("set") != null)
                Issues.issues.get(issueIdOrKey).getFields().setSummary(request.getUpdate().getSummary()[0].get("set"));
            if (request.getFields().getIssuetype().get("id") != null)
                Issues.issues.get(issueIdOrKey).getFields().getIssuetype().put("id", request.getFields().getIssuetype().get("id"));
            if (!ObjectUtils.isEmpty(request.getFields().getDescription()))
                Issues.issues.get(issueIdOrKey).getFields().setDescription(request.getFields().getDescription());
            if (request.getFields().getPriority().get("id") != null)
                Issues.issues.get(issueIdOrKey).getFields().getPriority().put("id", request.getFields().getPriority().get("id"));
            if (request.getFields().getLabels() != null)
                Issues.issues.get(issueIdOrKey).getFields().setLabels(request.getFields().getLabels());
            logger.info("UPDATE ISSUE: ID: " + number + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: NO_CONTENT 204");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(request);
        } else
            logger.info("UPDATE ISSUE: ID: - " + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: BAD_REQUEST 400");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
