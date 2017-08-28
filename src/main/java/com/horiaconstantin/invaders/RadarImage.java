package com.horiaconstantin.invaders;

public class RadarImage {

    private static final int ROWS = 50; // put this in app properties
    private static final int COLUMNS = 100; // put this in app properties

    private String[][] radarImage;//TODO consider using Array2DRowRealMatrix

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
        this.radarImage = radarImage;
    }


    public String getValueAt(int row, int column){
        if (row < 0 || row >= ROWS){
            throw new IllegalArgumentException("Requested row outside the radar image. Allowed values are between 0 and "+ROWS);
        } else if (column < 0 || column >= COLUMNS){
            throw new IllegalArgumentException("Requested column outside the radar image. Allowed values are between 0 and "+COLUMNS);
        }
        return radarImage[row][column];
    }

    // this will do array opearions (starts exactly at start and ends before the endRow)
    public String[][] getSubImage(int startRow, int endRow, int startColumn, int endColumn){
        // todo chekc inputs
        String[][] result = new String[endRow-startRow][endColumn-startColumn];

        for (int i = startRow; i<endRow; i++){
            for (int j = startColumn; j<endColumn; j++){
                result[i-startRow][j-startColumn]=radarImage[i][j];
            }
        }

        return result;
    }
}
