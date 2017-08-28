package com.horiaconstantin.invaders;

import com.horiaconstantin.invaders.InvalidRadarInput;
import com.horiaconstantin.invaders.MatrixUtils;
import com.horiaconstantin.invaders.RadarImage;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RadarImageTest {

    @Test
    public void createValidRadarImage() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(100, 50, "-");
        RadarImage image = new RadarImage(emptyMatrix);
        assertNotNull(image);
    }

    @Test(expected = InvalidRadarInput.class)
    public void createRadarImageWithInvalidChars() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(100, 50, "x");
        new RadarImage(emptyMatrix);
    }

    @Test(expected = InvalidRadarInput.class)
    public void createRadarImageWithInvalidSize() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(77, 50, "-");
        new RadarImage(emptyMatrix);
    }

    @Test
    public void getValueAtTopLeft() {
        String[][] emptyMatrix = MatrixUtils.getEmptyMatrix(100, 50, "-");
        RadarImage image = new RadarImage(emptyMatrix);
        assertThat(image.getValueAt(0,0), is("-"));
    }

}