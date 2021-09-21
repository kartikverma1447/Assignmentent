package com.off.bussiness.assigment.Model;

public class ChatLog {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public ChatLog(String message, long l, boolean sent) {
		super();
		this.message = message;
		this.timeStamp = l;
		this.sent = sent;
	}

	private long timeStamp;
	private boolean sent;

}
