package models

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Ingredients: Table() {
    val id: Column<Int> = integer("id").autoIncrement().primaryKey()
    val name: Column<String> = varchar("name", 100).uniqueIndex()
    val density: Column<Double> = double("density")
}

data class Ingredient(
    val id: Int,
    val name: String,
    val density: Double
)

data class NewIngredient(
    val name: String,
    val density: Double
)
