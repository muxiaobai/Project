package Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Task;

/**
 * Servlet implementation class Connector_TaskQueryUndo
 */
@WebServlet("/Connector_TaskQueryUndo")
public class Connector_TaskQueryUndo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connector_TaskQueryUndo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8") ;	
		  response.setContentType("text/html;charset=UTF-8");
			int task_id=Integer.parseInt(request.getParameter("task_id"));
			System.out.println(task_id);
			Task task=new Task();
			task.setTask_id(task_id);
			task.setTask_state("已完成");
			
			boolean as = false;
			try {
				as = DaoFactory.getTaskDaoInstance().doUpdate(task);
			} catch (Exception e) {
				e.printStackTrace();
			}
				if(as){
					response.sendRedirect("admin/jsp/Connector_Task.jsp?msg=1");
				}
				else{
					response.sendRedirect("admin/jsp/Connector_Task.jsp?msg=2");
				
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
