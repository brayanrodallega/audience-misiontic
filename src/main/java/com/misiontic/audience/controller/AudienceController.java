package com.misiontic.audience.controller;

import com.misiontic.audience.entities.Audience;
import com.misiontic.audience.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Audience")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<Audience> getAll(){
        return audienceService.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void save(@RequestBody Audience audience){
        audienceService.save(audience);
    }
}
