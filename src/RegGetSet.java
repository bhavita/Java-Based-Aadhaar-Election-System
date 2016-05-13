

public class RegGetSet extends TopClass
{
String email1,add1,pass1;
 long uid1,phno1;
RegGetSet(long p,String e)
{
p=getphno1();
e=getemail1();
}
int fphno1,femail1;
public String getemail1()
{ return email1; }
public String getadd1()
{ return add1; }
public String getpass1()
{ return pass1; }

public String getpass2(String s) throws Exception
{ return AESencrp.decrypt(s); }
public long getuid1()
{ return uid1; }
public long getphno1()
{ return phno1; }

public void setemail1(String e)
{ this.email1=e; }
public void setadd1(String a)
{ this.add1=a; }
public void setpass1(String p)
{ this.pass1=p; }


public String setpass2(String s1) throws Exception
{
return AESencrp.encrypt(s1);
}
public void setuid1(long u)
{ this.uid1=u; }
public void setphno1(long p1)
{ this.phno1=p1; }
long p=this.getphno1();
String s1=new Long(p).toString();
int len=s1.length();

String s=getemail1();
 

 String email1_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//	String s=getemail1();

	
	public  boolean authenticateemail1() {
		String s=getemail1();
System.out.println("in method email"+s);
 Boolean b = s.matches(email1_REGEX);

        if (b==true) {
			femail1=1;
            return true;
        }
	    return false;
		
    }
	
	
	int numdigits(long p1)
		{
		
		System.out.println("mob num is"+p1);
		int len = 0;

		while(p1 >= 1)
		{
		p1 = p1/10;
		len++;
		}

		return len;
		}

		
	public  boolean authenticatephno1(int ph) {
			
        if (ph==10) {
			fphno1=1;
		    return true;
        }
		return false;
    }
	
	public boolean checkPass(String p,String p1)
	{
	
	if(p.equals(p1))
	{
	return true;
	}
	return false;
	}
	public static void main(String []args)
	{
	long p=123; String e1="sd";
	RegGetSet rs=new RegGetSet(p,e1);
	System.out.println("ph no is="+rs.getphno1());
	long p1=rs.getphno1();
	int i=rs.numdigits(p1);
	}
	

}