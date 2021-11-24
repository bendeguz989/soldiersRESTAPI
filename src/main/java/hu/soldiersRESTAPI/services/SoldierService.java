package hu.soldiersRESTAPI.services;

import hu.soldiersRESTAPI.domain.Soldier;
import hu.soldiersRESTAPI.repositories.SoldierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


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

    public Soldier updateSoldier(int id, int shot) {
        Optional <Soldier> optionalSoldier = repository.findById(id);
        if(optionalSoldier.isPresent()){
            Soldier soldier = optionalSoldier.get();
            soldier.setShotenemis(shot);
            return  repository.save(soldier);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Soldier replaceSoldier(int id, Soldier soldier) {
        Optional <Soldier> optionalSoldier = repository.findById(id);
        if(optionalSoldier.isPresent()){
            soldier.setId(id);
            return  repository.save(soldier);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
