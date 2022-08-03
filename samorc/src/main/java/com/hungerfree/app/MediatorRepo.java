package com.hungerfree.app;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 @Repository
public interface MediatorRepo extends JpaRepository<Mediator, Long> {
 
}
