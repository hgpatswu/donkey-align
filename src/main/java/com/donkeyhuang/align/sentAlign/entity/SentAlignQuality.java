package com.donkeyhuang.align.sentAlign.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SentAlignQuality {

    EXACT("exact"), GOOD("good"), UNSURE("unsure"), BAD("bad");

    private final String value;

    private SentAlignQuality(String value) {
        this.value = value;
    }

    @JsonCreator
    public static SentAlignQuality fromValue(String value) {
        value = value.toLowerCase();
        for (SentAlignQuality quality : values()) {
            if (quality.value.equals(value)) return quality;
        }

        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

    public static List<String> qualityList() {
        var ret = Arrays.stream(values()).map(quality -> quality.value).collect(Collectors.toList());
        ret.remove(0);
        return ret;
    }

    @JsonValue
    public String toValue() {
        return value;
    }
}
