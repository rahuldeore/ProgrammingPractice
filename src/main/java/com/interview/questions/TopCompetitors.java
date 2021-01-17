package com.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Rahul on 2/1/20
 */
public class TopCompetitors {
    /**
     * This method returns a list of of top N competitors when given a list of reviews, a list of competitor names and
     * an integer value that is top N competitor
     *
     * Assumption: the review are all positive and each review talk about only one product.
     * */
    public static List<String> getTopNProductCompetitors(int totalCompetitors, List<String> competitorNames,
                                                  int topNCompetitors, List<String> reviews) {
        TreeMap<String, Integer> competitorsMap = new TreeMap<>();
        for (String competitor : competitorNames) {
            for (String review : reviews) {
                if (review.toLowerCase().contains(competitor.toLowerCase())) {
                    updateInsertCompetitor(competitor, competitorsMap);
                    //break;
                }
            }
        }
        List<String> topCompetitors = new ArrayList<>(topNCompetitors);
        competitorsMap.entrySet().forEach(stringIntegerEntry -> {
            topCompetitors.add(stringIntegerEntry.getKey());
        });

        return topCompetitors;
    }

    private static void updateInsertCompetitor(String competitor, TreeMap<String, Integer> competitorsMap) {
        if (competitorsMap.containsKey(competitor)) {
            competitorsMap.replace(competitor, competitorsMap.get(competitor) + 1);
        } else {
            competitorsMap.put(competitor, 1);
        }
    }

    public static void main(String args[]) {
        List<String> competitorNames = Arrays.asList("Neutrogena", "Olay", "Banana boat", "Lakme");
        List<String> reviews = Arrays.asList(
                "neutrogena products are great",
                "Lakme sunscreen gave me flawless skin over the summer",
                "There is no doubt generic products are as good as any other brands",
                "I have had amazing experience using neutrogena day cream and night cream to reverse aging. The day " +
                        "cream has spf 30",
                "By far the olay products are most premium product and works without a doubt",
                "Olay is my favourite brand",
                "i recommend neutrogena",
                "Banana boat is awesome for body sunscreen use at the beach",
                "neutrogena has very high quality products"
                );
        List<String> topCompetitors = getTopNProductCompetitors(competitorNames.size(), competitorNames,
                2, reviews);
        for (String topCompetitor : topCompetitors) {
            System.out.println(topCompetitor);
        }
    }

}
