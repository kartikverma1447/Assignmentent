package com.off.bussiness.assigment.Model;

import java.util.ArrayList;
import java.util.Map;

public class ChatModel {
	
	private String userId;
	
	private ArrayList<ChatLog> chatLog = new ArrayList<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ArrayList<ChatLog> getChatLog() {
		return chatLog;
	}

	public void setChatLog(ArrayList<ChatLog> chatLog) {
		this.chatLog = chatLog;
	}

	public ChatModel(String userId,ChatLog data) {
		super();
		this.userId = userId;
		System.out.println(data);
		this.chatLog.add(data);
	}
  
}
