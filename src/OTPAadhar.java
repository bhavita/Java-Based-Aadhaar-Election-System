public class OTPAadhar{



public static void main(String args[]){
OTPAadhar o=new OTPAadhar();
System.out.println(o.generatePIN());

}




 public static String generatePIN() 
   {

        //generate a 4 digit integer 1000 <10000
        int randomPIN = (int)(Math.random()*9000)+1000;

        //Bhavita Logic: Store integer in a string
         return String.valueOf(randomPIN);

    }
	
}