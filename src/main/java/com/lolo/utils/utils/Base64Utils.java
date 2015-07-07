package com.lolo.utils.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.codehaus.plexus.util.StringUtils;

public class Base64Utils {

	public final static String ENCODING = "UTF-8";

	/**
	 * 进行base64编码
	 * @param str
	 * @return
	 */
	public static final String base64(String str) {
		if (StringUtils.isBlank(str))
			return null;
		byte[] compressed;
		String compressedStr = null;
		try {
			compressed = str.getBytes();
			compressedStr = new sun.misc.BASE64Encoder().encodeBuffer(compressed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compressedStr;
	}
    
    
    /**
     * 对内容进行压缩和加密
     * zip
     * @param str
     * @return
     */
	public static final String zip(String str) {
		if (StringUtils.isBlank(str))
			return null;
		byte[] compressed;
		ByteArrayOutputStream out = null;
		ZipOutputStream zout = null;
		String compressedStr = null;
		try {
			out = new ByteArrayOutputStream();
			zout = new ZipOutputStream(out);
			zout.putNextEntry(new ZipEntry("0"));
			zout.write(str.getBytes());
			zout.closeEntry();
			compressed = out.toByteArray();
			compressedStr = new sun.misc.BASE64Encoder()
					.encodeBuffer(compressed);
//			compressedStr = Base64Utils.encodedByte(compressed);
//			byte[] b=UrlBase64.encode(compressed);
//			compressedStr = new String(b,"ISO8859-1");
		} catch (IOException e) {
			compressed = null;
		} finally {
			if (zout != null) {
				try {
					zout.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return compressedStr;
	}

	/**
	 * 对内容进行解密和解压缩
	 * unzip
	 * @param compressedStr
	 * @return
	 */
	public static final String unzip(String compressedStr) {
		if (StringUtils.isBlank(compressedStr))
			return null;
		ByteArrayOutputStream out = null;
		ByteArrayInputStream in = null;
		ZipInputStream zin = null;
		String decompressed = null;
		try {
			byte[] compressed = new sun.misc.BASE64Decoder()
					.decodeBuffer(compressedStr);
//			byte[] compressed = Base64Utils.decode(compressedStr).getBytes();
//			byte[] compressed=UrlBase64.decode(compressedStr.getBytes("ISO8859-1"));  
			out = new ByteArrayOutputStream();
			in = new ByteArrayInputStream(compressed);
			zin = new ZipInputStream(in);
			zin.getNextEntry();
			byte[] buffer = new byte[1024];
			int offset = -1;
			while ((offset = zin.read(buffer)) != -1) {
				out.write(buffer, 0, offset);
			}
			decompressed = out.toString();
		} catch (IOException e) {
			decompressed = null;
		} finally {
			if (zin != null) {
				try {
					zin.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return decompressed;
	}
}
