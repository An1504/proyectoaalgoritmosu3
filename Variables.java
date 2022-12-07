package Buzon;


public class Variables {
	String matricula;
	String grupo;
	String ingenierias;
	String comentario;
DataBuzon db=null;
public Variables(){
	db=new DataBuzon();
}
public String getMatricula() {
	return matricula;
}
public void setMatricula(String matricula) {
	this.matricula = matricula;
}
public String getGrupo() {
	return grupo;
}
public void setGrupo(String grupo) {
	this.grupo = grupo;
}
public String getIngenierias() {
	return ingenierias;
}
public void setIngenierias(String ingenierias) {
	this.ingenierias = ingenierias;
}
public String getComentario() {
	return comentario;
}
public void setComentario(String comentario) {
	this.comentario = comentario;
}
public boolean insertarqueja(){
	return(db.insertar(this))?true:false;
		
	}
}

