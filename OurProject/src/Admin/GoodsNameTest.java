package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Goods;
import DataBaseTable.User;

/**
 * Servlet implementation class GoodsNameTest
 */
@WebServlet("/GoodsNameTest")
public class GoodsNameTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsNameTest() {
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
		 request.setCharacterEncoding("UTF-8") ;	
		 response.setContentType("text/html;charset=UTF-8");

		try{

			 String goods_name = request.getParameter("goods_name");
			 System.out.print(goods_name);
			   Goods test;
			   PrintWriter pw = response.getWriter();
			
				test = DaoFactory.getGoodsDaoInstance().findByGoodsName(goods_name);

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
