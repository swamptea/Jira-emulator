package ru.swamptea.edujira.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.swamptea.edujira.entity.Issues;
import ru.swamptea.edujira.modelResponse.GetIssueResponse;

import java.util.Date;

@RestController
@RequestMapping("/rest/api/2/issue/{issueIdOrKey}")
public class GetIssueController {

    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(GetIssueController.class);

    @GetMapping
    public ResponseEntity<GetIssueResponse> getIssue(@PathVariable String issueIdOrKey) {

        Date date = new Date();
        if (Issues.issues.containsKey(issueIdOrKey)) {
            int number = Issues.issues.get(issueIdOrKey).getNumber();
            logger.info("GET ISSUE: ID: " + number + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: OK 200");
            return ResponseEntity.status(HttpStatus.OK).body(Issues.issues.get(issueIdOrKey));
        } else
            logger.info("GET ISSUE: ID: - " + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: NOT_FOUND 404");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}