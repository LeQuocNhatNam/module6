package com.example.busapp.repository;

import com.example.busapp.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IBusRepository extends JpaRepository<Bus, Integer> {
    @Query(value = "select b.* from bus as b",
            countQuery = "select count(*) FROM (SELECT b.* from bus as b) as bus_table", nativeQuery = true)
    Page<Bus> getAll(Pageable pageable);

    @Modifying
    @Query(value = "delete from bus as b where b.id = :id", nativeQuery = true)
    void deleteBus(@Param("id") int id);
}
