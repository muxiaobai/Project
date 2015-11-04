package Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Govnmt;

/**
 * Servlet implementation class GovnmtState
 */
@WebServlet("/GovnmtState")
public class GovnmtState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GovnmtState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int govnmt_id=Integer.parseInt(request.getParameter("govnmt_id"));
		int govnmt_state=Integer.parseInt(request.getParameter("govnmt_state"));
	int my =Integer.parseInt(request.getParameter("my"));
	Govnmt govnmt =new Govnmt();
	govnmt.setGovnmt_id(govnmt_id);
	govnmt.setGovnmt_state(govnmt_state);
	boolean as=false;
		try {
			as=DaoFactory.getGovnmtDaoInstance().doUpdate(govnmt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(my==1){
			response.sendRedirect("admin/jsp/GovnmtList.jsp");
		}else{
			response.sendRedirect("admin/jsp/GovnmtListCheck.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
