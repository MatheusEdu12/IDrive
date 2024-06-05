package com.idrive.service;

import com.idrive.dao.LocacaoDao;
import com.idrive.models.Locacao;

public class LocacaoService {

    private LocacaoDao locacaoDao;

    public LocacaoService() {
        locacaoDao = new LocacaoDao();
    }

    public boolean inserir(Locacao locacao) {
        if (locacao.getCliente() == null || locacao.getVeiculo() == null) {
            return false;
        }
        locacaoDao.inserir(locacao);
        return true;
    }

    public boolean excluir(Locacao locacao) {
        if (locacao.getId() == 0) {
            return false;
        }
        locacaoDao.excluir(locacao);
        return true;
    }

    public boolean editar(Locacao locacao) {
        if (locacao.getCliente() == null || locacao.getVeiculo() == null) {
            return false;
        }
        locacaoDao.editar(locacao);
        return true;
    }
}
