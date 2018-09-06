package com.king.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * filename：com.yilucaifu.utils.ArithmeticUtil.java
 * 
 * @author: zhangyong
 * @time: 2013-11-8下午5:09:48
 */

/**
 * 
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精
 * 
 * 确的浮点数运算，包括加减乘除和四舍五入。
 * 
 * 
 */

public class ArithmeticUtil {

	// 默认除法运算精度

	private static final int DEF_DIV_SCALE = 10;

	// 这个类不能实例化

	private ArithmeticUtil() {

	}

	/**
	 * 
	 * 提供精确的加法运算。
	 * 
	 * 
	 * @param v1
	 *            被加数
	 * 
	 * 
	 * @param v2
	 *            加数
	 * 
	 * @return 两个参数的和
	 * 
	 */

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * 
	 * @param v1
	 *            被减数
	 * 
	 * 
	 * @param v2
	 *            减数
	 * 
	 * @return 两个参数的差
	 * 
	 */

	public static double sub(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.subtract(b2).doubleValue();

	}

	/**
	 * 
	 * 提供精确的乘法运算。
	 * 
	 * 
	 * @param v1
	 *            被乘数
	 * 
	 * 
	 * @param v2
	 *            乘数
	 * 
	 * @return 两个参数的积
	 * 
	 */

	public static double mul(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).doubleValue();

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
	 * 
	 * 小数点以后10位，以后的数字四舍五入。
	 * 
	 * 
	 * @param v1
	 *            被除数
	 * 
	 * 
	 * @param v2
	 *            除数
	 * 
	 * @return 两个参数的商
	 * 
	 */

