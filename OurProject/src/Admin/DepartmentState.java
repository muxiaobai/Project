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
 * Servlet implementation class DepartmentState
 */
@WebServlet("/DepartmentState")
public class DepartmentState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int department_id=0;
		int department_state=0;
		int my=0;
		if(request.getParameter("department_id")!=null){
			department_id=Integer.parseInt(request.getParameter("department_id"));
		}
		if(request.getParameter("department_state")!=null){
			department_state=Integer.parseInt(request.getParameter("department_state"));	
		}
		if(request.getParameter("my")!=null){
			 my =Integer.parseInt(request.getParameter("my"));		
		}
		Department department =new Department();
		department.setDepartment_id(department_id);
		department.setDepartment_state(department_state);
		boolean as=false;
		try {
			as=DaoFactory.getDepartmentDaoInstance().doUpdate(department);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(my==1){
			response.sendRedirect("admin/jsp/DepartmentList.jsp");
		}else{
			response.sendRedirect("admin/jsp/DepartmentListCheck.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
