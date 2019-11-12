package com.example.task.linesAndPoints;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Dot<Integer, Integer>> dots = new LinkedHashSet<>();
        for (int i = 0; i < 50; i++) {
            dots.add(new Dot<>(new Random().nextInt(50), new Random().nextInt(50)));
        }

        Dot<Integer, Integer> dotArr[] = dots.toArray(new Dot[dots.size()]);
        List<String> lines = new ArrayList<>();
        for (int a = 0; a < dotArr.length - 1; a++) {
            for (int b = a + 1; b < dotArr.length; b++)
                lines.add(getLine(dotArr[a], dotArr[b]));
        }
        File directory =  new File(".");
        String absolutePath = System.getProperty("user.dir") +File.separator + "results.txt";
        File results =  new File(absolutePath);
        if(!results.exists()){
            results.createNewFile();
        }
        FileWriter writer =  new FileWriter(absolutePath);

        Map<String, Long> resultMap = lines.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().peek(e -> e.setValue(e.getValue() + 1)).
                collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

        for(Map.Entry<String, Long> entry : resultMap.entrySet()){
            writer.write(entry.getKey() + " crosses points " + entry.getValue() + "\r\n");
        }
        writer.close();

    }
    public static String getLine(Dot<Integer, Integer> dot1, Dot<Integer, Integer> dot2) {
        float k1 = dot1.getY() - dot2.getY();
        float k2 = dot1.getX() - dot2.getX();
        if (k1 == 0) {
            return "y = " + dot1.getY();
        }
        if (k2 == 0) {
            return "x = " + dot1.getX();
        }
        float k = k1 / k2;
        float b = dot2.getY() - k * dot2.getX();
        if (b >= 0) {
            return "y = " + k + "x+" + b;
        } else
            return "y = " + k + "x" + b;

    }
}
