package com.example.archunitsample;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packagesOf = ArchunitSampleApplication.class)
class ArchitectureTest {
	// 1. application, domain에서는 외부 패키지 호출이 불가하다.
	@ArchTest
	public static final ArchRule domainDependencyRule = noClasses()
		.that().resideInAnyPackage("..application..", "..domain..")
		.should().accessClassesThat().resideInAPackage("..adapter..");

	// 2. persistence.entity 패키지는 persistence 패키지 내에서만 사용된다.
	@ArchTest
	public static final ArchRule persistenceEntityIsolationRule = classes()
		.that().resideInAnyPackage("..out.persistence.entity..")
		.should().onlyBeAccessed().byAnyPackage("..out.persistence..");

	// 3. port.in 패키지의 클래스는 adapter.in 패키지에서 의존한다.
	@ArchTest
	public static final ArchRule inputPortDependencyRule = classes()
		.that().resideInAPackage("..application.port.in..")
		.should().onlyAccessClassesThat().resideInAPackage("..adapter.in..");

	// 4. port.out 패키지의 클래스는 application.service 패키지에서 의존한다.
	@ArchTest
	public static final ArchRule outputPortDependencyRule = classes()
		.that().resideInAnyPackage("..application.port.out..")
		.should().onlyAccessClassesThat().resideInAnyPackage("..application.service..");
}
