package com.codev.sample;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatesExample {



    public String createRulesMap4example() {


        Rules r=new Rules();


        Map<String, String> labels=new HashMap();


        labels.put("1","new");
        labels.put("2","dev");
        labels.put("3","tst");


        r.setLabels(labels);

        Map<String,List<String>> transitions=new HashMap();


        transitions.put("1", Arrays.asList("2"));

        transitions.put("2",Arrays.asList("3"));

        r.setTransitions(transitions);

        Gson g=new Gson();

        //System.out.println(g.toJson(r));

        return g.toJson(r);
    }



    public Rules fromString(String rulesJson)
    {
        Gson g=new Gson();
        return  g.fromJson(rulesJson,Rules.class);

    }


    public static void main(String[] args) {


        //i create sample data. in real life this should be stored as json in local file/resource/db etc
        StatesExample statesExample =new StatesExample();

        String json = statesExample.createRulesMap4example();

        System.out.println("the rules json is "+ json);

        Rules rules= statesExample.fromString(json);

        RunTimeModel runTimeModel =new RunTimeModel(rules);

        System.out.println("states are: " + runTimeModel.getStates());

        System.out.println("valid transitions are ");
        runTimeModel.getStates().forEach(s->
                {

                            System.out.println("from state " +s+" to "+ runTimeModel.getNextValidStates(s));               ;
                }
        );

    }








}
