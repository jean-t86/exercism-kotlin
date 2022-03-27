class BankAccount {

    var balance: Long = 0
        private set
        get() {
            if (field == -1L) throw IllegalStateException()
            return field
        }

    @Synchronized
    fun adjustBalance(amount: Long) {
        if (balance == -1L) throw IllegalStateException()
        balance += amount
    }

    fun close() {
        balance = -1L
    }
}
