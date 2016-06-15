package edu.ifg.formosa.bd;

import edu.ifg.formosa.model.Usuario;

public class Main {
	
	public static void main(String[]args){
	
		try{
		Usuario usuario = new Usuario();
	
		usuario.getEndereco().getCidade().getEstado().setNomeEstado("Goias");
		usuario.getEndereco().getCidade().setNome("Formosa");
		usuario.getEndereco().setBairro("Rosa Maria");
		usuario.getEndereco().setNumero("19");
		usuario.getEndereco().setComplemento("Avenida Circular");
		usuario.getEndereco().setRua("Rua D");
		usuario.setCpf("05210945189");
		usuario.setEmail("ricardolaiane8@gmail.com");
		usuario.setLogin("Laiane");
		usuario.setSenha("12345");
		usuario.setRg("5987267");
		usuario.setNome("Laiane Ricardo de Araujo");
		usuario.setTelefone("(61)9666-3374");
		
	
		UsuarioDAO.cadastrarUsuario(usuario);
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}
		
	}

}
