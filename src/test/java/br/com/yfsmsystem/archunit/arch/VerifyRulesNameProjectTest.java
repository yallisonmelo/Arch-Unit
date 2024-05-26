package br.com.yfsmsystem.archunit.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "br.com.yfsmsystem.archunit")
public class VerifyRulesNameProjectTest {

    @ArchTest
    public static final ArchRule verifyNameClassesControllers = classes()
            .that().areAnnotatedWith(RestController.class)
            .should().haveSimpleNameEndingWith("Controller")
            .as("Classes annotated with @RestController must have the suffix Controller in your name");


    @ArchTest
    public static final ArchRule verifyNameServices = classes()
            .that().areAnnotatedWith(Service.class)
            .should().haveSimpleNameEndingWith("Service")
            .andShould().haveSimpleNameNotEndingWith("ServiceImpl")
            .as("Classes annotated with @Service must have the suffix Service or ServiceImpl in your name");


}


