package exam.util;

import org.springframework.stereotype.Component;

@Component
public interface ValidationUtil {

        <T> boolean isValid(T entity);

//    <T> Set<ConstraintViolation<T>> violation(T entity);

}
