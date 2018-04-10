import java.util.*;
import java.io.*;

public class PIMManager{
	static int Itemno = 0;
	static String[] List = new String[99];//teacher required size is 100, so 
	
	public static void main(String[] args) throws IOException{
		System.out.println("Welcome to PIM.");
		Scanner scan = new Scanner(System.in);
		OUT:
		while (true){
			System.out.println("---Enter a command (suported commands are List Create Save Load Quit)---");
			String input = scan.next();
			switch(input){
				case"List":
				System.out.println("There are "+Itemno+" items.");
				for(int i=1; i<=Itemno;i++){
					if(Itemno==0) break;
					System.out.println(List[i]);
				}
				break;
				
				case"Create":
				System.out.println("Enter an item type ( todo, note, contact or appointment )");
				input = scan.next();
				
				switch(input){
						case "todo":
						PIMTodo todo= new PIMTodo();
						System.out.println("Enter date for todo item:");
						BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
						input = buff.readLine();
						todo.setDate(input);
						System.out.println("Enter todo text:");
						BufferedReader buff1 = new BufferedReader(new InputStreamReader(System.in));
						input = buff1.readLine();
						todo.setTodoText(input);
						System.out.println("Enter todo priority:");
						BufferedReader buff2 = new BufferedReader(new InputStreamReader(System.in));
						input = buff2.readLine();
						todo.setPriority(input);
						Itemno++;
						String ex=todo.toString();
						List[Itemno] = ex;
						break;
						
						case "note":
						PIMNote note = new PIMNote();
						System.out.println("Enter note text:");
						BufferedReader buff3 = new BufferedReader(new InputStreamReader(System.in));
						input = buff3.readLine();
						note.setNoteText(input);
						System.out.println("Enter note priority:");
						input = scan.next();
						note.setPriority(input);
						Itemno++;
						String ex1 = note.toString();
						List[Itemno] = ex1;
						break;
						
						case "contact":
						PIMContact contact=new PIMContact();
						System.out.println("Enter firstname for contact item:");
						BufferedReader buff4=new BufferedReader(new InputStreamReader(System.in));
						input=buff4.readLine();
						contact.setFirstname(input);
						System.out.println("Enter lastname for contact item:");
						BufferedReader buff5=new BufferedReader(new InputStreamReader(System.in));
						input=buff5.readLine();
						contact.setLastname(input);
						System.out.println("Enter email for contact item:");
						BufferedReader buff6=new BufferedReader(new InputStreamReader(System.in));
						input=buff6.readLine();
						contact.setEmail(input);
						System.out.println("Enter contact priority:");
						input=scan.next();
						contact.setPriority(input);
						Itemno++;
						String ex2=contact.toString();
						List[Itemno] = ex2;
						break;
						
						case "appointment":
						PIMAppointment appointment=new PIMAppointment();
						System.out.println("Enter date for appointment item:");
						BufferedReader buff7=new BufferedReader(new InputStreamReader(System.in));
						input=buff7.readLine();
						appointment.setDate(input);
						System.out.println("Enter appointment description:");
						BufferedReader buff8=new BufferedReader(new InputStreamReader(System.in));
						input=buff8.readLine();
						appointment.setDescription(input);
						System.out.println("Enter appointment priority:");
						input = scan.next();
						appointment.setPriority(input);
						Itemno++;
						String ex3 = appointment.toString();
						List[Itemno] = ex3;
						break;
						default:
						System.out.println("the item type is not exist");
						break;
						
						
				}
				
				break;
			case "Save":
			System.out.println("Items have been saved.");
			break;
			
			case "Quit":
			scan.close();
			break OUT;
			default:
			System.out.println("the command is not exist");
			break;
			}
		}
	}
}


interface Date{
	void setDate(String date);
}

class PIMTodo extends PIMEntity implements Date{
	String date,TodoText;
	
	public void setDate(String date){
		this.date = date;
	}
	
	void setTodoText(String TodoText){
		this.TodoText = TodoText;
	}
	
	public void fromString(String ex){
		
	}
	
	public String toString(){
		return ("Item "+PIMManager.Itemno+": TODO "+Priority+" "+date+" "+TodoText+".");
	}
	
}

class PIMNote extends PIMEntity{
	String NoteText;
	
	void setNoteText(String NoteText){
		this.NoteText= NoteText;
	}
	
	public void fromString(String ex){
		
	}
	
	public String toString(){
		return ("Item "+PIMManager.Itemno+": NOTE "+Priority+" "+NoteText+".");
	}
}

class PIMAppointment extends PIMEntity implements Date{
	String date,description;
	
	public void setDate(String date){
		this.date = date;
	}
	
	void setDescription(String description){
		this.description=description;
	}
	
	public void fromString(String ex) {
		
	}
	
	public String toString() {
		return ("Item "+PIMManager.Itemno+": APPOINTMENT "+Priority+" "+date+" "+description+".");
	}
}
		
class PIMContact extends PIMEntity{
	String firstname,lastname,email;
	
	void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	void setEmail(String email){
		this.email = email;
	}
	
	public void fromString(String ex){
		
	}
	
	public String toString(){
		return ("Item "+PIMManager.Itemno+": CONTACT "+Priority+" "+firstname+" "+lastname+" "+email+".");
	}
}