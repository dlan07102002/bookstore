package database;

import java.util.ArrayList;

import model.Category;

public class CategoryDAO implements DAOInterface<Category> {
	private ArrayList<Category> data = new ArrayList<Category>();

	public ArrayList<Category> selectAll() {
		return this.data;
	}

	@Override
	public Category selectById(Category o) {
		for (Category Category : data) {
			if (Category.equals(o)) {
				return Category;
			}
		}
		return null;
	}

	public int insert(Category Category) {
		Category isExist = this.selectById(Category);
		if (isExist == null) {
			data.add(Category);
			return 1;
		}
		return 0;

	}

	public int insertAll(ArrayList<Category> list) {
		int cnt = 0;
		for (Category Category : list) {
			cnt += this.insert(Category);

		}
		return cnt;
	}

	public int delete(Category Category) {
		Category isExist = this.selectById(Category);
		if (isExist != null) {
			data.remove(Category);
			return 1;
		}
		return 0;

	}

	public int deleteAll(ArrayList<Category> list) {
		int cnt = 0;
		for (Category Category : list) {
			cnt += this.delete(Category);

		}
		return cnt;
	}

	public int update(Category Category) {
		Category isExist = this.selectById(Category);
		if (isExist != null) {
			data.remove(isExist);
			data.add(Category);
			return 1;
		}
		return 0;

	}

}
