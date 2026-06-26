package com.danu.repository;

import com.danu.modal.salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalonRepository extends JpaRepository <salon, Long>{

    salon findByOwnerId(Long id);

    @Query(
            "select s from salon s where" +
                    "(lower(s.city) like lower(concat('%', :keyword ,'%')) OR "+
                     "(lower(s.name) like lower (concat('%' ,:keyword,'%')) OR " +
                     "lower(s.address) like lower(concat('%' ,:keyword, '%' ))))"
    )
    List<salon> searchSalons(@Param("keyword") String keyword);


}
