package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Category;

/**
 * Servlet implementation class CategoryAdd
 */
@WebServlet("/CategoryOpera")
public class CategoryOpera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryOpera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html,UTF-8");
		
		int category_number=0;
		if(request.getParameter("category_number")!=null){
		 category_number=Integer.parseInt(request.getParameter("category_number"));
		}
		String category_name=request.getParameter("category_name");
		int category_fanumber=0;
		if(request.getParameter("category_fanumber")!=null){
			category_fanumber=Integer.parseInt(request.getParameter("category_fanumber"));
		}
		int category_id=0;
		if(request.getParameter("category_id")!=null){
			category_id=Integer.parseInt(request.getParameter("category_id"));
		}
		Category category=new Category();
		category.setCategory_number(category_number);
		category.setCategory_name(category_name);
		category.setCategory_fanumber(category_fanumber);
		boolean Add=false;
		boolean Del=false;
		PrintWriter pw=response.getWriter();
		
		if(request.getParameter("opera").equals("Add")){
			try {
				Add=DaoFactory.getCategoryDaoInstance().doCreate(category);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Add){
				pw.write("添加成功");
			}else{
				pw.write("添加失败");
			}
		}else{
			try {
				Del=DaoFactory.getCategoryDaoInstance().doDelete(category_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(Del){
					pw.write("删除成功");
				}else{
					pw.write("删除失败");
				}
		}
		pw.close();
		
	}

}
