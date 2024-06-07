package com.idrive.service;

import com.idrive.dao.ClienteDao;
import com.idrive.models.Cliente;

public class ClienteService {

    private ClienteDao clienteDao;

    public ClienteService() {
        clienteDao = new ClienteDao();
    }

    public void inserir(Cliente cliente) {
        if (cliente.getNome().isEmpty() || cliente.getCpf().isEmpty()) {
            return;
        }
        clienteDao.inserir(cliente);
        
    }

    public void excluir(Cliente cliente) {
        if (cliente.getId() == 0) {
            return;
        }
        clienteDao.excluir(cliente);
        
    }

    public void editar(Cliente cliente) {
        if (cliente.getNome().isEmpty() || cliente.getCpf().isEmpty()) {
            return;
        }
        clienteDao.editar(cliente);
        
    }
}