package com.horiaconstantin.invaders;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void stringMatrixToRealMatrix_convertsWithCorrectDimensions() {
        String[][] matrix = new String[2][33];
        Arrays.fill(matrix[0], "-");
        Arrays.fill(matrix[1], "o");

        RealMatrix realMatrix = MatrixUtils.stringMatrixToRealMatrix(matrix);

        assertThat(realMatrix.getRowDimension(), is(2));
        assertThat(realMatrix.getColumnDimension(), is(33));
    }

    @Test(expected = NullPointerException.class)
    public void realMatrixToStringMatrix() {
        MatrixUtils.realMatrixToStringMatrix(null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void realMatrixToStringMatrix_incorrectValueThrowsException() {
        RealMatrix matrix = new Array2DRowRealMatrix(1,1);
        matrix.setEntry(0,0, 3);

        MatrixUtils.realMatrixToStringMatrix(matrix);
        fail();
    }

    @Test
    public void realMatrixToStringMatrix_correctConversion() {
        RealMatrix matrix = new Array2DRowRealMatrix(1,2);
        matrix.setEntry(0,0, 1);
        matrix.setEntry(0,1, 0);

        String[][] stringMatrix = MatrixUtils.realMatrixToStringMatrix(matrix);

        assertThat(stringMatrix[0][0], is("o"));
        assertThat(stringMatrix[0][1], is("-"));
        assertThat(stringMatrix.length, is(1));
        assertThat(stringMatrix[0].length, is(2));
    }

    @Test
    public void realMatrixToStringMatrix_convertsWithCorrectDimensions() {
        RealMatrix matrix = new Array2DRowRealMatrix(2,33);

        String[][] stringMatrix = MatrixUtils.realMatrixToStringMatrix(matrix);

        assertThat(stringMatrix.length, is(2));
        assertThat(stringMatrix[0].length, is(33));
    }

}