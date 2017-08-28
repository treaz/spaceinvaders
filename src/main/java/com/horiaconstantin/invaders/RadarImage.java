package com.horiaconstantin.invaders;

public class RadarImage {

    private static final int ROWS = 50; // put this in app properties
    private static final int COLUMNS = 100; // put this in app properties

    private String[][] radarImage;

    public RadarImage(String[][] radarImage) {
        if (radarImage.length != ROWS){
            throw new InvalidRadarInput("Radar image contains too few rows: '"+radarImage.length+"'. It should have '"+ ROWS +"' rows");
        }
        //TODO improve this double for
        for (String[] row : radarImage) {
            if (row.length != COLUMNS){
                throw new InvalidRadarInput("Radar image row length '"+row.length+"' invalid. All rows should have '"+ COLUMNS +"' chars");
            }
            for (String value : row) {
                if (!"-".equals(value) && !"o".equals(value)){
                    throw new InvalidRadarInput("Radar image contains invalid characters");
                }
            }
        }
        this.radarImage = radarImage;
    }

    public String getValueAt(int row, int column){
        return radarImage[row][column];
    }
}
