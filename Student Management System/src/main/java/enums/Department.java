package enums;

public enum Department {
	COMPUTER_SCIENCE("Computer Science"), BUSINESS_ADMINISTRATION("Business Administration"),
	ELECTRICAL_ENGINEERING("Electrical Engineering"), HUMANITIES("Humanities");

	private final String displayName;

	Department(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return this.displayName;
	}
}
