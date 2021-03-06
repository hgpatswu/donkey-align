package com.donkeyhuang.align.sentAlign.controller;

import com.donkeyhuang.align.sentAlign.entity.*;
import com.donkeyhuang.align.sentAlign.manager.SentAligner;
import com.donkeyhuang.commons.rest.RestRequest;
import com.donkeyhuang.commons.rest.RestResponse;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping(method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SentAlignController {

    private static final Logger LOG = LoggerFactory.getLogger(SentAlignController.class);

    @Autowired
    private SentAligner sentAligner;

    @RequestMapping(value = "align/sent", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<SentAlignResponse> alignSent(@Validated @RequestBody RestRequest<SentAlignRequest> param) {
        var request = param.getValue();
        if (request == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        LOG.info(request.toString());
        var response = sentAligner.alignSent(request);
        if (response != null) LOG.info(response.toString()); else LOG.info("response is null");


        return new RestResponse<>(response);
    }

    @RequestMapping(value = "align/sent/async", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<String> alignSentAsync(@Validated @RequestBody RestRequest<SentAlignRequest> param) {
        var request = param.getValue();
        if (request == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        LOG.info(request.toString());
        var response = sentAligner.alignSentAsync(request);
        if (response != null) LOG.info("taskId: {}", response); else LOG.info("taskId is null");


        return new RestResponse<>(response);
    }

    @RequestMapping(value = "align/sent/async/check", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<TaskStatus> checkAlignSentTask(@Validated @RequestBody RestRequest<String> param) {
        var taskId = param.getValue();
        if (taskId == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        var response = sentAligner.checkAlignSentTask(taskId);
        if (response != null) LOG.info("taskId: {}, check: {}", taskId, response); else LOG.info("failed to check task id: {}", taskId);

        return new RestResponse<>(response);
    }

    @RequestMapping(value = "align/sent/async/list", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<List<TaskStatus>> listAlignSentTask(@Validated @RequestBody RestRequest<String> param) {
        var response = sentAligner.listAlignSentTask();
        if (response != null) LOG.info("list: {}", response); else LOG.info("failed to list task id");

        return new RestResponse<>(response);
    }

    @RequestMapping(value = "align/sent/async/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<Boolean> deleteAlignSentTask(@Validated @RequestBody RestRequest<String> param) {
        var taskId = param.getValue();
        if (taskId == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        var response = sentAligner.deleteAlignSentResult(taskId);
        if (response != null) LOG.info("taskId: {}, delete: {}", taskId, response); else LOG.info("failed to delete task id: {}", taskId);

        return new RestResponse<>(response);
    }

    @RequestMapping(value = "align/sent/async/load", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<SentAlignResponse> loadAlignSentTask(@Validated @RequestBody RestRequest<String> param) {
        var taskId = param.getValue();
        if (taskId == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        var response = sentAligner.loadAlignSentResult(taskId);
        if (response != null) LOG.info(response.toString()); else LOG.info("response is null");

        return new RestResponse<>(response);
    }

    @RequestMapping(value = "align/word", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<WordAlignResponse> alignWord(@Validated @RequestBody RestRequest<WordAlignRequest> param) {
        var request = param.getValue();
        if (request == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        LOG.info(request.toString());
        var response = sentAligner.alignWord(request);

        return new RestResponse<>(response);
    }

    @RequestMapping(value = "token/sent", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<SentTokenResponse> tokenSent(@Validated @RequestBody RestRequest<SentTokenRequest> param) {
        var request = param.getValue();
        if (request == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        LOG.info(request.toString());
        var response = sentAligner.tokenSent(request);

        return new RestResponse<>(response);
    }
}
