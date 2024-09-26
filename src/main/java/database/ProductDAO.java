package database;

import java.util.ArrayList;

import model.Product;

public class ProductDAO implements DAOInterface<Product> {
	private ArrayList<Product> data = new ArrayList<Product>();

	public ArrayList<Product> selectAll() {
		return this.data;
	}

	@Override
	public Product selectById(Product o) {
		for (Product Product : data) {
			if (Product.equals(o)) {
				return Product;
			}
		}
		return null;
	}

	public int insert(Product Product) {
		Product isExist = this.selectById(Product);
		if (isExist == null) {
			data.add(Product);
			return 1;
		}
		return 0;

	}

	public int insertAll(ArrayList<Product> list) {
		int cnt = 0;
		for (Product Product : list) {
			cnt += this.insert(Product);

		}
		return cnt;
	}

	public int delete(Product Product) {
		Product isExist = this.selectById(Product);
		if (isExist != null) {
			data.remove(Product);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<Product> list) {
		int cnt = 0;
		for (Product Product : list) {
			cnt += this.delete(Product);

		}
		return cnt;
	}

	public int update(Product Product) {
		Product isExist = this.selectById(Product);
		if (isExist != null) {
			data.remove(isExist);
			data.add(Product);
			return 1;
		} else {
			return 0;
		}
	}

}
