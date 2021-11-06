package application.model;

public class Medication {
	private String name;
	private String dosage;
	private String unit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return name + " " + dosage + unit;
	}
	public Medication(String name, String dosage, String unit) {
		super();
		this.name = name;
		this.dosage = dosage;
		this.unit = unit;
	}
}
