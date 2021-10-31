package application.model;

public class Insurance {
	private String primaryHolder;
	private String name;
	private String number;
	private String address;
	public Insurance() {}
	public Insurance(String primaryHolder, String name, String number, String address) {
		super();
		this.primaryHolder = primaryHolder;
		this.name = name;
		this.number = number;
		this.address = address;
	}
	public String getPrimaryHolder() {
		return primaryHolder;
	}
	public void setPrimaryHolder(String primaryHolder) {
		this.primaryHolder = primaryHolder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
