package org.springframework.samples.petclinic.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class ThymeleafHelloWorldExample extends HttpServlet {

	private static final long serialVersionUID = 2050507574303059017L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		// XHTML is the default mode, but we will set it anyway for better
		// understanding of code
		templateResolver.setTemplateMode("XHTML");
		templateResolver.setPrefix("/WEB-INF/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheTTLMs(3600000L);
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		WebContext ctx = new WebContext(req, resp, getServletConfig()
				.getServletContext(), req.getLocale());
		ctx.setVariable("today", Calendar.getInstance());
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Value Sample 1");
		arrayList.add("Value Sample 2");

		TreeSet<String> set = new TreeSet<String>();
		set.add("Set Sample 1");
		set.add("Set Sample 2");
		set.add("Set Sample 3");

		ctx.setVariable("contextValue", "Store Context Value");
		ctx.setVariable("listExample", arrayList);
		ctx.setVariable("setExample", set);

		req.getSession().setAttribute("sessionValue", "Store Session Value");

		// This will be prefixed with /WEB-INF/ and suffixed with .html
		templateEngine.process("thymeleaf", ctx, resp.getWriter());
		resp.setContentType("text/html;charset=UTF-8");
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 1000);
	}
}