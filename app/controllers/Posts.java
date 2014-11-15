/**
 * 
 */
package controllers;

import java.util.List;

import models.Page;
import play.db.Model;
import play.exceptions.TemplateNotFoundException;

/**
 * @author Cheick Mahady SISSOKO
 * @date 8 nov. 2014 22:22:37
 */
public class Posts extends Admin {

	
	public static void index(int page, String search, String searchFields,
			String orderBy, String order) {
		controllers.ObjectType type = controllers.ObjectType.get(getControllerClass());
		notFoundIfNull(type);
		if (page < 1) {
			page = 1;
		}
		List<Model> objects = type.findPage(page, search, searchFields,
				orderBy, order, (String) request.args.get("where"));
		Long count = type.count(search, searchFields,
				(String) request.args.get("where"));
		Long totalCount = type.count(null, null,
				(String) request.args.get("where"));
		Page<Model> pages = new Page<Model>(objects, totalCount, page, controllers.ObjectType.getPageSize());
		try {
			render(type, pages, count, totalCount, page, orderBy, order);
		} catch (TemplateNotFoundException e) {
			render("CRUD/index.html", type, pages, count, totalCount, page,
					orderBy, order);
		}
	}
}
