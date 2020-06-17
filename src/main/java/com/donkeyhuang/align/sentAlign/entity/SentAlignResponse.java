package com.donkeyhuang.align.sentAlign.entity;

import java.util.ArrayList;
import java.util.List;

public class SentAlignResponse {

    private List<AlignedSentPair> sentPairList;

    public SentAlignResponse() {
        sentPairList = new ArrayList<>();
    }

    public SentAlignResponse(List<AlignedSentPair> sentPairList) {
        this.sentPairList = sentPairList;
    }

    public void addSentPair(AlignedSentPair pair) {
        sentPairList.add(pair);
    }

    public List<AlignedSentPair> getSentPairList() {
        return sentPairList;
    }

    public void setSentPairList(List<AlignedSentPair> sentPairList) {
        this.sentPairList = sentPairList;
    }

    @Override
    public String toString() {
        return "SentAlignResponse{" +
                "sentPairList=" + sentPairList +
                '}';
    }
}
