import java.util.*;

public class Substring{
	Substring(char[] A, int index, int length){
		String item= new String();
		for(int i=index;i<=index+length-1;i++){
			item=item+A[i];
		}
		System.out.println(item);
	}
	
	static int j=0;
	static int index,length;
	static char[] A;//can be used through its class name.
	
	public static void main(String[] args ) {//actually, i really want to know if there is another method to conbind arg to the Substring's THREE arguments?
		for(String arg:args){
			if(j==0){
				A=arg.toCharArray();
			}else if(j==1){
				index = Integer.parseInt(arg);
			}else if(j==2){
				length = Integer.parseInt(arg);
			}
			j++;
		}
		Substring ex = new Substring(A,index,length);
	}
}