package external_lib;



import java.math.BigDecimal;

import java.math.MathContext;

import java.math.RoundingMode;

public class ArithmeticFunctions {

	

	private static final int BIN_RADIX = 2;

	private static final int OCT_RADIX = 8;

	private static final int HEX_RADIX = 16;

	

	public String add(String x, String y) {

		BigDecimal x1 = new BigDecimal(x);

		BigDecimal y1 = new BigDecimal(y);

		BigDecimal sum = x1.add(y1);

		return sum.toString();

	}

	

	public String addBin(String x, String y) {

		String sum = add(binToInt(x), binToInt(y));

		return Integer.toBinaryString(Integer.parseInt(sum));

	}

	

	public String addOct(String x, String y) {

		String sum = add(octToInt(x), octToInt(y));

		return Integer.toOctalString(Integer.parseInt(sum));

	}

	

	public String addHex(String x, String y) {

		String sum = add(hexToInt(x), hexToInt(y));

		return Integer.toHexString(Integer.parseInt(sum));

	}

	

	public String subtract(String minuend, String subtrahend) {

		BigDecimal x1 = new BigDecimal(minuend);

		BigDecimal y1 = new BigDecimal(subtrahend);

		BigDecimal difference = x1.subtract(y1);

		return difference.toString();

	}

	

	public String subtractBin(String minuend, String subtrahend) {

		String difference = subtract(binToInt(minuend), binToInt(subtrahend));

		return Integer.toBinaryString(Integer.parseInt(difference));

	}

	

	public String subtractOct(String minuend, String subtrahend) {

		String difference = subtract(octToInt(minuend), octToInt(subtrahend));

		return Integer.toOctalString(Integer.parseInt(difference));

	}

	

	public String subtractHex(String minuend, String subtrahend) {

		String difference = subtract(hexToInt(minuend), hexToInt(subtrahend));

		return Integer.toHexString(Integer.parseInt(difference));

	}

	

	public String multiply(String x, String y) {

		BigDecimal x1 = new BigDecimal(x);

		BigDecimal y1 = new BigDecimal(y);

		BigDecimal product = x1.multiply(y1);

		return product.toString();

	}

	

	public String multiplyBin(String x, String y) {

		String product = multiply(binToInt(x), binToInt(y));

		return Integer.toBinaryString(Integer.parseInt(product));

	}

	

	public String multiplyOct(String x, String y) {

		String product = multiply(octToInt(x), octToInt(y));

		return Integer.toOctalString(Integer.parseInt(product));

	}

	

	public String multiplyHex(String x, String y) {

		String product = multiply(hexToInt(x), hexToInt(y));

		return Integer.toHexString(Integer.parseInt(product));

	}

	

	private String divide(String dividend, String divisor, int scale) {

		BigDecimal x = new BigDecimal(dividend);

		BigDecimal y = new BigDecimal(divisor);

		BigDecimal quotient = x.divide(y, scale, RoundingMode.HALF_UP);

		return quotient.toString();

	}

	

	public String divide(String dividend, String divisor) {

		boolean dividendAndDivisorAreInts = true;

		if ((dividend + divisor).contains(".")) {

			dividendAndDivisorAreInts = false;

		}

		String quotient = divide(dividend, divisor, 5);

		if (dividendAndDivisorAreInts && quotient.contains(".00")) {

			quotient = quotient.substring(0, quotient.indexOf("."));

		} else {

			quotient = String.valueOf(Double.parseDouble(quotient));

		}

		return quotient;

	}

	

	public String divideBin(String dividend, String divisor) {

		String quotient = divide(binToInt(dividend), binToInt(divisor), 0);

		return Integer.toBinaryString(Integer.parseInt(quotient));

	}

	

	public String divideOct(String dividend, String divisor) {

		String quotient = divide(octToInt(dividend), octToInt(divisor), 0);

		return Integer.toOctalString(Integer.parseInt(quotient));

	}

	

	public String divideHex(String dividend, String divisor) {

		String quotient = divide(hexToInt(dividend), hexToInt(divisor), 0);

		return Integer.toHexString(Integer.parseInt(quotient));

	}

	

	public String squareRoot(String x) {

		BigDecimal x1 = new BigDecimal(x);

		MathContext mc = new MathContext(10);


		return "1";
	}

	

	public String squareRootBin(String x) {

		String squareRoot = squareRoot(binToInt(x));

		return Integer.toBinaryString(Integer.parseInt(squareRoot));

	}

	

	public String squareRootOct(String x) {

		String squareRoot = squareRoot(octToInt(x));

		return Integer.toOctalString(Integer.parseInt(squareRoot));

	}

	

	public String squareRootHex(String x) {

		String squareRoot = squareRoot(hexToInt(x));

		return Integer.toHexString(Integer.parseInt(squareRoot));

	}

	

	public String power(String base, String exponent) {

		BigDecimal x = new BigDecimal(base);

		int y = Integer.parseInt(exponent);

		BigDecimal power = x.pow(y);

		return power.toString();

	}

	

	public String powerBin(String base, String exponent) {

		String power = power(binToInt(base), binToInt(exponent));

		return Integer.toBinaryString(Integer.parseInt(power));

	}

	

	public String powerOct(String base, String exponent) {

		String power = power(octToInt(base), octToInt(exponent));

		return Integer.toOctalString(Integer.parseInt(power));

	}

	

	public String powerHex(String base, String exponent) {

		String power = power(hexToInt(base), hexToInt(exponent));

		return Integer.toHexString(Integer.parseInt(power));

	}

	

	// ----------- to int -----------

	

	private int intVal(String nonIntValue, int radix) {

		return Integer.parseInt(nonIntValue, radix);

	}

	

	public String binToInt(String binValue) {

		return String.valueOf(intVal(binValue, ArithmeticFunctions.BIN_RADIX));

	}

	

	public String octToInt(String octValue) {

		return String.valueOf(intVal(octValue, ArithmeticFunctions.OCT_RADIX));

	}

	

	public String hexToInt(String hexValue) {

		return String.valueOf(intVal(hexValue, ArithmeticFunctions.HEX_RADIX));

	}

	

	// ----------- to bin -----------

	

	public String intToBin(String intValue) {

		return Integer.toBinaryString(Integer.parseInt(intValue));

	}

	

	public String octToBin(String octValue) {

		return Integer.toBinaryString(Integer.parseInt(octToInt(octValue)));

	}

	

	public String hexToBin(String hexValue) {

		return Integer.toBinaryString(Integer.parseInt(hexToInt(hexValue)));

	}

	

	// ----------- to oct -----------

	

	public String binToOct(String binValue) {

		return Integer.toOctalString(Integer.parseInt(binToInt(binValue)));

	}

	

	public String intToOct(String intValue) {

		return Integer.toOctalString(Integer.parseInt(intValue));

	}

	

	public String hexToOct(String hexValue) {

		return Integer.toOctalString(Integer.parseInt(hexToInt(hexValue)));

	}

	

	// ----------- to hex -----------

	

	public String binToHex(String binValue) {

		return Integer.toHexString(Integer.parseInt(binToInt(binValue)));

	}

	

	public String octToHex(String octValue) {

		return Integer.toHexString(Integer.parseInt(octToInt(octValue)));

	}

	

	public String intToHex(String intValue) {

		return Integer.toHexString(Integer.parseInt(intValue));

	}

	

}