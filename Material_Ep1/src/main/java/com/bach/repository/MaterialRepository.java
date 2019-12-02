package com.bach.repository;

import com.bach.models.Material;
import com.bach.models.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MaterialRepository extends PagingAndSortingRepository<Material, Long> {
    Page<Material> findAllByNameContaining(String name, Pageable pageable);

    Iterable<Material> findAllBySupplier(Supplier supplier);
}
