package com.oski.epoint.recruitmenttaskbackend.controller;

import com.oski.epoint.recruitmenttaskbackend.exception.ResourceNotFoundException;
import com.oski.epoint.recruitmenttaskbackend.model.Element;
import com.oski.epoint.recruitmenttaskbackend.repository.ElementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ElementController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private final ElementRepository repository;

  @Autowired
  public ElementController(ElementRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/elements")
  public List<Element> getElements() {
    logger.info("Getting all elements from database");
    return repository.findAll();
  }

  @PostMapping("/elements")
  public Element createElement(@Valid @RequestBody Element element) {
    logger.info("Saving new element in database");
    return repository.save(element);
  }

  @PutMapping("/elements/{elementId}")
  public Element updateElement(@PathVariable Integer elementId,
                               @Valid @RequestBody Element elementRequest) {
    return repository.findById(elementId)
        .map(element -> {
          element.setName(elementRequest.getName());
          logger.info("Element with id " + elementId + " saved to database");
          return repository.save(element);
        }).orElseThrow(()->new ResourceNotFoundException("Element with id " + elementId + " not found"));
  }

  @DeleteMapping("/elements/{elementId}")
  public ResponseEntity<?> deleteElement(@PathVariable Integer elementId) {
    return repository.findById(elementId)
        .map(element -> {
          repository.delete(element);
          logger.info("Element with id " + elementId + " successfully deleted");
          return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Element with id " + elementId + " not found"));
  }
}
