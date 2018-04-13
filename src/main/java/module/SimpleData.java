package module;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SimpleData {
	
    public static final ObservableList<EmailMessageBean> Inbox = FXCollections.observableArrayList(
    		new EmailMessageBean("Hello from Sefu!!!","aaa@yahoo.com", 5500000, Calendar.getInstance().getTime().toString(),"<html>Hello from Sefu!!!<h3>lorem ipsum + <br> </h3></html>", false),
    		new EmailMessageBean("Hello from Barosanu","bbb@yahoo.com", 200, Calendar.getInstance().getTime().toString(),"<html>Hello from Barosanu<h3>lorem ipsum + <br> </h3></html>", false),
    		new EmailMessageBean("Hello from Sefu!!!asdas","ccc@yahoo.com", 10, Calendar.getInstance().getTime().toString(),"<html>Hello from Sefu!!!asdas<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hello from Barosanuasdasas","ddd@yahoo.com", 6300, Calendar.getInstance().getTime().toString(),"<html>Hello from Barosanuasdasas<h3>lorem ipsum + <br> </h3></html>", true)    		
    		);
    public static final ObservableList<EmailMessageBean> Sent = FXCollections.observableArrayList(
    		new EmailMessageBean("Hi! long time, no see","example@yahoo.com", 22, Calendar.getInstance().getTime().toString(),"<html>Hi! long time, no see<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hi! Check this!!","example@yahoo.com", 200, Calendar.getInstance().getTime().toString(),"<html>You are the best<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Where are my money???","example@yahoo.com",  10, Calendar.getInstance().getTime().toString(),"<html>You ask me???<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Escape plans","example@yahoo.com",6300, Calendar.getInstance().getTime().toString(),"<html>Basement and then tun to the left<h3>lorem ipsum + <br> </h3></html>", true)    		
    		);
    public static final ObservableList<EmailMessageBean> Spam = FXCollections.observableArrayList(
    		new EmailMessageBean("You won't belive this: click and see!!!","serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", false),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", false),   
    		new EmailMessageBean("You won't belive this: click and see!!!","serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true),     
    		new EmailMessageBean("You won't belive this: click and see!!!", "serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true)   
    		);
    public static final ObservableList<EmailMessageBean> trash = FXCollections.observableArrayList(
    		new EmailMessageBean("Hello from Sefu!!!","aaa@yahoo.com", 5500000, Calendar.getInstance().getTime().toString(),"<html>Hello from Sefu!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hello from Barosanu","bbb@yahoo.com", 200, Calendar.getInstance().getTime().toString(),"<html>Hello from Barosanu<h3>lorem ipsum + <br> </h3></html>",false),
    		new EmailMessageBean("Hello from Sefu!!!asdas","ccc@yahoo.com", 10, Calendar.getInstance().getTime().toString(),"<html>Hello from Sefu!!!asdas<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hello from Barosanuasdasas","ddd@yahoo.com", 6300, Calendar.getInstance().getTime().toString(),"<html>Hello from Barosanuasdasas<h3>lorem ipsum + <br> </h3></html>", true)    		
    		);
    public static final ObservableList<EmailMessageBean> starred = FXCollections.observableArrayList(
    		new EmailMessageBean("Hi! long time, no see","example@yahoo.com", 22, Calendar.getInstance().getTime().toString(),"<html>Hi! long time, no see<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hi! Check this!!","example@yahoo.com", 200, Calendar.getInstance().getTime().toString(),"<html>You are the best<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Where are my money???","example@yahoo.com",  10, Calendar.getInstance().getTime().toString(),"<html>You ask me???<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Escape plans","example@yahoo.com",6300, Calendar.getInstance().getTime().toString(),"<html>Basement and then tun to the left<h3>lorem ipsum + <br> </h3></html>", false)    		
    		);
    public static final ObservableList<EmailMessageBean> important = FXCollections.observableArrayList(
    		new EmailMessageBean("You won't belive this: click and see!!!","serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true),   
    		new EmailMessageBean("You won't belive this: click and see!!!","serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>",false),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true),     
    		new EmailMessageBean("You won't belive this: click and see!!!", "serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true)   
    		);
    public static final ObservableList<EmailMessageBean> drafts = FXCollections.observableArrayList(
    		new EmailMessageBean("Hello from Sefu!!!","aaa@yahoo.com", 5500000, Calendar.getInstance().getTime().toString(),"<html>Hello from Sefu!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hello from Barosanu","bbb@yahoo.com", 200, Calendar.getInstance().getTime().toString(),"<html>Hello from Barosanu<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hello from Sefu!!!asdas","ccc@yahoo.com", 10, Calendar.getInstance().getTime().toString(),"<html>Hello from Sefu!!!asdas<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Hello from Barosanuasdasas","ddd@yahoo.com", 6300, Calendar.getInstance().getTime().toString(),"<html>Hello from Barosanuasdasas<h3>lorem ipsum + <br> </h3></html>", true)    		
    		);
    public static final ObservableList<EmailMessageBean> allmail = FXCollections.observableArrayList(
    		new EmailMessageBean("You won't belive this: click and see!!!","serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true),   
    		new EmailMessageBean("You won't belive this: click and see!!!","serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>",false),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true),     
    		new EmailMessageBean("You won't belive this: click and see!!!", "serious@company.com", 22000000, Calendar.getInstance().getTime().toString(),"<html>You are smart<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("Like and share if you care!!","book@face.com", 200, Calendar.getInstance().getTime().toString(),"<html>Your likes make a huge difference!!!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You just won 2 cents! Click to claim!","ss@bail.com", 10, Calendar.getInstance().getTime().toString(),"<html>Give us first 3 cents!<h3>lorem ipsum + <br> </h3></html>", true),
    		new EmailMessageBean("You got a virus!","safe@brousing.com",6300, Calendar.getInstance().getTime().toString(),"<html>Formatting computer.....<h3>lorem ipsum + <br> </h3></html>", true)   
    		);

}
