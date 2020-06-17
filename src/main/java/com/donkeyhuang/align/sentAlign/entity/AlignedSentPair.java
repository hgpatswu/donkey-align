package com.donkeyhuang.align.sentAlign.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

public class AlignedSentPair {

    private List<String> sourceSentList;

    private List<String> targetSentList;

    private Double score;

    private List<Double> scoreList;

    private SentAlignQuality level;

    public AlignedSentPair() {
        this.sourceSentList = new ArrayList<>();
        this.targetSentList = new ArrayList<>();
        this.score = 0.;
        this.scoreList = new ArrayList<>();
        this.level = null;
    }

    public void addSourceSent(String sourceSent) {
        sourceSentList.add(sourceSent);
    }

    public void addTargetSent(String targetSent) {
        targetSentList.add(targetSent);
    }

    public void addScore(double score) {
        scoreList.add(score);
    }

    public List<String> getSourceSentList() {
        return sourceSentList;
    }

    public void setSourceSentList(List<String> sourceSentList) {
        this.sourceSentList = sourceSentList;
    }

    public List<String> getTargetSentList() {
        return targetSentList;
    }

    public void setTargetSentList(List<String> targetSentList) {
        this.targetSentList = targetSentList;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<Double> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Double> scoreList) {
        this.scoreList = scoreList;
    }

    public SentAlignQuality getLevel() {
        return level;
    }

    public void setLevel(SentAlignQuality level) {
        this.level = level;
    }

    public void setLevel(int level) {
        switch (level) {
            case 0:
                this.level = SentAlignQuality.EXACT;
                break;
            case 1:
                this.level = SentAlignQuality.GOOD;
                break;
            case 2:
                this.level = SentAlignQuality.UNSURE;
                break;
            case 3:
                this.level = SentAlignQuality.BAD;
                break;
        }
    }

    @Override
    public String toString() {
        return "AlignedSentPair{" +
                "sourceSentList=" + sourceSentList +
                ", targetSentList=" + targetSentList +
                ", score=" + score +
                ", scoreList=" + scoreList +
                ", level=" + level +
                '}';
    }
}
