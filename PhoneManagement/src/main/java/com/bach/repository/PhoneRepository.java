package com.bach.repository;

import com.bach.models.Category;
import com.bach.models.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {
    Page<Phone> findAllByNameContaining(String name, Pageable pageable);

    Iterable<Phone> findAllByCategory(Category category);
}
