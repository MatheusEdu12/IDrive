package com.idrive.service;

import com.idrive.dao.VeiculoDao;
import com.idrive.models.Veiculo;

public class VeiculoService {

    private VeiculoDao veiculoDao;

    public VeiculoService() {
        veiculoDao = new VeiculoDao();
    }

    public void inserir(Veiculo veiculo) {
        if (veiculo.getMarca().isEmpty() || veiculo.getModelo().isEmpty() || veiculo.getPlaca().isEmpty()) {
            return;
        }
        veiculoDao.inserir(veiculo);
        
    }

    public void excluir(Veiculo veiculo) {
        if (veiculo.getId() == 0) {
            return;
        }
        veiculoDao.excluir(veiculo);
        
    }

    public void editar(Veiculo veiculo) {
        if (veiculo.getMarca().isEmpty() || veiculo.getModelo().isEmpty() || veiculo.getPlaca().isEmpty()) {
            return;
        }
        veiculoDao.editar(veiculo);
        
    }
}
