package DataBaseImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DataBaseDao.AddressDao;
import DataBaseTable.Address;
import DataBaseTable.Role;

public class AddressDaoImpl implements AddressDao{

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public AddressDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public boolean doCreate(Address address) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO t_address(address_userid,address_province,address_city,address_country,address_street,address_detail) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, address.getAddress_userid());
		this.pstmt.setString(2, address.getAddress_province());
		this.pstmt.setString(3, address.getAddress_city());
		this.pstmt.setString(4, address.getAddress_country());
		this.pstmt.setString(5, address.getAddress_street());
		this.pstmt.setString(6, address.getAddress_detail());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Address> findAll(String keyWord) throws Exception {
		List<Address> result = new ArrayList<Address>();
		String sql = "SELECT * FROM t_address WHERE  address_id LIKE ? OR address_userid  LIKE ? OR address_province  LIKE ? OR address_city  LIKE ? OR address_country LIKE ? OR address_street LIKE ? OR address_detail  LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		this.pstmt.setString(7, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		Address address = null;
		while (rs.next()) {
			address = new Address();
			address.setAddress_id(rs.getInt("address_id"));
			address.setAddress_userid(rs.getInt("address_userid"));
			address.setAddress_province(rs.getString("address_province"));
			address.setAddress_city(rs.getString("address_city"));
			address.setAddress_country(rs.getString("address_country"));
			address.setAddress_street(rs.getString("address_street"));
			address.setAddress_detail(rs.getString("address_detail"));
			result.add(address);
		}
		this.pstmt.close();
		return result;
	
	}

	@Override
	public Address findById(int address_id) throws Exception {
		Address address = null;
		String sql = "SELECT * FROM t_address WHERE address_id=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, address_id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			address = new Address();
			address.setAddress_id(rs.getInt("address_id"));
			address.setAddress_userid(rs.getInt("address_userid"));
			address.setAddress_province(rs.getString("address_province"));
			address.setAddress_city(rs.getString("address_city"));
			address.setAddress_country(rs.getString("address_country"));
			address.setAddress_street(rs.getString("address_street"));
			address.setAddress_detail(rs.getString("address_detail"));
		}
		this.pstmt.close();
		return address;
	}
	}


