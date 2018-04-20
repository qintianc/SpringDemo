package com.mudi.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传,下载
 * @author csd
 *
 */
@Controller
@RequestMapping("fileUpload")
public class FileUploadCtrl {

	@RequestMapping("fileUpload_one")
	public String fileUpOne() {
		return "fileUpload_one";
	}

	@RequestMapping("fileUpload_more")
	public String fileUpMore() {
		return "fileUpload_more";
	}
	@RequestMapping("fileDown")
	public String down() {
		return "down";
	}

	// 单文件上传，参数必须是MultipartFile类型,用来接收上传的文件
	@RequestMapping("upOne")
	@ResponseBody
	public String upOne(MultipartFile multipartFile) throws Exception {
		if (multipartFile != null) {
			// 文件上传的保存路径
			String path = "E:\\fileUpload\\";
			// 图片的原始名称（不含路径）
			String origanlFileName = multipartFile.getOriginalFilename();
			// 上传的图片的保存的新名称，随机生成文件名称+.jpg
			// String newFileName = UUID.randomUUID() +
			// origanlFileName.substring(origanlFileName.lastIndexOf("."));
			File file = new File(path + origanlFileName);
			// 将内存的数据写到磁盘上
			multipartFile.transferTo(file);
		}
		return "OK";
	}

	// 多文件上传,MultipartFiles是自定义包装类，用List<MultipartFile>接收
	@RequestMapping("/upMore")
	@ResponseBody
	public String upMore(MultipartFiles multipartFiles) throws Exception {

		List<MultipartFile> list = multipartFiles.getPic(); // 得到上传的文件链表
		for (MultipartFile multipartFile : list) {
			if (multipartFile != null && multipartFile.getSize() > 0) {
				// 文件上传的保存路径
				String path = "E:\\fileUpload\\";
				// 图片的原始名称（不含路径）
				String origanlFileName = multipartFile.getOriginalFilename();
				// 上传的图片的保存的新名称，随机生成文件名称+.jpg
				// String newFileName = UUID.randomUUID() +
				// origanlFileName.substring(origanlFileName.lastIndexOf("."));
				File file = new File(path + origanlFileName);
				// 将内存的数据写到磁盘上
				multipartFile.transferTo(file);
			}
		}
		return "OK";
	}

	@RequestMapping("/down")
	@ResponseBody
	public void test_download(HttpServletRequest request, HttpServletResponse response, String filename) throws Exception {
		filename = new String(filename.getBytes("iso-8859-1"), "UTF-8");// get提交，修改编码
		// String path = request.getRealPath("/WEB-INF/picture/"+filename);//得到资源在硬盘上的绝对的路径
		String path = "E:\\fileUpload\\down.txt";
		File file = new File(path);
		response.setCharacterEncoding("UTF-8");
		filename = URLEncoder.encode(filename, "UTF-8");// 将中文转为浏览器可认识的编码
		response.setHeader("content-disposition", "attachment;filename=" + filename);// 设置响应头为文件下载
		response.setContentLength((int) file.length());
		int len = 0;
		byte[] buffer = new byte[1024];
		InputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();// 向浏览器写数据
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		is.close();
		os.close();
		//return null; // 若有返回值,则返回null,执行后不跳转
	}
}
