package blackjack.view

import blackjack.model.CardHand
import blackjack.model.CardNumber
import blackjack.model.CardShape
import blackjack.model.DealerWinning
import blackjack.model.Participants
import blackjack.model.PlayerWinning
import blackjack.model.Role

class OutputView {
    fun printInitialSetting(participants: Participants) {
        val dealer = participants.dealer

        val players = participants.players
        println(dealer.name.name + "와 " + players.players.joinToString { it.name.name } + "에게 2장씩 카드를 나눴습니다")
    }

    fun printInitialCardHands(participants: Participants) {
        print(NAME_CARD_HAND_FORMAT.format(participants.dealer.name.name))
        printFirstCardHand(participants.dealer.cardHand)

        participants.players.players.forEach {
            print(NAME_CARD_HAND_FORMAT.format(it.name.name))
            printAllCardHand(it.cardHand)
            println()
        }
    }

    private fun printFirstCardHand(cardHand: CardHand) {
        val (shape, number) = cardHand.hand.first()
        println(number.number.toString() + convertCardShapeFormat(shape))
    }

    fun printDealerHit() = println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.")

    fun printGameResult(participants: Participants) {
        println("\n")

        printPlayerCardHand(participants.dealer)
        println(CARD_HAND_SUM_FORMAT.format(participants.dealer.cardHand.sum()))

        participants.players.players.forEach {
            printPlayerCardHand(it)
            println(CARD_HAND_SUM_FORMAT.format(it.cardHand.sum()))
        }
    }

    private fun printAllCardHand(cardHand: CardHand) {
        print(
            cardHand.hand.joinToString {
                convertCardNumberFormat(it.number) + convertCardShapeFormat(it.shape)
            },
        )
    }

    private fun convertCardShapeFormat(shape: CardShape): String {
        return when (shape) {
            CardShape.HEART -> HEART_OUTPUT_FORMAT
            CardShape.CLOVER -> CLOVER_OUTPUT_FORMAT
            CardShape.SPADE -> SPADE_OUTPUT_FORMAT
            CardShape.DIAMOND -> DIAMOND_OUTPUT_FORMAT
        }
    }

    private fun convertCardNumberFormat(number: CardNumber): String {
        return if (number == CardNumber.ACE) {
            ACE_OUTPUT_FORMAT
        } else {
            number.number.toString()
        }
    }

    fun printPlayerCardHand(role: Role) {
        print(NAME_CARD_HAND_FORMAT.format(role.name.name))
        printAllCardHand(role.cardHand)
    }

    fun printFinalDealerResult(dealerWinning: DealerWinning) {
        println("\n## 최종 승패")

        print("딜러: ")
        dealerWinning.result.forEach {
            print(it.value.toString() + it.key.output + " ")
        }
        println()
    }

    fun printFinalPlayersResult(playerWinning: PlayerWinning) {
        playerWinning.result.forEach { (name, status) ->
            println("${name.name}: ${status.output}")
        }
        println()
    }

    companion object {
        private const val NAME_CARD_HAND_FORMAT = "%s 카드: "
        private const val CARD_HAND_SUM_FORMAT = " - 결과: %d"
        private const val HEART_OUTPUT_FORMAT = "하트"
        private const val CLOVER_OUTPUT_FORMAT = "클로버"
        private const val SPADE_OUTPUT_FORMAT = "스페이드"
        private const val DIAMOND_OUTPUT_FORMAT = "다이아몬드"
        private const val ACE_OUTPUT_FORMAT = "A"
    }
}
