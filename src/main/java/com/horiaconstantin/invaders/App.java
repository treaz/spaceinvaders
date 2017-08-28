package com.horiaconstantin.invaders;

public class App {

    public static final int ROW_LENGTH = 100; // put this in app properties
    public static final int NUMBER_OF_ROWS = 50; // put this in app properties
    private String[][] radarImage; //todo this can be an object

    public App(String[][] radarImage) throws Exception {
        //todo move the validations in an object
        if (radarImage.length != NUMBER_OF_ROWS){
            throw new Exception("Radar image contains too few rows: '"+radarImage.length+"'. It should have '"+NUMBER_OF_ROWS+"' rows");
        }
        //TODO improve this double for
        for (String[] row : radarImage) {
            if (row.length != ROW_LENGTH){
                throw new Exception("Radar image row length '"+row.length+"' invalid. Rows should have '"+ROW_LENGTH+"' chars");
            }
            for (String value : row) {
                if (!"-".equals(value) || !"o".equals(value)){
                    //TODO make this exception app specific
                    throw new Exception("Radar image contains invalid characters");
                }
            }
        }
        this.radarImage = radarImage;
    }

    public static void detectInvaders() {

        //radar size
        String[][] input = new String[ROW_LENGTH][NUMBER_OF_ROWS];
    }

    public static void main(String[] args) {
//        System.out.println(MatrixUtils.getEmptyRadarImage());
    }
}
