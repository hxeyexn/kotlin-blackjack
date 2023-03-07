package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ParticipantsTest {
    @Test
    fun `딜러와 플레이어들을 모두 가져온다`() {
        val participants = Participants(
            Players(
                listOf(
                    Player(
                        Name("pobi"),
                        Cards(
                            listOf(
                                Card.of(CardCategory.CLOVER, CardNumber.EIGHT),
                                Card.of(CardCategory.SPADE, CardNumber.NINE),
                            ),
                        ),
                    ),
                    Player(
                        Name("jason"),
                        Cards(
                            listOf(
                                Card.of(CardCategory.CLOVER, CardNumber.EIGHT),
                                Card.of(CardCategory.SPADE, CardNumber.NINE),
                            ),
                        ),
                    ),
                ),
            ),
            Dealer(
                Cards(
                    listOf(
                        Card.of(CardCategory.CLOVER, CardNumber.EIGHT),
                        Card.of(CardCategory.SPADE, CardNumber.NINE),
                    ),
                ),
            ),
        )
        val result = participants.participants.joinToString(", ") { it.name.value }
        assertThat(result).isEqualTo("딜러, pobi, jason")
    }
}
