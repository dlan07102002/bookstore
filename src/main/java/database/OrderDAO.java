package database;

import java.util.ArrayList;

import model.Order;

public class OrderDAO implements DAOInterface<Order> {
	private ArrayList<Order> data = new ArrayList<Order>();

	public ArrayList<Order> selectAll() {
		return this.data;
	}

	@Override
	public Order selectById(Order o) {
		for (Order Order : data) {
			if (Order.equals(o)) {
				return Order;
			}
		}
		return null;
	}

	public int insert(Order Order) {
		Order isExist = this.selectById(Order);
		if (isExist == null) {
			data.add(Order);
			return 1;
		}
		return 0;

	}

	public int insertAll(ArrayList<Order> list) {
		int cnt = 0;
		for (Order Order : list) {
			cnt += this.insert(Order);

		}
		return cnt;
	}

	public int delete(Order Order) {
		Order isExist = this.selectById(Order);

		if (isExist != null) {
			OrderDetailDAO oDDao = new OrderDetailDAO();
			oDDao.deleteByOrderId(Order);
			this.data.remove(Order);
			return 1;
		}
		return 0;

	}

	public int deleteAll(ArrayList<Order> list) {
		int cnt = 0;
		for (Order Order : list) {
			cnt += this.delete(Order);

		}
		return cnt;
	}

	public int update(Order Order) {
		Order isExist = this.selectById(Order);
		if (isExist != null) {
			data.remove(isExist);
			data.add(Order);
			return 1;
		}
		return 0;

	}

}
