package model.users;

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
	
	public ArrayList<User> findUserByNameOrSurname (String inputWord){
		for()
		
	}
	
	public ArrayList<Page> findPageByTitleOrDescription(String inputWord){
		
	}
	
	public ArrayList<Post> findPublicPostInPrivateUserOrInPage(String inputWord){
		
	}
	

	
	
}
