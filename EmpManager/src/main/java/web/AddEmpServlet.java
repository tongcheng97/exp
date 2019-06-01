package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//1.接收参数
		String name = req.getParameter("name");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		
		//2.处理业务
		Emp e = new Emp();
		e.setEname(name);
		e.setJob(job);
		if(sal != null && !sal.equals("")) {
			e.setSal(new Double(sal));
		}
		EmpDao dao = new EmpDaoImpl();
		dao.save(e);
		
		//3.输出响应
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();	
//		out.println("<p>保存成功</p>");
//		out.close();
		//重定向到查询页面
		//就是建议浏览器去访问查询页面
		resp.sendRedirect("findEmp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	
}
