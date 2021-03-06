package com.king.utils;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	private static Random randGen = null;
	private static char[] numbersAndLetters = null;

	private StringUtil() {

	}

	/**
	 * 判断是否为空
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean isEmpty(String arg) {
		return (arg == null)
				|| (arg.trim().equals("") || arg.trim().equals("null") || arg
						.trim().equals("NULL"));
	}

	/**
	 * 判断是否为空，为空时返回true
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean isNotEmpty(String arg) {
		return !isEmpty(arg);
	}

	/**
	 * 以字符串形式返回，null返回空串
	 * 
	 * @param o
	 * @return
	 */
	public static String getStringValue(Object o) {
		if (o == null)
			return "";
		return String.valueOf(o);
	}

	/**
	 * 判断是否是渠道关键字
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean notqudao(String arg) {
		return (arg == null)
				|| (arg.trim().equals("") || (arg.trim().equals("ylcf")));
	}

	public static String trim(String arg) {
		if (!StringUtil.isEmpty(arg)) {
			return arg.trim();
		} else {
			return "";
		}
	}

	/**
	 * 数字长度不够右对齐左补0
	 * 
	 * @param num
	 * @param length
	 * @return
	 */
	public static String fillNumWithLeft(String num, int length) {
		StringBuffer sb = new StringBuffer();
		if (!isEmpty(num)) {
			int i = getStrLength(num);
			if (i > length) {
				sb.append(limitString(num, length));
				// sb.append(num.substring(0, length));
			} else {
				for (; i < length; i++) {
					sb.append("0");
				}
				sb.append(num);
			}

		} else {
			for (int i = 0; i < length; i++) {
				sb.append("0");
			}

		}
		return sb.toString();
	}

	/**
	 * 是否包含空字符串
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean hasNullStr(String arg) {
		return arg == null || arg.trim().equals("")
				|| arg.trim().equalsIgnoreCase("null");
	}

	/**
	 * 去空格
	 * 
	 * @param resource
	 * @param ch
	 * @return
	 */
	public static String removeSpace(String resource) {
		return resource.replace(" ", "");
	}

	/**
	 * 字符串长度不够左对齐右补空格
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public static String fillStrWithRight(String str, int length) {
		StringBuffer sb = new StringBuffer();
		if (!isEmpty(str)) {
			int i = getStrLength(str);
			if (i > length) {
				sb.append(limitString(str, length));
				// sb.append(str.substring(0, length));
			} else {
				sb.append(str);
				for (; i < length; i++) {
					sb.append(" ");
				}
			}
		} else {
			for (int i = 0; i < length; i++) {
				sb.append(" ");
			}

		}
		return sb.toString();
	}

	/**
	 * 获得字符串长度,中文两个长度
	 * 
	 * @param str
	 * @return
	 */
	public static int getStrLength(String str) {
		if (!isEmpty(str)) {
			try {
				return str.getBytes("GBK").length;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param length
	 * @return
	 */
	public static String getSpace(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param date
	 *            时间
	 * @param format
	 *            格式
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		return (new SimpleDateFormat(format)).format(date);
	}

	public static String formatDate(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
	}

	public static String formatDateShort(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

	public static String formatDateByShort(Date date) {
		return (new SimpleDateFormat("yyyyMMdd")).format(date);
	}

	/**
	 * 返回当前日期 yyyyMMdd
	 * 
	 * @return
	 */
	public static String getDate() {
		return (new SimpleDateFormat("yyyyMMdd")).format(new Date());
	}

	/**
	 * 返回当前时间HHmmss
	 * 
	 * @return
	 */
	public static String getTime() {
		return (new SimpleDateFormat("HHmmss")).format(new Date());
	}

	/**
	 * 返回当前时间yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getDateTime() {
		return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
	}

	/**
	 * 获得默认的时间字符串
	 * 
	 * @return
	 */
	public static String findDefaultDateStr() {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
	}

	/**
	 * 根据时间模板返回字符串
	 * 
	 * @param fmt
	 * @return
	 */
	public static String findDateStr(String fmt) {
		return (new SimpleDateFormat(fmt)).format(new Date());
	}

	/**
	 * 不同时间模板之间转换返回字符串
	 *
	 * @param fmt
	 * @return
	 */
	public static  String transferDateStr(String time,String fmtBefore,String fmtAfter) throws ParseException {
		Date date = new SimpleDateFormat(fmtBefore).parse(time);
		String dateStr = new SimpleDateFormat(fmtAfter).format(date);
		return dateStr;
	}


	/**
	 * 验证邮箱是否正确
	 * 
	 * @param searchPhrase
	 * @return
	 */
	public static boolean isEmail(final String searchPhrase) {
		if (!isEmpty(searchPhrase)) {
			final String check = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
			final Pattern regex = Pattern.compile(check);
			final Matcher matcher = regex.matcher(searchPhrase);
			return matcher.matches();
		}
		return false;
	}

	/**
	 * 验证手机号是否正确
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		if (!isEmpty(mobiles)) {
			Pattern p = Pattern
					.compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0-9])|(14[0-9]))\\d{8}$");
			Matcher m = p.matcher(mobiles);
			return m.matches();
		}
		return false;
	}

	/**
	 * 计算字符串长度，拼接报文头,不足前补0
	 * 
	 * @param content
	 * @param lenght
	 * @return
	 */
	public static String computeLengthMergerStr(String content, int lenght) {
		return StringUtil.fillNumWithLeft(content+ "", lenght);
	}

	/**
	 * 根据字节长度截取字符串
	 * 
	 * @param str
	 * @param begin
	 * @param count
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String subBytes(String str, int begin, int count)
			throws UnsupportedEncodingException {
		byte[] src = str.getBytes("GBK");
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++) {
			bs[i - begin] = src[i];
		}
		String s = new String(bs, "GBK");
		return trim(s);
	}

	/**
	 * 获得六位号随机数
	 * 
	 * @return
	 */
	public static String GetRandomNumberStr6() {
		Random r = new Random();
		// return "888888";
		return "" + (r.nextInt(900000) + 100000);
	}

	/**
	 * 2元到十元之间随机数
	 * 
	 * @return
	 */
	public static String GetRandomNumber2To10() {
		long i = Math.round(Math.random() * (799) + 200);
		// return "888888";

		return "" + ArithmeticUtil.divStr(Double.parseDouble("" + i), 100);
	}

	public static String GetRandom10To15() {
		long i = Math.round(Math.random() * (5) + 10);
		return "" + i;
	}

	public static String GetRandom5000To15000() {
		long i = Math.round(Math.random() * (10) + 5);
		return "" + i * 1000;
	}

	// 体验金抽奖金额

	public static String GetRandomVirtual() {

		// Random r = new Random();
		// int rand = (r.nextInt(100) + 1);
		// int money = 2000;
		// if (rand == 2) {
		// money = 3000;
		// }
		// if (rand > 2 && rand <= 5) {
		// money = 5000;
		// }
		// if (rand > 5 && rand <= 10) {
		// money = 6000;
		// }
		// if (rand > 10 && rand <= 20) {
		// money = 7000;
		// }
		// if (rand > 20 && rand <= 30) {
		// money = 8000;
		// }
		// if (rand > 30 && rand <= 40) {
		// money = 9000;
		// }
		// if (rand > 40 && rand <= 100) {
		// money = 10000;
		// }
		// return money + "";
		Random r = new Random();
		int rand = (r.nextInt(100) + 1);
		int money = 2000;
		if (rand == 2) {
			money = 3000;
		}
		if (rand > 2 && rand <= 5) {
			money = 5000;
		}
		if (rand > 5 && rand <= 20) {
			money = 6000;
		}
		if (rand > 20 && rand <= 40) {
			money = 7000;
		}
		if (rand > 40 && rand <= 60) {
			money = 8000;
		}
		if (rand > 60 && rand <= 80) {
			money = 9000;
		}
		if (rand > 80 && rand <= 100) {
			money = 10000;
		}
		return money + "";
	}

	/**
	 * B-F级抽取比例对应表：
	 * 
	 * @return
	 */
	public static String GetRandomB_F() {
		// Random r = new Random();
		// int rand = (r.nextInt(100) + 1);
		// String fundType = "B";
		// if (rand > 5 && rand <= 30) {
		// fundType = "C";
		// }
		// if (rand > 30 && rand <= 60) {
		// fundType = "D";
		// }
		// if (rand > 60 && rand <= 90) {
		// fundType = "E";
		// }
		// if (rand > 90 && rand <= 100) {
		// fundType = "F";
		// }
		// return fundType;
		// Random r = new Random();
		// int rand = (r.nextInt(100) + 1);
		// String fundType = "B";
		// if (rand > 20 && rand <= 40) {
		// fundType = "C";
		// }
		// if (rand > 40 && rand <= 60) {
		// fundType = "D";
		// }
		// if (rand > 60 && rand <= 80) {
		// fundType = "E";
		// }
		// if (rand > 80 && rand <= 100) {
		// fundType = "F";
		// }
		// return fundType;
		Random r = new Random();
		int rand = (r.nextInt(100) + 1);
		String fundType = "B";
		if (rand > 10 && rand <= 50) {
			fundType = "C";
		}
		if (rand > 50 && rand <= 85) {
			fundType = "D";
		}
		if (rand > 85 && rand <= 95) {
			fundType = "E";
		}
		if (rand > 95 && rand <= 100) {
			fundType = "F";
		}
		return fundType;
	}

	public static String GetRandomNumberStr3() {
		Random r = new Random();
		return "" + (r.nextInt(900) + 100);
	}

	public static String GetRandomNumberStr4() {
		Random r = new Random();
		return "" + (r.nextInt(9000) + 1000);
	}

	public static String GetRandomNumberStr5() {
		Random r = new Random();
		return "" + (r.nextInt(90000) + 10000);
	}

	public static boolean isInteger(String arg) {
		return (!isEmpty(arg)) && arg.matches("-?[0-9]*"); // 正负数
	}

	public static boolean isPositiveInteger(String arg) {
		return (!isEmpty(arg)) && arg.matches("[0-9]*"); // 正负数
	}

	/**
	 * 判断是否为金额，最多两位小数，且不能为负
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMoney(String money) {
		if (!isEmpty(money)) {
			Pattern p = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$");
			Matcher m = p.matcher(money);
			return m.matches();
		}
		return false;
	}

	/**
	 * 判断两位小数金额
	 * 
	 * @param money
	 * @return
	 */
	public static boolean isMoney(double money) {
		Pattern p = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$");
		Matcher m = p.matcher("" + money);
		return m.matches();
	}

	/**
	 * 判断两位小数金额
	 * 
	 * @param money
	 * @return
	 */
	public static boolean isFloatMoney(float money) {
		Pattern p = Pattern.compile("^[0-9]+(\\.[0-9]{1,2})?$");
		Matcher m = p.matcher("" + money);
		return m.matches();
	}

	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		if (!isEmpty(str)) {
			return str
					.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		}
		return false;
	}

	/**
	 * 判断是否是邮政编码
	 * 
	 * @param postcode
	 * @return
	 */
	public static boolean isPostcode(String postcode) {
		if (isEmpty(postcode))
			return false;
		return postcode.matches("^[0-9]{6}$");
	}

	/**
	 * 返回double值,默认为0
	 * 
	 * @param str
	 * @return
	 */
	public static double getDefaultDoubleValue(String str) {
		if (StringUtil.isNumber(str)) {
			return Double.parseDouble(str);
		}
		return 0;
	}

	/**
	 * 返回两数相除,默认返回0
	 * 
	 * @param str
	 *            除数
	 * @param d
	 *            被除数
	 * @return
	 */
	public static String getDivDoubleValue(String str, double d) {
		if (StringUtil.isNumber(str)) {
			return ArithmeticUtil.divStr(Double.parseDouble(str), d);
		}
		return "0";
	}

	/**
	 * 获得随机大小英文字符串
	 * 
	 * @param length
	 * @return
	 */
	public static final String getRandomString(int length) {
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			randGen = new Random();
		}
		if (numbersAndLetters == null) {
			numbersAndLetters = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
					.toCharArray();
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(51)];
		}
		return new String(randBuffer);
	}

	/**
	 * sql攻击过滤
	 * 
	 * @param str
	 * @return
	 */
	public static boolean sqlValidate(String str) {
		str = str.toLowerCase();// 统一转为小写
		String badStr = "'|and|exec|execute|insert|create|drop|table|from|grant|use|group_concat|column_name|"
				+ "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
				+ "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";// 过滤掉的sql关键字，可以手动添加
		String[] badStrs = badStr.split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.indexOf(badStrs[i]) != -1) {
				return true;
			}
		}
		return false;
	}

