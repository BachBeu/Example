package com.bach.service.impl;

import com.bach.models.Supplier;
import com.bach.repository.SupplierRepository;
import com.bach.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public Iterable<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findOne(id);
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void remove(Long id) {
        supplierRepository.delete(id);
    }
}