package br.com.viittor.cloudgames.service;

import br.com.viittor.cloudgames.model.Usuario;
import br.com.viittor.cloudgames.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private boolean system = true;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void iniciar(Scanner scanner) {
        System.out.println("Escolha o que deseja fazer:\n"
                + "0 - Voltar\n"
                + "1 - Salvar\n"
                + "2 - Atualizar\n"
                + "3 - Visualizar\n"
                + "4 - Excluir\n"
                + "5 - Buscar por nome\n"
                + "6 - Buscar por email");

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
            case 5:
                buscarPorNome(scanner);
                break;
            case 6:
                buscarPorEmail(scanner);
                break;
            default:
                break;
        }

    }

    public void salvar(Scanner scanner) {
        System.out.println("Informe o nome");
        String nome = scanner.next();

        System.out.println("Informe o login");
        String login = scanner.next();

        System.out.println("Informe a senha");
        String password = scanner.next();

        System.out.println("Informe o email");
        String email = scanner.next();

        System.out.println("Informe a Data de Nascimento");
        String dataDeNascimento = scanner.next();

        System.out.println("Informe o CPF");
        String cpf = scanner.next();

        System.out.println("Informe o RG");
        String rg = scanner.next();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setDataDeNascimento(dataDeNascimento);
        usuario.setCpf(cpf);
        usuario.setRg(rg);
        usuarioRepository.save(usuario);
    }

    public void atualizar(Scanner scanner) {
        //Pega o id
        System.out.println("Digite o ID que deseja atualizar:");
        //Lê a informção passada e joga em um Optional.
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(scanner.nextLong());
        //Valida se o campo não está vazio
        if (usuarioOptional.isEmpty()) {
            System.out.println("O id informado é inválido");
            return;
        }
        System.out.println("Digite o nome que deseja alterar:");
        String descricao = scanner.nextLine();
        //Procura onde realizar a atualização
        Usuario usuario = usuarioOptional.get();
        //Altera a descrição
        usuario.setNome(descricao);
        //Salva a Atualização
        usuarioRepository.save(usuario);
        System.out.println("Usuario Atualizado!");
    }

    public void visualizar(Scanner scanner) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        usuarios.forEach(System.out::println);

    }

    public void excluir(Scanner scanner) {
        System.out.println("Digite o ID do usuario que deseja deletar:");
        Long id = scanner.nextLong();
        usuarioRepository.deleteById(id);
    }

    public void buscarPorNome(Scanner scanner){
        System.out.println("Informe o nome que deseja buscar");
        String nomeBuscar = scanner.next();
        Optional<Usuario> retornoBusca = usuarioRepository.findByNome(nomeBuscar);

        System.out.println(retornoBusca.get());

    }

    public void buscarPorEmail(Scanner scanner){
        System.out.println("Informe o email que deseja buscar");
        String emailBuscar = scanner.next();
        Optional<Usuario> retornoBusca = usuarioRepository.findByEmail(emailBuscar);

        System.out.println(retornoBusca.get());

    }
}
