public class NumbersToWords {

  private static final String[] subTwenty = {
    "",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen"
  };

  private static final String[] multiplesOfTen = {
    "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
  };

  private static final Integer[] thousandsIntegers = {
    100, 1_000, 1_000_000, 1_000_000_000, 1_000_000_000
  };

  private static final String[] thousandsStrings = {
    " hundred", " thousand", " million", " billion", " trillion"
  };

  public static String transformInputNumber(int inputNumber) {
    if (inputNumber == 0) { // base case
      return "zero";
    }
    return transform(inputNumber);
  }

  /**
   * Recursively transform an integer input number into its string-equivalent words. Using integer
   * because upper bound of input is 100,000 (int upper bound is 2147483647)
   *
   * @param inputNumber The input number integer to be transformed.
   * @return the String words representing a given input number integer.
   */
  private static String transform(int inputNumber) {
    if (inputNumber < 20) {

      return subTwenty[inputNumber];

    } else if (inputNumber < 100) {

      int inputNumberMod10 = inputNumber % 10;
      String spacing = (inputNumberMod10 != 0) ? "-" : "";
      return multiplesOfTen[inputNumber / 10] + spacing + subTwenty[inputNumberMod10];

    } else if (inputNumber < 1000) {

      int inputNumberMod100 = inputNumber % 100;
      String spacing = (inputNumberMod100 != 0) ? " and " : "";
      return subTwenty[inputNumber / 100] + " hundred" + spacing + transform(inputNumberMod100);

    } else {
      // generic case
      String inputNumberString = Integer.toString(inputNumber);
      int inputNumberStringLength = inputNumberString.length();
      int inputNumberStringLengthBy3 = (inputNumberStringLength - 1) / 3; // 999,999 should divide by 1,000 (1st element not 2nd element)
      // x = number to divide by and to be used to find remainder
      int x = thousandsIntegers[inputNumberStringLengthBy3];
      int inputNumberModX = inputNumber % x;
      String spacing =
          (inputNumberModX != 0) ? ((inputNumberModX < 100) ? " and " : ", ") : "";
      return transform(inputNumber / x) 
        + thousandsStrings[inputNumberStringLengthBy3] 
        + spacing 
        + transform(inputNumberModX);
    }
  }

  public static void main(String[] args) {
    int numberToBeConverted = Integer.parseInt(args[0]);
    System.out.println(transformInputNumber(numberToBeConverted));
  }
}
