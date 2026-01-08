# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## 1.1.15

### Changed

- aligned maven wrapper config and removed unneeded jacoco config in pom.xml

## 1.1.14

### Changed

- Update postgres from 15.14 to 15.15
- Update com.diffplug.spotless:spotless-maven-plugin from 3.0.0 to 3.1.0
- Update org.jacoco:jacoco-maven-plugin from 0.8.13 to 0.8.14
- Update ch.admin.bit.jeap:jeap-spring-boot-parent from 27.2.0 to 28.3.0


## 1.1.13

### Changed

- Update maven from 3.9.10 to 3.9.11
- Update maven-wrapper from 3.3.2 to 3.3.4
- Update maven-wrapper from 3.3.2 to 3.3.4
- Update maven-wrapper from 3.3.2 to 3.3.4
- Update postgres from 15.13 to 15.14
- Update org.apache.maven.plugins:maven-surefire-plugin from 3.5.2 to 3.5.4
- Update org.apache.maven.plugins:maven-compiler-plugin from 3.14.0 to 3.14.1
- Update com.diffplug.spotless:spotless-maven-plugin from 2.45.0 to 3.0.0
- Update ch.admin.bit.jeap:jeap-spring-boot-parent from 26.68.0 to 27.2.0



## 1.1.12

### Other

- Added tests confirming that endpoints only expose datastore entries with status ACTIVE

## 1.1.11

### Changed

- Update maven from 3.9.9 to 3.9.10
- Update com.diffplug.spotless:spotless-maven-plugin from 2.44.4 to 2.45.0
- Update ch.admin.bit.jeap:jeap-spring-boot-parent from 26.50.1 to 26.68.0


## 1.1.10

### Other

- Downgrade maven-surefire-plugin due to archunit incompatibility	

## 1.1.9

### Other

- Update Interface Summaries

## 1.1.8

### Changed

- Update org.apache.maven.plugins:maven-surefire-plugin from 3.5.2 to 3.5.3
- Update ch.admin.bit.jeap:jeap-spring-boot-parent from 26.50.0 to 26.50.1


## 1.1.7

### Changed

- Downgrade maven-sunfire-plugin due to archunit incompatibility

## 1.1.6

### Changed

- Update maven from 3.9.6 to 3.9.9
- Update postgres from 15.8 to 15.13
- Update org.apache.maven.plugins:maven-compiler-plugin from 3.12.1 to 3.14.0
- Update com.tngtech.archunit:archunit-junit5 from 1.4.0 to 1.4.1
- Update org.jacoco:jacoco-maven-plugin from 0.8.9 to 0.8.13
- Update ch.admin.bit.jeap:jeap-spring-boot-parent from 26.48.0 to 26.50.0

## 1.1.5

### Other

- Added spotless plugin

## 1.1.4

### Changed

- dependency updates (jeap)

## 1.1.3

### Fixed

- fixed api description of /api/v1/statuslist

## 1.1.2

### Changed

- internal improvements for local development

## 1.1.1

### Changed

- jeapyfied service according to checklist

## 1.1.0

### Added

- Extending prometheus export with metrics for build

## 1.0.0

- Initial Release 
