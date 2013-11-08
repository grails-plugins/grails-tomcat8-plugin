grails.project.work.dir = 'target'

grails.project.dependency.resolver = "maven"

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {
		String tomcatVersion = '8.0.0-RC5'

		runtime("org.apache.tomcat:tomcat-catalina-ant:$tomcatVersion") {
			excludes 'tomcat-catalina', 'tomcat-coyote'
		}

		compile "org.apache.tomcat.embed:tomcat-embed-core:$tomcatVersion", {
			excludes 'tomcat-embed-logging-juli', 'tomcat-embed-logging-log4j'
		}
		runtime "org.apache.tomcat.embed:tomcat-embed-jasper:$tomcatVersion", {
			excludes 'ecj', 'tomcat-embed-core'
		}
		runtime "org.apache.tomcat.embed:tomcat-embed-logging-log4j:$tomcatVersion"
		runtime "org.apache.tomcat.embed:tomcat-embed-logging-juli:$tomcatVersion"

		compile 'javax.servlet:javax.servlet-api:3.1.0'

		// needed for JSP compilation
		runtime 'org.eclipse.jdt.core.compiler:ecj:4.2.2'
	}

	plugins {
		build ':release:3.0.0', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}
