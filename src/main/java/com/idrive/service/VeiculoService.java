package com.idrive.service;

import com.idrive.dao.VeiculoDao;
import com.idrive.models.Veiculo;

public class VeiculoService {

    private VeiculoDao veiculoDao;

    public VeiculoService() {
        veiculoDao = new VeiculoDao();
    }

    public boolean inserir(Veiculo veiculo) {
        if (veiculo.getMarca().isEmpty() || veiculo.getModelo().isEmpty() || veiculo.getPlaca().isEmpty()) {
            return false;
        }
        veiculoDao.inserir(veiculo);
        return true;
    }

    public boolean excluir(Veiculo veiculo) {
        if (veiculo.getId() == 0) {
            return false;
        }
        veiculoDao.excluir(veiculo);
        return true;
    }

    public boolean editar(Veiculo veiculo) {
        if (veiculo.getMarca().isEmpty() || veiculo.getModelo().isEmpty() || veiculo.getPlaca().isEmpty()) {
            return false;
        }
        veiculoDao.editar(veiculo);
        return true;
    }
}
