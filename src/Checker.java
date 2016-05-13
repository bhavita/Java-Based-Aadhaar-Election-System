import java.sql.*;

public class Checker {


    public static void main(String[] args) throws Exception {

        String password ="BhavitaSolved";
        String passwordEnc = AESencrp.encrypt(password);
        String passwordDec = AESencrp.decrypt(passwordEnc);
		
					try
					{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
					if(!con.isClosed()){ System.out.println("Connection Successful"); }
					else{ System.out.println("Connection is Closed"); }
					
					PreparedStatement ps = con.prepareStatement("insert into t1 (t) values (?)");
					ps.setString(1,passwordEnc);
					

					int i=ps.executeUpdate();  
					System.out.println(i+" records affected");  
					
					String sql ="select * from t1";

        //creating PreparedStatement object to execute query
					PreparedStatement preStatement = con.prepareStatement(sql);
				
					ResultSet result = preStatement.executeQuery();
				  
						while(result.next()){
							System.out.println("Current Date from Oracle : " +         result.getString("t"));
						}
			
					}

					
					catch(Exception e2) { e2.printStackTrace(); }
		


/*        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);*/
    }
}