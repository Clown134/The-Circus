package com.example.demo.repositories;

import com.example.demo.enities.*;
import org.springframework.data.jpa.repository.*;

public interface HistoryRepo extends JpaRepository<PurchaseHistory, Long> {
}
