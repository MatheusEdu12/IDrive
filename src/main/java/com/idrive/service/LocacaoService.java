package com.idrive.service;

import com.idrive.dao.LocacaoDao;
import com.idrive.models.Locacao;

public class LocacaoService {

    private LocacaoDao locacaoDao;

    public LocacaoService() {
        locacaoDao = new LocacaoDao();
    }

    public void inserir(Locacao locacao) {
        if (locacao.getCliente() == null || locacao.getVeiculo() == null) {
            return;
        }
        locacaoDao.inserir(locacao);
        
    }

    public void excluir(Locacao locacao) {
        if (locacao.getId() == 0) {
            return;
        }
        locacaoDao.excluir(locacao);
        
    }

    public void editar(Locacao locacao) {
        if (locacao.getCliente() == null || locacao.getVeiculo() == null) {
            return;
        }
        locacaoDao.editar(locacao);
        
    }
}
