package com.donkeyhuang.align.sentAlign.manager;

import com.donkeyhuang.align.sentAlign.entity.*;
import com.donkeyhuang.commons.util.CollectionUtil;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class SentAligner {

    @Autowired
    private SentAlignerJNI sentAlignerJNI;

    public SentAlignResponse alignSent(SentAlignRequest request) {
        SentAlignResponse nullRet = new SentAlignResponse();
        if (request == null) return nullRet;

        filterSentList(request.getSource().getSentList());
        filterSentList(request.getTarget().getSentList());

        if (request.getSource() == null || request.getSource().getSentList() == null || request.getSource().getSentList().isEmpty() ||
            request.getTarget() == null || request.getTarget().getSentList() == null || request.getTarget().getSentList().isEmpty())
            return nullRet;

        var ret = (SentAlignResponse) sentAlignerJNI.alignSent(request);
        return ret == null ? nullRet : ret;
    }

    public String alignSentAsync(SentAlignRequest request) {
        SentAlignResponse nullRet = new SentAlignResponse();
        if (request == null) return null;

        filterSentList(request.getSource().getSentList());
        filterSentList(request.getTarget().getSentList());

        if (request.getSource() == null || request.getSource().getSentList() == null || request.getSource().getSentList().isEmpty() ||
                request.getTarget() == null || request.getTarget().getSentList() == null || request.getTarget().getSentList().isEmpty())
            return null;

        return sentAlignerJNI.alignSentAsync(request);
    }

    public TaskStatus checkAlignSentTask(String taskId) {
        taskId = StringUtils.trim(taskId);
        if (StringUtils.isEmpty(taskId)) return null;

        var ret = (TaskStatus) sentAlignerJNI.checkAlignSentTask(taskId);
        if (ret != null) return ret;

        ret = new TaskStatus();
        ret.setError(true);
        ret.setFinished(false);
        ret.setMessage("not exist");
        return ret;
    }

    public Boolean deleteAlignSentResult(String taskId) {
        taskId = StringUtils.trim(taskId);
        if (StringUtils.isEmpty(taskId)) return null;

        return sentAlignerJNI.deleteAlignSentResult(taskId);
    }

    public SentAlignResponse loadAlignSentResult(String taskId) {
        SentAlignResponse nullRet = new SentAlignResponse();
        taskId = StringUtils.trim(taskId);
        if (StringUtils.isEmpty(taskId)) return nullRet;

        var ret = (SentAlignResponse) sentAlignerJNI.loadAlignSentResult(taskId);
        return ret == null ? nullRet : ret;
    }


    public WordAlignResponse alignWord(WordAlignRequest request) {
        WordAlignResponse nullRet = new WordAlignResponse();
        if (request == null) return nullRet;

        request.setSrcSent(filterSent(request.getSrcSent()));
        request.setTgtSent(filterSent(request.getTgtSent()));
        if (request.getSrcLang() == null || request.getTgtLang() == null) return nullRet;

        var ret = (WordAlignResponse) sentAlignerJNI.alignWord(request);
        return ret == null ? nullRet : ret;
    }

    public SentTokenResponse tokenSent(SentTokenRequest request) {
        SentTokenResponse nullRet = new SentTokenResponse();
        if (request == null) return nullRet;

        request.setSent(filterSent(request.getSent()));
        filterSentList(request.getSentList());
        if (request.getSentList() != null && request.getSentList().isEmpty()) request.setSentList(null);

        if (request.getSent() == null && request.getSentList() == null) return nullRet;

        var ret = (SentTokenResponse) sentAlignerJNI.tokenSent(request);
        return ret == null ? nullRet : ret;
    }

    protected void filterSentList(List<String> sentList) {
        if (sentList == null) return;

        for (int i = 0; i < sentList.size();) {
            var sent = filterSent(sentList.get(i));

            if (StringUtils.isEmpty(sent)) {
                sentList.remove(i);
                continue;
            }

            sentList.set(i, sent);
            i++;
        }
    }

    protected String filterSent(String sent) {
        if (sent == null) return null;

        sent = sent.replaceAll("\n", " ");
        sent = sent.replaceAll("\t", " ");
        sent = StringUtils.trim(sent);

        if (StringUtils.isEmpty(sent)) return null;

        return sent;
    }
}
