package com.mudi.demo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/* 
 * 上传多个文件，每个文件都用Controller方法中的MultipartFiles类型的形参接收，所以自定义pojo包装类 
 * */
public class MultipartFiles {
	private List<MultipartFile> pic;// 用List接收,每个文件对应一个MultipartFile

	public List<MultipartFile> getPic() {
		return pic;
	}

	public void setPic(List<MultipartFile> pic) {
		this.pic = pic;
	}

}