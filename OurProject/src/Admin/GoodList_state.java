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
import DataBaseTable.Goods;

/**
 * Servlet implementation class GoodList_state
 */
@WebServlet("/GoodList_state")
public class GoodList_state extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodList_state() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8") ;	
		response.setContentType("text/html;charset=UTF-8");
		int state=Integer.parseInt(request.getParameter("param"));
		System.out.print(state);
		//Goods goods=new Goods();
		response.setContentType("text/x-json");
		PrintWriter pw = response.getWriter();
		String j = "{\"rows\": [";
		try {
			List <Goods> all = DaoFactory.getGoodsDaoInstance().findByState(state);	
			Iterator<Goods> iter = all.iterator() ;
			while(iter.hasNext()){
				Goods goods = iter.next() ;
				j += "{";
				j += "\"goodsid\": \"" + goods.getGoods_id() + "\", ";
				j += "\"name\": \"" + goods.getGoods_name() + "\", ";
				j += "\"category\": \"" + goods.getGoods_category() + "\", ";
				j += "\"price\": \"" + goods.getGoods_price() + "\", ";
				j += "\"unit\": \"" +goods.getGoods_unit() + "\", ";
				j += "\"inventory\": \"" + goods.getGoods_inventory() + "\",";
				if(goods.getGoods_state()==1){
					j += "\"state\": \"" + "等待审核" + "\"";}
					if(goods.getGoods_state()==2){
					j += "\"state\": \"" + "在售" + "\"";}
					if(goods.getGoods_state()==3){
					j += "\"state\": \"" + "下架" + "\"";}
				j += "}";
				
				j += ", ";}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
