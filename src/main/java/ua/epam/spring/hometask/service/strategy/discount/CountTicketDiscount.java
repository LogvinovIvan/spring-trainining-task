package ua.epam.spring.hometask.service.strategy.discount;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventRating;
import ua.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class CountTicketDiscount implements DiscountStrategy {
    private final static Integer DISCOUNT_TICKET = 10;
    private final static Double DISCOUNT = 0.5;
    @Override
    public double calcDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        double discount = 0;
        if(event.getRating()== EventRating.LOW){
            discount+=20;
        }else if(event.getRating() == EventRating.MID){
            discount+=10;
        }
        return discount+numberOfTickets/DISCOUNT_TICKET*DISCOUNT;
    }
}
