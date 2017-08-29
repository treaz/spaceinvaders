package com.horiaconstantin.invaders;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixUtilsTest {

    @Test(expected = NotStrictlyPositiveException.class)
    public void getEmptyMatrixWithNegativeArguments() {
        MatrixUtils.getEmptyMatrix(-1, -1);
    }

    @Test(expected = NotStrictlyPositiveException.class)
    public void getEmptyMatrixWithZeroColumns() {
        MatrixUtils.getEmptyMatrix(10, 0);
    }

    @Test
    public void getEmptyMatrix() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(30, 25);

        assertThat(emptyMatrix[0][0], is("-"));
        assertThat(emptyMatrix[29][24], is("-"));
    }


    @Test(expected = NullPointerException.class)
    public void stringMatrixToRealMatrix() {
        MatrixUtils.stringMatrixToRealMatrix(null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void stringMatrixToRealMatrix_nullValues() {
        String[][] matrix = new String[1][1];

        MatrixUtils.stringMatrixToRealMatrix(matrix);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void stringMatrixToRealMatrix_incorrectValueThrowsException() {
        String[][] matrix = new String[1][1];
        matrix[0][0] = "x";

        MatrixUtils.stringMatrixToRealMatrix(matrix);

        fail();
    }

    @Test
    public void stringMatrixToRealMatrix_correctConversion() {
        String[][] matrix = new String[1][2];
        matrix[0][0] = "o";
        matrix[0][1] = "-";

        RealMatrix realMatrix = MatrixUtils.stringMatrixToRealMatrix(matrix);

        assertThat(realMatrix.getEntry(0,0), is(1.0));
        assertThat(realMatrix.getEntry(0,1), is(0.0));
    }

//
//    @Test
//    public void realMatrixToStringMatrix() throws Exception {
//        MatrixUtils.realMatrixToStringMatrix()
//    }

}