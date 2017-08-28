package com.horiaconstantin.invaders;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RadarImageTest {

    @Test
    public void createValidRadarImage() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100, "-");
        RadarImage image = new RadarImage(emptyMatrix);
        assertNotNull(image);
    }

    @Test(expected = InvalidRadarInput.class)
    public void createRadarImageWithInvalidChars() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100, "x");
        new RadarImage(emptyMatrix);
    }

    @Test(expected = InvalidRadarInput.class)
    public void createRadarImageWithInvalidSize() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 77, "-");
        new RadarImage(emptyMatrix);
    }

    @Test
    public void getValueAtTopLeft() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100, "-");
        RadarImage image = new RadarImage(emptyMatrix);
        assertThat(image.getValueAt(0,0), is("-"));
    }

    @Test
    public void getRandomValue() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100, "-");
        emptyMatrix[33][33] = "o";
        RadarImage image = new RadarImage(emptyMatrix);
        assertThat(image.getValueAt(33,33), is("o"));
    }

    @Test
    public void getSubImage() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100, "-");
        RadarImage image = new RadarImage(emptyMatrix);
        String[][] subImage = image.getSubImage(0, 4, 0, 3);
        assertTrue(Arrays.deepEquals(subImage, MatrixUtils.getEmptyMatrix(4, 3, "-")));
    }

}