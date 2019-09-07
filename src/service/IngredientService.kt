package service


import it.tejpb.cookit.DatabaseFactory.dbQuery
import models.Ingredient
import models.Ingredients
import models.NewIngredient
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll


class IngredientService {

    suspend fun getAllIngredients(): List<Ingredient> = dbQuery {
        Ingredients.selectAll().map { toIngredient(it) }
    }

    suspend fun getIngredientByName(name: String): Ingredient? = dbQuery {
        Ingredients.select {
            (Ingredients.name eq name)
        }.mapNotNull { toIngredient(it) }
            .singleOrNull()
    }

    private fun toIngredient(row: ResultRow): Ingredient =
        Ingredient(
            id = row[Ingredients.id],
            name = row[Ingredients.name],
            density = row[Ingredients.density]
        )

    suspend fun createIngredient(newIngredient: NewIngredient) = dbQuery {
        Ingredients.insert {
            it[name] = newIngredient.name
            it[density] = newIngredient.density
        }
    }
}
