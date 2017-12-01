package com.iris.monitor.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密工具 1、压缩性:任意长度的数据，算出的MD5值长度都是固定的。 2、容易计算:从原数据计算出MD5值很容易(算法简单)
 * 3、抗修改性:对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。
 * 4、强抗碰撞:已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。 5、不可逆计算反推
 * 
 */
public class MD5Utils {

	public static String getmd5String(String str) {

		try {

			// 创建加密对象
			MessageDigest digest = MessageDigest.getInstance("md5");

			// 调用加密对象的方法。
			byte[] bs = digest.digest(str.getBytes());
			String hexString = "";
			// mysql的优化思路：
			// 1、 将数据转换成正数
			for (byte b : bs) {
				int temp = b & 255;

				// 2、将数据转成16进制。 注意：转换的时侯 if 正数 >=&&<16, 那么如果使用
				// Integer.toHexString(),可能会造成缺少位数。
				if (temp < 16 && temp >= 0) {
					// 手动补零
					hexString = hexString + "0" + Integer.toHexString(temp);
				} else {
					hexString = hexString + Integer.toHexString(temp);
				}
			}
			// 返回转换后 十六进制数据
			return hexString;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return "";
	}
}