package br.com.viittor.cloudgames;

import br.com.viittor.cloudgames.repository.PlataformaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  CloudgamesApplication {

	private final PlataformaRepository plataformaRepository;

	public CloudgamesApplication(PlataformaRepository plataformaRepository){
		this.plataformaRepository = plataformaRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(CloudgamesApplication.class, args);
	}

}
