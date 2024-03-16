package blackjack.model.card

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CardTest {
    @ParameterizedTest
    @CsvSource(
        "CLOVER, ACE",
        "HEART, TWO",
        "SPADE, KING",
    )
    fun `카드는 모양과 숫자를 알고 있다`(
        suit: String,
        number: String,
    ) {
        val card = Card(Suit.valueOf(suit), number = CardNumber.valueOf(number))
        assertThat(card).isEqualTo(Card(Suit.valueOf(suit), CardNumber.valueOf(number)))
    }
}
