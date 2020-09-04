package bellakratchei.com.github.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO {

	public static void writer(List<Pessoa> pessoas, String nomeArquivo) throws IOException {
		FileWriter filewriter = new FileWriter(nomeArquivo);
		
		try(BufferedWriter writer = new BufferedWriter(filewriter)){
			List<String> dados = pessoas
					.stream() // pega tudo oq tem na lista e transforma em binário
					.map(pessoa -> pessoa.toString()) // aqui funciona como se fosse um foreach
					.collect(Collectors.toList()); // vai coletar toda a informação serializada e transformar em lista

			for(String linha : dados) {
				writer.write(linha);
			}
		}
	}

	public static PessoaRepositorio reader(String nomeArquivo) throws IOException{
		PessoaRepositorio pessoas = new PessoaRepositorio();
		FileReader fileReader = new FileReader(nomeArquivo);
		
		try(BufferedReader reader = new BufferedReader(fileReader)){
			String dado = "";
			while((dado = reader.readLine()) != null) {
				/* System.out.println(dado); */
				String[] linha = dado.split(",");
				Pessoa p = new Pessoa(linha[0],linha[1],linha[2]);
				pessoas.pessoas.add(p);
			}
		}
		
		return pessoas;
	}
}
