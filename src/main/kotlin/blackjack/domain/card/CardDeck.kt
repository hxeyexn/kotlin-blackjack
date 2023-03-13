package blackjack.domain.card

class CardDeck(deck: List<Card> = Card.all().shuffled()) {
    private val deck: MutableList<Card> = deck.toMutableList()

    fun draw(): Card = deck.removeFirst()
}