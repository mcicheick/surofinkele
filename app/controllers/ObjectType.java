/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controllers.CRUD;
import play.Logger;
import play.Play;
import play.db.Model;
import play.mvc.Controller;
import play.utils.Java;

/**
 * @author Cheick Mahady SISSOKO
 * @date 13 nov. 2014 23:14:55
 */
public class ObjectType extends CRUD.ObjectType {

	public ObjectType(Class<? extends Model> modelClass) {
		super(modelClass);
	}

	 public ObjectType(String modelClass) throws ClassNotFoundException {
		 super(modelClass);
     }
	 
	 public static ObjectType forClass(String modelClass) throws ClassNotFoundException {
         return new ObjectType(modelClass);
     }

     public static ObjectType get(Class<? extends Controller> controllerClass) {
         Class<? extends Model> entityClass = getEntityClassForController(controllerClass);
         if (entityClass == null || !Model.class.isAssignableFrom(entityClass)) {
             return null;
         }
         ObjectType type;
         try {
             type = (ObjectType) Java.invokeStaticOrParent(controllerClass, "createObjectType", entityClass);
         } catch (Exception e) {
             Logger.error(e, "Couldn't create an ObjectType. Use default one.");
             type = new ObjectType(entityClass);
         }
         type.name = controllerClass.getSimpleName().replace("$", "");
         type.controllerName = controllerClass.getSimpleName().toLowerCase().replace("$", "");
         type.controllerClass = controllerClass;
         return type;
     }
	 
	 public List<Model> findPage(int page, String search, String searchFields, String orderBy, String order, String where) {
         int offset = (page - 1) * getPageSize();
         List<String> properties = searchFields == null ? new ArrayList<String>(0) : Arrays.asList(searchFields.split("[ ]"));
         return Model.Manager.factoryFor(entityClass).fetch(offset, getPageSize(), orderBy, order, properties, search, where);
     }

	static int getPageSize() {
		return Integer.parseInt(Play.configuration.getProperty("crud.pageSize",
				"10"));
	}
}