//	/**
//	 * 获得交易流水号
//	 * 
//	 * @return
//	 */
//	public static String getChannelSerialno() {
//		// String sss = new SimpleDateFormat("yyyyMMddHHmmssSSS")
//		// .format(new Date());
//		// return sss + (++PinganConstants.SERIALNO);
//		Calendar cal = Calendar.getInstance();
//		java.util.Date date = cal.getTime();
//		String time = "" + date.getTime();
//		String serialno = "" + (++PinganConstants.SERIALNO) % 10000;
//		return time.substring(0, 10) + StringUtil.fillNumWithLeft(serialno, 4);
//	}

	// public static String getSerialno12() {
	// String sss = new SimpleDateFormat("yyyMMddHHmmssSSS")
	// .format(new Date());
	// // return sss + (++PinganConstants.SERIALNO);
	// Calendar cal = Calendar.getInstance();
	// java.util.Date date = cal.getTime();
	// String time = "" + date.getTime();
	// String serialno = "" + (++PinganConstants.SERIALNO) % 10000;
	// return time.substring(0, 10) + StringUtil.fillNumWithLeft(serialno, 4);
	//
	//
	// }
	/**
	 * 订单号
	 * 
	 * @return
	 */
	public static String getChannelSerialno2() {
		// String serialno = new SimpleDateFormat("yyyyMMddHHmmss")
		// .format(new Date());
		// String no = fillNumWithLeft("" + (++PinganConstants.SERIALNO) % 100,
		// 2);
		// return serialno + GetRandomNumberStr4() + no;
		String serialno = new SimpleDateFormat("yyyyMMddhhmmssSSS")
				.format(new Date());
		return serialno + GetRandomNumberStr4();
	}

	/**
	 * 超级网银转账凭证号（20位长度流水号）
	 * 
	 * @return
	 */
	public static String getThirdVoucher() {
		String serialno = new SimpleDateFormat("yyMMddHHmmssSSS")
				.format(new Date());
		return serialno + GetRandomNumberStr5();
	}

	/**
	 * 超级网银客户自定义凭证号（20位长度流水号）
	 * 
	 * @return
	 */
	public static String getCstInnerFlowNo() {
		String serialno = new SimpleDateFormat("yyyyMMddHHmmssSSS")
				.format(new Date());
		return serialno + GetRandomNumberStr3();
	}

	public static String limitString(String str, int subLength) {
		try {
			if (str == null) {
				return "";
			} else {
				int tempSubLength = subLength;//
				String subStr = str.substring(0,
						str.length() < subLength ? str.length() : subLength);
				int subByetsLength = subStr.getBytes("GBK").length;// 截取子串的字节长度
				// 说明截取的字符串中包含有汉字
				while (subByetsLength > tempSubLength) {
					int subLengthTemp = --subLength;
					subStr = str.substring(0,
							(subLengthTemp > str.length() ? str.length()
									: subLengthTemp));
					subByetsLength = subStr.getBytes("GBK").length;
				}
				return subStr;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String httpChineseEncode(String s) {
		try {
			s = new String(s.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 字符串转时间
	 * 
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date stringToDate(String dateStr, String formatStr) {
		DateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 将Unicode码转换为中文
	public static String tozhCN(String unicode) {
		StringBuffer gbk = new StringBuffer();
		String hex[] = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) { // 注意要从 1 开始，而不是从0开始。第一个是空。
			int data = Integer.parseInt(hex[i], 16); // 将16进制数转换为 10进制的数据。
			gbk.append((char) data); // 强制转换为char类型就是我们的中文字符了。
		}
		return gbk.toString();
	}

	// 将字符串转换为Unicode码
	public static String toUnicode(String zhStr) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < zhStr.length(); i++) {
			char c = zhStr.charAt(i);
			unicode.append("\\u" + Integer.toHexString(c));
		}
		System.out.println(unicode.toString());
		System.out.println(zhStr + "转换为unicode码成功！");
		return unicode.toString();
	}

	public static void appendStrNotEmpty(StringBuffer sb, String str) {
		if (!isEmpty(str))
			sb.append(str);
	}

	// double转字符串且保留2位小数
	public static String doubleToString(Double d) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(d);

	}

	// 判断字符串是否含有中文
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param userType
	 * @param exchangeRate
	 *            以分为单位兑换
	 * @return
	 */
	public static String getRondomMoney(int userType, int exchangeRate) {
		Random random = new Random();
		int a = random.nextInt(100);
		double d = 0;
		if (userType == 0) {
			d = 5000;
		} else {
			if (a < 75) {
				d = random.nextInt(500) + 500;
			} else {
				d = random.nextInt(500) + 1000;
			}
		}
		String money = ArithmeticUtil.divStr(String.valueOf(d), exchangeRate
				+ "");
		return money;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("11="+transferDateStr("20171212","yyyyMMdd","yyyy.MM.dd"));
	}
}
