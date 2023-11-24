package lotto.model;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int TICKET_PRICE = 1000;
    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto() {
        this(LottoNumbers.generate());
    }

    public Lotto(List<Integer> numbers) {
        this(LottoNumbers.of(numbers));
    }

    public static int calculateTicketCount(int money) {
        return money/TICKET_PRICE;
    }

    public LottoNumbers numbers() {
        return this.numbers;
    }

    public static int price(int count) {
        return count * TICKET_PRICE;
    }

    public LottoRank rank(LottoNumbers winningNumber, LottoNumber bonusNumber) {
        return LottoRank.valueOf(this.numbers.matchNumbers(winningNumber), this.numbers.containsNumber(bonusNumber));
    }

    @Override
    public boolean equals(Object obj) {
        Lotto other = (Lotto) obj;
        return this.numbers.equals(other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
