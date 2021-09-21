package com.off.bussiness.assigment.Model;

import java.util.ArrayList;

public interface ChatServiceManager {

	ArrayList<ChatLog> findAll(String id);

	void addChat(String id, String msg,String status);

	void deleteAllMessage(String id);

	void deleteUniqueMessage(String id, String message);


}
