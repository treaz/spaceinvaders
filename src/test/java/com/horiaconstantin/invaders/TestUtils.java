package com.horiaconstantin.invaders;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

    //TODO consider writing a test for this and also refactoring it
    static String[][] readMatrixFromFile(String filename) throws IOException {
        String content = Resources.toString(Resources.getResource(filename), Charsets.UTF_8);
        List<String[]> dynamicMatrix = Lists.newArrayList();
        Arrays.stream(content.split("\n")).forEach(line -> dynamicMatrix.add(line.split("")));
        return dynamicMatrix.stream().toArray(String[][]::new);
    }
}
