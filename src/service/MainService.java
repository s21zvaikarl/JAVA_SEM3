package service;

import java.util.ArrayList;
import java.util.Iterator;

import model.users.User;
import model.users.GuestUser;
import model.users.PrivateUser;
import model.Post;
import model.PostType;
import model.users.BussinessUser;
import model.Page;

public class MainService {

	public static ArrayList<User> allRegisterdUsers = new ArrayList<>();
	
	
	public static void main(String[] args) {
		//1. create 2 Guest User objects
		GuestUser gu1 = new GuestUser();
		GuestUser gu2 = new GuestUser();
		
		System.out.println(gu1);
		System.out.println(gu2);
		
		//public boolean register(String name, String surname, String username, String password)
		
		//2. create 2 Private user objects
		PrivateUser pu1 = new PrivateUser("Karlis", "Zvaigzne", "karlisz", "parole123");
		PrivateUser pu2 = new PrivateUser("Nekarlis", "Nezvaigzne", "nekarlis", "neparole");
		allRegisterdUsers.add(pu1);
		allRegisterdUsers.add(pu2);
		
		//3. create 2 Business User objects
		BussinessUser bu1 = new BussinessUser("AS", "Zvaigzne", "ZvaigzneAS", "parole1");
		BussinessUser bu2 = new BussinessUser("SIA", "KarlisCO", "karlisunco", "karlisco");
		System.out.println(bu1);
		System.out.println(bu2);
		
		//4. create 1 private and 1 public posts for each Private User
		pu1.createPost(new Post("Sodien skaista dieninja!!!"), PostType.publicPost);
		pu1.createPost(new Post("Nopirkt tomaatus"), PostType.privatePost);
		pu2.createPost(new Post("Nepirkt netomaatus"), PostType.privatePost);
		
		for(Post temp: pu1.getAllPrivatePosts()) {
			System.err.println(temp);
		}
		
		for(Post temp: pu2.getAllPrivatePosts()) {
			System.err.println(temp);
		}
		
		//5. create page for private user --> it is not allowed in our system
		//pu1.addPage();
		
		//6. create at least one page for each Business User
		Page p1 = new Page("Zvaigznes Ventspilī", "Viss par astronomiju Ventspilī");
		bu1.addPage(p1);
		Page p2 = new Page("Zvaigznes Pārventā", "Viss par un ap Pārventas zvaigznēm");
		bu1.addPage(p2);
		
		//7. create at least one post in each page
		bu1.createPostInPage(p1, new Post( "Ventspils pludmalē manīts asteorīds"));
		bu1.createPostInPage(p2, new Post("Pārventā nekas jauns"));
		
		for(Post temp: bu1.getAllPages().get(0).getPostsInPage()) {
			System.out.println(temp);
		}
		
		//8. verify login func.
		BussinessUser bu3 = new BussinessUser("SIA", "VeA", "sia.vea", "123");
		System.out.println(pu2.login()); //t
		System.out.println(bu3.login()); //f
		
		//9. verify followPage func.
		try {
			pu1.followPage(p1);
			pu2.followPage(p1);
			pu2.followPage(p2);
			
			System.out.println(p1);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		//10. verify addFollower func.
		//11. verify removeFollower func.
		//12. verify increaseLikes func.
		
		for(int i  = 0; i < 6; i++) {
			pu1.getAllPrivatePosts().get(0).increaseLikes();
		}
		for(int i  = 0; i < 10; i++) {
			bu1.getAllPages().get(0).getPostsInPage().get(0).increaseLikes();
		}
		
		for(Post temp: pu1.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		
		for(Post temp: pu2.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		
		System.out.println("--------------------------");
		for(Post temp: bu1.getAllPages().get(0).getPostsInPage()) {
			System.out.println(temp);
		}for(int i  = 0; i < 6; i++) {
			pu1.getAllPrivatePosts().get(0).increaseLikes();
		}
		for(int i  = 0; i < 10; i++) {
			bu1.getAllPages().get(0).getPostsInPage().get(0).increaseLikes();
		}
		
		for(Post temp: pu1.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		
		for(Post temp: pu2.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		
		System.out.println("--------------------------");
		for(Post temp: bu1.getAllPages().get(0).getPostsInPage()) {
			System.out.println(temp);
		}
		
		System.out.println("--------------------------");
		System.out.println(pu1.findUserByNameOrSurnameOrUsername("nekarlis"));
		
		System.out.println("--------------------------");
		System.out.println(pu2.findPublicPostInPrivateUserOrInPage("sodien"));
		
		System.out.println("--------------------------");
		System.out.println(pu2.findPageByTitleOrDescription("astronomiju"));
	}

}
