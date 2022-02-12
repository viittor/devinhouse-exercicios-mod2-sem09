package br.com.viittor.cloudgames.service;

import br.com.viittor.cloudgames.model.Genero;
import br.com.viittor.cloudgames.model.Jogo;
import br.com.viittor.cloudgames.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;
    private boolean system = true;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public void iniciar(Scanner scanner) {
        System.out.println("Escolha o que deseja fazer:\n"
                + "0 - Voltar\n"
                + "1 - Salvar\n"
                + "2 - Atualizar\n"
                + "3 - Visualizar\n"
                + "4 - Excluir");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 0:
                break;
            case 1:
                salvar(scanner);
                break;
            case 2:
                atualizar(scanner);
                break;
            case 3:
                visualizar(scanner);
                break;
            case 4:
                excluir(scanner);
                break;
            default:
                break;
        }

    }

    public void salvar(Scanner scanner) {
        System.out.println("Informe o nome");
        String nome = scanner.next();

        System.out.println("Informe a Data de Lançamento");
        String dataLancamento = scanner.next();

        System.out.println("Informe a capa");
        String capa = scanner.next();

        System.out.println("Informe o genero");
        String genero = scanner.next();

//        System.out.println("Informe as plataformas");
//        String plataforma = scanner.next();

        Jogo jogo = new Jogo();
        jogo.setNome(nome);
        jogo.setDataLancamento(dataLancamento);
        jogo.setCapa(capa);
        jogo.setGenero(Genero.valueOf(genero));
        //jogo.setPlataformas(plataforma);
        jogoRepository.save(jogo);

    }

    public void atualizar(Scanner scanner) {
        //Pega o id
        System.out.println("Digite o ID que deseja atualizar:");
        //Lê a informção passada e joga em um Optional.
        Optional<Jogo> jogoOptional = jogoRepository.findById(scanner.nextLong());
        //Valida se o campo não está vazio
        if (jogoOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }
        System.out.println("Digite o nome que deseja alterar:");
        String descricao = scanner.nextLine();
        //Procura onde realizar a atualização
        Jogo jogo = jogoOptional.get();
        //Altera a descrição
        jogo.setNome(descricao);
        //Salva a Atualização
        jogoRepository.save(jogo);
        System.out.println("Jogo Atualizado!");
    }

    public void visualizar(Scanner scanner) {
        Iterable<Jogo> jogos = jogoRepository.findAll();
        jogos.forEach(System.out::println);

    }

    public void excluir(Scanner scanner) {
        System.out.println("Digite o ID do jogo que deseja deletar:");
        Long id = scanner.nextLong();
        jogoRepository.deleteById(id);
    }

}
