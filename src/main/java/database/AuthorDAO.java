package database;

import java.util.ArrayList;

import model.Author;

public class AuthorDAO implements DAOInterface<Author> {
	private ArrayList<Author> data = new ArrayList<Author>();

	public ArrayList<Author> selectAll() {
		return this.data;
	}

	@Override
	public Author selectById(Author o) {
		for (Author author : data) {
			if (author.equals(o)) {
				return author;
			}
		}
		return null;
	}

	public int insert(Author author) {
		Author isExist = this.selectById(author);
		if (isExist == null) {
			data.add(author);
			return 1;
		}
		return 0;

	}

	public int insertAll(ArrayList<Author> list) {
		int cnt = 0;
		for (Author author : list) {
			cnt += this.insert(author);

		}
		return cnt;
	}

	public int delete(Author author) {
		Author isExist = this.selectById(author);
		if (isExist != null) {
			data.remove(author);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<Author> list) {
		int cnt = 0;
		for (Author author : list) {
			cnt += this.delete(author);

		}
		return cnt;
	}

	public int update(Author author) {
		Author isExist = this.selectById(author);
		if (isExist != null) {
			data.remove(isExist);
			data.add(author);
			return 1;
		} else {
			return 0;
		}
	}

}
