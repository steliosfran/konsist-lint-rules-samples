package com.steliosf.konsist.rules

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.imports
import com.lemonappdev.konsist.api.verify.assertFalse
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extension

@ExtendWith(Extension::class)
class DomainLayerDoesNotDependOnDTOs : BehaviorSpec() {

    init {
        Given("All files in the domain module") {
            val domainModuleFiles = Konsist.scopeFromDirectory("domain").files

            Then("They do not access DTOs") {
                domainModuleFiles.imports.assertFalse {
                    it.hasNameStartingWith("com.steliosf.dto")
                }
            }
        }
    }
}
