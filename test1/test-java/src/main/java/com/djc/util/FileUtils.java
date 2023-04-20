package com.djc.util;

/**
 * Title：文件通用工具类
 * Description：
 * @author ---
 * @version 1.0.0
 * @date 2020/7/20
 */
public class FileUtils {

	/**
	 * 文件后缀判断
	 * @param originFileName 上传时的文件名全部
	 * @return
	 */
	public static boolean verificationFile(String originFileName){
		// 后缀
		String extName = originFileName.substring(originFileName.lastIndexOf(".") + 1);
		// 判断是不是图片、文档、excel、pdf、压缩包等文件后缀
		if(!extName.matches("(tif|gif|png|jpg|jpeg|bmp|doc|docx|pdf|xls|xlsx|rar|zip)")) {
			// "文件格式错误"
			return false;
		}
		return true;
	}

	/**
	 * 图片后缀判断
	 * @param originFileName 上传时的文件名全部
	 * @return
	 */
	public static boolean verificationImage(String originFileName){
		// 后缀
		String extName = originFileName.substring(originFileName.lastIndexOf(".") + 1);
		// 判断是不是图片、文档、excel、pdf、压缩包等文件后缀
		if(!extName.matches("(png|jpg|jpeg)")) {
			// "文件格式错误"
			return false;
		}
		return true;
	}
}
