/**
 * 
 */
package me.lishuo.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**   
*  
* @author lis   
* @date 2016年4月16日
* @version V1.0   
*/
public class SignUtil {

    static final Logger LOG = LoggerFactory.getLogger(SignUtil.class);

    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static final String SIGN_KEY = "07500o0wQt19000000l30U0P0XvgH093Y0XaA050620zZ50r0h7O1094qD0x";

    static String byteArray2Hex(byte[] hash) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1)
                buf.append('0');
            buf.append(hex);
        }
        return buf.toString();
    }

    /**
     * <p>
     * 签名请求数据
     * </p>
     * 
     * @param method
     * @param content
     * @param charset
     * @param version
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String signReqData(String method, String content, Charset charset, String version)
            throws NoSuchAlgorithmException {
        if (version == null || "".equals(version))
            return "";

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(method);
            md.update((content + version + SIGN_KEY).getBytes(charset));
            return byteArray2Hex(md.digest()).toLowerCase();
        } finally {
            md.reset();
        }

    }

    public static String messageDigest(String method, String content, Charset charset) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        try {
            if (charset == null) {
                charset = UTF_8;
            }
            messageDigest = MessageDigest.getInstance(method);
            messageDigest.update(content.getBytes(charset));
            return formatDigest(messageDigest.digest());
        } finally {
            if (messageDigest != null) {
                messageDigest.reset();
            }
        }
    }

    public static String messageDigest(String method, byte[] content, Charset charset) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        try {
            if (charset == null) {
                charset = UTF_8;
            }
            messageDigest = MessageDigest.getInstance(method);
            messageDigest.update(content);
            return formatDigest(messageDigest.digest());
        } finally {
            if (messageDigest != null) {
                messageDigest.reset();
            }
        }
    }

    public static String md5Digest(String content) throws NoSuchAlgorithmException {
        return messageDigest(MD5, content, UTF_8);
    }

    /**
     * 支付签名
     * 
     * @param content
     * @return
     */
    public static String payDigest(String method, String content) {
        try {
            return messageDigest(method, content, null);
        } catch (Exception e) {
            LOG.error("payDigest error {}.", e.getMessage());
        }
        // TODO
        return "";
    }

    public static String sha1Digest(String content) throws NoSuchAlgorithmException {
        return messageDigest(SHA1, content, UTF_8);
    }

    private static String formatDigest(byte[] bytes) {
        StringBuilder buf = new StringBuilder();
        for (byte b : bytes) {
            buf.append(Integer.toHexString(b & 0xff).toUpperCase());
        }
        return buf.toString();
    }

}
