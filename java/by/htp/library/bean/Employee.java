package by.htp.library.bean;

import java.sql.Date;

//import java.util.Date;

public class Employee extends Entity {

	private String name;
	private String e_mail;
	private Date date_of_birth;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String e_mail, Date date_of_birth) {
		super(id);
		this.name = name;
		this.e_mail = e_mail;
		this.date_of_birth = date_of_birth;
	}

	public Employee(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return e_mail;
	}

	public void setEmail(String e_mail) {
		this.e_mail = e_mail;
	}

	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", e_mail=" + e_mail + ", date_of_birth=" + date_of_birth + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
		result = prime * result + ((e_mail == null) ? 0 : e_mail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (date_of_birth == null) {
			if (other.date_of_birth != null)
				return false;
		} else if (!date_of_birth.equals(other.date_of_birth))
			return false;
		if (e_mail == null) {
			if (other.e_mail != null)
				return false;
		} else if (!e_mail.equals(other.e_mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

}
