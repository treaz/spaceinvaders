package com.horiaconstantin.invaders;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixUtilsTest {

    @Test(expected = NotStrictlyPositiveException.class)
    public void getEmptyMatrixWithNegativeArguments() throws Exception {
        MatrixUtils.getEmptyMatrix(-1, -1);
    }

    @Test(expected = NotStrictlyPositiveException.class)
    public void getEmptyMatrixWithZeroColumns() throws Exception {
        MatrixUtils.getEmptyMatrix(10, 0);
    }

    @Test
    public void getEmptyMatrix() throws Exception {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(30, 25);

        assertThat(emptyMatrix[0][0], is("-"));
        assertThat(emptyMatrix[29][24], is("-"));
    }


//    @Test
//    public void stringMatrixToRealMatrix() throws Exception {
//        MatrixUtils.stringMatrixToRealMatrix()
//    }
//
//    @Test
//    public void realMatrixToStringMatrix() throws Exception {
//        MatrixUtils.realMatrixToStringMatrix()
//    }

}