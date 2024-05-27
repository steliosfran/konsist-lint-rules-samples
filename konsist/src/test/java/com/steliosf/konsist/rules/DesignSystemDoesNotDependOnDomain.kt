package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.imports
import com.lemonappdev.konsist.api.verify.assertFalse
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class DesignSystemDoesNotDependOnDomain : BehaviorSpec() {

    init {
        Given("All files in the design system module") {
            val designSystemFiles = Konsist.scopeFromDirectory("design-system").files

            Then("They do not access the domain layer") {
                designSystemFiles.imports.assertFalse {
                    it.hasNameStartingWith("com.steliosf.domain")
                }
            }
        }
    }
}
