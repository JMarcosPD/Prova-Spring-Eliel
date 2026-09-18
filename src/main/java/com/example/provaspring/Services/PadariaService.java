package com.example.provaspring.Services;

import com.example.provaspring.Models.PadariaModel;
import com.example.provaspring.Repositories.PadariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadariaService {

    @Autowired
    private PadariaRepository padariaRepository;

    public List<PadariaModel> findAll(){
        return padariaRepository.findAll();
    }

    public PadariaModel buscarPorId(Long id){
        return padariaRepository.findById(id).get();
    }

    public PadariaModel criarPadaria(PadariaModel padariaModel){
        return padariaRepository.save(padariaModel);
    }

    public void deletarPadaria(Long id){
        padariaRepository.deleteById(id);
    }

    public PadariaModel atualizarPadaria(Long id, PadariaModel padariaModel){

        PadariaModel padariaAtual = padariaRepository.findById(id).get();

        padariaAtual.setNome(padariaModel.getNome());
        padariaAtual.setEndereco(padariaModel.getEndereco());

        return padariaRepository.save(padariaAtual);

    }
}
