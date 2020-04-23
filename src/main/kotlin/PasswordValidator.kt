val vowels = listOf("a", "e", "i", "o", "u")

fun String.hasVowel(): Boolean =
    vowels.map {
        this.contains(it)
    }.reduce(Boolean::or)

fun String.hasValidSequence(): Boolean =
    toCharArray().indices.map {
        if (this.get(it).toString() in vowels)
            1
        else 0
    }.toList()
        .let { list ->
            list.indices.filter { index ->
                list.get(index) == 1
            }.map { onesIndex ->
                (list.getOrNull(onesIndex + 1) ?: 0) + (list.getOrNull(onesIndex + 2) ?: 0)
            }.toList()
        }.filter {
            it == 2
        }.count().let {
            it == 0
        }