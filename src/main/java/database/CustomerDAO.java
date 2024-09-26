package database;

import java.util.ArrayList;

import model.Customer;

public class CustomerDAO implements DAOInterface<Customer> {
	private ArrayList<Customer> data = new ArrayList<Customer>();

	public ArrayList<Customer> selectAll() {
		return this.data;
	}

	@Override
	public Customer selectById(Customer o) {
		for (Customer Customer : data) {
			if (Customer.equals(o)) {
				return Customer;
			}
		}
		return null;
	}

	public int insert(Customer Customer) {
		Customer isExist = this.selectById(Customer);
		if (isExist == null) {
			data.add(Customer);
			return 1;
		}
		return 0;

	}

	public int insertAll(ArrayList<Customer> list) {
		int cnt = 0;
		for (Customer Customer : list) {
			cnt += this.insert(Customer);

		}
		return cnt;
	}

	public int delete(Customer Customer) {
		Customer isExist = this.selectById(Customer);
		if (isExist != null) {
			data.remove(Customer);
			return 1;
		}
		return 0;

	}

	public int deleteAll(ArrayList<Customer> list) {
		int cnt = 0;
		for (Customer Customer : list) {
			cnt += this.delete(Customer);

		}
		return cnt;
	}

	public int update(Customer Customer) {
		Customer isExist = this.selectById(Customer);
		if (isExist != null) {
			data.remove(isExist);
			data.add(Customer);
			return 1;
		}
		return 0;

	}

}
