package be.christophe.order.domain.service.localdatetime;

import java.time.LocalDateTime;

public class GetLocalDate implements ILocalDate{
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
