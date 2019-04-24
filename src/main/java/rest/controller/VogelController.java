package rest.controller;

import models.Vogel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import rest.service.IVogelContainerService;
import rest.service.IVogelService;

import java.util.List;

@RestController
public class VogelController {
    @Autowired
    private IVogelContainerService vogelContainerService;

    @Autowired
    private IVogelService vogelService;

    @GetMapping(value = "/hoothoot/vogels/{id}")
    public ResponseEntity<Vogel> getVogelById(@PathVariable("id") int id) {
        System.out.println("Fetching Vogel with id " + id);
        Vogel vogel = vogelContainerService.getVogelById(id);
        if (vogel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vogel, HttpStatus.OK);
    }

    @GetMapping(value = "/hoothoot/vogels")
    public List<Vogel> getAllVogels() {
        return vogelContainerService.getVogels();
    }

    @PostMapping(value = "/hoothoot/vogels/{id}", headers = "Accept=application/json")
    public ResponseEntity<Void> createVogel(@RequestBody Vogel vogel, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Vogel " + vogel.getVogelsoort());
        vogelContainerService.saveVogel(vogel);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hoothoot/vogels/{id}").buildAndExpand(vogel.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/hoothoot/vogels/{id}")
    public ResponseEntity<String> updateVogel(@PathVariable("id") int id, @RequestBody Vogel vogel) {
        vogelService.update(vogel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/hoothoot/vogels/{id}")
    public ResponseEntity deleteVogel(@PathVariable("id") int id) {
        Vogel vogel = vogelContainerService.getVogelById(id);
        if (vogel == null) {
            return new ResponseEntity<Vogel>(HttpStatus.NOT_FOUND);
        }
        vogelContainerService.deleteVogel(vogel);
        return new ResponseEntity<Vogel>(HttpStatus.NO_CONTENT);
    }
}
