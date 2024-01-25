package com.booboil.springbootinit.common;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 系统工具类
 */
public class CommonUtils {

	/**
	 * 组织文件下载时的文件名称
	 *
	 * @param request
	 * @param fileName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getDownloadFileName(HttpServletRequest request, String fileName)
			throws UnsupportedEncodingException {

		String userAgent = request.getHeader("user-agent");
		if (StringUtils.isEmpty(userAgent)) {
			return fileName;
		}

		if (userAgent.contains("Edge") || userAgent.contains("Apifox")) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else if (userAgent.contains("Firefox") || userAgent.contains("Chrome")) {
			fileName = new String(org.apache.commons.codec.binary.Base64.encodeBase64(fileName.getBytes(StandardCharsets.UTF_8)));
		} else if (userAgent.contains("Safari")) {
			fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
		} else {
			fileName = new String(fileName.getBytes("GBK"), StandardCharsets.ISO_8859_1);
		}

		return fileName;
	}

}