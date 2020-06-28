package com.donkeyhuang.align.sentAlign.entity;

import java.util.ArrayList;
import java.util.List;

public class WordAlignResponse {

    private List<String> srcSentTokens;

    private List<String> tgtSentTokens;

    private List<Double> scoreList;

    private List<List<Integer>> align;

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

    public List<List<Integer>> getAlign() {
        return align;
    }

    public void setAlign(List<List<Integer>> align) {
        this.align = align;
    }

    public void addAlign(int index, boolean append) {
        if (append) align.add(new ArrayList<>());
        align.get(align.size()-1).add(index);
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
