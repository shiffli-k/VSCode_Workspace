// 29May2026
// Given two strings for different image dimensions, return the aspect ratio of the image with a greater width-to-height ratio.

// The given strings will be in the format "WxH", for example, "1920x1080".
// The aspect ratio is the ratio of width to height, reduced to the lowest whole numbers. For example, "1920x1080" reduces to "16:9".
// Return a string in format "W:H", for example, "16:9".


import java.math.BigInteger;
import java.util.Arrays;

public class AspectRatio {
    public static void main(String[] args) {

        System.out.println(
            Arrays.toString(getWiderAspectRatio("1920x1080", "800x600"))
            +" \n "+
            Arrays.toString(getWiderAspectRatio("1080x1350", "2048x1536"))
            +" \n "+
            Arrays.toString(getWiderAspectRatio("640x480", "2440x1220"))
            +" \n "+
            Arrays.toString(getWiderAspectRatio("360x640", "1080x1920"))
            +" \n "+
            Arrays.toString(getWiderAspectRatio("3440x1440", "2048x858"))
            +" \n "+
            Arrays.toString(getWiderAspectRatio("12345x61234", "12534x51234"))
        );

    }

    private static int[] getWiderAspectRatio(String firstResolution, String secondResolution) {
        
        String[] firstRes = firstResolution.split("x");
        String[] secondRes = secondResolution.split("x");
        
        int w1 = Integer.valueOf(firstRes[0]);
        int h1 = Integer.valueOf(firstRes[1]);

        int w2 = Integer.valueOf(secondRes[0]);
        int h2 = Integer.valueOf(secondRes[1]);

        int[] resultArr = ((w1 * h2) > (w2 * h1)) ? new int[]{w1,h1} : new int[]{w2, h2};        

        int gcdVal = getGcdFor(resultArr[0], resultArr[1]);

        return new int[]{
            resultArr[0] / gcdVal,
            resultArr[1] / gcdVal
        };
    }

    private static int getGcdFor(int firstVal, int secondVal){
        return 
            BigInteger.valueOf(firstVal)
                .gcd(BigInteger.valueOf(secondVal))
                .intValue();

    }
}
