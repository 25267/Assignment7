package kz.example.repository;

import kz.example.entity.Moder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends JpaRepository<Moder, Long> {

    @Query(value = "SELECT * FROM Moder u Where u.name=?1 and u.password=?2", nativeQuery = true)
    Moder findModer(String name, String password);
}
