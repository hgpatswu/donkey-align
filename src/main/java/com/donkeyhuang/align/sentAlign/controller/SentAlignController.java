package com.donkeyhuang.align.sentAlign.controller;

import com.donkeyhuang.align.sentAlign.entity.SentAlignRequest;
import com.donkeyhuang.align.sentAlign.entity.SentAlignResponse;
import com.donkeyhuang.align.sentAlign.manager.SentAligner;
import com.donkeyhuang.commons.rest.RestRequest;
import com.donkeyhuang.commons.rest.RestResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping(method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SentAlignController {

    @Autowired
    private SentAligner sentAligner;

    @RequestMapping(value = "align/sent", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<SentAlignResponse> callApiImt(@Validated @RequestBody RestRequest<SentAlignRequest> param) {
        var request = param.getValue();
        if (request == null) {
            return new RestResponse<>(HttpStatus.BAD_REQUEST.value(), "Param-Error", "Value is null");
        }

        var response = sentAligner.alignSent(request);

        return new RestResponse<>(response);
    }
}
