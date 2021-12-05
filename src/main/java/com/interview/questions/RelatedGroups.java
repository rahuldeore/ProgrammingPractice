package com.interview.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Rahul on 4/17/21
 *
 * given a matrix nxn, where n is number of users, each user is either related or not related to other user.
 * There could be transitive relations as well. Find out the total number of groups. where each group consist of direct
 * and transitive related users. Remember, each user is related to itself.
 * Eaxmple: u1, u2 and u3 are users
 *      u1  u2  u3
 *    u1 1  1   0
 *    u2 1  1   0
 *    u3 0  0   1
 *
 *    u1 and u2 are related. We can see that the (row0, col1) -> 1 and so is (row1, col0) -> 1. user3 is not related to
 *    anyone, hence only (row3, col3) -> 1 and rest of the relations are 0 for user3.
 *
 *      u1  u2  u3  u4  u5
 *   u1 1   1   1   0   1
 *   u2 1   1   0   1   0
 *   u3 1   0   1   0   0
 *   u4 0   1   0   1   0
 *   u5 1   0   0   0   1
 *
 *      u1  u2  u3  u4  u5
 *   u1 1   1   0   0   1
 *   u2 1   1   0   1   0
 *   u3 0   0   1   0   1
 *   u4 0   1   0   1   0
 *   u5 1   0   1   0   1
 *
 *      u1  u2  u3  u4  u5
 *   u1 1   1   0   0   0
 *   u2 1   1   1   1   1
 *   u3 0   1   1   0   0
 *   u4 0   1   0   1   0
 *   u5 1   1   0   0   1
 */
public class RelatedGroups
{
    static Map<Integer, HashSet<Integer>> groups = new HashMap<>();

    static int findGroups(String[] relMatrix) {
        int result = 0, size = relMatrix.length;



        for (int i=0; i<size; i++) {
            Set<Integer> group = new HashSet<>();
            for (int j=i+1; j<size; j++) {

            }
        }


        return result;
    }

    static Integer giveGroupWhereUserBelongs(Integer user) {
        HashSet<Integer> group = null;
        for (Integer i=0; i<groups.size(); i++) {
            group = groups.get(i);
            if (group.contains(user)){
                return i;
            }
        }
        return -1;
    }
}
