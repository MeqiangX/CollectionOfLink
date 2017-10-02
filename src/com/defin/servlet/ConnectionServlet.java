package com.defin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.defin.bean.Bean;
import com.defin.daoImpl.CollecDaoImpl;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action != null && action.equals("save")) {
			save(request,response);
		}else if (action.equals("get")){
			get(request,response);
		}else if(action.equals("update")) {
			update(request,response);
		}else if (action.equals("show")){
			show(request,response);
		}else if (action.equals("delete")) {
			delete(request,response);
		}else {
			
		}
	}
	
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		CollecDaoImpl cdi = new CollecDaoImpl();
		Bean bean = new Bean(); 
		
		bean.setName(name);
		bean.setUrl(url);
		
		cdi.save(bean);
		
		List list = cdi.list();
		request.setAttribute("ColledList", list);
        request.getRequestDispatcher("/LinkCollection.jsp").forward(request, response);
	}
	
	public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CollecDaoImpl cdi = new CollecDaoImpl();
		
		Bean bean = cdi.getfromid((new Integer(id)).intValue());
		
		request.setAttribute("Bean", bean);
        request.getRequestDispatcher("/CollectionEdit.jsp").forward(request, response);
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		int id = (new Integer(request.getParameter("id"))).intValue();
		Bean bean = new Bean();
		bean.setId(id);
		bean.setName(name);
		bean.setUrl(url);
		CollecDaoImpl cdi = new CollecDaoImpl();
		cdi.update(bean);
		
        request.getRequestDispatcher("/collection?action=show").forward(request, response);
	}
	

	public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CollecDaoImpl cdi = new CollecDaoImpl();
		List list = cdi.list();
		request.setAttribute("ColledList", list);
        request.getRequestDispatcher("/LinkCollection.jsp").forward(request, response);
	}
	
	

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		String[] s = request.getParameterValues("its");
		
		CollecDaoImpl cdi = new CollecDaoImpl();
		
		cdi.delete(s);
	    
        request.getRequestDispatcher("/collection?action=show").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
