package com.horiaconstantin.invaders;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SpaceInvaderDetectorTest {

    RealMatrix matrix;
    String[][] invaderOne;
    String[][] invaderTwo;

    @Before
    public void before(){
        matrix = new Array2DRowRealMatrix(50, 100);
        invaderOne = InvadersGenerator.getInvaderOne();
        invaderTwo = InvadersGenerator.getInvaderTwo();
    }

    @Test
    public void searchForSpaceInvader_emptyImage(){
        RadarImage image = new RadarImage(matrix);

        int spaceInvadersFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderOne);

        assertThat(spaceInvadersFound, is(0));
    }

    @Test
    public void searchForSpaceInvader_spaceInvaderAtTopLeft(){

        RealMatrix invaderOneMatrix = MatrixUtils.stringMatrixToRealMatrix(invaderOne);
        matrix.setSubMatrix(invaderOneMatrix.getData(), 0, 0);
        RadarImage image = new RadarImage(matrix);

        int spaceInvadersFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderOne);

        assertThat(spaceInvadersFound, is(1));
    }

    @Test
    public void searchForSpaceInvader_spaceInvaderAtTopRight(){
        RealMatrix invaderOneMatrix = MatrixUtils.stringMatrixToRealMatrix(invaderOne);
        matrix.setSubMatrix(invaderOneMatrix.getData(), 0, 100-invaderOneMatrix.getColumnDimension());
        RadarImage image = new RadarImage(matrix);

        int spaceInvadersFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderOne);

        assertThat(spaceInvadersFound, is(1));
    }

    @Test
    public void searchForSpaceInvader_spaceInvaderAtBottomLeft(){
        RealMatrix invaderOneMatrix = MatrixUtils.stringMatrixToRealMatrix(invaderOne);
        matrix.setSubMatrix(invaderOneMatrix.getData(), 50-invaderOneMatrix.getRowDimension(), 0);
        RadarImage image = new RadarImage(matrix);

        int spaceInvadersFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderOne);

        assertThat(spaceInvadersFound, is(1));
    }

    @Test
    public void searchForSpaceInvader_spaceInvaderAtBottomRight(){
        RealMatrix invaderOneMatrix = MatrixUtils.stringMatrixToRealMatrix(invaderOne);
        matrix.setSubMatrix(invaderOneMatrix.getData(), 50-invaderOneMatrix.getRowDimension(), 100-invaderOneMatrix.getColumnDimension());
        RadarImage image = new RadarImage(matrix);

        int spaceInvadersFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderOne);

        assertThat(spaceInvadersFound, is(1));
    }

    @Test
    public void searchForSpaceInvader_spaceInvaderTwoAtBottomRight(){
        RealMatrix invaderOneMatrix = MatrixUtils.stringMatrixToRealMatrix(invaderTwo);
        matrix.setSubMatrix(invaderOneMatrix.getData(), 50-invaderOneMatrix.getRowDimension(), 100-invaderOneMatrix.getColumnDimension());
        RadarImage image = new RadarImage(matrix);

        int spaceInvadersFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderTwo);

        assertThat(spaceInvadersFound, is(1));
    }

    @Test
    public void searchForSpaceInvader_threeInvaders(){
        RealMatrix invaderTwoMatrix = MatrixUtils.stringMatrixToRealMatrix(invaderTwo);
        RealMatrix invaderOneMatrix = MatrixUtils.stringMatrixToRealMatrix(invaderOne);
        matrix.setSubMatrix(invaderOneMatrix.getData(), 5, 10);
        matrix.setSubMatrix(invaderOneMatrix.getData(), 22, 80);
        matrix.setSubMatrix(invaderTwoMatrix.getData(), 30, 50);
        RadarImage image = new RadarImage(matrix);

        int spaceInvadersTwoFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderTwo);
        int spaceInvadersOneFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderOne);

        assertThat(spaceInvadersTwoFound, is(1));
        assertThat(spaceInvadersOneFound, is(2));
    }

    @Test
    public void searchForSpaceInvader_InvadersInAllCorners() throws IOException {
        RadarImage image = new RadarImage(TestUtils.readMatrixFromFile("images/invadersInAllCorners.txt"));

        int spaceInvadersTwoFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderTwo);
        int spaceInvadersOneFound = SpaceInvaderDetector.searchForSpaceInvader(image, invaderOne);

        assertThat(spaceInvadersTwoFound, is(2));
        assertThat(spaceInvadersOneFound, is(2));
    }


}