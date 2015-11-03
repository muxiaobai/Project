package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.OrderDao;
import DataBaseTable.Order;
import DataBaseTable.Role;

public class OrderDaoImpl implements OrderDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public OrderDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(Order Order) throws Exception {

		boolean flag = false;
		String sql = "INSERT INTO t_order(order_number,order_userid,order_paysum,order_province,order_city,order_country,order_address,order_stationnumber,order_pmtl_offer,order_place_time,order_pay_time,order_state) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
	
		this.pstmt.setString(1, Order.getOrder_number());
		this.pstmt.setInt(2, Order.getOrder_userid());
		this.pstmt.setDouble(3, Order.getOrder_paysum());
		this.pstmt.setString(4, Order.getOrder_province());
		this.pstmt.setString(5, Order.getOrder_city());
		this.pstmt.setString(6, Order.getOrder_country());
		this.pstmt.setString(7, Order.getOrder_address());
		this.pstmt.setString(8, Order.getOrder_stationnumber());
		this.pstmt.setInt(9, Order.getOrder_pmtl_offer());
		this.pstmt.setTimestamp(10, Order.getOrder_place_time());
		this.pstmt.setTimestamp(11, Order.getOrder_pay_time());
		this.pstmt.setInt(12, Order.getOrder_state());

		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;

	}


	@Override
	public List<Order> findAll(String keyWord) throws Exception {
		List<Order> result = new ArrayList<Order>();
		String sql = "SELECT * FROM t_order WHERE  order_id LIKE ?  OR order_number LIKE ? OR order_userid LIKE ? OR order_paysum LIKE ? OR order_province LIKE ? OR order_city LIKE ? OR order_country LIKE ? OR order_address LIKE ? OR order_stationnumber LIKE ? OR order_pmtl_offer LIKE ? OR order_place_time LIKE ? OR order_pay_time LIKE ? OR order_state LIKE ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		this.pstmt.setString(8, "%" + keyWord + "%");
		this.pstmt.setString(9, "%" + keyWord + "%");
		this.pstmt.setString(10, "%" + keyWord + "%");
		this.pstmt.setString(11, "%" + keyWord + "%");
		this.pstmt.setString(12, "%" + keyWord + "%");
		this.pstmt.setString(13, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Order Order = null;
		while (rs.next()) {
			Order  = new Order();
			Order.setOrder_id(rs.getInt("order_id"));
			Order.setOrder_number(rs.getString("order_number"));
			Order.setOrder_userid(rs.getInt("order_userid"));
			Order.setOrder_paysum(rs.getDouble("order_paysum"));
			Order.setOrder_province(rs.getString("order_province"));
			Order.setOrder_city(rs.getString("order_city"));
			Order.setOrder_country(rs.getString("order_country"));
			Order.setOrder_address(rs.getString("order_address"));
			Order.setOrder_stationnumber(rs.getString("order_stationnumber"));
			Order.setOrder_pmtl_offer(rs.getInt("order_pmtl_offer"));
			Order.setOrder_place_time(rs.getTimestamp("order_place_time"));
			Order.setOrder_pay_time(rs.getTimestamp("order_pay_time"));
			Order.setOrder_state(rs.getInt("order_state"));
			result.add(Order);
		}
		this.pstmt.close();
		return result;

	}
	@Override
	public Order findById(int order_id) throws Exception {
		Order Order = null;
		String sql = "SELECT * FROM t_order WHERE order_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, order_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			Order  = new Order();
			Order.setOrder_id(rs.getInt("order_id"));
			Order.setOrder_number(rs.getString("order_number"));
			Order.setOrder_userid(rs.getInt("order_userid"));
			Order.setOrder_paysum(rs.getDouble("order_paysum"));
			Order.setOrder_province(rs.getString("order_province"));
			Order.setOrder_city(rs.getString("order_city"));
			Order.setOrder_country(rs.getString("order_country"));
			Order.setOrder_address(rs.getString("order_address"));
			Order.setOrder_stationnumber(rs.getString("order_stationnumber"));
			Order.setOrder_pmtl_offer(rs.getInt("order_pmtl_offer"));
			Order.setOrder_place_time(rs.getTimestamp("order_place_time"));
			Order.setOrder_pay_time(rs.getTimestamp("order_pay_time"));
			Order.setOrder_state(rs.getInt("order_state"));
		}
		this.pstmt.close();
		return Order;
	}

}
