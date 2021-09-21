package com.off.bussiness.assigment.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.off.bussiness")
public class ChatController {
	
	@Autowired
	private ChatServiceManager chatServiceManager; 
	
	@GetMapping(value="/hello")
	public String hello(){
		return "hello";
	}
	
	@GetMapping(value="findAll")
	public ArrayList<ChatLog> getChat(@RequestParam(name = "id") String id){
		System.out.println("point1.Controller");
		ArrayList<ChatLog> chat = chatServiceManager.findAll(id);
		//TODO. have to implement 1 more execution
		return chat;
	}
	
	@PostMapping(value="add")
	public void postChat(@RequestParam(name = "msg") String msg,@RequestParam(name = "id") String id,@RequestParam(name = "status") String status){
		chatServiceManager.addChat(id,msg,status);
	}

	@DeleteMapping(value="remove")
	public void deleteparticularMessage(@RequestParam(name = "id") String id,@RequestParam(name = "msg") String message){
		chatServiceManager.deleteUniqueMessage(id,message);
	}
	
	@DeleteMapping(value="removeAll")
	public void deleteAllMessage(@RequestParam(name = "id") String id){
		chatServiceManager.deleteAllMessage(id);
	}
	
	
	
	
	
}
