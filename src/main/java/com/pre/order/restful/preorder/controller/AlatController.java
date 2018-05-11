package com.pre.order.restful.preorder.controller;

import com.pre.order.restful.preorder.dao.AlatDao;
import com.pre.order.restful.preorder.entity.Alat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Added by     : com.didikhariyanto@gmail.com
 * Since        : 5/9/18
 * Time         : 11:16 AM
 */
@Controller
public class AlatController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlatController.class);

    @Autowired
    private AlatDao ad;

    @GetMapping("/api/alat")
    @ResponseBody
    public Page<Alat> dataAlat(Pageable page){
        return ad.findAll(page);
    }

    /*
    @GetMapping("/api/alat/{id}")
    @ResponseBody
    public Alat cariAlatById(@PathVariable(name = "id") Alat a){
        return a;
    }
    */

    @GetMapping("/api/alat/{id}")
    public ResponseEntity<Alat> cariAlatById(@PathVariable("id") String id){
        Alat hasil = ad.findOne(id);
        if (hasil == null){
            LOGGER.warn("Data id  -> {} <- can’t be found [404] !!!...", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(hasil, HttpStatus.OK);
    }


    @PostMapping("/api/alat")
    @ResponseStatus(HttpStatus.CREATED)
    public void simpanAlat(@RequestBody @Valid Alat a){
        ad.save(a);
    }


    @PutMapping("/api/alat/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAlat(@PathVariable("id") String id,
                       @RequestBody @Valid Alat input){
       Alat fromDb = ad.findOne(id);
        if ( fromDb == null){
            LOGGER.warn("id -> {} <- can’t be found...", id);
            return;
        }
        BeanUtils.copyProperties(input, fromDb);
        fromDb.setId(id);
        ad.save(fromDb);
    }


    @DeleteMapping("/api/alat/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public void hapusAlat(@PathVariable("id") Alat a){
        if (a != null){
            ad.delete(a);
        }
    }

}
