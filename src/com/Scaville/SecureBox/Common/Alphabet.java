package com.Scaville.SecureBox.Common;

import java.util.Random;

public class Alphabet {
    private static char[] alphabet = new char[]{
            'A','B','C','D','E',
            'F','H','I','J','K',
            'L','M','N','O','P',
            'Q','R','S','T','W'
            ,'X','Y','Z','1','2','3','4','5','6','7','8','9','0'};

    public static String getRandom(int amount){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < amount; i++){
            Random rand = new Random();
            int random = (int) rand.nextInt(alphabet.length);
            sb.append(alphabet[random]);
        }
        return sb.toString();
    }


}
