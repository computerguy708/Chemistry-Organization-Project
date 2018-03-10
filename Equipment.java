
public class Equipment {
String desc;
String shelf;
String loc;
public Equipment()
{
	desc = "Any description";
	shelf = "Any shelf";
	loc = "Any location";
}
public Equipment(String d, String s, String l)
{
	desc = d;
	shelf = s;
	loc = l;
}
public String getDesc()
{
	return desc;
}

public String getShelf()
{
	return shelf;
}
public String getLoc()
{
	return loc;
}
public void setDesc(String de)
{
	desc = de;
}
public void setShelf(String sh)
{
	shelf = sh;
}
public void setLoc(String lo)
{
	loc = lo;
}
public String toString()
{
	return "Description:"+" "+desc+" "+"Shelf:"+" "+shelf+" "+"Location:"+" "+loc;
}
}
