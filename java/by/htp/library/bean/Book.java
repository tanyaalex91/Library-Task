package by.htp.library.bean;

import java.util.Date;

public class Book extends Entity{


	private String title;
	private String description;
	private String author;
	private Date date_of_publishing;

	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getAuthor() {
		return author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(int id, String title, String description, String author) {
		super(id);
		this.title = title;
		this.description = description;
		this.author = author;
	}
	public Book() {
		super();
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (super.id != other.id) {
			return false;
		}
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", author=" + author + "]";
	}
	public Date getDate_of_publishing() {
		return date_of_publishing;
	}
	public void setDate_of_publishing(Date year_of_publishing) {
		this.date_of_publishing = date_of_publishing;
	}
	
}
