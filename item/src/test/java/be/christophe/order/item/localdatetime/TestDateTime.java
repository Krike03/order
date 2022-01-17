package be.christophe.order.item.localdatetime;

import be.christophe.order.domain.localdatetime.ILocalDate;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Profile("Test")
public class TestDateTime implements ILocalDate {
    private LocalDateTime thisTime;

    public TestDateTime() {
        this.thisTime = LocalDateTime.now();
    }

    @Override
    public LocalDateTime now() {
        return thisTime;
    }

    public void minusDays(int days){
        thisTime = thisTime.minusDays(days);
    }

    public void plusDays(int days){
        thisTime = thisTime.plusDays(days);
    }

    @Override
    public void reset() {
        LocalDateTime.now();
    }
}
