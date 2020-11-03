package com.samuelpateixeira.sudokusolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samuelpateixeira.sudokusolver.SudokuSolver.Companion.sudokuGame
import com.samuelpateixeira.sudokusolver.classes.SudokuGame

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        var btn_solve = findViewById<Button>(R.id.btn_solve)
        var btn_clean = findViewById<Button>(R.id.btn_clean)
        var btn_insert_1 = findViewById<Button>(R.id.btn_insert_1)
        var btn_insert_2 = findViewById<Button>(R.id.btn_insert_2)
        var btn_insert_3 = findViewById<Button>(R.id.btn_insert_3)
        var btn_insert_4 = findViewById<Button>(R.id.btn_insert_4)
        var btn_insert_5 = findViewById<Button>(R.id.btn_insert_5)
        var btn_insert_6 = findViewById<Button>(R.id.btn_insert_6)
        var btn_insert_7 = findViewById<Button>(R.id.btn_insert_7)
        var btn_insert_8 = findViewById<Button>(R.id.btn_insert_8)
        var btn_insert_9 = findViewById<Button>(R.id.btn_insert_9)
        var btn_solve_by_only_possible_value_for_cell = findViewById<Button>(R.id.btn_solve_by_only_possible_value_for_cell)
        var btn_solve_by_only_possible_cell_for_value = findViewById<Button>(R.id.btn_solve_by_only_possible_cell_for_value)

        sudokuGame = SudokuGame()

        sudokuGame!!.getCell(1,1).finalValue = 9
        sudokuGame!!.getCell(1,7).finalValue = 5

        sudokuGame!!.getCell(2,2).finalValue = 2
        sudokuGame!!.getCell(2,3).finalValue = 1
        sudokuGame!!.getCell(2,4).finalValue = 7
        sudokuGame!!.getCell(2,8).finalValue = 8

        sudokuGame!!.getCell(3,4).finalValue = 4
        sudokuGame!!.getCell(3,5).finalValue = 9
        sudokuGame!!.getCell(3,8).finalValue = 7
        sudokuGame!!.getCell(3,9).finalValue = 3

        sudokuGame!!.getCell(5,1).finalValue = 1
        sudokuGame!!.getCell(5,7).finalValue = 6
        sudokuGame!!.getCell(5,8).finalValue = 3

        sudokuGame!!.getCell(6,1).finalValue = 5
        sudokuGame!!.getCell(6,3).finalValue = 4
        sudokuGame!!.getCell(6,6).finalValue = 2
        sudokuGame!!.getCell(6,9).finalValue = 1

        sudokuGame!!.getCell(7,4).finalValue = 9

        sudokuGame!!.getCell(8,2).finalValue = 6
        sudokuGame!!.getCell(8,5).finalValue = 2
        sudokuGame!!.getCell(8,7).finalValue = 3

        sudokuGame!!.getCell(9,1).finalValue = 8
        sudokuGame!!.getCell(9,3).finalValue = 3

        recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
        recyclerView.layoutManager = GridLayoutManager(this, 9)

        btn_solve.setOnClickListener {
            sudokuGame!!.solve()
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }

        btn_solve_by_only_possible_cell_for_value.setOnClickListener {
            for (cellgroup in sudokuGame!!.getAllCellGroups()){
                sudokuGame!!.fillCellGroupByOnlyPossibleCellForValue(cellgroup)
            }
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }

        btn_solve_by_only_possible_value_for_cell.setOnClickListener {
            for (cell in sudokuGame!!.cells) {
                sudokuGame!!.fillCellByOnlyPossibleValueForCell(cell)
            }
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }

        btn_clean.setOnClickListener {
            sudokuGame = SudokuGame()
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }

        btn_insert_1.setOnClickListener { sudokuGame!!.insertNumber(1, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_2.setOnClickListener { sudokuGame!!.insertNumber(2, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_3.setOnClickListener { sudokuGame!!.insertNumber(3, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_4.setOnClickListener { sudokuGame!!.insertNumber(4, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_5.setOnClickListener { sudokuGame!!.insertNumber(5, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_6.setOnClickListener { sudokuGame!!.insertNumber(6, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_7.setOnClickListener { sudokuGame!!.insertNumber(7, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_8.setOnClickListener { sudokuGame!!.insertNumber(8, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }
        btn_insert_9.setOnClickListener { sudokuGame!!.insertNumber(9, sudokuGame!!.selectedCell())
            recyclerView.adapter = SudokuAdapter(this, sudokuGame!!.getOrderedCells())
            recyclerView.layoutManager = GridLayoutManager(this, 9)
        }


    }
}