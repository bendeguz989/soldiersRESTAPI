package hu.soldiersRESTAPI.repositories;

import hu.soldiersRESTAPI.domain.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier, Integer> {

}
