package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Staff;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		  response.setContentType("text/html;charset=UTF-8");
		String staff_number=request.getParameter("staff_number");
		String staff_password=request.getParameter("staff_password");
		Staff Staff;
		
		try {
			Staff = DaoFactory.getStaffDaoInstance().findByStaffNumber(staff_number);
		
		if (staff_password.equals(Staff.getStaff_password())) {
			HttpSession hs =request.getSession(); //   验证成功。保存session
			hs.setAttribute("staff_id", Staff.getStaff_id());
			hs.setAttribute("staff_role", Staff.getStaff_role());
			hs.setAttribute("logined", "auto"); 
			 request.setCharacterEncoding("utf-8");
			 response.sendRedirect("admin/jsp/Index.jsp");
		//	request.getRequestDispatcher("admin/index.html").forward(request, response);//登陆成功，跳转。
		  }
		  else {
			  response.sendRedirect("admin/AdminLogin.html");
		//	  request.getRequestDispatcher("login.html").forward(request, response);
		  }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
