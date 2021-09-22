package com.off.bussiness.assigment.Model;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.xmlunit.diff.Comparison;

@Service
public class ChatService implements ChatServiceManager {

	public static ArrayList<ChatModel> modelData = new ArrayList<>();

	@Override
	public ArrayList<ChatLog> findAll(String id) {
		System.out.println("point2.Service");
		for (ChatModel cm : modelData) {
			System.out.println(cm.getUserId());
			if (cm.getUserId().equals(id)) {
				return cm.getChatLog();
			}
		}
		System.out.println("result.Service");
		return new ArrayList<ChatLog>();
	}

	@Override
	public void addChat(String id, String msg, String status) {
		boolean stat = false;
		System.out.println(modelData.size());
		for (int i = 0; i < modelData.size(); i++) {
			if (modelData.get(i).getUserId().equals(id)) {
				System.out.println("if condition satisfied");
				stat = true;
				ChatLog newMessage = new ChatLog(msg, System.currentTimeMillis(), status == "t" ? true : false);
				modelData.get(i).getChatLog().add(newMessage);
				break;
			}
		}
		if (stat == false) {
			ChatLog log = new ChatLog(msg, System.currentTimeMillis(), status == "true" ? true : false);
			ChatModel model = new ChatModel(id,log);
			modelData.add(model);

		}
	}

	@Override
	public void deleteUniqueMessage(String id, String message) {
		for (ChatModel cm : modelData) {
			if (cm.getUserId().equals(id)) {
				ArrayList<ChatLog> chatlog = cm.getChatLog();
				for (ChatLog ch : chatlog) {
					if (ch.getMessage() == message) {
						chatlog.remove(chatlog.indexOf(ch));
					}
				}
			}
		}
	}

	@Override
	public void deleteAllMessage(String id) {
		for (ChatModel cm : modelData) {
			if (cm.getUserId().equals(id)) {
				cm.setChatLog(new ArrayList<ChatLog>());
			}
		}

	}
}
