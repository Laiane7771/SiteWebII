package edu.ifg.formosa.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifg.formosa.bd.EnderecoDAO;
import edu.ifg.formosa.model.Estado;


@WebServlet("/ListarEstado")
public class ListarEstadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarEstadoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter exibe = response.getWriter();
		ArrayList<Estado> listaEstado = EnderecoDAO.buscaEstado();
		if(listaEstado!=null){
			Iterator<Estado> it = listaEstado.iterator();
			while(it.hasNext()){
				Estado e = it.next();
				exibe.println("<option value="+e.getIdEstado()+">"+e.getNomeEstado()+"</option>");
			}
		}
		else{
			exibe.printf("<option>Nenhum Estado Selecionado</option>");
		}
	}

}
