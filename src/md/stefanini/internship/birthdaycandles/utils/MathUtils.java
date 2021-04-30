package md.stefanini.internship.birthdaycandles.utils;


public class MathUtils {

    public static boolean isBetweenInclusive(int x, int min, int max) {
        return min <= x && x <= max;
    }

    public static boolean isBetweenInclusive(int[] arrayOfX, int min, int max) {
        for (int i = 0; i < arrayOfX.length; i++) {
            if(!isBetweenInclusive(arrayOfX[i], min, max)) {
                return false;
            }
        }
        return true;
    }
}
