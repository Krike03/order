package be.christophe.order.item.localdatetime;

import be.christophe.order.domain.localdatetime.ILocalDate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDate implements ILocalDate {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    @Override
    public void minusDays(int i) {

    }

    @Override
    public void plusDays(int i) {

    }

    @Override
    public void reset() {

    }
}
