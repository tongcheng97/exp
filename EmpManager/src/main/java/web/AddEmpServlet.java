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
		
		//1.���ղ���
		String name = req.getParameter("name");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		
		//2.����ҵ��
		Emp e = new Emp();
		e.setEname(name);
		e.setJob(job);
		if(sal != null && !sal.equals("")) {
			e.setSal(new Double(sal));
		}
		EmpDao dao = new EmpDaoImpl();
		dao.save(e);
		
		//3.�����Ӧ
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();	
//		out.println("<p>����ɹ�</p>");
//		out.close();
		//�ض��򵽲�ѯҳ��
		//���ǽ��������ȥ���ʲ�ѯҳ��
		resp.sendRedirect("findEmp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	
}
