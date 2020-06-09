package com.donkeyhuang.align.sentAlign.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SentAlignPair {

    private List<String> sourceSentList;

    private List<String> targetSentList;

    private Double score;

    private List<Double> scoreList;

    private SentAlignQuality level;
}
