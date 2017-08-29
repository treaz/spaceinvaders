package com.horiaconstantin.invaders;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RadarImageTest {

    String[][] emptyMatrix;

    @Before
    public void before(){
        emptyMatrix = MatrixUtils.getEmptyMatrix(50, 100);
    }

    @Test(expected = NullPointerException.class)
    public void createRadarImage() {
        new RadarImage(null);
    }

    @Test
    public void createValidRadarImage() {
        RadarImage image = new RadarImage(emptyMatrix);

        assertNotNull(image);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRadarImageWithInvalidSize() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(50, 77);

        new RadarImage(emptyMatrix);
    }

    @Test
    public void getValuesFromCorners() {
        RadarImage image = new RadarImage(emptyMatrix);

        String valueTopLeft = image.getValueAt(0,0);
        String valueTopRight = image.getValueAt(0,99);
        String valueBottomLeft = image.getValueAt(49,0);
        String valueBottomRight = image.getValueAt(49,99);

        assertThat(valueTopLeft, is("-"));
        assertThat(valueTopRight, is("-"));
        assertThat(valueBottomLeft, is("-"));
        assertThat(valueBottomRight, is("-"));
    }

    @Test(expected = OutOfRangeException.class)
    public void getValueInvalidRow() {
        RadarImage image = new RadarImage(emptyMatrix);

        image.getValueAt(50,0);
    }

    @Test(expected = OutOfRangeException.class)
    public void getValueInvalidColumn() {
        RadarImage image = new RadarImage(emptyMatrix);

        image.getValueAt(1,100);
    }

    @Test(expected = OutOfRangeException.class)
    public void getValueNegativeColumn() {
        RadarImage image = new RadarImage(emptyMatrix);

        image.getValueAt(1,-1);
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
        emptyMatrix[endRow-1][startColumn]="o";
        emptyMatrix[startRow][endColumn-1]="o";
        emptyMatrix[endRow-1][endColumn-1]="o";

        RadarImage image = new RadarImage(emptyMatrix);
        String[][] subMatrix = MatrixUtils.getEmptyMatrix(endRow-startRow, endColumn-startColumn);
        subMatrix[0][0]="o";
        subMatrix[3][0]="o";
        subMatrix[0][2]="o";
        subMatrix[3][2]="o";


        String[][] subImage = image.getSubImage(startRow, endRow-1, startColumn, endColumn-1);

        assertTrue(Arrays.deepEquals(subImage, subMatrix));
    }

    @Test
    public void getSubImageWithOneElement() {
        int startRow = 4;
        int endRow = 5;
        int startColumn = 6;
        int endColumn = 7;

        RadarImage image = new RadarImage(emptyMatrix);
        String[][] subMatrix = MatrixUtils.getEmptyMatrix(1, 1);

        String[][] subImage = image.getSubImage(startRow, endRow-1, startColumn, endColumn-1);

        assertTrue(Arrays.deepEquals(subImage, subMatrix));
    }



}