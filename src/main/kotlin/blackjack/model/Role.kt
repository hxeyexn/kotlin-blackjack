package blackjack.model

abstract class Role(open val name: String, open val cardHand: CardHand) {
    abstract fun getState(hitCondition: Boolean): CardHandState

    fun addInitialCards() {
        repeat(2) {
            cardHand.addNewCard()
        }
    }

    fun runPhase(hitCondition: Boolean) {
        if (getState(hitCondition) == CardHandState.HIT) {
            cardHand.addNewCard()
        }
    }
}
