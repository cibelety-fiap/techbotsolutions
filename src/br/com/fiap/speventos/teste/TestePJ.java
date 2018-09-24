package br.com.fiap.speventos.teste;

import br.com.fiap.speventos.beans.PessoaJuridica;
import br.com.fiap.speventos.dao.PessoaJuridicaDAO;
import br.com.fiap.speventos.excecao.Excecao;

public class TestePJ {

	public static void main(String[] args) {

		// PessoaJuridica testePJ = new PessoaJuridica(123, "pedro@pedro.com",
		// "12345678", "Pedro Assumpcao" ,
		// 2225756436L, "Rua Joao Lima",
		// "Empresa X", 209873570001L, 25);

		// Usuario testePJ2 = new PessoaJuridica(123, "pedro@pedro.com", "12345678",
		// "Pedro Assumpcao" ,
		// 2225756436L, "Rua Joao Lima",
		// "Empresa X", 209873570001L, 25);

		// System.out.println(testePJ.getCnpj());
		// System.out.println(testePJ.getCnpjDigito());
		// System.out.println(testePJ.getCodigoUsuario());
		// System.out.println(testePJ.getEmail());
		// System.out.println(testePJ.getEndereco());
		// System.out.println(testePJ.getNome());
		// System.out.println(testePJ.getRazaoSocial());
		// System.out.println(testePJ.getSenha());
		// System.out.println(testePJ.getTelefone());
		try {
			PessoaJuridicaDAO dao = new PessoaJuridicaDAO();

			int retorno = dao.editar(new PessoaJuridica(123, "pedro@pedro.com", "12345678", "Pedro Assumpcao", 2225756436L,
					"Rua Joao Lima", "Empresa X", 209873570001L, 25));
			System.out.println(retorno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}


		// System.out.println(testePJ2.getCnpj());
		// System.out.println(testePJ2.getCnpjDigito());
		// System.out.println(testePJ2.getCodigoUsuario());
		// System.out.println(testePJ2.getEmail());
		// System.out.println(testePJ2.getEndereco());
		// System.out.println(testePJ2.getNome());
		// System.out.println(testePJ2.getRazaoSocial());
		// System.out.println(testePJ2.getSenha());
		// System.out.println(testePJ2.getTelefone());
	}

}
