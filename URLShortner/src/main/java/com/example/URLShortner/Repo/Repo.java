package com.example.URLShortner.Repo;
import com.example.URLShortner.Entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<RequestEntity, Long> {
    boolean existsByRequestKey(String requestKey); // Update if you have this method too
    // Update this method
    RequestEntity findByRequestKey(String requestKey); // Change 'findByKey' to 'findByRequestKey'
}

