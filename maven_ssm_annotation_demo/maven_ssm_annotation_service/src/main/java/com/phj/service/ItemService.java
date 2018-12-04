package com.phj.service;

import java.util.List;


import com.phj.pojo.Items;

//@Service
public interface ItemService {
//	@Autowired
//	private ItemsMapper itemsDao;
	
	
	/*
	 * 查询所有
	 */
	public List<Items> findItemList() ;


	public Items findItemById(Integer id) ;


	public void updateItem(Items item) ;

}
