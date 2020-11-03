package com.samuelpateixeira.sudokusolver.classes

class SudokuCell (
    var row: Int,
    var column: Int,
    var finalValue : Int = 0,
    var possibleValues : ArrayList<Int> = ArrayList(),
    var selected: Boolean = false,
) {

    fun valueAssigned(): Boolean { return this.finalValue in 1..9 }
}