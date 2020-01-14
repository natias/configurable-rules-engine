package com.codev.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rules {

    Map<String, List<String>> transitions=new HashMap();

    Map<String, String> labels=new HashMap();

    public void setTransitions(Map<String, List<String>> transitions) {
        this.transitions = transitions;
    }

    public Map<String, List<String>> getTransitions() {
        return transitions;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }
}
