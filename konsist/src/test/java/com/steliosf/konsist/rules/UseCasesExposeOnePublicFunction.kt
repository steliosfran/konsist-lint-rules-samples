package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.modifierprovider.withPublicOrDefaultModifier
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertFalse
import com.lemonappdev.konsist.api.verify.assertTrue
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class UseCasesExposeOnePublicFunction : BehaviorSpec() {

    init {
        Given("All classes in production code") {
            val classes = Konsist.scopeFromProduction().classes()

            When("There is a UseCase") {
                val useCases = classes.withNameEndingWith("UseCase")

                Then("It exposes a single public function") {
                    useCases.assertFalse {
                        it.functions().withPublicOrDefaultModifier().size > 1
                    }
                }

                Then("It does not expose any properties") {
                    useCases.properties().assertTrue {
                        it.hasPrivateModifier
                    }
                }
            }
        }
    }
}
