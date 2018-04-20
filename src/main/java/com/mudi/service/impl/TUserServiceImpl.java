package com.mudi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudi.dao.TUserDao;
import com.mudi.model.TUser;
import com.mudi.service.TUserService;

@Service
public class TUserServiceImpl implements TUserService {

	@Autowired
	private TUserDao tUserDao;
	
	public TUser getUserBySalesNo(String salesNo) {
		return tUserDao.getUserBySalesNo(salesNo);
	}

	public void updateBySalesNo(String salesNo) {
		tUserDao.updateBySalesNo(salesNo);
	}

}
