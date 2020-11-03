package com.samuelpateixeira.sudokusolver.classes

class SudokuGame () {


    var cells: ArrayList<SudokuCell> = ArrayList()

    init {
        for (row in 1 until 9 + 1) {
            for (column in 1 until 9 + 1) {
                this.cells.add(SudokuCell(row, column, 0, ArrayList()))
            }
        }
    }

    fun getCellBox(sudokuCell: SudokuCell): ArrayList<SudokuCell> {
        var cellBox = ArrayList<SudokuCell>()

        var cellBoxMinRow = 0
        var cellBoxMaxRow = 0

        when (sudokuCell.row) {
            1, 2, 3 -> {
                cellBoxMinRow = 1
                cellBoxMaxRow = 3
            }
            4, 5, 6 -> {
                cellBoxMinRow = 4
                cellBoxMaxRow = 6
            }
            7, 8, 9 -> {
                cellBoxMinRow = 7
                cellBoxMaxRow = 9
            }
            else -> throw (Exception("invalid cell row"))
        }


        var cellBoxMinColumn = 0
        var cellBoxMaxColumn = 0

        when (sudokuCell.column) {
            1, 2, 3 -> {
                cellBoxMinColumn = 1
                cellBoxMaxColumn = 3
            }
            4, 5, 6 -> {
                cellBoxMinColumn = 4
                cellBoxMaxColumn = 6
            }
            7, 8, 9 -> {
                cellBoxMinColumn = 7
                cellBoxMaxColumn = 9
            }
            else -> throw (Exception("invalid cell column"))
        }

        for (cell in cells) {
            if (cell.row in cellBoxMinRow until cellBoxMaxRow + 1 && cell.column in cellBoxMinColumn until cellBoxMaxColumn + 1) {
                cellBox.add(cell)
            }
        }

        return cellBox

    }

    fun getCellBoxNo(number: Int): ArrayList<SudokuCell> {
        when (number) {
            1 -> {
                return getCellBox(getCell(1, 1))
            }
            2 -> {
                return getCellBox(getCell(4, 1))
            }
            3 -> {
                return getCellBox(getCell(7, 1))
            }
            4 -> {
                return getCellBox(getCell(1, 4))
            }
            5 -> {
                return getCellBox(getCell(5, 4))
            }
            6 -> {
                return getCellBox(getCell(7, 4))
            }
            7 -> {
                return getCellBox(getCell(1, 7))
            }
            8 -> {
                return getCellBox(getCell(4, 7))
            }
            9 -> {
                return getCellBox(getCell(7, 7))
            }
            else -> {
                throw(Exception("bad box number"))
            }
        }
    }

    fun getCellRow(sudokuCell: SudokuCell): ArrayList<SudokuCell> {
        var cellRow = ArrayList<SudokuCell>()

        for (cell in cells) {
            if (cell.row == sudokuCell.row) {
                cellRow.add(cell)
            }
        }

        return cellRow
    }

    fun getCellRowNo(number: Int): ArrayList<SudokuCell> {
        when (number) {
            1 -> {
                return getCellRow(getCell(1, 1))
            }
            2 -> {
                return getCellRow(getCell(2, 1))
            }
            3 -> {
                return getCellRow(getCell(3, 1))
            }
            4 -> {
                return getCellRow(getCell(4, 1))
            }
            5 -> {
                return getCellRow(getCell(5, 1))
            }
            6 -> {
                return getCellRow(getCell(6, 1))
            }
            7 -> {
                return getCellRow(getCell(7, 1))
            }
            8 -> {
                return getCellRow(getCell(8, 1))
            }
            9 -> {
                return getCellRow(getCell(9, 1))
            }
            else -> {
                throw(Exception("bad row number"))
            }
        }
    }

    fun getCellColumn(sudokuCell: SudokuCell): ArrayList<SudokuCell> {
        var cellColumn = ArrayList<SudokuCell>()

        for (cell in cells) {
            if (cell.column == sudokuCell.column) {
                cellColumn.add(cell)
            }
        }

        return cellColumn
    }

    fun getCellColumnNo(number: Int): ArrayList<SudokuCell> {
        when (number) {
            1 -> {
                return getCellColumn(getCell(1, 1))
            }
            2 -> {
                return getCellColumn(getCell(2, 2))
            }
            3 -> {
                return getCellColumn(getCell(3, 3))
            }
            4 -> {
                return getCellColumn(getCell(4, 4))
            }
            5 -> {
                return getCellColumn(getCell(5, 5))
            }
            6 -> {
                return getCellColumn(getCell(6, 6))
            }
            7 -> {
                return getCellColumn(getCell(7, 7))
            }
            8 -> {
                return getCellColumn(getCell(8, 8))
            }
            9 -> {
                return getCellColumn(getCell(9, 9))
            }
            else -> {
                throw(Exception("bad column number"))
            }
        }
    }

