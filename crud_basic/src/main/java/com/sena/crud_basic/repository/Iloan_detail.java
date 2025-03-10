package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.crud_basic.model.loan_detail;

public interface Iloan_detail extends JpaRepository
<loan_detail,Integer>
{

}
