package blackjack.model.playing.cardhand

enum class CardHandState(
    val precondition: Int = 0,
) {
    BLACKJACK(21),
    BUST,
    DRAW_POSSIBILITY,
    STAY,
    HIT,
}
