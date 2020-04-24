val vowels = "aeiou".toCharArray()

fun String.hasVowel(): Boolean =
    vowels.map {
        this.contains(it)
    }.reduce(Boolean::or)

fun String.hasValidThreeLessPattern(vowels: Boolean = true): Boolean =
    getLetterTypeSequence()
        .let { seq -> if (!vowels) seq.map { !it } else seq }
        .getNumberOfThreeLessPatternViolations().let { it == 0 }

private fun String.getLetterTypeSequence(): List<Boolean> {
    return indices.map {
        this[it] in vowels
    }.toList()
}

/**
 * Returns the number of the "three less pattern" violations.
 *
 * Given a list that specifies the type of letter in each position and checking
 * for the letter type represented by true, for each position where a
 * "true" (can be consonat or vowel, it is up to the construction of the
 * receiver) the function checks the types of the next two letters. If these,
 * are also "true" type it will count it as a violation.
 *
 * @receiver: List that specifies the type of letter (consonant or vowel)
 * using true or false. The index correspond to the position of the letter
 * in the original string.
 *
 * @return Number of violations of the three less pattern
 */
private fun List<Boolean>.getNumberOfThreeLessPatternViolations() =
    indices.asSequence().filter { index ->
        this[index] == true
    }.map { onesIndex ->
        (this.getOrNull(onesIndex + 1) ?: false) and
                (this.getOrNull(onesIndex + 2) ?: false)
    }.toList().filter { it }.count()