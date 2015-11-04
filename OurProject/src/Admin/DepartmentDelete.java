package Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Department;

/**
 * Servlet implementation class DepartmentDelete
 */
@WebServlet("/DepartmentDelete")
public class DepartmentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	int department_id=Integer.parseInt(request.getParameter("department_id"));
	boolean as=false;
	try {
		as=DaoFactory.getDepartmentDaoInstance().doDelete(department_id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(as){
		response.sendRedirect("admin/jsp/DepartmentListCheck.jsp?msg=3");
	}
	else{
		response.sendRedirect("admin/jsp/DepartmentListCheck.jsp?msg=4");
		System.out.print("cuowu");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
