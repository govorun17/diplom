package my.diplom.dev.dto;

public enum Events {
	CONFIRMATION("confirmation"),
	MESSAGE("message_new"),
	EVENT("message_event"),
	OK("ok");

	private final String label;

	Events(String label) {
		this.label = label;
	}

	public String label() {
		return this.label;
	}
}