	public static double div(double v1, double v2) {

		return div(v1, v2, DEF_DIV_SCALE);

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 
	 * 
	 * 定精度，以后的数字四舍五入。
	 * 
	 * 
	 * @param v1
	 *            被除数
	 * 
	 * 
	 * @param v2
	 *            除数
	 * 
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * 
	 * 
	 * @return 两个参数的商
	 * 
	 */

	public static double div(double v1, double v2, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

					"The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * 
	 * @param scale
	 *            小数点后保留几位
	 * 
	 * @return 四舍五入后的结果
	 * 
	 */

	public static double round(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

					"The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/***
	 * 格式化Double类型并保留scale位小数 四舍五入
	 * 
	 * @param doubleVal
	 * @param scale
	 *            scale必须为大于0的正整数，不能等于0
	 * @return
	 */
	public static String formatBy2Scale(Double doubleVal, int scale) {
		if (null == doubleVal) {
			doubleVal = new Double(0);
		}
		StringBuffer sbStr = new StringBuffer("0.");
		for (int i = 0; i < scale; i++) {
			sbStr.append("0");
		}
		DecimalFormat myformat = new DecimalFormat(sbStr.toString());
		return myformat.format(doubleVal);
	}

	/**
	 * 浮点型相加,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String addStr(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(4);
		return subZeroAndDot(nf.format(b1.add(b2).doubleValue()));
	}

	/**
	 * 浮点型相减,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String subStr(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(4);
		return subZeroAndDot(nf.format(b1.subtract(b2).doubleValue()));

	}

	/**
	 * 浮点型相乘,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */

	public static String mulStr(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.multiply(b2).doubleValue()));
	}

	/**
	 * 浮点型相除,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String divStr(double v1, double v2) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMinimumFractionDigits(4);
		return subZeroAndDot(nf.format(div(v1, v2, DEF_DIV_SCALE)));
	}

	/**
	 * 比较大小
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static int compareTod(String v1, String v2) {
		if (!StringUtil.isNumber(v1)) {
			return -1;
		}
		if (!StringUtil.isNumber(v2)) {
			return 1;
		}
		return new BigDecimal(v1).compareTo(new BigDecimal(v2));
	}

	/**
	 * 比较大小
	 * 
	 * @param v1
	 * @param v2
	 * @return v1小于v2返回-1,大于返回1,等于返回0
	 */
	public static int compareString(String v1, String v2) {
		return new BigDecimal(v1).compareTo(new BigDecimal(v2));
	}

	/**
	 * 判断字符串是否为0
	 * 
	 * @param v1
	 * @return
	 */
	public static boolean isZero(String v1) {
		if (!StringUtil.isNumber(v1)) {
			return true;
		}
		int c = compareTod("0", v1);
		return c == 0;
	}

	public static void main(String[] args) {
		// System.out.println(StringUtil.getDivDoubleValue("14347", 10000));
		//
		// BigDecimal b1 = new BigDecimal(14347);
		// BigDecimal b2 = new BigDecimal(10000);
		// System.out.println(b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP)
		// .doubleValue());
		//
		// System.out.println(new java.text.DecimalFormat("#.00")
		// .format(3.1455926));
		//
		// System.out.println(compareTod("0.0000", "0"));

		// String cashMoney = subStr2("16.07", "25.4");
		//
		// System.out.println(ArithmeticUtil.compareTod("-5.3800", "0"));

		// String myProfit = ArithmeticUtil.mulStr(
		// YLCFConstants.activeFundlevelProfitMap.get("E"),
		// ArithmeticUtil.divStr("5332", "10000"));
		// System.out.println(myProfit);
		// compareTod
		// System.out.println(compareTod("1","2"));
		//System.out.println(compareTod("-1", "0"));
		System.out.println(getFormatResult("000012340",2));

		// System.out.println(ArithmeticUtil.compareTod("-5.3800", "0"));

		// System.out.println(mulStr("458489.15489", "787894", 3));

		// NumberFormat nf = NumberFormat.getInstance();
		// nf.setMinimumFractionDigits(2);
		// nf.setGroupingUsed(false);
		// double result = b1.multiply(b2).doubleValue() ;
		// double f1 = result.setScale(2,
		// BigDecimal.ROUND_HALF_UP).doubleValue();

		// System.out.println(
		// subZeroAndDot(nf.format(nf.format("560.524".double))));
	}

	/**
	 * 使用java正则表达式去掉多余的.与0
	 * 
	 * @param s
	 * @return
	 */
	public static String subZeroAndDot(String s) {
		if (s.indexOf(".") > 0) {
			s = s.replaceAll("0+?$", "");// 去掉多余的0
			s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
		}
		return s;
	}

	/**
	 * 浮点型相加,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String addStr(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.add(b2).doubleValue()));
	}

	/**
	 * 浮点型相加,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String addStr(String v1, String v2, int digits) {

		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(digits);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.add(b2).doubleValue()));
	}

	/**
	 * 浮点型相加，输入值可以是科学计数法,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String addStrE(String v1, String v2) {

		if (StringUtil.isEmpty(v1) || StringUtil.isEmpty(v2)) {
			return "0";
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.add(b2).doubleValue()));
	}

	/**
	 * 浮点型相减,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String subStr(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));

		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		return nf.format(b1.subtract(b2).doubleValue());

	}

	public static String subStr(String v1, String v2, int digits) {

		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));

		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(digits);
		nf.setGroupingUsed(false);
		return nf.format(b1.subtract(b2).doubleValue());

	}

	/**
	 * 浮点型相减,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String subStr2(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));

		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setGroupingUsed(false);
		return nf.format(b1.subtract(b2).doubleValue());

	}

	/**
	 * 浮点型相乘,返回值为字符串
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */

	public static String mulStr(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.multiply(b2).doubleValue()));
	}

	public static String mulStr(String v1, String v2, int digits) {
		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(digits);
		nf.setGroupingUsed(false);
		return nf.format(b1.multiply(b2).doubleValue());
	}

	public static String divStr(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue()));
	}

	public static String divStrRoundDown(String v1, String v2, int round) {
		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.divide(b2, round, BigDecimal.ROUND_DOWN).doubleValue()));
	}

	public static String divStr(String v1, String v2, int round) {
		BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
		BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(round);
		nf.setGroupingUsed(false);
		return subZeroAndDot(nf.format(b1.divide(b2, round, BigDecimal.ROUND_HALF_UP).doubleValue()));
	}

	//
	// public static String divStr(String v1, String v2, int HALF_DOWN) {
	// MathContext mc = new MathContext(HALF_DOWN, RoundingMode.HALF_DOWN);
	// BigDecimal b1 = new BigDecimal(getFormatDouble(v1));
	// BigDecimal b2 = new BigDecimal(getFormatDouble(v2));
	// NumberFormat nf = NumberFormat.getInstance();
	// nf.setGroupingUsed(false);
	// return nf.format(b1.divide(b2, mc).doubleValue());
	// }

	/**
	 * 默认返回0
	 * 
	 * @param str
	 *            除数
	 * @return
	 */
	public static String getFormatDouble(String str) {
		if (StringUtil.isNumber(str)) {
			return str;
		}
		return "0";
	}

	public static String getFormatResult(String result, int d) {
		if (StringUtil.isNumber(result)) {
			result = new BigDecimal(result).setScale(d, BigDecimal.ROUND_HALF_UP) + "";
		} else {
			result = "0.00";
		}
		return result;
	}

	/**
	 * 保留小数位（不进位）
	 * @param result
	 * @param d
	 * @return
	 */
	public static String getFormatResultDown(String result, int d) {
		if (StringUtil.isNumber(result)) {
			result = new BigDecimal(result).setScale(d, BigDecimal.ROUND_DOWN) + "";
		} else {
			result = "0.00";
		}
		return result;
	}
	
}
