package com.company.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ListUtil {
    public static <T> List<T> getIntersectUsingMethod1(List<T> l1, List<T> l2)//метод перебора, квадратичная сложность
    {
        List<T> res = new LinkedList<>();
        for(T el1: l1)
        {
            boolean found = false;
            for(T el2: l2)
            {
                if(el1.equals(el2))
                {
                    res.add(el1);
                    found = true;
                }
            }
            if(!res.isEmpty() && !found)//проверяем, что концы списков (после найденной первой точки пересечения) совпадают
            {
                res.clear();
                break;
            }
        }
        return res;
    }

    public static <T> List<T> getIntersectUsingMethod2(List<T> l1, List<T> l2)//с использорванием доп. памяти (хэш-таблицы), линейная сложность
    {
        List<T> res = new LinkedList<>();
        Set<T> s = new HashSet<>(l1);
        for(T el: l2)
        {
            if(s.contains(el))
            {
                res.add(el);
            }
            else if(!res.isEmpty())//проверяем, что концы списков (после найденной первой точки пересечения) совпадают
            {
                res.clear();
                break;
            }
        }
        return res;
    }

    public static <T> List<T> getIntersectUsingMethod3(List<T> l1, List<T> l2)//без использорвания доп. памяти, линейная сложность
    {
        List<T> res = new LinkedList<>();
        int size1 = l1.size();
        int size2 = l2.size();
        int diff = Math.abs(size1 - size2);
        int minSize = Math.min(size1, size2);
        for(int i = 0; i< minSize; i++)
        {
            if(l2.get(i + (size2 == minSize ? 0 : diff)).equals(l1.get(i + (size1 == minSize ? 0 : diff))))
            {
                res.add(l1.get(i + (size1 == minSize ? 0 : diff)));
            }
            else if(!res.isEmpty())//проверяем, что концы списков (после найденной первой точки пересечения) совпадают
            {
                res.clear();
                break;
            }
        }
        return res;
    }
}
