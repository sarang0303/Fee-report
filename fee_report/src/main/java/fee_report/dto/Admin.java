package fee_report.dto;

import java.util.List;

public class Admin {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String password;
	
	private List<Accountant> accountants;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Accountant> getAccountants() {
		return accountants;
	}

	public void setAccountants(List<Accountant> accountants) {
		this.accountants = accountants;
	}


}
