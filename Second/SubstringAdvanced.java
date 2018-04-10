public class Substring{
	public static void main(String[] args){
		int index=Integer.parseInt(args[1]);
		int length=Integer.parseInt(args[2]);
		System.out.print(args[0].substring(index,index+length));
	}
}