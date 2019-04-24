package rest.controller;

import models.Vogelteller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.service.IVogeltellerContainerService;
import rest.service.IVogeltellerService;

import java.util.List;

@RestController
public class VogeltellerController {
    @Autowired
    private IVogeltellerContainerService vogeltellerContainerService;

    @Autowired
    private IVogeltellerService vogeltellerService;

    @GetMapping(value = "/hoothoot/vogeltellers/{id}")
    public ResponseEntity<Vogelteller> getVogeltellerById(@PathVariable("id") int id) {
        System.out.println("Fetching Vogelteller with id " + id);
        Vogelteller vogelteller = vogeltellerContainerService.getVogeltellerById(id);
        if (vogelteller == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vogelteller, HttpStatus.OK);
    }

    @GetMapping(value = "/hoothoot/vogeltellers")
    public List<Vogelteller> getAllVogeltellers() {
        return vogeltellerContainerService.getVogeltellers();
    }

    @PutMapping(value = "/hoothoot/vogeltellers/{id}")
    public ResponseEntity<String> vogeltellerUpdate(@PathVariable("id") int id, @RequestBody Vogelteller vogelteller) {
        vogeltellerService.updateVogelteller(vogelteller);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/hoothoot/vogeltellers/{id}")
    public ResponseEntity deleteVogelteller(@PathVariable("id") int id) {
        Vogelteller vogelteller = vogeltellerContainerService.getVogeltellerById(id);
        if (vogelteller == null) {
            return new ResponseEntity<Vogelteller>(HttpStatus.NOT_FOUND);
        }
        vogeltellerContainerService.deleteVogelteller(vogelteller);
        return new ResponseEntity<Vogelteller>(HttpStatus.NO_CONTENT);
    }
}
