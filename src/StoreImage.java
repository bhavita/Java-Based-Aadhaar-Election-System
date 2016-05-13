import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.awt.*;
import java.awt.image.*;

public class StoreImage extends javax.swing.JFrame {
Connection connection=null;
PreparedStatement ps=null;
ResultSet rs=null;
String filePath=null;

public StoreImage() {

initComponents();
//initConnection();
setSize(600,500);
}


private Image scaledImage(Image img,int w,int h)
{
BufferedImage resizeImage=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
Graphics2D g2=resizeImage.createGraphics();
g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
g2.drawImage(img,0,0,w,h,null);
g2.dispose();

return resizeImage;






}

public ImageIcon storeImage()
{

JFileChooser chooser=new JFileChooser(new File("E:\\"));
  
chooser.setMultiSelectionEnabled(false);
chooser.setVisible(true);

chooser.showOpenDialog(this);

File file=chooser.getSelectedFile();
if(file!=null){filePath=file.getPath();}
if(filePath!=null){
jLabel5.setText("File:"+" "+filePath);
java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(filePath); 
ImageIcon ic=new ImageIcon(scaledImage(image,256,256));
return ic;
}
return null;
}


private void initComponents() {

jLabel1 = new javax.swing.JLabel();
jLabel3 = new javax.swing.JLabel();
jButton1 = new javax.swing.JButton();
jButton3 = new javax.swing.JButton();
jTextField1 = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
jScrollPane1 = new javax.swing.JScrollPane();


setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
getContentPane().setLayout(null);

jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
jLabel1.setText("Store/Retive Image From MySQL");
getContentPane().add(jLabel1);
jLabel1.setBounds(90, 30, 220, 14);


jLabel3.setText("Select an Image :");
getContentPane().add(jLabel3);
jLabel3.setBounds(40, 130, 100, 14);

jButton1.setText("Browse");
jButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});
getContentPane().add(jButton1);
jButton1.setBounds(150, 123, 100, 30);

jLabel5.setForeground(new java.awt.Color(255, 0, 0));
getContentPane().add(jLabel5);
jLabel5.setBounds(40, 170, 240, 30);
jLabel5.setBounds(140, 200, 256, 256);


pack();
  }  

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
  ImageIcon ic=storeImage(); 
	JLabel jLabel6 = new javax.swing.JLabel(ic);
  getContentPane().add(jLabel6);
} 

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { 
//retriveImage(); 
}
// Variables declaration - do not modify 
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton3;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel5;

private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextField jTextField1;
// End of variables declaration 

private boolean check() {
if(filePath!=null) 
{
if(filePath.endsWith(".jpeg")||filePath.endsWith(".gif")||filePath.endsWith(".jpg")||filePath.endsWith(".JPEG")||filePath.endsWith(".GIF")||filePath.endsWith(".JPG"))
{
return true;
}
return false;
}
return false;
}
 

public static void main(String args[]) {
   new StoreImage().setVisible(true);
}



}