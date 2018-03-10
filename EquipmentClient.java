import java.io.*;
import java.util.*;
public class EquipmentClient {
	static int count = 0;
	Equipment [] equip;
public static void main(String [] args)
{
	try{
		File file = new File("inventory.txt");
		Scanner scan = new Scanner(file);
		String [] tok;
		String line;
		Equipment [] e;
		while(scan.hasNextLine())
		{
			line = scan.nextLine();
			count++;
		}
		System.out.println("File read"+" "+count+" "+"times");
		scan.close();
		scan = new Scanner(file);
		e = new Equipment[count];
		count = 0;
		while(scan.hasNextLine())
		{
			line = scan.nextLine();
			//System.out.println(line);
			tok = line.split(",");
			String desc = tok[0];
			String shelf = tok[1];
			String loc = tok[2];
			e[count++] = new Equipment(desc,shelf,loc);
		}
		scan.close();
		for(int i = 0; i < e.length; i++)
		{
			System.out.println(e[i].toString());
		}
		Equipment [] sorted = sortItem(e, count);
		System.out.println("Welcome to the Morton College Chemistry Database!");
		System.out.println("=============================================");
		System.out.println("Type in an keyword");
		Scanner scan1 = new Scanner(System.in);
		String item = scan1.nextLine();
		searchItem(sorted, item);
		
	}
	catch(IOException ioe)
	{
		System.out.println("File cannot be read!");
	}
}

public static Equipment [] sortItem(Equipment [] myArray, int arraySize)
{
	int insertPt;
	int maxIndex;
	for(int i=arraySize-1;i>=1;--i)
	{
		insertPt=i;
		maxIndex=0;
		for(int j=1;j<=i;++j)
		{
			if(myArray[maxIndex].getDesc().compareTo(myArray[j].getDesc())<0)
			{
				maxIndex=j;
			}
		}
		Equipment temp = myArray[insertPt];
		myArray[insertPt] = myArray[maxIndex];
		myArray[maxIndex] = temp;
	}
	return myArray;
}

public static void searchItem(Equipment [] myArray, String tag)
{
	if(count==0)
	{
		System.out.println("The library database is empty");
		return;
	}
	int first = 0;
	int end = count;
	int mid = (first+end)/2;
	while(first < end)
	{
		if(myArray[mid].getDesc().compareToIgnoreCase(tag)==0)
		{
			System.out.println("Found these items");
			System.out.println(myArray[mid].toString());
			return;
		}
		else if(myArray[mid].getDesc().compareToIgnoreCase(tag)<0)
		{
			first=mid+1;
			mid=(first+end)/2;
		}
		else if(myArray[mid].getDesc().compareToIgnoreCase(tag)>0)
		{
			end=mid-1;
			mid=(first+end)/2;
		}
	}
	System.out.println("No match found");
}

}
