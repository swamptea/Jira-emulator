package ru.swamptea.edujira.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.swamptea.edujira.entity.Issues;

import java.util.Date;

@RestController
@RequestMapping("/rest/api/2/issue/{issueIdOrKey}")
public class DeleteIssueController {

    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DeleteIssueController.class);

    @DeleteMapping
    public ResponseEntity deleteIssue(@PathVariable String issueIdOrKey) {

        Date date = new Date();

        if (Issues.issues.containsKey(issueIdOrKey)) {
            int number = Issues.issues.get(issueIdOrKey).getNumber();
            String id = Issues.issues.get(issueIdOrKey).getId();
            String key = Issues.issues.get(issueIdOrKey).getKey();
            Issues.issues.remove(id);
            Issues.issues.remove(key);
            logger.info("DELETE ISSUE: ID: " + number + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: NO_CONTENT 204");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            logger.info("DELETE ISSUE: ID: - " + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: NOT_FOUND 404");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}