class Allergies(private val score: Int) {

    fun getList(): List<Allergen> {

        var standardisedScore: Int = score
        while (standardisedScore > Allergen.CATS.score * 2) {
            standardisedScore -= Allergen.CATS.score
        }

        if (standardisedScore <= 0) {
            return listOf()
        }

        val allergens = mutableListOf<Allergen>()

        val allergenAbacus = Allergen
            .values()
            .filter { standardisedScore >= it.score }

        allergenAbacus
            .reversed()
            .fold(standardisedScore) { acc, allergen ->
                if (acc >= allergen.score) {
                    allergens.add(allergen)
                    acc - allergen.score
                } else {
                    acc
                }
            }

        return allergens.reversed()
    }

    fun isAllergicTo(allergen: Allergen): Boolean = getList().contains(allergen)
}
