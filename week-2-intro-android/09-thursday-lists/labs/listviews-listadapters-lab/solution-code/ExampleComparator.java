import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExampleComparator {
	
	public static void main(String[] args){
		ArrayList<ExampleClass> exampleList = setupList();
		
		//x comes before y when comparing x strA variables
		Collections.sort(exampleList, new ComparatorA());
		System.out.println("SORTED WITH COMPARATOR A");
		System.out.println(exampleList.get(0));
		System.out.println(exampleList.get(1));
		
		//y comes before x when comparing x strB variables
		Collections.sort(exampleList, new ComparatorB());
		System.out.println("SORTED WITH COMPARATOR B");
		System.out.println(exampleList.get(0));
		System.out.println(exampleList.get(1));
		
		/*
		 System output:
		 
			SORTED WITH COMPARATOR A
			a: apple
			b: bat
			
			a: bear
			b: ant
			
			SORTED WITH COMPARATOR B
			a: bear
			b: ant
			
			a: apple
			b: bat
		 
		 */
		
	}
	
	private static ArrayList<ExampleClass> setupList(){
		ExampleClass x = new ExampleClass("apple", "bat");
		ExampleClass y = new ExampleClass("bear", "ant");
		ArrayList<ExampleClass> list = new ArrayList<ExampleClass>();
		
		list.add(x);
		list.add(y);
		
		return list;
	}
}

//Compare strA properties
class ComparatorA implements Comparator<ExampleClass>{
	public int compare(ExampleClass ex1, ExampleClass ex2){
		return ex1.getStrA().compareTo(ex2.getStrA());
	}
}
	
//Compare strB properties
class ComparatorB implements Comparator<ExampleClass>{
	public int compare(ExampleClass ex1, ExampleClass ex2){
		return ex1.getStrB().compareTo(ex2.getStrB());
	}
}

class ExampleClass{
	private String strA;
	private String strB;
	
	public ExampleClass(String a, String b){
		strA = a;
		strB = b;
	}
	
	public String getStrA(){
		return strA;
	}
	
	public String getStrB(){
		return strB;
	}
	
	public String toString(){
		return "a: "+strA+"\nb: "+strB+"\n";
	}
}
