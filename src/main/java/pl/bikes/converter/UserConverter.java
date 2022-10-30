package pl.bikes.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.bikes.model.User;
import pl.bikes.repository.UserRepositpry;

public class UserConverter implements Converter<String, User> {

    @Autowired
    private UserRepositpry repository;

    @Override
    public User convert(String source) {
        return repository.findById(Long.parseLong(source)).orElse(null);
    }

}
