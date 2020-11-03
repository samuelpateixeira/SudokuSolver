package com.samuelpateixeira.sudokusolver

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samuelpateixeira.sudokusolver.R.*
import com.samuelpateixeira.sudokusolver.classes.SudokuCell

class SudokuAdapter(var context: Context, var cells: ArrayList<SudokuCell>) : RecyclerView.Adapter<SudokuAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var field = itemView.findViewById<TextView>(id.field)
        var viewGroup = itemView.findViewById<LinearLayout>(id.viewGroup)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(layout.sudoku_cell, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cells.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        var currentCell = cells[position]
        if (currentCell.finalValue in 1..9) {
            holder.field.text = currentCell.finalValue.toString()
        } else holder.field.text = ""

        if (currentCell.selected) {
            holder.viewGroup.setBackgroundColor(context.resources.getColor(color.purple_200))
        }

        holder.viewGroup.setOnClickListener{
            SudokuSolver.sudokuGame!!.selectCell(currentCell.row, currentCell.column)
            notifyDataSetChanged()
        }

    }

}
