package com.sena.crud_basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sena.crud_basic.model.loan_detail;

public interface Iloan_detail extends JpaRepository
<loan_detail,Integer>
{
@Query("SELECT ur FROM loan_detail ur WHERE ur.id_bill.id = :id AND ur.state LIKE '%Reservado%'") 
List<loan_detail> getUserByBillId(@Param("id") Integer id);
}
