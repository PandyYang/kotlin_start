package com.pandy.base.generic

fun main() {
    val numberComparator = Comparator<Number> {
        n1, n2 -> n1.toDouble().compareTo(n2.toDouble())
    }
    val doubleList = mutableListOf(2.0, 3.0)
    doubleList.sortWith(numberComparator)
    val intList = mutableListOf(1, 2)
    intList.sortWith(numberComparator)
}
