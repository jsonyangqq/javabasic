package com.interview.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtil {
	public static boolean isEmptyStr(String str) {
		return str == null || str.trim().length() == 0
				|| str.trim().equals("null");
	}

	public static boolean isEmptyCollection(Collection c) {
		return c == null || c.isEmpty();
	}

	public static boolean containsKey(Collection c, Object o) {
		return c != null && c.contains(o);
	}

	public static boolean containsKey(Map m, Object o) {
		return m != null && m.containsKey(o);
	}

	public static boolean isEmptyMap(Map m) {
		return m == null || m.isEmpty();
		
	}
	
	public static String getPadingStr(String str, String pading, int len) {
		String result = str;
		for (int i = 0; i < len - str.length(); i++)
			result = (new StringBuilder(pading)).append(result).toString();

		return result;
	}
	
	public static boolean checkArrayIsNull(Object obj[]) {
		if (obj.length == 0)
			return true;
		for (int i = 0; i < obj.length; i++)
			if (obj[i] != null)
				return false;

		return true;
	}
	
	public static String nvl(String strChk) {
		return nvl(strChk, "");
	}
	
	public static String nvl(String strChk, String strExp) {
		if (isEmptyStr(strChk))
			return strExp;
		else
			return strChk;
	}
	
	public static boolean ipIsValid(String ipSection, String ip) {
		int idx = ipSection.indexOf('-');
		String[] sips = ipSection.substring(0, idx).split("\\.");
		String[] sipe = ipSection.substring(idx + 1).split("\\.");
		String[] sipt = ip.split("\\.");
		long ips = 0L, ipe = 0L, ipt = 0L;
//////System.out.println(sips.length + " " + sipe.length + " " + sipt.length);
		for (int i = 0; i < 4; ++i) {
//////System.out.println(sips[i] + " " + sipe[i] + " " + sipt[i]);
			ips = ips << 8 | Integer.parseInt(sips[i]);
			ipe = ipe << 8 | Integer.parseInt(sipe[i]);
			ipt = ipt << 8 | Integer.parseInt(sipt[i]);
		}
		
		if (ips > ipe) {
			long t = ips;
			ips = ipe;
			ipe = t;
		}
		
		return ips <= ipt && ipt <= ipe;
	}
	
	public static String getLocalnetTab(String userPrefix, String tableName, String localnet) {
		String sufix = getLocalnetTabSufix(localnet);
		if (CommonUtil.isEmptyStr(sufix)) {
			return "";
		} else {
			StringBuffer tab = new StringBuffer();
			tab.append(userPrefix);
			tab.append(sufix);
			tab.append(".");
			tab.append(tableName);
			return tab.toString();
		}
	}
	
	public static String getLocalnetTab(String userPrefix, String tableName, String localnet, String dblink) {
		String sufix = getLocalnetTabSufix(localnet);
		if (CommonUtil.isEmptyStr(sufix)) {
			return "";
		} else {
			StringBuffer tab = new StringBuffer();
			tab.append(userPrefix);
			tab.append(sufix);
			tab.append(".");
			tab.append(tableName);
			tab.append("@");
			tab.append(dblink);
			return tab.toString();
		}
	}
	
	public static String getLocalnetMonthTabNoDblink(String userPrefix, String tableName, String month, String localnet) {
		String sufix = getLocalnetTabSufix(localnet);
		if (CommonUtil.isEmptyStr(sufix)) {
			return "";
		} else {
			StringBuffer tab = new StringBuffer();
			tab.append(userPrefix);
			tab.append(sufix);
			tab.append(".");
			tab.append(tableName);
			tab.append("_");
			tab.append(month);
			tab.append("_T");
			return tab.toString();
		}
	}
	
	public static String getLocalnetMonthTab(String userPrefix, String tableName, String month, String localnet, String dblink) {
		String sufix = getLocalnetTabSufix(localnet);
		if (CommonUtil.isEmptyStr(sufix)) {
			return "";
		} else {
			StringBuffer tab = new StringBuffer();
			tab.append(userPrefix);
			tab.append(sufix);
			tab.append(".");
			tab.append(tableName);
			tab.append("_");
			tab.append(month);
			tab.append("_T");
			if (!CommonUtil.isEmptyStr(dblink)) {
				tab.append("@");
				tab.append(dblink);
			}
			return tab.toString();
		}
	}
	
	private static Map<String, String> lnDesc = new HashMap<String, String>();
	static {
		lnDesc.put("1001", "武汉");
		lnDesc.put("1003", "襄樊");
		lnDesc.put("1004", "黄冈");
		lnDesc.put("1005", "宜昌");
		lnDesc.put("1006", "孝感");
		lnDesc.put("1007", "鄂州");
		lnDesc.put("1008", "咸宁");
		lnDesc.put("1009", "十堰");
		lnDesc.put("1010", "荆门");
		lnDesc.put("1011", "黄石");
		lnDesc.put("1012", "随州");
		lnDesc.put("1013", "恩施");
		lnDesc.put("1014", "仙桃");
		lnDesc.put("1015", "天门");
		lnDesc.put("1016", "潜江");
		lnDesc.put("1017", "神龙架");
		lnDesc.put("1018", "荆州");
	}
	
	public static String getLocalnetDesc(String localnet) {
		return lnDesc.get(localnet);
	}
	
	public static String getLocalnetTabSufix(String localnet) {
		String userSufix = "";
    	if (localnet.equals("1003")) {//襄樊
    		userSufix = "_xf";
    	} else if (localnet.equals("1004")) {//黄冈
    		userSufix = "_hg";
    	} else if (localnet.equals("1005")) {//宜昌
    		userSufix = "_yc";
    	} else if (localnet.equals("1006")) {//孝感
    		userSufix = "_xg";
    	} else if (localnet.equals("1007")) {//鄂州
    		userSufix = "_ez";
    	} else if (localnet.equals("1008")) {//咸宁
    		userSufix = "_xn";
    	} else if (localnet.equals("1009")) {//十堰
    		userSufix = "_sy";
    	} else if (localnet.equals("1010")) {//荆门
    		userSufix = "_jm";
    	} else if (localnet.equals("1011")) {//黄石
    		userSufix = "_hs";
    	} else if (localnet.equals("1012")) {//随州
    		userSufix = "_sz";
    	} else if (localnet.equals("1013")) {//恩施
    		userSufix = "_es";
    	} else if (localnet.equals("1014")) {//仙桃
    		userSufix = "_xt";
    	} else if (localnet.equals("1015")) {//天门
    		userSufix = "_tm";
    	} else if (localnet.equals("1016")) {//潜江
    		userSufix = "_qj";
    	} else if (localnet.equals("1017")) {//神龙架
    		userSufix = "_snj";
    	} else if (localnet.equals("1018")) {//荆州
    		userSufix = "_jz";
    	}
    	
    	return userSufix;
	}

	public static String hidInfo(String str) throws Exception {
		if (isEmptyStr(str)) {
			return str;
		}
		
		int hidLen = str.length()/3;
		int remainLen = str.length() - hidLen;
		String rtnStr = str.substring(0, remainLen);
		StringBuffer sb = new StringBuffer();
		sb.append(rtnStr);
		for (int i = 0; i < hidLen; i++) {
			sb.append("*");
		}
		
		return sb.toString();
	}
	
	public static String hash(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes());
        byte md5byte[] = md5.digest();
        String enc = Base64.encode(md5byte);
        enc = enc.replace('+', '1');//如果是http get方式传递参数的话，+是特殊字符。
        enc = enc.replace('=', '2');
        enc = enc.replace('/', '3');
        return enc;
    }
	
	public static String localEnc(String str) {
		return str;
	}
	
	public static String getTransferSmsCode(String smsCode) {
		//s1:YYMMDD+8位流水(Q[0,1,2,3,4,5,6,7])，混淆编排
		//   76Y5M4Y3D2M1D0
		char[] cs = new char[14];
		cs[0]  = smsCode.charAt(13);
		cs[1]  = smsCode.charAt(12);
		cs[2]  = smsCode.charAt(0);
		cs[3]  = smsCode.charAt(11);
		cs[4]  = smsCode.charAt(2);
		cs[5]  = smsCode.charAt(10);
		cs[6]  = smsCode.charAt(1);
		cs[7]  = smsCode.charAt(9);
		cs[8]  = smsCode.charAt(4);
		cs[9]  = smsCode.charAt(8);
		cs[10] = smsCode.charAt(3);
		cs[11] = smsCode.charAt(7);
		cs[12] = smsCode.charAt(5);
		cs[13] = smsCode.charAt(6);

//////System.out.println(" -getTransferSmsCode begin- \n");
//for (int i = 0; i < 14; i++) {
//	//System.out.print(cs[i]);
//	//System.out.print(" ");
//}
//////System.out.println(" ");
//////System.out.println(" -getTransferSmsCode end- ");

		return new String(cs);
	}

	public static String getSmsCodeSum(String smsCode) {
		if (CommonUtil.isEmptyStr(smsCode)) {
			return "000";
		}
		
		int sum = 0;
		int len = smsCode.length();
		for (int i = 0; i < len; i++) {
			sum += Character.digit(smsCode.charAt(i), 10);
		}
		
		if (sum < 10) {
			return "00" + sum;
		} else if (sum < 100) {
			return "0" + sum;
		} else {
			return "" + sum;
		}
	}
	
	public static StringBuffer alpha = new StringBuffer("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");//62位原始字典
	//在苹果手机上，屏幕取词比较完备，即使url里面有符号之类的都可以完成对url的识别，但是android中，如果url中带有符号，则符号后面的部分不能被识别为url的一部分
	//所以，字典里面不能有符号，但是字母数字一共只有62个，必须用两个其他字符作为填充。考虑到算法的编码原则，每个1-9的数字被认为是4位，然后顺次组成6位的编码，用以
	//检索64位的字典，而1-9之间的数做4位编码，最多有连续3个1，比如7位0111，而63要求连续6个1：111111，62要求连续5个1，这两个情况都不可能出现，
    //所以字典只需要62位！！！！！
	public static String alpha1 = "1fqzcuWhNE4T8x5QjSKbtCAv0MXeB2yd7kYHOJmIRlnwUg6oVGpsLi3rZaFPD9";//经过混淆的62位字典
	
	static Map<String, Integer> alphaIdxMap = new HashMap<String, Integer>();
	static {
		for (int i = 0; i < alpha1.length(); i++) {
			alphaIdxMap.put(alpha1.substring(i, i+1), new Integer(i));
		}
	}
	
	public static String getMapString(String smsCode) {
		String sum  = getSmsCodeSum(smsCode);
//////System.out.println("getMapString sum = " + sum);
		String code = getTransferSmsCode(smsCode) + sum;//17位
//////System.out.println("getMapString transCode = " + code);
		
		//YYMMDD+8位序列+3位和,共17位，68个bit，其中月份的第一位(打乱后第4位)可以用1位bit标识(省3位)，日期第一位(打乱后第8位)可以用2位bit标识(省2位)，
        //三位数字和第一位(整个码的14位)可以用1位bit标识(省3位) 所以最终只需要60个bit
		//每六个一组，形成一个64以内的整数，用以在64位混淆过的字典中映射。采用little endian序
		StringBuffer result = new StringBuffer();

//////System.out.println((((code.charAt(0) - 48)&0x000f) << 2 ) + (((code.charAt(1) - 48)&0x000c) >> 2));
		result.append(alpha1.charAt( (((code.charAt(0) - 48)&0x000f) << 2 ) + (((code.charAt(1) - 48)&0x000c) >> 2) ));
//////System.out.println((((code.charAt(1) - 48)&0x0003) << 4 ) + ((code.charAt(2) - 48)&0x000f));
		result.append(alpha1.charAt( (((code.charAt(1) - 48)&0x0003) << 4 ) + ((code.charAt(2) - 48)&0x000f) ));
//////System.out.println((((code.charAt(3) - 48)&0x000f) << 2 ) + (((code.charAt(4) - 48)&0x0001) << 1) + (((code.charAt(5) - 48)&0x0008) >> 3));
		result.append(alpha1.charAt( (((code.charAt(3) - 48)&0x000f) << 2 ) + (((code.charAt(4) - 48)&0x0001) << 1) + (((code.charAt(5) - 48)&0x0008) >> 3) ));
//////System.out.println((((code.charAt(5) - 48)&0x0007) << 3 ) + (((code.charAt(6) - 48)&0x000e) >> 1));
		result.append(alpha1.charAt( (((code.charAt(5) - 48)&0x0007) << 3 ) + (((code.charAt(6) - 48)&0x000e) >> 1) ));
//////System.out.println((((code.charAt(6) - 48)&0x0001) << 5 ) + (((code.charAt(7) - 48)&0x000f) << 1) + (((code.charAt(8) - 48)&0x0002) >> 1));
		result.append(alpha1.charAt( (((code.charAt(6) - 48)&0x0001) << 5 ) + (((code.charAt(7) - 48)&0x000f) << 1) + (((code.charAt(8) - 48)&0x0002) >> 1) ));
//////System.out.println((((code.charAt(8) - 48)&0x0001) << 5 ) + (((code.charAt(9) - 48)&0x000f) << 1) + (((code.charAt(10) - 48)&0x0008) >> 3));
		result.append(alpha1.charAt( (((code.charAt(8) - 48)&0x0001) << 5 ) + (((code.charAt(9) - 48)&0x000f) << 1) + (((code.charAt(10) - 48)&0x0008) >> 3) ));
//////System.out.println((((code.charAt(10) - 48)&0x0007) << 3 ) + (((code.charAt(11) - 48)&0x000e) >> 1));
		result.append(alpha1.charAt( (((code.charAt(10) - 48)&0x0007) << 3 ) + (((code.charAt(11) - 48)&0x000e) >> 1) ));
//////System.out.println(((((code.charAt(11) - 48)&0x0001) << 5) + (((code.charAt(12) - 48)&0x000f) << 1) + (((code.charAt(13) - 48)&0x0008) >> 3)) );
		result.append(alpha1.charAt( (((code.charAt(11) - 48)&0x0001) << 5) + (((code.charAt(12) - 48)&0x000f) << 1) + (((code.charAt(13) - 48)&0x0008) >> 3) ));
//////System.out.println((((code.charAt(13) - 48)&0x0007) << 3 ) + (((code.charAt(14) - 48)&0x0001) << 2) + (((code.charAt(15) - 48)&0x000c) >> 2 ) );
		result.append(alpha1.charAt( (((code.charAt(13) - 48)&0x0007) << 3 ) + (((code.charAt(14) - 48)&0x0001) << 2) + (((code.charAt(15) - 48)&0x000c) >> 2) ));
//////System.out.println((((code.charAt(15) - 48)&0x0003) << 4 ) + ((code.charAt(16) - 48)&0x000f));
		result.append(alpha1.charAt( (((code.charAt(15) - 48)&0x0003) << 4 ) + ((code.charAt(16) - 48)&0x000f) ));

		return result.toString();
	}

	public static String getOriginString(String mapStr) {
		StringBuffer originStr = new StringBuffer();
		
		//10位短地址码还原为16位原文
		String[] strs = new String[10];
		for (int i = 0; i < 10; i++) {
			strs[i] = mapStr.substring(i, i + 1);
		}
		
//////System.out.println( ((alphaIdxMap.get(strs[0])&0x003c) >> 2) );
		originStr.append((alphaIdxMap.get(strs[0])&0x003c) >> 2);
//////System.out.println( (((alphaIdxMap.get(strs[0]).intValue()&0x0003) << 2) + ((alphaIdxMap.get(strs[1]).intValue()&0x0030) >> 4)) );
		originStr.append( (((alphaIdxMap.get(strs[0]).intValue()&0x0003) << 2) + ((alphaIdxMap.get(strs[1]).intValue()&0x0030) >> 4)) );
//////System.out.println( alphaIdxMap.get(strs[1]).intValue()&0x000f );
		originStr.append(alphaIdxMap.get(strs[1]).intValue()&0x000f);
//////System.out.println( ((alphaIdxMap.get(strs[2]).intValue()&0x003c) >> 2) );
		originStr.append( ((alphaIdxMap.get(strs[2]).intValue()&0x003c) >> 2) );
//////System.out.println( alphaIdxMap.get(strs[2]).intValue()&0x0003 );
		originStr.append( ((alphaIdxMap.get(strs[2]).intValue()&0x0002) >> 1) );//charAt(4)是原有月份第一位，只取1个bit
		originStr.append( ((alphaIdxMap.get(strs[2]).intValue()&0x0001) << 3) + ((alphaIdxMap.get(strs[3]).intValue()&0x0038) >> 3) );
//////System.out.println( ((alphaIdxMap.get(strs[3]).intValue()&0x003c) >>2) );
		originStr.append( ((alphaIdxMap.get(strs[3]).intValue()&0x0007) << 1) + ((alphaIdxMap.get(strs[4]).intValue()&0x0020) >> 5));
//////System.out.println( (((alphaIdxMap.get(strs[3]).intValue()&0x0003) << 2) + ((alphaIdxMap.get(strs[4]).intValue()&0x0030) >> 4)) );
		originStr.append( ((alphaIdxMap.get(strs[4]).intValue()&0x001e) >> 1) );
//////System.out.println( alphaIdxMap.get(strs[4]).intValue()&0x000f );
		originStr.append( (((alphaIdxMap.get(strs[4]).intValue()&0x0001) << 1) + ((alphaIdxMap.get(strs[5]).intValue()&0x0020) >> 5)) );//charAt(8)是原有日期第一位，只取两bit
//////System.out.println( ((alphaIdxMap.get(strs[5]).intValue()&0x001e) >> 1) );
		originStr.append( ((alphaIdxMap.get(strs[5]).intValue()&0x001e) >> 1) );
//////System.out.println( (((alphaIdxMap.get(strs[5]).intValue()&0x0001) << 3) + ((alphaIdxMap.get(strs[6]).intValue()&0x0038) >> 3)) );
		originStr.append( (((alphaIdxMap.get(strs[5]).intValue()&0x0001) << 3) + ((alphaIdxMap.get(strs[6]).intValue()&0x0038) >> 3)) );
//////System.out.println( (((alphaIdxMap.get(strs[6]).intValue()&0x0007) << 1) + ((alphaIdxMap.get(strs[7]).intValue()&0x0020) >> 5)) );
		originStr.append( (((alphaIdxMap.get(strs[6]).intValue()&0x0007) << 1) + ((alphaIdxMap.get(strs[7]).intValue()&0x0020) >> 5)) );
//////System.out.println( ((alphaIdxMap.get(strs[7]).intValue()&0x001e) >> 1) );
		originStr.append( ((alphaIdxMap.get(strs[7]).intValue()&0x001e) >> 1) );
//////System.out.println( (((alphaIdxMap.get(strs[7]).intValue()&0x0001) << 3) + ((alphaIdxMap.get(strs[8]).intValue()&0x0038) >> 3)) );
		originStr.append( (((alphaIdxMap.get(strs[7]).intValue()&0x0001) << 3) + ((alphaIdxMap.get(strs[8]).intValue()&0x0038) >> 3)) );
//////System.out.println( ((alphaIdxMap.get(strs[8]).intValue()&0x0004) >> 2) );
		originStr.append( ((alphaIdxMap.get(strs[8]).intValue()&0x0004) >> 2) );//数字和的第一位(charAt(14))只用1个bit
//////System.out.println( (((alphaIdxMap.get(strs[8]).intValue()&0x0003) << 2) + ((alphaIdxMap.get(strs[9]).intValue()&0x0030) >> 4)) );
		originStr.append( (((alphaIdxMap.get(strs[8]).intValue()&0x0003) << 2) + ((alphaIdxMap.get(strs[9]).intValue()&0x0030) >> 4)) );
//////System.out.println((alphaIdxMap.get(strs[9]).intValue()) + " " + ((alphaIdxMap.get(strs[9]).intValue()&0x000f)) );
		originStr.append( ((alphaIdxMap.get(strs[9]).intValue()&0x000f)) );
		
		
		return originStr.toString();
	}
	
	public static String checkEncCode(String encCode) {
		if ( (encCode == null)||(encCode.length() != 10) ){
			return null;
		} else {
//////System.out.println("checkEncCode encCode = " + encCode);
			String originCode = getOriginString(encCode);
//////System.out.println("checkEncCode originCode = " + originCode);
			String encSmsCode = originCode.substring(0, 14);
//////System.out.println("checkEncCode encSmsCode = " + encSmsCode);
			String sum        = originCode.substring(14, 17);
//////System.out.println("checkEncCode sum = " + sum);
			String calSum = getSmsCodeSum(encSmsCode);
			if (!calSum.equals(sum)) {
				//校验和运算
				return null;
			} else {
				char[] cs = new char[14];
				cs[13]  = encSmsCode.charAt(0);
				cs[12]  = encSmsCode.charAt(1);
				cs[0]  = encSmsCode.charAt(2);
				cs[11]  = encSmsCode.charAt(3);
				cs[2]  = encSmsCode.charAt(4);
				cs[10]  = encSmsCode.charAt(5);
				cs[1]  = encSmsCode.charAt(6);
				cs[9]  = encSmsCode.charAt(7);
				cs[4]  = encSmsCode.charAt(8);
				cs[8]  = encSmsCode.charAt(9);
				cs[3] = encSmsCode.charAt(10);
				cs[7] = encSmsCode.charAt(11);
				cs[5] = encSmsCode.charAt(12);
				cs[6] = encSmsCode.charAt(13);
				
				return new String(cs);
			}
		}
	}
	
	//生成一个混淆了的字典
	public static void getAlpah1() {
		int region = 61;
		char[] chAlpha = new char[62];
		int rndIdx = 0;
		for (int i = 0; i < 62; i++) {
			if (i == 61) {
				chAlpha[i] = alpha.charAt(0);
			} else {
				rndIdx = new BigDecimal(Math.random()*region).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
				//////System.out.println("rndIdx = " + rndIdx);
				chAlpha[i] = alpha.charAt(rndIdx);
				alpha.deleteCharAt(rndIdx);
				region--;
			}
		}
		
		////System.out.println("chAlpha = " + new String(chAlpha));
	}
	
	//验证混淆后的字典是否有重复字符
	public static void checkRndAlpha() {
		int len = alpha1.length();
		if (len != 62) {
			////System.out.println("len valid");
		} else {
			List<String> container = new ArrayList<String>();
			for (int i = 0; i < 62; i++) {
				if (!container.contains(new Integer(alpha1.charAt(i)).toString())) {
					container.add(new Integer(alpha1.charAt(i)).toString());
				}
			}
			
			if (container.size() == 62) {
				////System.out.println("success");
			} else{
				////System.out.println("fail");
			}
		}
	}
	
	public static String getValidCode(String smsCode) {
		if ( (CommonUtil.isEmptyStr(smsCode))||(smsCode.length() != 14) ) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 7; i++) {
				char a = smsCode.charAt(i);
				sb.append(Character.digit(a, 10) + Character.digit(smsCode.charAt(i + 7), 10));
			}

			int total = 0;
			for (int i = 0; i < sb.length(); i++) {
				total += Character.digit(sb.charAt(i), 10);
			}
			
			StringBuffer result = new StringBuffer();
			result.append(sb.length());
			result.append(total);
			
			return result.toString();
		}
	}

	public static String checkCode(String s1, String s2) {
		//smsCode直接采用数据库中存放短信以及内容页面的ID
		//s1:YYMMDD+8位流水(Q[0,1,2,3,4,5,6,7])，混淆编排
		//   76Y5M4Y3D2M1D0
		//s2:一个简单的校验码
		//   把s1还原成原始的YYMMDD+8位流水后，做彩虹相加，得数按位排开，取得位数(a),然后每位数相加得到一个数(b)
		//   把字符串a连接b，作为验证码。
		if ( (CommonUtil.isEmptyStr(s1))||(CommonUtil.isEmptyStr(s2)) ) {
			return "";
		}
		
		char[] cs = new char[14];
		cs[13]  = s1.charAt(0);
		cs[12]  = s1.charAt(1);
		cs[0]  = s1.charAt(2);
		cs[11]  = s1.charAt(3);
		cs[2]  = s1.charAt(4);
		cs[10]  = s1.charAt(5);
		cs[1]  = s1.charAt(6);
		cs[9]  = s1.charAt(7);
		cs[4]  = s1.charAt(8);
		cs[8]  = s1.charAt(9);
		cs[3] = s1.charAt(10);
		cs[7] = s1.charAt(11);
		cs[5] = s1.charAt(12);
		cs[6] = s1.charAt(13);
		
//////System.out.println(" -checkCode begin- \n");
//for (int i = 0; i < 14; i++) {
//	//System.out.print(cs[i]);
//	//System.out.print(" ");
//}
//////System.out.println(" ");
//////System.out.println(" -checkCode end- ");

		String smsCode = new String(cs);
		String validCode = getValidCode(smsCode);
		if (validCode.equals(s2)) {
			return smsCode;
		} else {
			return "";
		}
	}
	
	public static String getXmlNodeStr(String xml, String tagName) {
		if ( (CommonUtil.isEmptyStr(xml))||(CommonUtil.isEmptyStr(tagName)) ) {
			return "";
		} else {
			int idx1 = xml.indexOf("<" + tagName + ">");
			int idx2 = xml.indexOf("</" + tagName + ">");
			return xml.substring(idx1 + tagName.length() + 2, idx2);
		}
	}
	
	public static String[] splitStrByStr(String data, String splitStr, int maxSplit) {
		if ( (data == null)||(splitStr == null) ) {
			return null;
		} else {
			int splitCnt = 0;
			int idxStart = 0;
			int idxEnd   = 0;
			int splitStrLen = splitStr.length();
			int dataLen = data.length();
			
			List<String> lstSplitData = new ArrayList<String>();
			while ( (idxStart <= dataLen)&&(splitCnt <= maxSplit) ) {
				idxEnd = data.indexOf(splitStr, idxStart);
				if (idxEnd < 0) {
					lstSplitData.add(data.substring(idxStart));
					break;
				}
//////System.out.println(idxStart + " " + idxEnd);
				lstSplitData.add(data.substring(idxStart, idxEnd));
				idxStart = idxEnd + splitStrLen;
				splitCnt++;
			}
			
			String[] result = new String[lstSplitData.size()];
			for (int i = 0; i < lstSplitData.size(); i++) {
				result[i] = lstSplitData.get(i);
			}
			
			return result;
		}
	}
	
