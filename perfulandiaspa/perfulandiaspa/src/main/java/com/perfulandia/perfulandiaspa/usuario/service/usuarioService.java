package com.perfulandia.perfulandiaspa.usuario.service;

import com.perfulandia.perfulandiaspa.usuario.repository.*;
import com.perfulandia.perfulandiaspa.usuario.model.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class usuarioService {

    @Autowired
    private usuarioRepository usuarioRepository;

    public List<usuarioModel> findAll(){
        return usuarioRepository.findAll();
    }

    public usuarioModel findById(long id){
        return usuarioRepository.findById(id).get();
    }

    public usuarioModel save(usuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(long id){
        usuarioRepository.deleteById(id);
    }
}

