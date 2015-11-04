package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Goodsinfo;
import DataBaseTable.Otherinfo;
import DataBaseTable.Task;

/**
 * Servlet implementation class Connector_GoodsInfoInput
 */
@WebServlet("/Connector_GoodsInfoInput")
public class Connector_GoodsInfoInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connector_GoodsInfoInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		 int pinzhong=Integer.parseInt(request.getParameter("pinzhong"));
		 Double inprice=Double.parseDouble(request.getParameter("inprice"));
		 Double outprice=Double.parseDouble(request.getParameter("outprice"));
		 String otherinfo_text=request.getParameter("otherinfo_text");
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date now=new Date(); 
		 String str_date1 = formatter.format(now);
		 
	        try{
	         Date now1= formatter.parse(str_date1);
	   		 java.sql.Date sqlDate=new java.sql.Date(now1.getTime());
	   		 
	   		 Goodsinfo goodsinfo=new Goodsinfo();
			 goodsinfo.setGoodsinfo_categoryid(pinzhong);
			 goodsinfo.setGoodsinfo_inprice(inprice);
			 goodsinfo.setGoodsinfo_outprice(outprice);
			 goodsinfo.setGoodsinfo_time(sqlDate);
			 Otherinfo otherinfo=new Otherinfo();
			 otherinfo.setOtherinfo_text(otherinfo_text);
			 
			 
	        	boolean a=DaoFactory.getGoodsinfoDaoInstance().doCreate(goodsinfo);
	        	boolean b=DaoFactory.getOtherinfoDaoInstance().doCreate(otherinfo);
	        	if (a&&b){
	        		PrintWriter out = response.getWriter();
	        		out.print("<script>alert('添加成功');window.location.href='admin/jsp/Connector_GoodsInfoInput.jsp';</script>");
	        		out.close();
	        	}
	        }
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}}
