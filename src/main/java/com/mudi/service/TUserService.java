package com.mudi.service;

import com.mudi.model.TUser;

public interface TUserService {

	public TUser getUserBySalesNo(String salesNo);
	
	public void updateBySalesNo(String salesNo);
}
