package com.donkeyhuang.align.sentAlign.manager;

import com.donkeyhuang.align.sentAlign.entity.SentAlignRequest;
import com.donkeyhuang.align.sentAlign.entity.SentAlignResponse;
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

        filterSentList(request.getSource().getSentList());
        filterSentList(request.getTarget().getSentList());

        if (request.getSource() == null || request.getSource().getSentList() == null || request.getSource().getSentList().isEmpty() ||
            request.getTarget() == null || request.getTarget().getSentList() == null || request.getTarget().getSentList().isEmpty()) return nullRet;

        return (SentAlignResponse) sentAlignerJNI.alignSent(request);
    }

    public void filterSentList(List<String> sentList) {
        for (int i = 0; i < sentList.size();) {
            var sent = sentList.get(i);
            sent = sent.replaceAll("\n", "");
            sent = sent.replaceAll("\t", "");
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
}
