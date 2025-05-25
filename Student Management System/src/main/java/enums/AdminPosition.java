package enums;

public enum AdminPosition {
	SYSTEM_ADMIN("System Administrator"), ACADEMIC_ADMIN("Academic Administrator"),
	HR_ADMIN("Human Resources Administrator"), TECH_SUPPORT("Technical Support"), MANAGER("General Manager");

	private final String displayName;

	AdminPosition(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return this.displayName;
	}
}
