package com.loan.loan.management.system.Repository;

import com.loan.loan.management.system.Entity.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanProductRepository extends JpaRepository<LoanProduct,Long> {
}
