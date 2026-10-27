package com.example.designpatternslab2026.persistence;

import com.example.designpatternslab2026.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
}