package Buzon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;


public class DataBuzon {
private static final String controlador="com.mysql.cj.jdbc.Driver";
private static final String url="jdbc:mysql://localhost:3306/buzon";
private static final String usuario="root";
private static final String contra="1234";
static{
	try{
		Class.forName(controlador);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
}
public Connection conectar(){
	Connection cx=null;
	try{
		cx=DriverManager.getConnection(url,usuario,contra);
	}catch(SQLException e){
		e.printStackTrace();
	}
	return cx;
}
public static void main(String[] args){
	DataBuzon db=new DataBuzon();
	db.conectar();
}
public boolean insertar( Variables v){
	boolean sa=false;
	PreparedStatement ps= null;
	try{
		ps=conectar().prepareStatement("INSERT INTO datos VALUES (?,?,?,?)");
		ps.setString(1, v.getMatricula());
		ps.setString(2, v.getGrupo());
		ps.setString(3, v.getIngenierias());
		ps.setString(4, v.getComentario());
		int s=ps.executeUpdate();
		if(s>0){
			sa=true;
		}
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
	}
	
	return sa;
} 
}
