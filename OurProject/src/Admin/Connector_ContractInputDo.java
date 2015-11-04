package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBaseDao.ContractDetailDao;
import DataBaseFactory.DaoFactory;
import DataBaseTable.Contract;
import DataBaseTable.ContractDetail;
import DataBaseTable.ContractMedia;
import Tool.IpTimeStamp;



import com.jspsmart.upload.*; 



/**
 * Servlet implementation class Connector_ContractInputDo
 */
@WebServlet("/Connector_ContractInputDo")
public class Connector_ContractInputDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletConfig config;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }
    final public ServletConfig getServletConfig() {
        return config;
    }
    public Connector_ContractInputDo() {
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
		 response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");

		 
		 SmartUpload su =new SmartUpload(); 
		 String fileExt="";
		 su.initialize(getServletConfig(), request, response);  
		 //su.initialize(pageContext);
		 su.setAllowedFilesList("jpg,xls,xlsx,pdf,docx,doc");
	     //su.setAllowedFilesList("jpg,png,bmp,gif,psd");
	     //su.setDeniedFilesList("exe,bat,jsp,htm,html");
		 
         try {
			su.upload();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		 
		    try{
		    	com.jspsmart.upload.File myFile = su.getFiles().getFile(0);  
			      fileExt= myFile.getFileExt();    
			      
				 String contractnum=su.getRequest().getParameter("contractnum");
				 int supplierid=Integer.parseInt(su.getRequest().getParameter("supplierid"));
				 String context=su.getRequest().getParameter("context");
				 int goodsid=Integer.parseInt(su.getRequest().getParameter("goodsid"));
				 int num=Integer.parseInt(su.getRequest().getParameter("num"));
				 Double price=Double.parseDouble(su.getRequest().getParameter("price"));
				 Double sum=Double.parseDouble(su.getRequest().getParameter("sum"));
				 String state=su.getRequest().getParameter("state");
				 String unit=su.getRequest().getParameter("unit");
				 
				 String date=su.getRequest().getParameter("date");
				 SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd"); 
				 java.util.Date date1 = df1.parse(date);
			     java.sql.Date sqlDate1=new java.sql.Date(date1.getTime());  
     			 String text=myFile.getFileName();

			     Contract contract=new Contract();
			     contract.setContract_context(context);	    
			     contract.setContract_supplierid(supplierid);
			     contract.setContract_sum(sum);
			     contract.setContract_number(contractnum);
			     contract.setContract_state(state);
			     contract.setContract_time(sqlDate1);
			     
			    ContractDetail contractdetail=new ContractDetail();
			    contractdetail.setContractdetail_num(num);
			    contractdetail.setContractdetail_price(price);
			    contractdetail.setContractdetail_unit(unit);
			    contractdetail.setContractdetail_supplygoodsid(goodsid);
			    contractdetail.setContractdetail_contractid(contractnum);
			    
			    ContractMedia contractmedia= new ContractMedia();
			    contractmedia.setContractmedia_contractid(contractnum);
			    contractmedia.setContractmedia_title(text);
			    
			    IpTimeStamp url=new IpTimeStamp();
			    String my=url.getIPTimeRand()+"."+ su.getFiles().getFile(0).getFileExt();
			    contractmedia.setContractmedia_url(my);
			    myFile.saveAs("/admin/jsp/uploadContract/"+ my);
			    
			    boolean a=DaoFactory.getContractDaoInstance().doCreate(contract);
			    boolean b=DaoFactory.getContractDetailDaoInstance().doCreate(contractdetail);
			    boolean c=DaoFactory.getContractMediaDaoInstance().doCreate(contractmedia);
			    
			    
	        	
			    if (a && b && c){
	        		PrintWriter out = response.getWriter();
	        		out.print("<script>alert('添加成功');window.location.href='admin/jsp/Connector_ContractInput.jsp';</script>");
	        		out.close();}
	        	else {
	        		PrintWriter out = response.getWriter();
	        		out.print("<script>alert('添加失败');window.location.href='admin/jsp/Connector_ContractInput.jsp';</script>");
	        		out.close();
				}

		       
	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
	}

}
