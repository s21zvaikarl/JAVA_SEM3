package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import service.MainService;

public class GuestUser {
	private long generatedId;
	private static long idCounter = 0;
	
	public long getGeneratedId() {
		return generatedId;
	}
	public void setGeneratedId() {
		this.generatedId = idCounter++;
	}
	
	public GuestUser() {
		setGeneratedId();
	}
		
	public String toString() {
		return "GU No." + generatedId;
	}
	
	public ArrayList<User> findUserByNameOrSurnameOrUsername (String inputWord){
		ArrayList<User> result = new ArrayList<>();
		if(inputWord != null) {
			for(User temp: MainService.allRegisterdUsers) {
				if(temp.getName().contains(inputWord) || temp.getSurname().contains(inputWord) || temp.getUsername().contains(inputWord)) {
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	public ArrayList<Page> findPageByTitleOrDescription(String inputWord){
		ArrayList<Page> result = new ArrayList<>();
		if(inputWord != null) {
			for(User temp: MainService.allRegisterdUsers) {
				BussinessUser bUserTemp = (BussinessUser)temp;
				for(Page tempPage : bUserTemp.getAllPages()) {
					if(tempPage.getTitle().toLowerCase().contains(inputWord) || tempPage.getDescription().toLowerCase().contains(inputWord)) {
						result.add(tempPage);
					}
				}
			}
		}
		return result;
	}
	
	public ArrayList<Post> findPublicPostInPrivateUserOrInPage(String inputWord){
		ArrayList<Post> result = new ArrayList<>();
		if(inputWord != null) {
			for(User temp: MainService.allRegisterdUsers) {
				if(temp instanceof PrivateUser) {
					PrivateUser pUserTemp = (PrivateUser) temp;
					for(Post tempPost : pUserTemp.getAllPublicPosts()) {
						if(tempPost.getMsg().toLowerCase().contains(inputWord)) {
							result.add(tempPost);
							}
						}
					}
				else if(temp instanceof BussinessUser) {
					BussinessUser bUserTemp = (BussinessUser)temp;
					for(Page tempPage : bUserTemp.getAllPages()) {
						for(Post tempPost: tempPage.getPostsInPage()) {
							if(tempPage.getTitle().toLowerCase().contains(inputWord) || tempPage.getDescription().toLowerCase().contains(inputWord)) {
							result.add(tempPage);
							}
						
						}
					}
				}
				
			}
		}
	}
	

	
	
}
