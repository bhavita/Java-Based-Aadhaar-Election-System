//logic to new Registration
//public class InsertOTP


Otp=OTPAadhar.generatePIN();

vid=getString

try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver"); 

					
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");

					
					if(!con.isClosed()){ System.out.println("Connection Successful"); 
					
					
					
					PreparedStatement ps = con.prepareStatement("insert into OTPVoter (vid,Otp) values (?, ?)");
					ps.setInt(1,vid);
					ps.setString(2,Otp);
					int i=ps.executeUpdate();  
					
					
					
					
					}
					else{ System.out.println("Connection is Closed"); }
					
					 
					
					}