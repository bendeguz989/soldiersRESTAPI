package hu.soldiersRESTAPI.services;

import hu.soldiersRESTAPI.domain.Soldier;
import hu.soldiersRESTAPI.repositories.SoldierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SoldierService {

    @Autowired
    private SoldierRepository repository;

    public List<Soldier> getSoldiers() {
        return repository.findAll();
    }

    public Soldier createSoldier(Soldier soldier) {
        //egyediség vizsgálat 409-es státuszkódot kell adnia
        return repository.save(soldier);
    }
}
