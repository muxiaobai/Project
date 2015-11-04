package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tool.IpTimeStamp;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import DataBaseFactory.DaoFactory;
import DataBaseTable.Category;
import DataBaseTable.Goods;
import DataBaseTable.Goodsdetail;

/**
 * Servlet implementation class GoodsAdd
 */
@WebServlet("/GoodsAdd")
public class GoodsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsAdd() {
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
		 
		   int goods_grade=0;
		   int goods_inventory=0;
		   int goods_video=0;		  
		   int goods_sendnumber=0;
		   //float file_size = 0f;
		   
		   SmartUpload smartUpload =new SmartUpload(); 
			//String fileExt="";
			 smartUpload.initialize(getServletConfig(), request, response);  
			 //su.initialize(pageContext);
			 //smartUpload.setAllowedFilesList("jpg,xls,xlsx,pdf,docx,doc");
			 smartUpload.setAllowedFilesList("jpg,png,bmp,gif,psd");
		     //su.setDeniedFilesList("exe,bat,jsp,htm,html");
			 
	         try {
	        	 smartUpload.upload();
			} catch (SmartUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
		  
		   goods_grade=Integer.parseInt(smartUpload.getRequest().getParameter("goods_grade"));
		   goods_inventory=Integer.parseInt(smartUpload.getRequest().getParameter("goods_inventory"));
		   goods_video=Integer.parseInt(smartUpload.getRequest().getParameter("goods_video"));
		   goods_sendnumber=Integer.parseInt(smartUpload.getRequest().getParameter("goods_sendnumber"));
		   
		   int xiaolei=Integer.parseInt(smartUpload.getRequest().getParameter("xiaolei1"));
		   
		   String goods_name=smartUpload.getRequest().getParameter("goods_name");
		   String goods_anothername=smartUpload.getRequest().getParameter("goods_anothername");
		   String goods_place=smartUpload.getRequest().getParameter("goods_place");
		   String goods_unit=smartUpload.getRequest().getParameter("goods_unit");
		   Double goods_price=Double.parseDouble(smartUpload.getRequest().getParameter("goods_price"));
		   String goods_vantage=smartUpload.getRequest().getParameter("goods_vantage");
		   String goods_producetime=smartUpload.getRequest().getParameter("goods_producetime");
		   String goods_saletime=smartUpload.getRequest().getParameter("goods_saletime");
		   String goods_offtime=smartUpload.getRequest().getParameter("goods_offtime");
		   String goods_info=smartUpload.getRequest().getParameter("goods_info");
		   
           try {
        	     
        	   
        	   Category category=new Category();
               category.setCategory_fanumber(xiaolei);
               category.setCategory_name(goods_name);
			   boolean b=DaoFactory.getCategoryDaoInstance().doCreate(category);
			   
			   Category category2=new Category();
			   category2=DaoFactory.getCategoryDaoInstance().findByName(goods_name);
			   int id = category2.getCategory_id();
			   
			   Category category3=new Category();
			   category3.setCategory_number(id);
			   category3.setCategory_id(id);
			   boolean c=DaoFactory.getCategoryDaoInstance().doUpdate(category3);
			   if(b&&c){
				   System.out.print("ok");
			   }
			   
			  
			   Goods goods=new Goods();
			   
			   goods.setGoods_grade(goods_grade);
			   goods.setGoods_category(id);
			   goods.setGoods_inventory(goods_inventory);
			   goods.setGoods_video(goods_video);
			   goods.setGoods_name(goods_name);
			   goods.setGoods_sendnumber(goods_sendnumber);
			   goods.setGoods_anothername(goods_anothername);
			   goods.setGoods_place(goods_place);
			   goods.setGoods_unit(goods_unit);
			   goods.setGoods_price(goods_price);
			   goods.setGoods_vantage(goods_vantage);
			   goods.setGoods_state(1);         //待审核状态
			   goods.setGoods_type(1);         //商品
			   goods.setGoods_info(goods_info);
			   
			   SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd"); 
				Date producetime;
				Date saletime;
				Date offtime;
			
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
					a = DaoFactory.getGoodsDaoInstance().doCreate(goods);
					System.out.print("goods ok");
					
					Goods goods2=new Goods();
					goods2=DaoFactory.getGoodsDaoInstance().findByGoodsName(goods_name);      //找商品ID 存进商品详情表
					int goodsdetail_goodsid = goods2.getGoods_id();
					Map<Integer, String> goodsdetail_url =new HashMap<Integer, String>();
					Map<Integer, String> goodsdetail_otherurl =new HashMap<Integer, String>();
					Goodsdetail goodsdetail=new Goodsdetail();
					goodsdetail.setGoodsdetail_goodsid(goodsdetail_goodsid);

					 for (int i = 1; i <= 3; i++) {
		     	          com.jspsmart.upload.File myFile = smartUpload.getFiles().getFile(i-1);
		     	          
		     	          //count = smartUpload.save();
		     	          //file_size = myFile.getSize(); 
		     	          //fileExt= myFile.getFileExt(); 
		     	          //String text=myFile.getFileName();
		     	          IpTimeStamp url=new IpTimeStamp();
		   			    String my=url.getIPTimeRand()+i+"."+ smartUpload.getFiles().getFile(i-1).getFileExt();			    
		   			    myFile.saveAs("/admin/jsp/uploadContract/"+ my);
		   			    System.out.println(i+"picture ooook");
		   			    goodsdetail_url.put(i+2,my);
		   			    //goodsdetail.setGoodsdetaail_url+i(my);
		   			    }
					 for (int i = 4; i <= 9; i++) {
		     	          com.jspsmart.upload.File myFile= smartUpload.getFiles().getFile(i-1);		
		     	        
		     	          System.out.print(myFile);
//		     	          count = smartUpload.save();
//		     	          file_size = myFile.getSize(); 
//		     	          fileExt= myFile.getFileExt(); 
//		     	          String text=myFile.getFileName();
		     	          IpTimeStamp url1=new IpTimeStamp();
		   			    String my1=url1.getIPTimeRand()+i+"."+ smartUpload.getFiles().getFile(i-1).getFileExt();			    
		   			    myFile.saveAs("/admin/jsp/uploadContract/"+ my1);
	   			         System.out.println(i+"picture ooook");
	   			         goodsdetail_otherurl.put(i+2,my1);
		   				//goodsdetail.setGoodsdetail_otherurl+i(my);
		   			    }
						goodsdetail.setGoodsdetail_url(goodsdetail_url);
						goodsdetail.setGoodsdetail_otherurl(goodsdetail_otherurl);
					 boolean d;
					 d=DaoFactory.getGoodsdetailDaoInstance().doCreate(goodsdetail);
					 
					if (a&&d){
		        		PrintWriter out = response.getWriter();
		        		out.print("<script>alert('添加成功,请等待商品审核。');window.location.href='admin/jsp/GoodsList.jsp';</script>");
		        		out.close();}
					else{
		        		PrintWriter out = response.getWriter();
		        		out.print("<script>alert('添加失败,请重新添加商品。');window.location.href='admin/jsp/GoodsList.jsp';</script>");
		        		out.close();
					}
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		   
		 
	}

}
