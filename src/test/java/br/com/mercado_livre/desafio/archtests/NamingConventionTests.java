package br.com.mercado_livre.desafio.archtests;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "br.com.mercado_livre.desafio", importOptions = { ImportOption.DoNotIncludeTests.class })
public class NamingConventionTests {

    @ArchTest
    ArchRule controllers_should_be_suffixed =
            classes()
                    .that()
                    .areNotAnonymousClasses()
                    .and()
                    .resideInAPackage("..adapters.http.rest.v1.controllers..")
                    .should()
                    .haveSimpleNameEndingWith("Controller");

    @ArchTest
    ArchRule middlewares_should_be_suffixed =
            classes()
                    .that()
                    .resideInAPackage("..adapters.http.rest.v1.middlewares..")
                    .should()
                    .haveSimpleNameEndingWith("Middleware");

    @ArchTest
    ArchRule mappers_should_be_suffixed =
            classes()
                    .that()
                    .resideInAPackage("..mappers")
                    .should()
                    .haveSimpleNameEndingWith("Mapper")
                    .orShould()
                    .haveSimpleNameEndingWith("MapperImpl");

    @ArchTest
    ArchRule usecases_should_be_suffixed =
            classes()
                    .that()
                    .resideInAPackage("..core.usecases")
                    .should()
                    .haveSimpleNameEndingWith("UseCase")
                    .orShould()
                    .haveSimpleNameEndingWith("UseCaseImpl");

    @ArchTest
    ArchRule entities_should_be_suffixed =
            classes()
                    .that()
                    .resideInAPackage("..core.domain.entities")
                    .should()
                    .haveSimpleNameEndingWith("Entity")
                    .orShould()
                    .haveSimpleNameEndingWith("EntityBuilder");

    @ArchTest
    ArchRule ports_should_be_suffixed =
            classes()
                    .that()
                    .resideInAPackage("..core.domain.ports")
                    .should()
                    .haveSimpleNameEndingWith("Port");

    @ArchTest
    ArchRule dataProviders_should_be_suffixed =
            classes()
                    .that()
                    .resideInAPackage("..adapters.gateways")
                    .should()
                    .haveSimpleNameEndingWith("Gateway");
}