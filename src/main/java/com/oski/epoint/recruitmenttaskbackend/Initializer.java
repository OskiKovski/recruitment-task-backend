package com.oski.epoint.recruitmenttaskbackend;

import com.oski.epoint.recruitmenttaskbackend.model.Element;
import com.oski.epoint.recruitmenttaskbackend.repository.ElementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

  private final ElementRepository repository;

  public Initializer(ElementRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... strings) {
    Stream.of("Samsung Galaxy Tab A 10,1", "Lenovo Tab3 A8-50F 16GB", "Huawei MediaPad M3 8\" 32GB",
        "Apple iPad 32GB", "Overmax Qualcore 1026 16GB").forEach(name ->
        repository.save(new Element(name))
    );
  }
}
