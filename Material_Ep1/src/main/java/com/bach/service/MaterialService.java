package com.bach.service;

import com.bach.models.Material;
import com.bach.models.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MaterialService {
    Page<Material> findAll(Pageable pageable);
    Page<Material> findAllByNameContaining(String name, Pageable pageable);
    Material findById(Long id);
    void save (Material material);
    void remove(Long id);
    Iterable<Material> findAllBySupplier(Supplier supplier);

}
