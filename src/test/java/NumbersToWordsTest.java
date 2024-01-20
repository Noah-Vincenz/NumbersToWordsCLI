import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NumbersToWordsTest {

  @Test
  void test_transformInputNumber() {
    assertEquals("zero", NumbersToWords.transformInputNumber(0));
    assertEquals("one thousand", NumbersToWords.transformInputNumber(1000));
    assertEquals("one hundred and one", NumbersToWords.transformInputNumber(101));
    assertEquals("three hundred and fifty-two", NumbersToWords.transformInputNumber(352));
    assertEquals("twelve thousand, three hundred", NumbersToWords.transformInputNumber(12300));
    assertEquals("twelve thousand and fifty-five", NumbersToWords.transformInputNumber(12055));
    assertEquals("twelve thousand, three hundred and forty-five", NumbersToWords.transformInputNumber(12345));
    assertEquals("one billion", NumbersToWords.transformInputNumber(1000000000));
    assertEquals("one billion, three hundred thousand and twelve", NumbersToWords.transformInputNumber(1_000_300_012));
  }
}
