package com.donkeyhuang.align.sentAlign.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SentAlignResponse {

    private List<SentAlignPair> sentPairList;
}
