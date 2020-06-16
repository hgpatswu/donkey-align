package com.donkeyhuang.align.sentAlign.manager;

import com.donkeyhuang.align.sentAlign.entity.SentAlignResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SentAligner {

    @Autowired
    private SentAlignerJNI sentAlignerJNI;

    public SentAlignResponse alignSent(Object request) {
        return (SentAlignResponse) sentAlignerJNI.alignSent(request);
    }
}
