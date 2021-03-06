import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Help {

    public Help(){

        JFrame frame = new JFrame();
		frame.setBounds(0, 0, 1050, 750);
	

		JLabel label=new JLabel("<html>This page provides assistance with the most common questions about ELECTION COMMISSION.<br>FAQ'S<br><br><br>      Q1. What are the main categories of electors in India?<br>Ans.- There are 3 categories of electors in India: –(i) General electors,(ii) Oversees (NRI) electors - ,(iii) Service Electors -.<br><br><br><br>      Q2. Who is eligible to be registered as a general elector?<br>Ans. Every Indian citizen who has attained the age of 18 years on the qualifying date i.e.first day of January of the year of revision of electoral roll, unless otherwise disqualified,is eligible to be registered as a voter in the roll of the part/polling area of the constituency where he is ordinarily resident.<br><br><br>      Q3. What is the relevant date for determining the age of 18 years? Can I get myself registered as a voter on the day when I have completed 18 years of age?<br>Ans.- According to Section 14 (b) of the Representation of People Act, 1950 the relevant date (qualifying date) for determining the age of an applicant is the first day of January of the year in which the electoral roll after revision is finally published. For example, if you have completed or are completing 18 years of age on any date from and after 2nd January 2013 but upto to 1st January 2014, you will be eligible for registration as a voter in the elector roll going to be finally published in January, 2014.<br><br><br>      Q4. Can a non-citizen of India become a voter in the electoral rolls in India?<br>Ans.- No. A person who is not a citizen of India is not eligible for registration as a voter in the electoral rolls in India. Even those who have ceased to be citizens of India on acquiring the citizenship of another country are not eligible to be enrolled in the electoral rolls in India.<br><br><br>      Q.5 If I have a complaint against the order of Electoral Registration Officer, to whom I should make an appeal? <br>Ans. During the period of revision, you can file an appeal to the District Election Officer.In the case of application during the process of continuous updation, such appeal against any order of Electoral Registration Officer will lie before the District Magistrate/ Additional DM / Executive Magistrate / District Collector of the District concerned. A further appeal against the order of Appellate Authority will lie before the Chief Electoral Officer of the State.<br>Also<br>in case of any discrepancy,<br>feel free to contact<br>Election Commissioner<br><br>BHAVITA LALWANI<br>+91-9033641982<br><br><br>RIDDHI SONI<br>+91-9408344793<br><br></html>");




frame.add(label);
frame.setVisible(true);


}

public static void main(String [] args) {
        Help tester = new Help();
    }
}
