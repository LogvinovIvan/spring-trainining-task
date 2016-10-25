package ua.epam.spring.hometask.service.strategy.discount;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class BirthDiscountStrategy implements DiscountStrategy {
    @Override
    public double calcDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        double discount = 0d;
        if (airDateTime.toLocalDate().compareTo(user.getBirthDate()) >= 0 && airDateTime.toLocalDate().compareTo(user.getBirthDate().minusDays(5)) <= 0) {
            discount = 5d;
        }
        return discount;
    }
}
