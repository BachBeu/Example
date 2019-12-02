package com.bach.repository;

import com.bach.models.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SupplierRepository extends PagingAndSortingRepository<Supplier, Long> {
}