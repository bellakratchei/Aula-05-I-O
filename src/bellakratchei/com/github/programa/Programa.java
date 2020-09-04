package bellakratchei.com.github.programa;

import java.io.IOException;

import bellakratchei.com.github.classes.FileIO;
import bellakratchei.com.github.classes.Pessoa;
import bellakratchei.com.github.classes.PessoaRepositorio;

public class Programa {

	public static void main(String[] args) {
		
		
		PessoaRepositorio repositorio = new PessoaRepositorio();
		
		Pessoa p1 = new Pessoa("Isabella","12378956","isa@mail.com");
		Pessoa p2 = new Pessoa("Junior","78945632","junior@mail.com");
		
		repositorio.pessoas.add(p1);
		repositorio.pessoas.add(p2);
		
		try {
			//FileIO.writer(repositorio.pessoas, "pessoas.txt");
			PessoaRepositorio repositorio2 = FileIO.reader("pessoas.txt");
			
			Pessoa r = (Pessoa) repositorio2.pessoas.get(2);
			System.out.println(r.getEmail());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
