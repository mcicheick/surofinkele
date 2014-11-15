package controllers;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import models.Bribe;
import models.Message;
import models.Post;
import models.User;
import play.Play;
import play.i18n.Lang;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Util;
import play.templates.TemplateLoader;
import play.vfs.VirtualFile;

/**
 * The main controller, all others controllers must extends this controller
 * except admin controller.
 * 
 * @author Cheick Mahady SISSOKO
 * @date 30 oct. 2014 14:18:31
 */
public class Application extends Controller {

	@Before
	public static void setup() {
		// request.
		String locale = params.get("locale");
		if (locale != null) {
			Lang.change(locale);
		}
		if (renderArgs.get("connected") == null) {
			User user = Security.getSessionUser();
			if (user != null) {
				renderArgs.put("connected", user);
			}
		}
	}

	public static void index() {
		render();
	}

	public static void search(String search) {
		if (search == null || search.isEmpty()) {
			render();
		}
		render(); // TODO
	}

}