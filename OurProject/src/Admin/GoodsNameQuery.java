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

/**
 * Servlet implementation class GoodsNameQuery
 */
@WebServlet("/GoodsNameQuery")
public class GoodsNameQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsNameQuery() {
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
		String  keyword=request.getParameter("keyword");
		System.out.print(keyword);
		Goods goods=new Goods();
		response.setContentType("text/x-json");
		PrintWriter pw = response.getWriter();
		String j = "{\"rows\": [";
		try {
			goods = DaoFactory.getGoodsDaoInstance().findByGoodsName(keyword);			
				j += "{";
				j += "\"goodsid\": \"" + goods.getGoods_id() + "\", ";
				j += "\"name\": \"" + goods.getGoods_name() + "\", ";
				j += "\"category\": \"" + goods.getGoods_category() + "\", ";
				j += "\"price\": \"" + goods.getGoods_price() + "\", ";
				j += "\"unit\": \"" +goods.getGoods_unit() + "\", ";
				j += "\"inventory\": \"" + goods.getGoods_inventory() + "\", ";
				if(goods.getGoods_state()==1){
				j += "\"state\": \"" + "等待审核" + "\"";}
				if(goods.getGoods_state()==2){
				j += "\"state\": \"" + "在售" + "\"";}
				if(goods.getGoods_state()==3){
				j += "\"state\": \"" + "下架" + "\"";}
				
				j += "}";
				
				j += ", ";
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}
			j += "]}";
			
			pw.print(j);
			
			System.out.println(j);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
