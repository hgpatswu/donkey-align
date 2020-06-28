package com.donkeyhuang.align.sentAlign.manager;

import com.donkeyhuang.align.sentAlign.entity.SentAlignRequest;
import com.donkeyhuang.align.sentAlign.entity.SentAlignResponse;
import com.donkeyhuang.align.sentAlign.entity.WordAlignRequest;
import com.donkeyhuang.align.sentAlign.entity.WordAlignResponse;
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

    protected void filterSentList(List<String> sentList) {
        for (int i = 0; i < sentList.size();) {
            var sent = sentList.get(i);
            sent = sent.replaceAll("\n", " ");
            sent = sent.replaceAll("\t", " ");
            sent = StringUtils.trim(sent);

            if (StringUtils.isEmpty(sent)) {
                sentList.remove(i);
                continue;
            }

            sentList.remove(i);
            sentList.add(i, sent);
            i++;
        }
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

    protected String filterSent(String sent) {
        sent = sent.replaceAll("\n", " ");
        sent = sent.replaceAll("\t", " ");
        sent = StringUtils.trim(sent);

        if (StringUtils.isEmpty(sent)) {
            return null;
        }

        return sent;
    }
}
