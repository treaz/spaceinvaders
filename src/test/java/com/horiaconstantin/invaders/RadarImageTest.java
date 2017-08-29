package com.horiaconstantin.invaders;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RadarImageTest {

    String[][] emptyMatrix;

    @Before
    public void before(){
        emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100, "-");
    }

    @Test
    public void createValidRadarImage() {
        RadarImage image = new RadarImage(emptyMatrix);

        assertNotNull(image);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRadarImageWithInvalidChars() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100, "x");

        new RadarImage(emptyMatrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRadarImageWithInvalidSize() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 77, "-");

        new RadarImage(emptyMatrix);
    }

    @Test
    public void getValueAtTopLeft() {
        RadarImage image = new RadarImage(emptyMatrix);

        String value = image.getValueAt(0,0);

        assertThat(value, is("-"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getValueInvalidRow() {
        RadarImage image = new RadarImage(emptyMatrix);

        image.getValueAt(50,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getValueInvalidColumn() {
        RadarImage image = new RadarImage(emptyMatrix);

        image.getValueAt(1,100);
    }

    @Test
    public void getRandomValue() {
        emptyMatrix[33][33] = "o";
        RadarImage image = new RadarImage(emptyMatrix);

        String value = image.getValueAt(33, 33);

        assertThat(value, is("o"));
    }

    @Test
    public void getSubImageWithValuesInTheCorners() {
        int startRow = 4;
        int endRow = 8;
        int startColumn = 6;
        int endColumn = 9;

        emptyMatrix[startRow][startColumn]="o";
        emptyMatrix[7][startColumn]="o";

        emptyMatrix[startRow][endColumn-1]="o";
        emptyMatrix[endRow-1][endColumn-1]="o";

        RadarImage image = new RadarImage(emptyMatrix);
        String[][] subMatrix = MatrixUtils.getEmptyMatrix(endRow-startRow, endColumn-startColumn, "-");
        subMatrix[0][0]="o";
        subMatrix[3][0]="o";
        subMatrix[0][2]="o";
        subMatrix[3][2]="o";


        String[][] subImage = image.getSubImage(startRow, endRow, startColumn, endColumn);

        assertTrue(Arrays.deepEquals(subImage, subMatrix));
    }



}