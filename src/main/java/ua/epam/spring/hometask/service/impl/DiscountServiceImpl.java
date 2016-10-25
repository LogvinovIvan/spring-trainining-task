package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.strategy.discount.DiscountStrategy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Ivan_Lohvinau on 10/25/2016.
 */
public class DiscountServiceImpl implements DiscountService {
    private List<DiscountStrategy> strategies;
    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {

        return (byte) strategies.stream()
                                .mapToDouble(p->p.calcDiscount(user,event,airDateTime,numberOfTickets))
                                .max()
                                .orElse(0d);
    }

    public void setStrategies(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }
}
