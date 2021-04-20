package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.utils.CaptchaUtil;

/**
* @author HSS
* @version 2021年4月2日 下午6:32:58
* @Description 生成验证码图片及验证类
*/
@Controller
@RequestMapping("/api/img")
public class ImgCodeController {

	@RequestMapping("/getCode")
	public void getImgCode(HttpServletRequest request,HttpServletResponse response,
			HttpSession session) {
		//设置返回数据格式为图片
		response.setContentType("image/jpeg");
		//禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		OutputStream os = null;
		//以流的形式传回验证码图片
		try {
			os = response.getOutputStream();
			Map<String, Object> imageCode = CaptchaUtil.getImageCode(165, 38, os);
			session.setAttribute("code", imageCode.get("strEnsure").toString().toLowerCase());
			ImageIO.write((BufferedImage) imageCode.get("image"), "jpg", os);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (os != null) {
				try {
					os.flush();
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 检验验证码
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/checkCode",method=RequestMethod.POST)
	@ResponseBody
	public boolean checkCode(HttpSession session,String code){
		String getCode = (String)session.getAttribute("code");
		if(code.equals(getCode)){
			return true;
		}
		return false;
	}
}
