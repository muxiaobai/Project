package Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;

/**
 * Servlet implementation class GovnmtDelete
 */
@WebServlet("/GovnmtDelete")
public class GovnmtDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GovnmtDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int govnmt_id=Integer.parseInt(request.getParameter("govnmt_id"));
		boolean as=false;
		try {
			as=DaoFactory.getGovnmtDaoInstance().doDelete(govnmt_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(as){ 
			response.sendRedirect("admin/jsp/GovnmtListCheck.jsp?msg=3");
		}
		else{
			response.sendRedirect("admin/jsp/GovnmtListCheck.jsp?msg=4");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
