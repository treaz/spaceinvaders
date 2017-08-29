package com.horiaconstantin.invaders;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class RadarImage {

    private static final int ROWS = 50; // put this in app properties
    private static final int COLUMNS = 100; // put this in app properties


    // I've really given much thought if for this application I should use String[][] or a Array2DRowRealMatrix
    // I've decided to go with Array2DRowRealMatrix because I trust it more (no need to write unit tests for it) and it contains many methods that I need
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

    private RealMatrix stringMatrixToRealMatrix(String[][] radarImage){
        double[][] radarImageAsNumbers = new double[radarImage.length][radarImage[0].length];
        for (int i = 0; i<radarImage.length; i++){
            for (int j = 0; j<radarImage[0].length; j++){
                radarImageAsNumbers[i][j] = ("-".equals(radarImage[i][j]) ? 0 : 1);
            }
        }

        return new Array2DRowRealMatrix(radarImageAsNumbers);
    }

    private String[][] realMatrixToStringMatrix(RealMatrix radarImageMartix){
        double[][] radarImageAsNumbers = radarImageMartix.getData();

        String[][] radarImage = new String[radarImageAsNumbers.length][radarImageAsNumbers[0].length];
        for (int i = 0; i<radarImageAsNumbers.length; i++){
            for (int j = 0; j<radarImageAsNumbers[0].length; j++){
                radarImage[i][j] = (0 == radarImageAsNumbers[i][j] ? "-" : "o");
            }
        }

        return radarImage;
    }


    public String getValueAt(int row, int column){
        if (row < 0 || row >= ROWS){
            throw new IllegalArgumentException("Requested row outside the radar image. Allowed values are between 0 and "+ROWS);
        } else if (column < 0 || column >= COLUMNS){
            throw new IllegalArgumentException("Requested column outside the radar image. Allowed values are between 0 and "+COLUMNS);
        }
        return radarImage.getEntry(row, column) == 0 ? "-" : "o";
    }

    /**
     *
     * @param startRow
     * @param endRow
     * @param startColumn
     * @param endColumn
     * @return
     */
    public String[][] getSubImage(int startRow, int endRow, int startColumn, int endColumn){
        RealMatrix subMatrix = radarImage.getSubMatrix(startRow, endRow-1, startColumn, endColumn-1);

        return realMatrixToStringMatrix(subMatrix);
    }
}
