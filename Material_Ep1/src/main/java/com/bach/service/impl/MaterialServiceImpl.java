package com.bach.service.impl;

import com.bach.models.Material;
import com.bach.models.Supplier;
import com.bach.repository.MaterialRepository;
import com.bach.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Page<Material> findAll(Pageable pageable){
        return materialRepository.findAll(pageable);
    }
    @Override
    public Page<Material> findAllByNameContaining(String name,@PageableDefault(size = 5 ,sort = "price") Pageable pageable) {
        return materialRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Material findById(Long id) {
        return materialRepository.findOne(id);
    }

    @Override
    public void save(Material material) {
        materialRepository.save(material );
    }

    @Override
    public void remove(Long id) {
        materialRepository.delete(id);
    }

    @Override
    public Iterable<Material> findAllBySupplier(Supplier supplier) {
        return materialRepository.findAllBySupplier(supplier);
    }

}
