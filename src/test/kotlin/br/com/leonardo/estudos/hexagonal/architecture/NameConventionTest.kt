package br.com.leonardo.estudos.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes

@AnalyzeClasses(packages = ["br.com.leonardo.estudos.hexagonal"])
class NameConventionTest {

    @ArchTest
    val `consumer classes must reside only in consumer packages` = classes()
        .that().haveSimpleNameEndingWith("Consumer")
        .should().resideInAPackage("..adapters.in..consumer")
        .`as`("Classes ending with Consumer must reside in consumer package")

    @ArchTest
    val `response classes must reside only in response packages (in or out)` = classes()
        .that().haveSimpleNameEndingWith("Response")
        .should().resideInAnyPackage("..adapters.in.api.response", "..adapters.out.client.response..")
        .`as`("Classes ending with Response must reside in response package (in/out)")

    @ArchTest
    val `should be suffixed  by Consumer` = classes()
        .that().resideInAPackage("..adapters.in..consumer")
        .should().haveSimpleNameEndingWith("Consumer")

    @ArchTest
    val `should be suffixed  by Message` = classes()
        .that().resideInAPackage("..adapters.in..message")
        .should().haveSimpleNameEndingWith("Message")

}