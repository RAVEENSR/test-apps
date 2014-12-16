--------------------------------------------------------------------
	JAX-RS Animal Demo 1.0.0 Service
	Author : Sanjeewa Malalgoda
--------------------------------------------------------------------

Run Sample
==========

01. Run mvn clean install in /Animal directory
02. Then it will create animal.war file. You need to deolpy it in application server.(cp target/animal.war /home/sanjeewa/work/packs/wso2as-5.2.1/repository/deployment/server/webapps/animal.war)
03. Open provided jmeter script with apache-jmeter 2.9 or above
04. Then run the script. It will do GET PUT POST DELETE operations.

This service expect following request format for animal.

<Animal>
   	<name>elephant</name>
   	<speciesName>Asian</speciesName>
	<worldPopulation>1000000</worldPopulation>
	<dateOfSpeciesIdentification>01-01-1800</dateOfSpeciesIdentification>
	<continentNames>
		<names>asian,african</names>
	</continentNames>
</Animal>
