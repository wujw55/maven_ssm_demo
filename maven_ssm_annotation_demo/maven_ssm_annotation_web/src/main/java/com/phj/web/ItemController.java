package com.phj.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phj.pojo.Items;
import com.phj.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/*
	 * 查询列表
	 */
	@RequestMapping("/itemList")
	public String itemList(HttpServletRequest request ,Items item){
		
		List<Items> itemList =itemService.findItemList();
//		System.out.println(1/0);
		request.setAttribute("itemList", itemList);
		return "itemList";
	}


	@RequestMapping("/itemEdit")
	public String toEdit(HttpServletRequest request ,Integer id) {

		Items item = itemService.findItemById(id);

		request.setAttribute("item", item);
		return "editItem";
	}
	@RequestMapping("/updateitem")
	public String updateItem(HttpServletRequest request ,Items item) {
		
		itemService.updateItem(item);
		return "redirect:/item/itemList.html";
	}
}
