package blackjack.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {
    @Test
    fun `딜러 카드 패의 합과 플레이어들의 카드 패의 합을 각각 비교해서 플레이어들의 승패 여부를 판단한다`() {
        val dealerSum = 18
        val playerResult = mapOf("해나" to 17, "심지" to 20, "악어" to 18, "팡태" to 25)

        val result =
            PlayerWinning(
                mapOf(
                    "해나" to WinningResultStatus.DEFEAT,
                    "심지" to WinningResultStatus.VICTORY,
                    "악어" to WinningResultStatus.DRAW,
                    "팡태" to WinningResultStatus.DEFEAT,
                ),
            )
        val winningResult = Referee().judgeWinningResult(dealerSum, playerResult)
        assertThat(winningResult).isEqualTo(result)
    }

    @Test
    fun `딜러 카드 패의 합이 21 초과 이고, 플레이어 카드 패의 합이 21 이하이면 플레이어가 승리한다`() {
        val dealerSum = 24
        val playerResult = mapOf("해나" to 17, "심지" to 20, "악어" to 18, "팡태" to 25)

        val result =
            PlayerWinning(
                mapOf(
                    "해나" to WinningResultStatus.VICTORY,
                    "심지" to WinningResultStatus.VICTORY,
                    "악어" to WinningResultStatus.VICTORY,
                    "팡태" to WinningResultStatus.DEFEAT,
                ),
            )
        val winningResult = Referee().judgeWinningResult(dealerSum, playerResult)
        assertThat(winningResult).isEqualTo(result)
    }
}
