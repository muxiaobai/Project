package Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Bidding;
import DataBaseTable.Bkgoods;

/**
 * Servlet implementation class CheckBidding1
 */
@WebServlet("/CheckBidding1")
public class CheckBidding1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBidding1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8") ;	
		   response.setContentType("text/html;charset=UTF-8");
			int bidding_id=Integer.parseInt(request.getParameter("bidding_id"));
			Double bidding_price=Double.parseDouble(request.getParameter("bidding_price"));
			System.out.println(bidding_id);
			Bidding bidding=new Bidding();
			bidding.setBidding_id(bidding_id);
			bidding.setBidding_state("同意供货");
			bidding.setBidding_price(bidding_price);
			boolean as = false;
			try {
			
				as = DaoFactory.getBiddingDaoInstance().doUpdate(bidding);
			} catch (Exception e) {
				e.printStackTrace();
			}
				if(as){
					response.sendRedirect("admin/jsp/CheckBidding.jsp?msg=1");
				}
				else{
					response.sendRedirect("admin/jsp/CheckBidding.jsp?msg=2");
				
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
