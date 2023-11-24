package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoReportTest {

    @ParameterizedTest
    @DisplayName("수익률 계산 - 소수점 둘째자리 이하 버림")
    @CsvSource(value = {
            "1, 0, 0, 2, 1, 0, 0:15",
            "3, 0, 0, 0, 0, 0, 0:0",
            "1, 1, 1, 0, 0, 0, 1:500000",
            "13, 0, 0, 1, 0, 0, 0:0.35"},
            delimiter = ':')
    public void 리포트_수익률_계산(String result, double expected) {
        List<Integer> resultReport = Arrays.stream(result.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Assertions.assertThat(new LottoReport(resultReport).rateOfReturn())
                .isEqualTo(expected);
    }
}
