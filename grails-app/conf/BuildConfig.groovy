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
		String tomcatVersion = '8.0.0-RC10'

//		build "org.apache.tomcat:tomcat-catalina-ant:$tomcatVersion"

		compile "org.apache.tomcat.embed:tomcat-embed-core:$tomcatVersion"

		runtime "org.apache.tomcat.embed:tomcat-embed-jasper:$tomcatVersion"

		runtime "org.apache.tomcat.embed:tomcat-embed-logging-log4j:$tomcatVersion"

		runtime "org.apache.tomcat.embed:tomcat-embed-logging-juli:$tomcatVersion"

		compile 'javax.servlet:javax.servlet-api:3.1.0'

		// needed for JSP compilation
		runtime 'org.eclipse.jdt.core.compiler:ecj:4.2.2'
	}

	plugins {
		build ':release:3.0.1', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}
