package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.DBEntity;

import java.util.List;

@Repository
public interface DBEntityRepository extends JpaRepository<DBEntity, Integer> {
}
