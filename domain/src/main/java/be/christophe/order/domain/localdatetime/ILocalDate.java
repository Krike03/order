package be.christophe.order.domain.localdatetime;

import java.time.LocalDateTime;

public interface ILocalDate {
    LocalDateTime now();

    void minusDays(int i);
    void plusDays(int i);
    void reset();
}
