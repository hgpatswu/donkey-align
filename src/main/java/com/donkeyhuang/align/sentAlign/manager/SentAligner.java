package com.donkeyhuang.align.sentAlign.manager;

import com.donkeyhuang.align.sentAlign.entity.SentAlignRequest;
import com.donkeyhuang.align.sentAlign.entity.SentAlignResponse;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@NoArgsConstructor
public class SentAligner {

    private SentAlignerJNI sentAlignerJNI = new SentAlignerJNI();

    @PostConstruct
    public void init() {

        if (sentAlignerJNI.init()) return;
    }

    public SentAlignResponse alignSent(SentAlignRequest request) {
        return null;
    }
}
