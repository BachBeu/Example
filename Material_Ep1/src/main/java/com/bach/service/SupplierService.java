package com.bach.service;

import com.bach.models.Supplier;

public interface SupplierService {
    Iterable<Supplier> findAll();

    Supplier findById(Long id);

    void save(Supplier  supplier);

    void remove(Long id);
}
