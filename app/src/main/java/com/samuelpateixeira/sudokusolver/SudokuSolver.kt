package com.samuelpateixeira.sudokusolver

import android.app.Application
import com.samuelpateixeira.sudokusolver.classes.SudokuGame


class SudokuSolver : Application() {

    companion object{
        var sudokuGame: SudokuGame? = null
    }
}
