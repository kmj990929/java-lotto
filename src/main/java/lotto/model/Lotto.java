package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> CANDIDATE_NUMBERS = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        this.numbers = lottoNumbers;
    }

    public Lotto() {
        this(createLottoNumbers());
    }

    private static List<Integer> createLottoNumbers() {
        Collections.shuffle(CANDIDATE_NUMBERS);
        List<Integer> numbers = CANDIDATE_NUMBERS.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return new ArrayList<>(numbers);
    }

    public List<LottoNumber> numbers() {
        return this.numbers;
    }

    public int matchNumbers(List<LottoNumber> targets) {
        return targets.stream()
                .filter(this::matchNumber)
                .mapToInt(target -> 1)
                .sum();
    }

    private boolean matchNumber(LottoNumber number) {
        return this.numbers.contains(number);
    }

    @Override
    public boolean equals(Object obj) {
        Lotto other = (Lotto) obj;
        return this.numbers.equals(other.numbers);
    }
}
