package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new InputView(), new ResultView());
        controller.run();
    }
}
