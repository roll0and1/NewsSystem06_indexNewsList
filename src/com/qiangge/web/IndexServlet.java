package com.qiangge.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qiangge.model.News;
import com.qiangge.service.NewsService;
import com.qiangge.utils.AppException;

public class IndexServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		try {
			// 初始化新闻业务逻辑类
			NewsService newsService = new NewsService();
			// 声明新闻列表
			List<News> newsList = null;
			// 设置新闻状态
			int state = 1;
			newsList = newsService.getList(state);
		// 将newsList 存入request
		request.setAttribute("newsList", newsList);
//		转发到首页
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (AppException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
