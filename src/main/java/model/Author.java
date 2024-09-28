package model;

import java.sql.Date;
import java.util.Objects;

public class Author {
	private String authorId;
	private String name;
	private Date birthDate;
	private String bio;

	public Author() {
		
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", birthDate=" + birthDate + ", bio=" + bio + "]";
	}
	
	public Author(String authorId) {
		this.authorId = authorId;
	}

	public Author(String authorId, String name, Date birthDate, String bio) {
		this.authorId = authorId;
		this.name = name;
		this.birthDate = birthDate;
		this.bio = bio;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorId, bio, birthDate, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorId, other.authorId);
	}
	
	

}
