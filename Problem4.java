/*Algo Problem 4 - Store Delivery*/
import java.util.Scanner;
import java.util.Arrays;
class Problem4
{
    	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) 
	{
		boolean orderBreaked;
		int testCases=sc.nextInt();
		sc.nextLine();
		while(testCases-->0)
		{
		    orderBreaked=false;
			int[] takeOut=convert(sc.nextLine());
			int[] dineIn=convert(sc.nextLine());
			int[] servedOrders=convert(sc.nextLine());
			int takeNext=0,dineNext=0;
			for(int serving=0;serving<servedOrders.length;serving++)        //Checking if Delivery Sequence is correct or not
			{
				if(takeNext<takeOut.length && servedOrders[serving]==takeOut[takeNext])
				    takeNext++;
				else if(dineNext<dineIn.length && servedOrders[serving]==dineIn[dineNext])
					dineNext++;
				else
				{
					orderBreaked=true;
					break;
				}
			}
			if(orderBreaked || takeNext!=takeOut.length || dineNext!=dineIn.length)     //Displaying final result
				System.out.println("Invalid");
			else
				System.out.println("Valid");
		}
	}

	static int[] convert(String string) {
	    String[] partition = string.replace(",",", ").replace("[", "").replace("]", "").split(", ");
	    int result[] = new int[partition.length],next=0;

	    for (String part : partition) {                         //Conversion into Array
		try { result[next++] = Integer.parseInt(part); } 
		catch (NumberFormatException e) {   e.printStackTrace();    }
	    }
	    return result;
  	}
}
