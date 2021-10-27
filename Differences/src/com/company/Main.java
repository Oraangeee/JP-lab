package com.company;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ListsDifference diff = new ListsDifference();
        diff.Lists();
        System.out.println("#################################################");
        SetsDifference setDiff = new SetsDifference();
        setDiff.Set();
        System.out.println("#################################################");
        MapsDifference mapDiff = new MapsDifference();
        mapDiff.Map();
    }

}
class ListsDifference {

    public void Lists()
    {
        List<Integer> listOne = new LinkedList<>();
        List<Integer> listTwo = new ArrayList<>();

        for (int i = 0; i<10000;i++)
        {
            listOne.add(i);
            listTwo.add(i);
        }

        final long timeOfStartLLGetting = System.nanoTime();
        listOne.get(5000);
        final long timeOfEndLLGetting = System.nanoTime();
        final long timeOfStartALGetting = System.nanoTime();
        listTwo.get(5000);
        final long timeOfEndALGetting = System.nanoTime();

        final long timeOfStartLLDelete = System.nanoTime();
        listOne.remove(5); //jesli liczba usuwana bedzie wieksza niz około 4% wielkosci listy wtedy juz arraylista ma wieksza wydajnosc
        final long timeOfEndLLDelete = System.nanoTime();
        final long timeOfStartALDelete = System.nanoTime();
        listTwo.remove(5); //jesli liczba usuwana bedzie wieksza niz około 4% wielkosci listy wtedy juz arraylista ma wieksza wydajnosc
        final long timeOfEndALDelete = System.nanoTime();

        long totalTimeForLinkedGetting = timeOfEndLLGetting - timeOfStartLLGetting;
        long totalTimeForArrayGetting = timeOfEndALGetting - timeOfStartALGetting;
        long totalTimeForLinkedDelete = timeOfEndLLDelete - timeOfStartLLDelete;
        long totalTimeForArrayDelete = timeOfEndALDelete - timeOfStartALDelete;
        System.out.println("Time of LinkedList getting = "+ totalTimeForLinkedGetting);
        System.out.println("Time of ArrayList getting = "+ totalTimeForArrayGetting);
        System.out.println("Time of LinkedList getting = "+ totalTimeForLinkedDelete);
        System.out.println("Time of ArrayList getting = "+ totalTimeForArrayDelete);
        List<Integer> listThree = new LinkedList<>();
        listThree.add(5);
        listThree.add(1);
        listThree.add(15);
        listThree.add(1);
        listThree.add(8);
        System.out.println(listThree);
        listThree.remove(1);
        listThree.remove(0);
        System.out.println(listThree);
    }
}
class SetsDifference{
    public void Set(){
        Set<String> treeset = new TreeSet<>();
        Set<String> hashset = new HashSet<>();

        treeset.add("Adam");
        treeset.add("Tomek");
        treeset.add("Krzysiek");
        treeset.add("Marek");
        treeset.add("Krystian");
        treeset.add("Maciek");
        //Zduplikowany element
        treeset.add("Marek");
        System.out.println("TreeSet: ");
        for(String temp : treeset) System.out.println(temp);
        System.out.println("Jak widać TreeSet ma jest automatycznie posortowany niezależnie od tego w jakiej kolejnosci dodamy imiona");


        hashset.add("Adam");
        hashset.add("Tomek");
        hashset.add("Krzysiek");
        hashset.add("Marek");
        hashset.add("Krystian");
        hashset.add("Maciek");
        //Zduplikowany element
        hashset.add("Krzysiek");
        System.out.println("HashSet: ");
        for(String temp : hashset) System.out.println(temp);
        System.out.println("W HashSecie nie ma automatycznego sortowania");
    }
}
class MapsDifference{
    public void Map(){
        Map<Integer, String> hashmap = new HashMap<>();
        Map<Integer, String> treemap = new TreeMap<>();
        int[] array = {1, -1, 0, 2, -2,-1, 0};
        for(int x: array)
        {
            hashmap.put(x, Integer.toString(x));
        }
        System.out.println("HashMap: ");
        for (int k:hashmap.keySet()) System.out.println(k + ", ");
        for(int x: array)
        {
            treemap.put(x, Integer.toString(x));
        }
        System.out.println("TreeMap: ");
        for (int k:treemap.keySet()) System.out.println(k + ", ");
        System.out.println("Jak widać TreeMap jest posortowana automatycznie przy wyswietlaniu, gdzie dla hashmap mozemy posortowac dobrowolnie");
        System.out.println("Nie wyswietlają sie tez zdublowane elementy w obu mapach");
    }


}