package Admin;

import java.io.IOException;

import DataBaseTable.Govnmt;
import DataBaseFactory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GovnmtAdd
 */
@WebServlet("/GovnmtAdd")
public class GovnmtAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GovnmtAdd() {
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
		String govnmt_number=request.getParameter("govnmt_number");
		String govnmt_name=request.getParameter("govnmt_name");
		Govnmt govnmt=new Govnmt();
		govnmt.setGovnmt_name(govnmt_name);
		govnmt.setGovnmt_number(govnmt_number);
	
		boolean as = false;
		try {
			as = DaoFactory.getGovnmtDaoInstance().doCreate(govnmt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(as){
			response.sendRedirect("admin/jsp/GovnmtList.jsp?msg=1");
		}else{
			response.sendRedirect("admin/jsp/GovnmtList.jsp?msg=2");
		}
		
		
	}

}
