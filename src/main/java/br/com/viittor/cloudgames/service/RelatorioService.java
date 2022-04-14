package br.com.viittor.cloudgames.service;

import br.com.viittor.cloudgames.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class RelatorioService {

    @Autowired
    RelatorioRepository repository;

    public void iniciar(Scanner scanner){
        repository.findByGender(String.valueOf(scanner));
    }


}
