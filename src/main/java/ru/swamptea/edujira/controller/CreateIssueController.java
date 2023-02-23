package ru.swamptea.edujira.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.swamptea.edujira.entity.*;
import ru.swamptea.edujira.modelResponse.CreateIssueResponse;
import ru.swamptea.edujira.modelResponse.CreateIssueSuccessResponse;
import ru.swamptea.edujira.modelResponse.CreateIssueFailedResponse;
import ru.swamptea.edujira.modelResponse.GetIssueResponse;

import java.util.*;


@RestController
@RequestMapping("/rest/api/2/issue")
public class CreateIssueController {

    private static int count = 0;
    org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CreateIssueController.class);
    @PostMapping
    public ResponseEntity<CreateIssueResponse> createIssue(@RequestBody CreateIssueRequest request) {

        Date date = new Date();
        int number = ++count;
        List<String> errorMessages = new ArrayList<>();
        Map<String, String> errors = new HashMap();

        if (ObjectUtils.isEmpty(request.getFields().getSummary())) {
            errorMessages.add("Field 'summary' is required");

        }
        if (request.getFields().getIssuetype().get("id") == null) {
            errorMessages.add("Field 'issuetype' is required");
        }
        if (request.getFields().getProject().get("id") == null) {
            errorMessages.add("Field 'project' is required");
        }
        if (!errorMessages.isEmpty()) {
            CreateIssueFailedResponse notCreateResponse = new CreateIssueFailedResponse(errors, errorMessages);
            logger.info("CREATE ISSUE: ID: " + number + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: BAD_REQUEST 400");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(notCreateResponse);
        }

        {
            String randomId = String.valueOf(randomNumBetweenBounds(100, 999));
            String randomKey = "TEST-" + randomNumBetweenBounds(100, 999);
            CreateIssueSuccessResponse createResponse = new CreateIssueSuccessResponse(randomId, randomKey);
            GetIssueResponse getResponse = new GetIssueResponse(number, String.valueOf(randomId), randomKey, request.getFields());
            Issues.issues.put(String.valueOf(randomId), getResponse);
            Issues.issues.put(String.valueOf(randomKey), getResponse);
            System.out.println("POST resp " + "\n" + randomId + "\n" + randomKey);
            logger.info("CREATE ISSUE: ID: " + number + " response time: " + (new Date().getTime() - date.getTime()) + "ms, response code: CREATED 201");
            return ResponseEntity.status(HttpStatus.CREATED).body(createResponse);
        }
    }

    public int randomNumBetweenBounds(int x, int y) {
        Random random = new Random();
        return random.nextInt(y - x + 1) + x;
    }
}
