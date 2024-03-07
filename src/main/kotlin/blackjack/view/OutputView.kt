package blackjack.view

import blackjack.model.CardHand
import blackjack.model.Dealer
import blackjack.model.Participants
import blackjack.model.Player
import blackjack.model.Role

class OutputView {
    fun printInitialSetting(people: Participants) {
        val participants = people.participants
        val dealer = participants.find { it is Dealer }
        requireNotNull(dealer) { "예기치 못한 오류입니다. 관리자에게 문의해주세요." }

        val players = participants.filterIsInstance<Player>()
        println(dealer.name + "와 " + players.joinToString { it.name } + "에게 2장씩 카드를 나눴습니다")

        printInitialCardHands(dealer, players)
    }

    private fun printInitialCardHands(
        dealer: Role,
        players: List<Player>,
    ) {
        print(NAME_CARD_HAND_FORMAT.format(dealer.name))
        printFirstCardHand(dealer.cardHand)

        players.forEach {
            print(NAME_CARD_HAND_FORMAT.format(it.name))
            printAllCardHand(it.cardHand)
        }
    }

    private fun printFirstCardHand(cardHand: CardHand) {
        val (shape, number) = cardHand.hand.first()
        println(number.number.toString() + shape.shape)
    }

    fun printDealerHit() = println("딜러는 16이하라 한장의 카드를 더 받았습니다.")

    fun printGameResult(participants: Participants) {
        participants.participants.forEach {
            printPlayerCardHand(it)
            println(CARD_HAND_SUM_FORMAT.format(it.cardHand.sum))
        }
    }

    private fun printAllCardHand(cardHand: CardHand) {
        print(
            cardHand.hand.joinToString {
                it.number.output + it.shape.shape
            },
        )
    }

    private fun printPlayerCardHand(role: Role) {
        print(NAME_CARD_HAND_FORMAT.format(role.name))
        printAllCardHand(role.cardHand)
    }

    companion object {
        private const val NAME_CARD_HAND_FORMAT = "%s 카드: "
        private const val CARD_HAND_SUM_FORMAT = " - 결과: %d"
    }
}