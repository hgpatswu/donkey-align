package com.donkeyhuang.align.sentAlign.entity;

import com.donkeyhuang.commons.lang.Language;

import java.util.List;

public class SentTokenRequest {

    private Language lang;

    private String sent;

    private List<String> sentList;

    public SentTokenRequest() {

    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public String getSent() {
        return sent;
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
        return "SentTokenRequest{" +
                "lang=" + lang +
                ", sent='" + sent + '\'' +
                ", sentList=" + sentList +
                '}';
    }
}
