package com.donkeyhuang.align.sentAlign.entity;

import com.donkeyhuang.commons.lang.Language;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

public class SentAlignTarget {

    private Language lang;

    private List<String> sentList;

    public SentAlignTarget() {

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

    @Override
    public String toString() {
        return "SentAlignTarget{" +
                "lang=" + lang +
                ", sentList=" + sentList +
                '}';
    }
}
