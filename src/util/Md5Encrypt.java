package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 名称：MD5加密类
 * */
public class Md5Encrypt {
	private final static String DEFAUL_CHARSET = "UTF-8";
	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param text
	 *            明文
	 * 
	 * @return 密文
	 */
	public static String md5(String text) {
		MessageDigest msgDigest = null;

		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(
					"System doesn't support MD5 algorithm.");
		}

		try {
			msgDigest.update(text.getBytes(DEFAUL_CHARSET));

		} catch (UnsupportedEncodingException e) {

			throw new IllegalStateException(
					"System doesn't support your  EncodingException.");

		}

		byte[] bytes = msgDigest.digest();

		String md5Str = new String(encodeHex(bytes));

		return md5Str;
	}
	/**
	 * 生成订单数据流验签串
	 * @param startDate
	 * @param endDate
	 * @param productID
	 * @param productType 产品类型
	 * @param productNum
	 * @param totalAmount
	 * @return
	 */
//	public static String getMd5ForOrder(String startDate,String endDate,Integer productID,Integer productType,Integer productNum,Double totalAmount) {
//		if(!StringUtil.isNotNullorEmpty(startDate)){
//			startDate="";
//		}
//		if(!StringUtil.isNotNullorEmpty(endDate)){
//			endDate="";
//		}
//		StringBuilder stringBuilder=new StringBuilder();
//		stringBuilder.append(startDate).append("_").append(endDate).append("+").append(productID).append("p").append(productType).append(productNum).append("?").append(totalAmount);
//		String orderMD5Key=ReadProperties.readValue("/system.properties", "orderMD5Key");
//		stringBuilder.insert(stringBuilder.length()/2, orderMD5Key);
//		return md5(stringBuilder.toString());
//	}
	
	public static char[] encodeHex(byte[] data) {

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}

}