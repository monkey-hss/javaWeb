package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
* @author HSS
* @version 2021年3月31日 下午5:21:42
* @Description 工具类
*/
public class CommonUtils {

	/**
	 * 生成UUID
	 * @return
	 */
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 设置日期格式并转成字符串
	 */
	public static String getDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = sdf.format(new Date());
		return strDate;
	}
}
