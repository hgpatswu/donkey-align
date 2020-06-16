package com.donkeyhuang.align.sentAlign.entity;

import com.donkeyhuang.commons.lang.Language;

import java.util.List;

public class SentAlignSource {

    private Language lang;

    private List<String> sentList;

    public SentAlignSource() {

    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public List<String> getSentList() {
        return sentList;
    }

    public void setSentList(List<String> sentList) {
        this.sentList = sentList;
    }
}
