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
 * Servlet implementation class DepartmentAdd
 */
@WebServlet("/DepartmentAdd")
public class DepartmentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
		String department_name=request.getParameter("department_name");
		String department_remark=request.getParameter("department_remark");
		Department department=new Department();
		department.setDepartment_name(department_name);
		department.setDepartment_remark(department_remark);
		boolean as = false;
		try {
			 as=DaoFactory.getDepartmentDaoInstance().doCreate(department);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		if(as){
			response.sendRedirect("admin/jsp/DepartmentList.jsp?msg=1");
		}else{
			response.sendRedirect("admin/jsp/DepartmentList.jsp?msg=2");
		}
	}

}
