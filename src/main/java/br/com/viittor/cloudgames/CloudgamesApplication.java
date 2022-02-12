package br.com.viittor.cloudgames;

import br.com.viittor.cloudgames.repository.PlataformaRepository;
import br.com.viittor.cloudgames.service.PlataformaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CloudgamesApplication implements CommandLineRunner {

    private final PlataformaRepository plataformaRepository;
    private final PlataformaService plataformaService;

    public CloudgamesApplication(PlataformaRepository plataformaRepository, PlataformaService plataformaService) {
        this.plataformaRepository = plataformaRepository;
        this.plataformaService = plataformaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudgamesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean system = true;

        while (system) {
            System.out.println("Escolha o que deseja fazer:\n" + "0 - Sair\n" + "1 - Plataforma\n");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    system = false;
                    break;
                case 1:
                    plataformaService.iniciar(scanner);
                    break;
                default:
                    break;
            }

        }
    }


}
