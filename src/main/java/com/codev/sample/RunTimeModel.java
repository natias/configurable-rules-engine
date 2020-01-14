package com.codev.sample;

import com.codepoetics.protonpack.maps.MapStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
    this class taes a "Rules" object
 **/


public class RunTimeModel {

    final Rules rules;


    public RunTimeModel(Rules rules) {
        this.rules = rules;
    }

    boolean validateConfiguration()
    {

        //todo check that rules configuration is valid

        //for now just return true
        return true;
    }

    //return the labels rater than the IDs
    public List<String> getStates()
    {

        return (List<String>) rules.getLabels().entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());

    }


    // what are the next states for a given current state
    public List<String> getNextValidStates(String currentState)
    {


        String h=MapStream.of(rules.getLabels()).inverseMapping().collect().get(currentState);

        return rules.getTransitions().getOrDefault(h,new ArrayList<>()).stream().map(s->rules.getLabels().get(s)).collect(Collectors.toList());

    }



}
