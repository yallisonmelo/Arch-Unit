package br.com.yfsmsystem.archunit.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "br.com.yfsmsystem.archunit")
public class VerifyPackagesRulesTests {

    @ArchTest
    public static final ArchRule verifyClassesAnnotatedWithServiceMustStayInServicePackage = classes()
            .that().areAnnotatedWith(Service.class)
            .should().resideInAPackage("..service..")
            .as("Classes annotated with @Service must be in the 'service' package.");

    @ArchTest
    public static final ArchRule verifyClassesAnnotatedWithControllerMustStayInControllerPackage = classes()
            .that().areAnnotatedWith(RestController.class)
            .should().resideInAPackage("..controller..")
            .as("Classes annotated with @Controller must be in the 'controller' package.");

}