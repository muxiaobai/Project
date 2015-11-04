package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.User;

/**
 * Servlet implementation class BackUsernameCheck
 */
@WebServlet("/BackUsernameCheck")
public class BackUsernameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackUsernameCheck() {
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
		try {

		 String user_name = request.getParameter("username");
		 System.out.print(user_name);
		  User test;
		   PrintWriter pw = response.getWriter();
		
			test = DaoFactory.getUserDaoInstance().findByUsername(user_name);

			if(test==null){
			pw.write("1");
			}else{
			pw.write("0");
			}

			}
	        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
