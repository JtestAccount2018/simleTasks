package com.example.task.polynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Poly {
    public static void main(String[] args) {
        List<Integer> first =  new ArrayList<>(Collections.nCopies(5, 2));
        List<Integer> second =  new ArrayList<>(Collections.nCopies(3, 2));
        System.out.println(first.stream().mapToInt(Integer::valueOf).map((e)->second.stream().mapToInt(Integer::valueOf).map(s->e*s).sum()).sum());
    }
}
