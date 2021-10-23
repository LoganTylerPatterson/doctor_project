package application.model;

public class Medication {
	private String name;
	private int dosage;
	private String unit;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
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
	public Medication(String name, int dosage, String unit) {
		super();
		this.name = name;
		this.dosage = dosage;
		this.unit = unit;
	}
}
