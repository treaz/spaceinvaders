package com.horiaconstantin.invaders;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import static com.horiaconstantin.invaders.MatrixUtils.realMatrixToStringMatrix;
import static com.horiaconstantin.invaders.MatrixUtils.stringMatrixToRealMatrix;

public class RadarImage {

    private static final int ROWS = 50; // put this in app properties
    private static final int COLUMNS = 100; // put this in app properties

    // I've really given much thought if for this application I should use String[][] or a Array2DRowRealMatrix
    // I've decided to go with Array2DRowRealMatrix because I trust it more (no need to write unit tests for it) and it contains many methods that I need.
    // Another advantage of using this is that it handles corner cases (exceptions when some input args are incorrect and copying arrays instead of storing their references)
    // The drawback is that it takes more memory, bloats the application and it requires type conversion. But, for the purpose of this app these are not major concerns.
    // Priority is speed of development and tested code
    private RealMatrix radarImage;

    public RadarImage(String[][] radarImage) {
        if (radarImage.length != ROWS){
            throw new IllegalArgumentException("Radar image contains too few rows: '"+radarImage.length+"'. It should have '"+ ROWS +"' rows");
        }
        //TODO improve this double for
        for (String[] row : radarImage) {
            if (row.length != COLUMNS){
                throw new IllegalArgumentException("Radar image row length '"+row.length+"' invalid. All rows should have '"+ COLUMNS +"' chars");
            }
            for (String value : row) {
                if (!"-".equals(value) && !"o".equals(value)){
                    throw new IllegalArgumentException("Radar image contains invalid characters");
                }
            }
        }
        this.radarImage = stringMatrixToRealMatrix(radarImage);
    }

    /**
     * Get the entry in the specified row and column. Row and column indices
     * start at 0.
     *
     * @param row Row index of entry to be fetched.
     * @param column Column index of entry to be fetched.
     * @return the matrix entry at {@code (row, column)}.
     * @throws OutOfRangeException if the row or column index is not valid.
     */
    public String getValueAt(int row, int column){
        return radarImage.getEntry(row, column) == 0 ? "-" : "o";
    }

    /**
     * Gets a submatrix. Rows and columns are indicated
     * counting from 0 to n-1.
     *
     * @param startRow Initial row index
     * @param endRow Final row index (inclusive)
     * @param startColumn Initial column index
     * @param endColumn Final column index (inclusive)
     * @return The subMatrix containing the data of the
     * specified rows and columns.
     * @throws OutOfRangeException if the indices are not valid.
     * @throws NumberIsTooSmallException if {@code endRow < startRow} or
     * {@code endColumn < startColumn}.
     */
    public String[][] getSubImage(int startRow, int endRow, int startColumn, int endColumn){
        RealMatrix subMatrix = radarImage.getSubMatrix(startRow, endRow, startColumn, endColumn);

        return realMatrixToStringMatrix(subMatrix);
    }
}
