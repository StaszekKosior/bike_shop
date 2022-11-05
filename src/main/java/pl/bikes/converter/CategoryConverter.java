package pl.bikes.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.bikes.model.Category;
import pl.bikes.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository repository;


    @Override
    public Category convert(String source) {
        return repository.findById(Long.parseLong(source)).orElse(null);
    }
}
