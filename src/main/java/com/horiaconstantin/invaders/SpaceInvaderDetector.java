package com.horiaconstantin.invaders;

import lombok.NonNull;

import java.util.Arrays;

public class SpaceInvaderDetector {

    /**
     * Uses a rolling window technique to search for a space invader
     * @param image
     * @param spaceInvader
     * @return
     * * @throws NullPointerException if arguments are null
     */
    public static int searchForSpaceInvader(@NonNull RadarImage image, @NonNull String[][] spaceInvader) {
        int windowWidth = spaceInvader[0].length;
        int windowHeight = spaceInvader.length;

        int invadersFound = 0;
        for (int i = 0; i<=image.getRowDimension()-windowHeight; i++){
            for (int j = 0; j<=image.getColumnDimension()-windowWidth; j++){
                String[][] subImage = image.getSubImage(i, i + windowHeight-1, j, j + windowWidth-1);
                if (Arrays.deepEquals(subImage, spaceInvader)){
                    invadersFound++;
                }
            }
        }

        return invadersFound;
    }
}
