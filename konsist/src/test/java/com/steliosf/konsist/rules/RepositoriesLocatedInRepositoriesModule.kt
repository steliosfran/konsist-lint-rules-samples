package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class RepositoriesLocatedInRepositoriesModule : BehaviorSpec() {

    init {
        Given("All classes in production code") {
            val classes = Konsist.scopeFromProduction().classes()

            When("There is a Repository") {
                val repositories = classes.withNameEndingWith("Repository")

                Then("It is located in the repositories module") {
                    repositories.assertTrue {
                        it.resideInModule("data/repository")
                    }
                }
            }
        }
    }
}
