package md.stefanini.internship.birthdaycandles;

import md.stefanini.internship.birthdaycandles.utils.MathUtils;

import java.util.Scanner;

public class Main {

    private static final int MAX_ALLOWED_CANDLE_HEIGHT = 1000;
    private static final int MIN_ALLOWED_CANDLE_HEIGHT = 1;

    private static final String SPACE = " ";

    public static void main(String[] args) {
        // Open an input scanner
        Scanner scanner = new Scanner(System.in);

        // Read number of candles
        int numberOfCandles = scanner.nextInt();

        // Ignore one new line
        scanner.nextLine();

        // Read candle heights
        String candleHeightsInput = scanner.nextLine();
        int[] candleHeights = readCandleHeights(candleHeightsInput, numberOfCandles);

        // Check that provided values are between 1 and 1000
        if (MathUtils.isBetweenInclusive(numberOfCandles, MIN_ALLOWED_CANDLE_HEIGHT, MAX_ALLOWED_CANDLE_HEIGHT)
                && MathUtils.isBetweenInclusive(candleHeights, MIN_ALLOWED_CANDLE_HEIGHT, MAX_ALLOWED_CANDLE_HEIGHT)) {
            // Calculate number of tallest candles
            int numberOfTallestCandles = birthdayCakeCandles(candleHeights);
            // Print number of tallest candles
            System.out.println(numberOfTallestCandles);
        } else {
            System.err.println("Provided values are not between 1 and 1000");
        }

        // Close scanner
        scanner.close();
        // Exit application
        System.exit(0);
    }

    private static int[] readCandleHeights(String candleHeightsInput, int numberOfCandles) {
        // Remove trailing spaces and split by space
        String[] candleHeightsInputArray = candleHeightsInput.trim().split(SPACE);

        if(candleHeightsInputArray.length != numberOfCandles) {
            System.err.printf("Incorrect number of candles. Should be %d \n", numberOfCandles);
            System.exit(0);
        }

        // Convert strings to numbers
        int[] candleHeights = new int[numberOfCandles];
        for (int i = 0; i < candleHeightsInputArray.length; i++) {
            candleHeights[i] = Integer.parseInt(candleHeightsInputArray[i]);
        }

        return candleHeights;
    }

    private static int birthdayCakeCandles(int[] candleHeights) {
        // Let the first candle be tallest
        int tallestCandle = candleHeights[0];
        int numberOfTallestCandles = 1;
        
        for (int i = 1; i < candleHeights.length; i++) {
            // If there is a taller candle, reset tallestCandle and numberOfTallestCandles
            if(candleHeights[i] > tallestCandle) {
                tallestCandle = candleHeights[i];
                numberOfTallestCandles = 1;
            }
            // If there is another candle with the same height, increment numberOfTallestCandles
            if(candleHeights[i] == tallestCandle) {
                numberOfTallestCandles++;
            }
        }

        return numberOfTallestCandles;
    }

}
