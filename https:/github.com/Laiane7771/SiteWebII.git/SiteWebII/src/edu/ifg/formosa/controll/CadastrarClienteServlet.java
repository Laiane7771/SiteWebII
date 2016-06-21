package edu.ifg.formosa.controll;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ifg.formosa.bd.UsuarioDAO;
import edu.ifg.formosa.model.Cidade;
import edu.ifg.formosa.model.Endereco;
import edu.ifg.formosa.model.Estado;
import edu.ifg.formosa.model.Usuario;


@WebServlet("/CadastrarCliente")
public class CadastrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CadastrarClienteServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Estado estado = new Estado();
		Cidade cidade = new Cidade();
		int est = Integer.parseInt(request.getParameter("uf"));
		
		estado.setIdEstado(est);
		cidade.setEstado(estado);
		cidade.setNome(request.getParameter("cidade"));
		Endereco endereco = new Endereco();
		endereco.setCidade(cidade);
		endereco.setBairro(request.getParameter("bairro"));
		endereco.setCep(request.getParameter("cep"));
		endereco.setComplemento(request.getParameter("complemento"));
		endereco.setNumero(request.getParameter("numero"));
		endereco.setRua(request.getParameter("rua"));
	
		Usuario usuario = new Usuario();
		usuario.setEndereco(endereco);
		usuario.setNome(request.getParameter("nome"));
		usuario.setRg(request.getParameter("rg"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setLogin(request.getParameter("usuario"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefone(request.getParameter("telefone"));
		
		
		boolean r = UsuarioDAO.cadastrarUsuario(usuario);
		String resposta = "";
		if(r){
			resposta = "Cadastro Realizado com sucesso!";
		}else{
			resposta = "O Cadastro não pode ser concluído";
		}
		
		response.getWriter().write(resposta);
		
		request.getSession().setAttribute("mensagem", resposta);
		
		response.sendRedirect("index.jsp");

	}
}
