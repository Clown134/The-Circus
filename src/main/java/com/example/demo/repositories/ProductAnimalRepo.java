package com.example.demo.repositories;

import com.example.demo.enities.*;
import org.springframework.data.jpa.repository.*;

public interface ProductAnimalRepo extends JpaRepository<ProductAnimal, Long> {
}
