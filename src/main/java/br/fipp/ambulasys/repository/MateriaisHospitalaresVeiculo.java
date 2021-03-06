/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fipp.ambulasys.repository;

import br.fipp.ambulasys.model.MaterialHospitalarVeiculo;
import br.fipp.ambulasys.model.MaterialHospitalarVeiculoPK;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author felipe
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless
public class MateriaisHospitalaresVeiculo
        extends RepositorioGenerico<MaterialHospitalarVeiculo, MaterialHospitalarVeiculoPK> {

    public MateriaisHospitalaresVeiculo() {
        super(MaterialHospitalarVeiculo.class);
    }

}
