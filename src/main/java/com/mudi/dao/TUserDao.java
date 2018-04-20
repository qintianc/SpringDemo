package com.mudi.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import com.mudi.model.TUser;

@MapperScan
@Component
public interface TUserDao {

	public TUser getUserBySalesNo(String salesNo);
	
	public void updateBySalesNo(String salesNo);
}
