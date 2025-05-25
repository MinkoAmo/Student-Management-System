package enums;

public enum Role {
	ADMIN("Admin"), TEACHER("Teacher"), STUDENT("Student");

	private final String displayName;

	Role(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return this.displayName;
	}
}
