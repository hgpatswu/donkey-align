package com.donkeyhuang.align.sentAlign.entity;

import java.util.ArrayList;
import java.util.List;

public class SentTokenResponse {

    private String sent;

    private List<String> sentList;

    public SentTokenResponse() {

    }

    public String getSent() {
        return sent;
    }

    public void addSent(String sent) {
        if (sentList == null) sentList = new ArrayList<>();
        sentList.add(sent);
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public List<String> getSentList() {
        return sentList;
    }

    public void setSentList(List<String> sentList) {
        this.sentList = sentList;
    }

    @Override
    public String toString() {
        return "SentTokenResponse{" +
                "sent='" + sent + '\'' +
                ", sentList=" + sentList +
                '}';
    }
}
