package com.horiaconstantin.invaders;

import lombok.NonNull;

import java.util.Arrays;

public class SpaceInvaderDetector {

    /**
     * Uses a rolling window technique to search for a space invader
     * Drawbacks of the algorythm is that is might count a space invader twice when the allowedErrors is increased a lot
     * Also, it will only scan for invaders strictly in the radar image.
     * If an invader is displayed partially on the radar image (a column/row is missing from it), it will be ignored
     * @param image
     * @param spaceInvader
     * @param allowedErrors
     * @return
     * * @throws NullPointerException if arguments are null
     */
    public static int searchForSpaceInvader(@NonNull RadarImage image, @NonNull String[][] spaceInvader, int allowedErrors) {
        int windowWidth = spaceInvader[0].length;
        int windowHeight = spaceInvader.length;

        int invadersFound = 0;
        for (int i = 0; i<=image.getRowDimension()-windowHeight; i++){
            for (int j = 0; j<=image.getColumnDimension()-windowWidth; j++){
                String[][] subImage = image.getSubImage(i, i + windowHeight-1, j, j + windowWidth-1);
                if (countDifferences(subImage, spaceInvader)<=allowedErrors){
                    System.out.println("i: "+i+"; j:"+j);
                    invadersFound++;
                }
            }
        }
        return invadersFound;
    }

    private static int countDifferences(String[][] matrix1,String[][] matrix2){
        int differences = 0;
        for (int i = 0; i<matrix1.length; i++){
            for (int j = 0; j<matrix1[0].length; j++){
                if (!matrix1[i][j].equals(matrix2[i][j])){
                    differences++;
                }
            }
        }
        return differences;
    }
}
