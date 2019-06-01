package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res) 
			throws ServletException, IOException {
		//1.���ղ���(û��)
		
		//2.����ҵ��(��ѯ)
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findAll();
		
		//3.�����Ӧ(���)
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<a href='add_emp.html'>����</a>");
		out.println("<table border='1' cellspacing='0' width='40%'>");
		out.println("	<tr>");
		out.println("		<th>���</th>");
		out.println("		<th>����</th>");
		out.println("		<th>ְλ</th>");
		out.println("		<th>��н</th>");
		out.println("	</tr>");
		if(list != null) {
			for(Emp e : list) {
				out.println("<tr>");
				out.println("	<td>"+e.getEmpno()+"</td>");
				out.println("	<td>"+e.getEname()+"</td>");
				out.println("	<td>"+e.getJob()+"</td>");
				out.println("	<td>"+e.getSal()+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.close();
	}
	
}
