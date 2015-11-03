package DataBaseDao;

import java.util.List;
import DataBaseTable.Address;
public interface AddressDao {
	public boolean doCreate(Address address) throws Exception;

	public List<Address> findAll(String keyWord) throws Exception;

	public Address findById(int address_id) throws Exception;
}
