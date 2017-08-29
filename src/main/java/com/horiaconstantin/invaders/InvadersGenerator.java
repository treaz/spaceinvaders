package com.horiaconstantin.invaders;

public class InvadersGenerator {

    //TODO consider refactoring this into reading from a file and populating the array in that way

    public static String[][] getInvaderOne(){
        String[][] invader = new String[8][11];
        invader[0] = "--o-----o--".split("");
        invader[1] = "---o---o---".split("");
        invader[2] = "--ooooooo--".split("");
        invader[3] = "-oo-ooo-oo-".split("");
        invader[4] = "ooooooooooo".split("");
        invader[5] = "o-ooooooo-o".split("");
        invader[6] = "o-o-----o-o".split("");
        invader[7] = "---oo-oo---".split("");

        return invader;
    }

    public static String[][] getInvaderTwo(){
        String[][] invader = new String[8][8];
        invader[0] = "---oo---".split("");
        invader[1] = "--oooo--".split("");
        invader[2] = "-oooooo-".split("");
        invader[3] = "oo-oo-oo".split("");
        invader[4] = "oooooooo".split("");
        invader[5] = "--o--o--".split("");
        invader[6] = "-o-oo-o-".split("");
        invader[7] = "o-o--o-o".split("");

        return invader;
    }
}
