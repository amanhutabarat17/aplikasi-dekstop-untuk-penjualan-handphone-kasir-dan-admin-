/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectakhir;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
public class koneksi {
public static Connection con;
public static Statement stm;
    
    public static void main(String[] args) {
    config();
    }
    
 public static void config(){
       try{
           String url="jdbc:mysql://localhost/hpvivo";
           String user="root";
           String pass="";
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection(url,user,pass);
           stm=con.createStatement();
           System.out.println("Koneksi Berhasil");
       }catch(Exception e){
           System.out.println("Koneksi Gagal"+e.getMessage());
           
       }
   }
}
