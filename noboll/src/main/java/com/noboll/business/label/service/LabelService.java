package com.noboll.business.label.service;


import java.util.List;
import java.util.Map;

import com.noboll.business.label.entity.Label;
import com.noboll.core.base.service.BaseService;


public interface LabelService extends BaseService<Label> {

	/**
	 * 查找标签选择数据
	 */
	public List<Label> getChooseList(Map<String, Object> map);
	
}
