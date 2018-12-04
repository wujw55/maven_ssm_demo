package com.phj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.phj.mapper.ItemsMapper;
import com.phj.pojo.Items;
import com.phj.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Items> findItemList() {
		// TODO Auto-generated method stub
		return itemsDao.selectByExampleWithBLOBs(null);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Items findItemById(Integer id) {
		// TODO Auto-generated method stub
		return itemsDao.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateItem(Items item) {
		// TODO Auto-generated method stub
		
		itemsDao.updateByPrimaryKeySelective(item);
		System.out.println(1/0);
	}

}
