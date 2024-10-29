package br.com.leonardo.estudos.hexagonal.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.layeredArchitecture

@AnalyzeClasses(packages = ["br.com.leonardo.estudos.hexagonal"])
class LayerArchitectureTest {

    @ArchTest
    val `layered architecture teste` = layeredArchitecture().consideringAllDependencies()
        .layer("AdaptersIn").definedBy("..infrastructure.adapters.in..")
        .layer("AdaptersOut").definedBy("..infrastructure.adapters.out..")
        .layer("UseCase").definedBy("..application.core.usecase..")
        .layer("PortsIn").definedBy("..application.ports.in..")
        .layer("PortsOut").definedBy("..application.ports.out..")
        .layer("Config").definedBy("..infrastructure.config..")
        .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
        .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "AdaptersIn")
        .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
        .whereLayer("Config").mayNotBeAccessedByAnyLayer()
}