    fun getPossibleValues(sudokuCell: SudokuCell) {

        if (sudokuCell.valueAssigned()) throw(Exception("trying to process cell with value already assigned"))

        var sudokuCellImpossibleValues = ArrayList<Int>()

        //clear any old values
        sudokuCell.possibleValues.clear()

        // for each cell that matters
        for (cell in getCellsThatMatter(sudokuCell)) {
            // add its value to impossible values list
            if (cell.valueAssigned() && !sudokuCellImpossibleValues.contains(cell.finalValue)) {
                sudokuCellImpossibleValues.add(cell.finalValue)
            }
        }

        // for each possible value
        for (value in getPossibleValuesFromImpossibleValues(sudokuCellImpossibleValues)) {
            // check if not repeated
            if (!sudokuCell.possibleValues.contains(value)) {
                // add to possible values
                sudokuCell.possibleValues.add(value)
            }
        }

    }

    fun getPossibleValuesFromImpossibleValues(impossibleValues: ArrayList<Int>) : ArrayList<Int> {

        var possibleValues = ArrayList<Int>()

        // for each value
        for (value in 1 until 9 + 1) {
            // if not impossible
            if (!impossibleValues.contains(value)) {
                // add to possible values
                possibleValues.add(value)
            }
        }

        return possibleValues
    }

    fun getCell(row: Int, column: Int): SudokuCell {
        var returnCell: SudokuCell? = null
        for (cell in cells) {
            if (cell.row == row && cell.column == column) {
                returnCell = cell
            }
        }

        if (returnCell == null) {
            throw(Exception("bad cell info"))
        } else

            return returnCell
    }

    fun getOrderedCells(): ArrayList<SudokuCell> {
        var orderedCells = ArrayList<SudokuCell>()

        for (i in 1 until 9 + 1) {
            for (j in 1 until 9 + 1) {
                orderedCells.add(getCell(i, j))
            }
        }

        return orderedCells
    }

    fun loadPossibleValues() {
        for (cell in cells) {
            if (!cell.valueAssigned()) getPossibleValues(cell)
            else cell.possibleValues.clear()
        }

    }

    fun getAllCellGroups(): ArrayList<ArrayList<SudokuCell>> {
        var cellGroups = ArrayList<ArrayList<SudokuCell>>()
        for (i in 1 until 9 + 1) {
            cellGroups.add(getCellBoxNo(i))
            cellGroups.add(getCellRowNo(i))
            cellGroups.add(getCellColumnNo(i))
        }
        return cellGroups
    }

    fun getCellGroupsForCell(cell: SudokuCell): ArrayList<ArrayList<SudokuCell>> {
        var cellGroups = ArrayList<ArrayList<SudokuCell>>()

        cellGroups.add(getCellColumn(cell))
        cellGroups.add(getCellRow(cell))
        cellGroups.add(getCellBox(cell))

        return cellGroups
    }

    fun getCellsThatMatter(sudokuCell: SudokuCell) : ArrayList<SudokuCell> {

        var cellsThatMatter = ArrayList<SudokuCell>()

        for (cellGroup in getCellGroupsForCell(sudokuCell)) {
            for (cell in cellGroup) {
                if (!cellsThatMatter.contains(cell))
                cellsThatMatter.add(cell)
            }
        }
        return cellsThatMatter
    }

    fun fillCellGroupByOnlyPossibleCellForValue(cellGroup: ArrayList<SudokuCell>) {
        var count: Int = 0
        var lastCountedCell: SudokuCell? = null

        loadPossibleValues()

        // fill by only possible cell in cell group

        //for each value (1 to 9)
        for (i in 1 until 9 + 1) {
            count = 0
            //count possible cells for value
            for (cell in cellGroup) {
                if (cell.possibleValues.contains(i)) {
                    if (cell.valueAssigned()) throw(Exception("counting cell with value assigned"))
                    count++
                    lastCountedCell = cell
                }
            }
            // if there's only one possible cell for said value
            if (count == 1) {
                if (lastCountedCell!!.valueAssigned()) throw(Exception("trying to fill cell with a value already assigned"))

                // fill cell
                insertNumber(i, lastCountedCell)
            }
        }


    }

    fun fillCellByOnlyPossibleValueForCell(sudokuCell: SudokuCell){

        loadPossibleValues()

        // fill by only possible value in cell
        for (cell in cells) {
            if (cell.possibleValues.size == 1) {
                if (cell.valueAssigned()) throw(Exception("trying to fill cell with a value already assigned"))
                insertNumber(cell.possibleValues[0], cell)
            }
        }
    }

    fun fillCells(){
        for (cell in cells) {
            fillCellByOnlyPossibleValueForCell(cell)
        }
        for (cellGroup in getAllCellGroups()) {
            fillCellGroupByOnlyPossibleCellForValue(cellGroup)
        }
    }

    fun countUnsolvedCells(): Int {
        var unsolvedCells = 0

        for (cell in cells) {
            if (cell.finalValue in 1..9) {
                unsolvedCells++
            }
        }

        return unsolvedCells
    }

    fun solved(): Boolean {
        return countUnsolvedCells() == 0
    }

    fun solve() {
        while (!solved()) {
            fillCells()
        }
    }

    fun selectCell(row: Int, column: Int) {
        for (cell in cells) {
            cell.selected = false
        }
        getCell(row, column).selected = true
    }

    fun selectedCell(): SudokuCell? {
        var selectedCell: SudokuCell? = null
        for (cell in cells) {
            if (cell.selected) selectedCell = cell
        }

        return selectedCell

    }

    fun insertNumber (number: Int, cell: SudokuCell?) {
        cell?.let { it.finalValue = number }
        loadPossibleValues()
    }

}