//	public static String getNbrPixForTelRegion(String nbr) {
//		String result = null;
//		if (nbr != null){
//			List<RegionPojo> _list = RegionInfoUtil.getInstance().getRegionsMap();
//			for ( RegionPojo _pojo : _list ){
//				if (nbr.indexOf(_pojo.getTelRegionId())==0){
//					result = _pojo.getTelRegionId();
//					break;
//				}
//			}
//		}
//		return result;
//	}
//
//	public static String isNbrPixContainsTelRegion(String nbr) {
//		String result = null;
//		if (nbr != null){
//			List<RegionPojo> _list = RegionInfoUtil.getInstance().getRegionsMap();
//			for ( RegionPojo _pojo : _list ){
//				if (nbr.indexOf(_pojo.getTelRegionId())==0){
//					result = _pojo.getKeyId();
//					break;
//				}
//			}
//		}
//		return result;
//	}
	
	/**
//				100000 在用
//				110000 拆机
//				120000 停机
//				130000 未竣工
//				140000 未激活(预开通)
//				140001  预开通
//				140002 未激活
//				140003 预开通待反档激活
//				150000 撤销"
	 */
	public static String getNbrStateDesc(String servState, String jfState) {
		String stateDesc = "";
		
		if ("100000".equals(servState)){
			stateDesc = "正常";
		} else if ("110000".equals(servState)){
			stateDesc = "拆机";
		}else if ("120000".equals(servState)){
			stateDesc = "停机";
		} else {
			if (CommonUtil.isEmptyStr(jfState)) {
				stateDesc = "正常";
			}
			
			if (jfState.contains("单向停机")){
				stateDesc = "单停";
			} else if (jfState.contains("双向停机")){
				stateDesc = "双停";
			} else if (jfState.contains("紧急停机")){
				stateDesc = "挂失";
			} else if (jfState.contains("停机")) {
				stateDesc = "停机";
			}
		}
		
		return stateDesc;
	}
	
	public static void main(String args[]) throws Exception {
		
	}

	public static String getCurMonth() {
		String format = "yyyyMM";
		return (new SimpleDateFormat(format)).format(new Date());
	}
	
	public static String getDay(Date date) throws Exception {
		String format = "yyyyMMdd";
		return (new SimpleDateFormat(format)).format(date);
	}
	
	public static String getMonthOffDay(String ymd, int months) throws Exception {
		Date date = parseFormatStr(ymd);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return getDay(calendar.getTime());
	}
	
	public static Date parseFormatStr(String date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1,
				Integer.parseInt(date.substring(6, 8)));
		return cal.getTime();
	}
	
	public static boolean isNums(String c15) {
		if (c15 == null || c15.length() <= 0) {
			return false;
		} else {
			boolean b = c15.matches("[0-9]+");
			return b;
		}
	}
	
	public static String getCurDay() throws Exception {
		return getFormatDate(new Date());
	}

	public static String getFormatDate(Date date) throws Exception {
		String format = "yyyyMMdd";
		return (new SimpleDateFormat(format)).format(date);
	}
	
	public static String getDayDiff(String day) throws Exception {
		String curMonth = getCurMonth();
		String month = day.substring(0, 6);

		if (!curMonth.equals(month)) {
			return "-1";// 如果是跨月了，则不进行折算
		} else {
			String sMonth = day.substring(0, 6);
			int maxDay = getMaxDayByYearMonth(sMonth);
			int ddDay = Integer.parseInt(day.substring(6));
			String result = new Integer(maxDay - ddDay + 1).toString() + "_" + maxDay;
			return result;
		}
	}
	
	public static int getMaxDayByYearMonth(String month) throws Exception {
		String strDate = month;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar calendar = new GregorianCalendar();
		Date date = sdf.parse(strDate);
		calendar.setTime(date);
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	public static String getMonthMaxDay(String month) throws Exception {
		String strDate = month;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar calendar = new GregorianCalendar();
		Date date = sdf.parse(strDate);
		calendar.setTime(date);
		int idxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return ((idxDay < 10) ? "0" + new Integer(idxDay).toString() : new Integer(idxDay).toString());
	}
	
	public static String getYMD(Date date) {
		String format = "yyyy-MM-dd";
		return (new SimpleDateFormat(format)).format(date);
	}
	
	public static String getFormatYMD(Date date) {
		String format = "yyyyMMdd";
		return (new SimpleDateFormat(format)).format(date);
	}
	
	public static String getReqid(){
		return UUID.randomUUID().toString();
	}
	
//	public static List<Map<String,String>> prod_num_list =  CutOverUtil.getInstance().getLi();
//	//根据号码规则表将业务号码取出
//	public static String getAccNbr(String accNum,String account,String prodId){
//		if(!CommonUtil.isEmptyCollection(prod_num_list)){
//			for(Map<String,String> one:prod_num_list){
//				if(!CommonUtil.isEmptyStr(one.get("prod_id"))&&!CommonUtil.isEmptyStr(prodId)&&one.get("prod_id").equals(prodId)){
//					if("SERV_T.ACC_NBR".equals(one.get("acount_nbr"))){
//						 if(!CommonUtil.isEmptyStr(account)){
//							 return account;
//						 }
//					}
//				}
//			}
//	   }
//	   return accNum;
//	}
//
//	public static String getB30ProdType(String prodId){
//		if(!CommonUtil.isEmptyCollection(prod_num_list)){
//			for(Map<String,String> one:prod_num_list){
//				if(!CommonUtil.isEmptyStr(one.get("prod_id"))&&!CommonUtil.isEmptyStr(prodId)&&one.get("prod_id").equals(prodId)){
//					return one.get("b30_prod_type");
//				}
//			}
//	   }
//	   return "99";
//	}
	
	public static String getB30ProdName(String b30ProdType){
		switch (b30ProdType) {
		case "10":
			return "固话";
		case "11":
			return "宽带";
		case "12":
			return "手机";
		case "16":
			return "ITV";
		case "99":
			return "其他";
		default:
			return "其他";
		}
	}
}
