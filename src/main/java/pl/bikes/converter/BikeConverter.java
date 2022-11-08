package pl.bikes.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.bikes.model.Bike;
import pl.bikes.repository.BikeRepository;


public class BikeConverter implements Converter<String, Bike> {
    @Autowired
    private BikeRepository repository;

    @Override
    public Bike convert(String source) {
        return repository.findById(Long.parseLong(source)).orElse(null);
    }

}
