package database;

import java.util.ArrayList;

import model.Order;
import model.OrderDetail;

public class OrderDetailDAO implements DAOInterface<OrderDetail> {
	private ArrayList<OrderDetail> data = new ArrayList<OrderDetail>();

	public ArrayList<OrderDetail> selectAll() {
		return this.data;
	}

	@Override
	public OrderDetail selectById(OrderDetail o) {
		for (OrderDetail OrderDetail : data) {
			if (OrderDetail.equals(o)) {
				return OrderDetail;
			}
		}
		return null;
	}

	public int insert(OrderDetail OrderDetail) {
		OrderDetail isExist = this.selectById(OrderDetail);
		if (isExist == null) {
			data.add(OrderDetail);
			return 1;
		}
		return 0;

	}

	public int insertAll(ArrayList<OrderDetail> list) {
		int cnt = 0;
		for (OrderDetail OrderDetail : list) {
			cnt += this.insert(OrderDetail);

		}
		return cnt;
	}

	public int delete(OrderDetail OrderDetail) {
		OrderDetail isExist = this.selectById(OrderDetail);
		if (isExist != null) {
			data.remove(OrderDetail);
			return 1;
		}
		return 0;

	}

	public int deleteAll(ArrayList<OrderDetail> list) {
		int cnt = 0;
		for (OrderDetail OrderDetail : list) {
			cnt += this.delete(OrderDetail);

		}
		return cnt;
	}

	public int deleteByOrderId(Order o) {
		int cnt = 0;
		for (OrderDetail orderDetail : data) {
			if (orderDetail.getOrder().equals(o)) {
				cnt += this.delete(orderDetail);
			}
		}
		return cnt;
	}

	public int update(OrderDetail OrderDetail) {
		OrderDetail isExist = this.selectById(OrderDetail);
		if (isExist != null) {
			data.remove(isExist);
			data.add(OrderDetail);
			return 1;
		}
		return 0;

	}

}
