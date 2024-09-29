package util;

import java.security.MessageDigest;
import java.util.Base64;

public class Encoding {
	// md5
	// sha-1 => thuong duoc su dung

	public static String toSHA1(String str) {
		// make the encoded str more complicated
		String salt = " ";
		String res = null;
		str = str + salt;

		try {
			byte[] dateBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			res = Base64.getEncoder().encodeToString(md.digest(dateBytes));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}
}
