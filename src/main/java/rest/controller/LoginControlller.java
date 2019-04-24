package rest.controller;

import models.Vogelteller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import rest.service.ILoginContainerService;

@RestController
public class LoginControlller {
    @Autowired
    private ILoginContainerService loginContainerService;

    @GetMapping(value = "/hoothoot/login")
    public ResponseEntity<Vogelteller> authenticate(@RequestBody Vogelteller vogelteller) {
        Vogelteller tmpVogelteller = loginContainerService.authenticate(vogelteller);
        if (tmpVogelteller == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // TODO: Implement JWT Token
        return new ResponseEntity<>(tmpVogelteller, HttpStatus.OK);
    }

    @PostMapping(value = "/hoothoot/register", headers = "Accept=application/json")
    public ResponseEntity<Void> register(@RequestBody Vogelteller vogelteller, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Vogelteller " + vogelteller.getNaam());
        loginContainerService.saveVogelteller(vogelteller);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hoothoot/user/{id}").buildAndExpand(vogelteller.getId()).toUri());
        return  new  ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping(value = "/hoothoot/logout", headers = "Accept=application/json")
    public ResponseEntity<Void> logout(@RequestBody Vogelteller vogelteller) {
        if (!loginContainerService.logout(vogelteller)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
