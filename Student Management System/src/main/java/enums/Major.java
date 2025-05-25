package enums;

import java.util.List;

public enum Major {
    SOFTWARE_ENGINEERING("Software Engineering", List.of(
        Subject.DATA_STRUCTURES,
        Subject.ALGORITHMS,
        Subject.DATABASES,
        Subject.OPERATING_SYSTEMS,
        Subject.SOFTWARE_TESTING
    )),
    DATA_SCIENCE("Data Science", List.of(
        Subject.MACHINE_LEARNING,
        Subject.BIG_DATA_ANALYTICS,
        Subject.DATA_MINING,
        Subject.DATABASES,
        Subject.ALGORITHMS
    )),
    NETWORK_SECURITY("Network Security", List.of(
        Subject.CYBER_SECURITY,
        Subject.CRYPTOGRAPHY,
        Subject.NETWORK_SECURITY,
        Subject.OPERATING_SYSTEMS,
        Subject.DATA_STRUCTURES
    )),
    MARKETING("Marketing", List.of(
        Subject.MARKETING_STRATEGY,
        Subject.CONSUMER_BEHAVIOR,
        Subject.DIGITAL_MARKETING,
        Subject.BRAND_MANAGEMENT
    )),
    FINANCE("Finance", List.of(
        Subject.FINANCIAL_ACCOUNTING,
        Subject.CORPORATE_FINANCE,
        Subject.INVESTMENT_ANALYSIS,
        Subject.ECONOMETRICS
    )),
    LINGUISTICS("Linguistics", List.of(
        Subject.INTRO_TO_LINGUISTICS,
        Subject.SYNTAX,
        Subject.PHONETICS,
        Subject.SOCIOLINGUISTICS
    ));

    private final String displayName;
    private final List<Subject> subjects;

    Major(String displayName, List<Subject> subjects) {
        this.displayName = displayName;
        this.subjects = subjects;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}

