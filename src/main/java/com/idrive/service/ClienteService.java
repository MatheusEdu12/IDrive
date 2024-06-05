package com.idrive.service;

import com.idrive.dao.ClienteDao;
import com.idrive.models.Cliente;

public class ClienteService {

    private ClienteDao clienteDao;

    public ClienteService() {
        clienteDao = new ClienteDao();
    }

    public boolean inserir(Cliente cliente) {
        if (cliente.getNome().isEmpty() || cliente.getCpf().isEmpty()) {
            return false;
        }
        clienteDao.inserir(cliente);
        return true;
    }

    public boolean excluir(Cliente cliente) {
        if (cliente.getId() == 0) {
            return false;
        }
        clienteDao.excluir(cliente);
        return true;
    }

    public boolean editar(Cliente cliente) {
        if (cliente.getNome().isEmpty() || cliente.getCpf().isEmpty()) {
            return false;
        }
        clienteDao.editar(cliente);
        return true;
    }
}