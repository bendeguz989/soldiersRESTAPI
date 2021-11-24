package hu.soldiersRESTAPI.controllers;

import hu.soldiersRESTAPI.domain.Soldier;
import hu.soldiersRESTAPI.services.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldiers")// root path
public class SoldierController {

    @Autowired
    private SoldierService service;

    @GetMapping("")
    public List<Soldier> getSoldiers(){
        return service.getSoldiers();
    }

    @PostMapping(value="")
    @ResponseStatus(HttpStatus.CREATED)
    public Soldier createSoldier(@RequestBody Soldier soldier){
        return service.createSoldier(soldier);
    }

    @PatchMapping("/{id}/{shotenemies}")
    public Soldier updateSoldier(@PathVariable("id") int id,@PathVariable("shotenemies") int shot){
        return service.updateSoldier(id, shot);
    }
}
