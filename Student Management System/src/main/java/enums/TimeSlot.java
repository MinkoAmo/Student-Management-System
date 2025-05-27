package enums;

public enum TimeSlot {
	PERIOD_1("7:00 - 7:45"),
    PERIOD_2("7:50 - 8:35"),
    PERIOD_3("8:40 - 9:25"),
    PERIOD_4("9:30 - 10:15"),
    PERIOD_5("10:20 - 11:05"),
    PERIOD_6("11:10 - 11:55"),
    PERIOD_7("13:00 - 13:45"),
    PERIOD_8("13:50 - 14:35"),
    PERIOD_9("14:40 - 15:25"),
    PERIOD_10("15:30 - 16:15"),
    PERIOD_11("16:20 - 17:05"),
    PERIOD_12("18:00 - 18:45"),
    PERIOD_13("18:50 - 19:35"),
    PERIOD_14("19:40 - 20:25");
	
	private final String timeRange;

    TimeSlot(String timeRange) {
        this.timeRange = timeRange;
    }

    public String getTimeRange() {
        return timeRange;
    }
}
