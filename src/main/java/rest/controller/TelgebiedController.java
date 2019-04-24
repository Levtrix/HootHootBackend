package rest.controller;

import models.Telgebied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.service.ITelgebiedContainerService;
import rest.service.ITelgebiedService;

import java.util.List;

@RestController
public class TelgebiedController {
    @Autowired
    private ITelgebiedContainerService telgebiedContainerService;

    @Autowired
    private ITelgebiedService telgebiedService;

    @GetMapping(value = "/hoothoot/telgebieden/{id}")
    public ResponseEntity<Telgebied> getTelgebiedById(@PathVariable("id") int id) {
        System.out.println("Fetching Telgebied with id " + id);
        Telgebied telgebied = telgebiedContainerService.getTelgebiedById(id);
        if (telgebied == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(telgebied, HttpStatus.OK);
    }

    @GetMapping(value = "/hoothoot/telgebieden")
    public List<Telgebied> getAllTelgebieden() {
        return telgebiedContainerService.getTelgebieden();
    }

    @PostMapping(value = "/hoothoot/telgebieden/{id}", headers = "Accept=application/json")
    public ResponseEntity<Void> createTelgebied(@RequestBody Telgebied telgebied, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Telgebied " + telgebied.getNaam());
        telgebiedContainerService.saveTelgebied(telgebied);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hoothoot/telgebieden/{id}").buildAndExpand(telgebied.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/hoothoot/telgebieden/{id}")
    public ResponseEntity<String> updateTelgebied(@PathVariable("id") int id, @RequestBody Telgebied telgebied) {
        telgebiedService.update(telgebied);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/hoothoot/telgebieden/{id}")
    public ResponseEntity deleteTelgebied(@PathVariable("id") int id) {
        Telgebied telgebied = telgebiedContainerService.getTelgebiedById(id);
        if (telgebied == null) {
            return new ResponseEntity<Telgebied>(HttpStatus.NOT_FOUND);
        }
        telgebiedContainerService.deleteTelgebied(telgebied);
        return new ResponseEntity<Telgebied>(HttpStatus.NO_CONTENT);
    }
}
