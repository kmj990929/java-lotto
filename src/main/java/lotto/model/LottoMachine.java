package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000;

    public static List<Lotto> issue(int money) {
        int ticketCount = calculateTicketCount(money);
        return generateTickets(ticketCount);
    }

    private static List<Lotto> generateTickets(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto());
        }
        return tickets;
    }

    public static int calculateTicketCount(int money) {
        return money/TICKET_PRICE;
    }

    public static int ticketPrice() {
        return TICKET_PRICE;
    }
}
