package DataBaseProxy;

import java.util.List;

import DataBaseConn.lianjie;
import DataBaseDao.AddressDao;
import DataBaseImpl.AddressDaoImpl;
import DataBaseTable.Address;
import DataBaseTable.Role;

public class AddressDaoProxy implements AddressDao {
	private lianjie dbc = null;
	private AddressDao dao = null;

	public AddressDaoProxy() throws Exception {
		this.dbc = new lianjie();
		this.dao = new AddressDaoImpl(this.dbc.getConnection());
	}
	@Override
	public boolean doCreate(Address address) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(address.getAddress_id()) == null) {
				flag = this.dao.doCreate(address);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;

	}

	@Override
	public List<Address> findAll(String keyWord) throws Exception {
		List<Address> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	@Override
	public Address findById(int address_id) throws Exception {
		Address address = null;
		try {
			address = this.dao.findById(address_id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return address;
	}

}
