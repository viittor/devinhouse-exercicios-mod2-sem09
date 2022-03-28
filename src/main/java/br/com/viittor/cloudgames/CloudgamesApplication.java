package br.com.viittor.cloudgames;

import br.com.viittor.cloudgames.repository.PlataformaRepository;
import br.com.viittor.cloudgames.service.JogoService;
import br.com.viittor.cloudgames.service.PlataformaService;
import br.com.viittor.cloudgames.service.RelatorioService;
import br.com.viittor.cloudgames.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CloudgamesApplication implements CommandLineRunner {

    private final PlataformaRepository plataformaRepository;
    private final PlataformaService plataformaService;
    private final UsuarioService usuarioService;
    private final JogoService jogoService;
    @Autowired
    private final RelatorioService relatorioService;

    public CloudgamesApplication(PlataformaRepository plataformaRepository, PlataformaService plataformaService, UsuarioService usuarioService, JogoService jogoService, RelatorioService relatorioService) {
        this.plataformaRepository = plataformaRepository;
        this.plataformaService = plataformaService;
        this.usuarioService = usuarioService;
        this.jogoService = jogoService;
        this.relatorioService = relatorioService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudgamesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean system = true;

        while (system) {
            System.out.println("Escolha o que deseja fazer:\n" +
                    "0 - Sair\n" +
                    "1 - Plataforma\n" +
                    "2 - Usuário\n" +
                    "3 - Jogo\n" +
                    "4 - Relatórios");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    system = false;
                    break;
                case 1:
                    plataformaService.iniciar(scanner);
                    break;
                case 2:
                    usuarioService.iniciar(scanner);
                    break;
                case 3:
                    jogoService.iniciar(scanner);
                case 4:
                    relatorioService.iniciar(scanner);

                default:
                    break;
            }

        }
    }


}
