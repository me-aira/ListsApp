package com.company;

import com.company.util.ListUtil;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        try
        {
            List<Integer> l1 = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, 3, 44, 55, 6, 7, 8}));
            List<Integer> l2 = new LinkedList<>(Arrays.asList(new Integer[]{13, 12, 11, 10, 9, 4, 5, 6, 7, 8}));
            //для списков = null, всегда будет возвращаться EmptyList
            l1 = Optional.ofNullable(l1).orElse(Collections.emptyList());
            l2 = Optional.ofNullable(l2).orElse(Collections.emptyList());
            List<Integer> res1 = ListUtil.getIntersectUsingMethod1(l1, l2);
            List<Integer> res2 = ListUtil.getIntersectUsingMethod2(l1, l2);
            List<Integer> res3 = ListUtil.getIntersectUsingMethod3(l1, l2);

            if (res1.isEmpty() || res2.isEmpty() || res3.isEmpty())
            {
                throw new Exception("Пересечение не найдено!");
            }

            System.out.println(res1);
            System.out.println(res2);
            System.out.println(res3);

        } catch (Exception e)
        {
            e.printStackTrace(System.out);
        }
    }
}
