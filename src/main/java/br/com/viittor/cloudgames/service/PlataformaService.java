package br.com.viittor.cloudgames.service;

import br.com.viittor.cloudgames.model.Plataforma;
import br.com.viittor.cloudgames.repository.PlataformaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class PlataformaService {
    private boolean system = true;
    private PlataformaRepository plataformaRepository;

    public PlataformaService(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    public void iniciar(Scanner scanner) {
        System.out.println("Escolha o que deseja fazer:\n"
                + "0 - Voltar\n"
                + "1 - Salvar\n"
                + "2 - Atualizar\n"
                + "3 - Visualizar\n"
                + "4 - Excluir\n");

        int escolha = scanner.nextInt();

        switch (escolha) {
            case 0:
                break;
            case 1:
                salvar(scanner);
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
        Plataforma plataforma = new Plataforma();
        plataformaRepository.save(plataforma);
    }

    public void atualizar(Scanner scanner) {
        //Pega o id
        System.out.println("Digite o ID que deseja atualizar:");
        //Lê a informção passada e joga em um Optional.
        Optional<Plataforma> plataformaOptional = plataformaRepository.findById(scanner.nextLong());
        //Valida se o campo não está vazio
        if(plataformaOptional.isEmpty()){
            System.out.println("O id informado é inválido");
            return;
        }
        System.out.println("Digite o nome que deseja alterar:");
        String descricao = scanner.nextLine();
        //Procura onde realizar a atualização
        Plataforma plataforma = plataformaOptional.get();
        //Altera a descrição
        plataforma.setNome(descricao);
        //Salva a Atualização
        plataformaRepository.save(plataforma);
        System.out.println("Plataforma Atualizada!");
    }

    public void visualizar(Scanner scanner) {
        Iterable<Plataforma> plataformas = plataformaRepository.findAll();
        plataformas.forEach(System.out::println);

    }

    public void excluir(Scanner scanner) {
        System.out.println("Digite o ID da plataforma que deseja deletar:");
        Long id = scanner.nextLong();
        plataformaRepository.deleteById(id);
    }
}

