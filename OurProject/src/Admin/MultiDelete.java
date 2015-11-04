package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;

/**
 * Servlet implementation class MultiDelete
 */
@WebServlet("/MultiDelete")
public class MultiDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiDelete() {
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
		String ids=request.getParameter("ids");
		 PrintWriter pw =response.getWriter();
		 Boolean test=false;
		 //pw.print(ids);
		 System.out.print(ids);
			
				 String[] ids1=ids.split(",");  //对传过来的id字符串进行分割
				  for(int i=0;i<ids1.length;i++)
				  {
				 
			      try {		   
			       int id=Integer.parseInt(ids1[i]);
				   test=DaoFactory.getGoodsDaoInstance().doDelete(id);
				   System.out.print(test); 
				  }
			      catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
				  
				  if(test){
						 pw.write("1");
						 
					 }else {
						 pw.write("0");
					 }
			
		
		 
	}

}
