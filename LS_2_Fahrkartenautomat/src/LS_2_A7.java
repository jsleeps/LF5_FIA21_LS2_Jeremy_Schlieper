
public class LS_2_A7 {

	public static void main(String[] args) {
		
		//Aufgabe 1: Index
		int[] zahlen = new int[]{1, 6, 3, 7, 2};
		int i = 4;
		
		//a)
		System.out.println(zahlen[1]);
			//6
		//b)
		//System.out.println(zahlen[5]);
			//Outbound Error
		//c)
		System.out.println(zahlen[3]);
			//7
		//d)
		
		System.out.println(zahlen[i]);
			//2
		//e)
		System.out.println(zahlen[i-2]);
			//3
		//f)
		System.out.println(zahlen[zahlen[4]]);
			//3
		
		//Aufgabe 2:
		
		 int[] zahlen2 = {1, 6, 3, 7, 2, 2, 4, 8};


		 //a)

		 for (int i2=2; i2<=3; i2++) {

		      System.out.print(zahlen2[i2] + ", ");
		      //3, 7,
		 }


		// b)

//		 for (int i3=0;  i3<=zahlen2.length;  i3++) {
//
//		       System.out.print (zahlen2[i3] + ", ");
//		       //bis 8
//		 }


		 //c)

		 for (int i4=1; i4<=zahlen2.length-1; i4=i4+2) {

		       System.out.print(zahlen2[i4] + ", ");
		       //6, 7, 2, 8,
		 }
	}
	
}
