package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Goods;

/**
 * Servlet implementation class GoodListUpdate
 */
@WebServlet("/GoodListUpdate")
public class GoodListUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodListUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8") ;	
		   response.setContentType("text/html;charset=UTF-8");
          		   
		   int goods_grade=0;
		   int goods_inventory=0;
		   int goods_video=0;
		   int goods_id=0;
		   int goods_sendnumber=0;
		   goods_id=Integer.parseInt(request.getParameter("goods_id"));
		   System.out.print(goods_id);
		   goods_grade=Integer.parseInt(request.getParameter("goods_grade"));
		   goods_inventory=Integer.parseInt(request.getParameter("goods_inventory"));
		   goods_video=Integer.parseInt(request.getParameter("goods_video"));
		   goods_sendnumber=Integer.parseInt(request.getParameter("goods_sendnumber"));
		   String goods_name=request.getParameter("goods_name");
		   String goods_anothername=request.getParameter("goods_anothername");
		   String goods_place=request.getParameter("goods_place");
		   String goods_unit=request.getParameter("goods_unit");
		   Double goods_price=Double.parseDouble(request.getParameter("goods_price"));
		   System.out.print(goods_price);
		   String goods_vantage=request.getParameter("goods_vantage");
		   String goods_producetime=request.getParameter("goods_producetime");
		   String goods_saletime=request.getParameter("goods_saletime");
		   String goods_offtime=request.getParameter("goods_offtime");
		   
		   Goods goods=new Goods();
		   goods.setGoods_id(goods_id);
		   goods.setGoods_grade(goods_grade);
		   goods.setGoods_inventory(goods_inventory);
		   goods.setGoods_video(goods_video);
		   goods.setGoods_name(goods_name);
		   goods.setGoods_sendnumber(goods_sendnumber);
		   goods.setGoods_anothername(goods_anothername);
		   goods.setGoods_place(goods_place);
		   goods.setGoods_unit(goods_unit);
		   goods.setGoods_price(goods_price);
		   goods.setGoods_vantage(goods_vantage);
		   
		   SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd"); 
			Date producetime;
			Date saletime;
			Date offtime;
			try {
				producetime = df1.parse(goods_producetime);
				java.sql.Date produce=new java.sql.Date(producetime.getTime());  
				System.out.print(produce);
				goods.setGoods_producetime(produce);
				
				saletime = df1.parse(goods_saletime);
				java.sql.Date sale=new java.sql.Date(saletime.getTime());  
				System.out.print(sale);
				goods.setGoods_saletime(sale);
				
				
				offtime = df1.parse(goods_offtime);
				java.sql.Date off=new java.sql.Date(offtime.getTime());  
				System.out.print(off);
				goods.setGoods_offtime(off);
				

				boolean a;
				a = DaoFactory.getGoodsDaoInstance().doUpdate(goods);
				if (a){
	        		PrintWriter out = response.getWriter();
	        		out.print("<script>alert('添加成功');window.location.href='admin/jsp/GoodsList.jsp';</script>");
	        		out.close();}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		   
		   
		    
	}

}
