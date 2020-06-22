package com.donkeyhuang.align.sentAlign.entity;

import java.util.ArrayList;
import java.util.List;

public class WordAlignResponse {

    private List<String> srcSentTokens;

    private List<String> tgtSentTokens;

    private List<Double> scoreList;

    private String align;

    public WordAlignResponse() {
        srcSentTokens = new ArrayList<>();
        tgtSentTokens = new ArrayList<>();
        scoreList = new ArrayList<>();
    }

    public List<String> getSrcSentTokens() {
        return srcSentTokens;
    }

    public void addSrcSentToken(String token) {
        srcSentTokens.add(token);
    }

    public void setSrcSentTokens(List<String> srcSentTokens) {
        this.srcSentTokens = srcSentTokens;
    }

    public List<String> getTgtSentTokens() {
        return tgtSentTokens;
    }

    public void addTgtSentToken(String token) {
        tgtSentTokens.add(token);
    }

    public void setTgtSentTokens(List<String> tgtSentTokens) {
        this.tgtSentTokens = tgtSentTokens;
    }

    public void addScore(double score) {
        scoreList.add(score);
    }

    public List<Double> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Double> scoreList) {
        this.scoreList = scoreList;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    @Override
    public String toString() {
        return "WordAlignResponse{" +
                "srcSentTokens=" + srcSentTokens +
                ", tgtSentTokens=" + tgtSentTokens +
                ", scoreList=" + scoreList +
                ", align='" + align + '\'' +
                '}';
    }
}
