package com.kun.p3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kun
 * @date 2022/4/3
 */
@Repository
interface StudentRepository extends JpaRepository<Student, Long> {
}
