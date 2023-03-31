package org.vasianovych.division;

public class DivisionMaker {
    public int partialIntDevision(int divided, int divisor) {
        int[] ints = getArrayOfIntegerFromInputInteger(divided);
        drawHeader(divided, divisor);
        return partialIntDevision(ints, divisor, divided);
    }

    private int[] getArrayOfIntegerFromInputInteger(int inputInteger) {
        String stringFromInteger = String.valueOf(inputInteger);
        int length = stringFromInteger.length();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.valueOf(String.valueOf(stringFromInteger.charAt(i)));
        }
        return result;
    }

    private int partialIntDevision(int[] divided, int divisor, int oroginalDivided) {
        int result = 0;
        int indexStart = 0;
        int indexAtTheBeginingOfTheLoop = 0;
        int remain = 0;
        boolean startFlag = true;
        while (indexStart < divided.length) {
            indexAtTheBeginingOfTheLoop = indexStart;
            int tempValue = divided[indexStart] + remain * 10;
            boolean condition = tempValue / divisor > 0;
            if (condition) {
                result = addNumberToResult(tempValue / divisor, result);
                remain = tempValue % divisor;
                indexStart++;
            } else {
                tempValue = tempValue * 10 + divided[indexStart + 1];
                result = addNumberToResult(tempValue / divisor, result);
                remain = tempValue % divisor;
                indexStart = indexStart + 2;
            }

            if (startFlag) {
                int resultLength = String.valueOf(oroginalDivided / divisor).length();
                drawResult(String.valueOf(divisor), getAnyNumberOfSymbol(divided.length - indexAtTheBeginingOfTheLoop - 1, " "), getAnyNumberOfSymbol(resultLength, "-"));
                drawResult("-", getAnyNumberOfSymbol(divided.length - indexAtTheBeginingOfTheLoop - 1, " "), String.valueOf(oroginalDivided / divisor));
                startFlag = false;
            } else {
                drawUsualRow(getAnyNumberOfSymbol(indexAtTheBeginingOfTheLoop - 1, " "), "_" + tempValue);
                drawUsualRow(getAnyNumberOfSymbol(indexAtTheBeginingOfTheLoop, " "), String.valueOf((tempValue / divisor) * divisor));
                drawUsualRow(getAnyNumberOfSymbol(indexAtTheBeginingOfTheLoop, " "), "--");

            }
        }
        drawUsualRow(getAnyNumberOfSymbol(indexAtTheBeginingOfTheLoop, " "), String.valueOf(oroginalDivided % divisor));
        return result;
    }

    private int addNumberToResult(int inputNumber, int inputResult) {
        int result = inputResult;
        int divRes = inputNumber / 10;
        if (divRes < 1) {
            result = result * 10 + inputNumber;
        } else {
            result = result * 100 + inputNumber;
        }
        return result;
    }

    private int getDevisionResult(int[] divided, int divisor) {
        int result = 0;
        return result;
    }

    private void drawHeader(int divided, int divisor) {
        System.out.println("_" + divided + "|" + divisor);
    }

    private void drawResult(String partial, String remainSpaces, String result) {
        System.out.println(" " + partial + remainSpaces + "|" + result);
    }

    private void drawUsualRow(String spaces, String partial) {
        System.out.println(spaces + partial);
    }

    private String getAnyNumberOfSymbol(int n, String symbol) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + symbol;
        }
        return result;
    }
}

