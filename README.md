# Overview

Parent project that holds module projects for the persistence of resource system data.

The project holds backend data for all kind of resources like images and file management.

# ERD-Diagramm

The erd-diagramm for this database looks as follows: ![erd-diagramm](https://github.com/lightblueseas/resource-system-data/blob/develop/resource-system-init/src/main/resources/erd/erd-diagramm-resourcesystem.png)

This erd-diagramm was created with the awesome [SQuirreL SQL Client](http://squirrel-sql.sourceforge.net/)

## License

The source code comes under the liberal MIT License, making resource-system-data great for all types of applications that handles resources.

# Build status
[![Build Status](https://travis-ci.org/lightblueseas/resource-system-data.svg?branch=master)](https://travis-ci.org/lightblueseas/resource-system-data)

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/resource-system-data/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/resource-system-data)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~resource-system-data~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- resource-system-data version -->
		<resource-system-data.version>3.12.0</resource-system-data.version>
		<resource-system-business.version>${resource-system-data.version}</resource-system-business.version>
		<resource-system-domain.version>${resource-system-data.version}</resource-system-domain.version>
		<resource-system-entities.version>${resource-system-data.version}</resource-system-entities.version>
		<resource-system-init.version>${resource-system-data.version}</resource-system-init.version>
		<resource-system-rest-api.version>${resource-system-data.version}</resource-system-rest-api.version>
		<resource-system-rest-client.version>${resource-system-data.version}</resource-system-rest-client.version>
		<resource-system-rest-web.version>${resource-system-data.version}</resource-system-rest-web.version>
			...
	</properties>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of resource-system-business:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>resource-system-business</artifactId>
				<version>${resource-system-business.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of resource-system-domain:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>resource-system-domain</artifactId>
				<version>${resource-system-domain.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of resource-system-entities:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>resource-system-entities</artifactId>
				<version>${resource-system-entities.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of resource-system-init:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>resource-system-init</artifactId>
				<version>${resource-system-init.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of resource-system-rest-api:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>resource-system-rest-api</artifactId>
				<version>${resource-system-rest-api.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of resource-system-rest-client:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>resource-system-rest-client</artifactId>
				<version>${resource-system-rest-client.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of resource-system-rest-web:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>resource-system-rest-web</artifactId>
				<version>${resource-system-rest-web.version}</version>
			</dependency>
			...
		</dependencies>
		
		 
## Open Issues
[![Open Issues](https://img.shields.io/github/issues/astrapi69/resource-system-data.svg?style=flat)](https://github.com/astrapi69/resource-system-data/issues) 


## Want to Help and improve it? ###

The source code for resource-system-data are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/resource-system-data/fork](https://github.com/lightblueseas/resource-system-data/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/resource-system-data/pull/new/master).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the resource-system-data developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/resource-system-data/issues).

## Note

No animals were harmed in the making of this library.

# Donate

If you like this library, please consider a donation through 
<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fresource-system-data" target="_blank">
<img src="http://button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0">
</a>
