package com.example.mopm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class HelloApplication {

    public static void main(String[] args) {
        int listSize = 100000;
        int InsertElements = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        fill(arrayList, listSize, "ArrayList");
        fill(linkedList, listSize, "LinkedList");

        randomAccess(arrayList, "ArrayList");
        randomAccess(linkedList, "LinkedList");

        sequentialAccess(arrayList, "ArrayList");
        sequentialAccess(linkedList, "LinkedList");

        insertBeginning(arrayList, InsertElements, "ArrayList");
        insertBeginning(linkedList, InsertElements, "LinkedList");

        insertEnd(arrayList, InsertElements, "ArrayList");
        insertEnd(linkedList, InsertElements, "LinkedList");

        insertMiddle(arrayList, InsertElements, "ArrayList");
        insertMiddle(linkedList, InsertElements, "LinkedList");
    }

    private static void fill(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Заповнення масиву %s: %d ms%n", listType, endTime - startTime);
    }

    private static void randomAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Доступ за індексом %s: %d ms%n", listType, endTime - startTime);
    }

    private static void sequentialAccess(List<Integer> list, String listType) {
        long startTime = System.currentTimeMillis();
        for (Integer value : list) {
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Послідовний доступ  до %s: %d ms%n", listType, endTime - startTime);
    }

    private static void insertBeginning(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Вставити на початку %s: %d ms%n", listType, endTime - startTime);
    }

    private static void insertEnd(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Вставка в кінці %s: %d ms%n", listType, endTime - startTime);
    }

    private static void insertMiddle(List<Integer> list, int count, String listType) {
        long startTime = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator(list.size() / 2);
        for (int i = 0; i < count; i++) {
            iterator.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Вставка в середині %s: %d ms%n", listType, endTime - startTime);
    }
}
