package com.iris.monitor.servcie;

import java.util.List;

import com.iris.monitor.entity.Sys_MenuInfo;

public interface Sys_MenuInfoService {

	public Sys_MenuInfo findMenuInfoById(int id);

	public List<Sys_MenuInfo> findMenuInfos();
}
