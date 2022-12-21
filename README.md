## Hide DB Credentials

There are two ways to hide the DB credentials in the application.properties file
  
### Store the Credentials in the System Environment Variables

The dbuser and dbpassword are system variables that store the real credential in the System

```
spring.datasource.username=${dbuser}
spring.datasource.password=${dbpassword}
```

### Encrypt the Credentials using Jasypt (Java Simplified Encryption)

Jasypt (Java Simplified Encryption), provides encryption support for property sources in Spring Boot Applications.

#### Step 1: Add maven dependency of jasypt in pom.xml 

```
<!-- https://mvnrepository.com/artifact/com.github.ulisesbocchio/jasypt-spring-boot-starter -->
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>3.0.4</version>
</dependency>

<plugin>
	<groupId>com.github.ulisesbocchio</groupId>
	<artifactId>jasypt-maven-plugin</artifactId>
	<version>3.0.4</version>
</plugin>
```

#### Step 2: Update the application.properties
Add the following Jasypt properties

```

spring.datasource.username=DEC(your-username)
spring.datasource.password=DEC(your-password)
jasypt.encryptor.iv-generator-classname=org.jasypt.iv.NoIvGenerator
jasypt.encryptor.algorithm=PBEWithMD5AndDES
jasypt.encryptor.password=techjava
jasypt.encryptor.keyObtentionIterations=1000
jasypt.encryptor.poolSize=1
jasypt.encryptor.providerName=SunJCE
jasypt.encryptor.saltGeneratorClassname=org.jasypt.salt.RandomSaltGenerator
jasypt.encryptor.stringOutputType=base64
```

DEC(your-username)
DEC(your-password)

Will be encrypted using the Jasypt algoritm by running the following command:

```
mvn jasypt:encrypt -Djasypt.encryptor.password=techjava
```

And change to:

spring.datasource.username=ENC(OQU5p/cR6Sw946szK78WWQ==)
spring.datasource.password=ENC(4oGwVGAp1KtoOSMkez70/vnm4m5u2H7L)

ALT+CTRL+F [Indent File]

drop table mydb.players;

CREATE TABLE IF NOT EXISTS mydb.players(
	ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(40) UNIQUE NOT NULL,	
    SCORE INTEGER NOT NULL
)AUTO_INCREMENT=100;
alter table mydb.players
add RATING decimal(4,2)
generated always as (SCORE/20) stored;

INSERT INTO mydb.players (NAME, SCORE)
values
('Alen Jones',66),
('Ron Dex', 45),
('Amy Dentz', 50),
('Lucy Lam', 80),
('Adam Berts', 90),
('David Suiter', 35),
('Jess Jones', 72),
('Alex Carter', 88),
('Rony Dolton', 48),
('Alice Denis', 52),
('Lara Lin', 81),
('Aden Banner', 92),
('Dania Sutler', 39),
('Jessy James', 74),
('Alia Camil', 87),
('Ortega Gomez', 76),
('Lian Lyn', 89),
('Adonis Bas', 93),
('Daneka Semens', 32),
('Jasper James', 73),
('Amos Cahan', 86),
('Oliver Gotez',  77),
('Amir Baber', 93),
('Daisy Suns', 40),
('Jaime Julz', 71),
('Axel Castor', 86),
('Orelia Gomez', 76),
('Lena Lin', 90),
('Apolo Creed', 92),
('Damia Semar', 33),
('Jamal Jones', 72),
('Aria Calian', 85),
('Olena Golez', 77),
('Adolf Baits', 90),
('Dona Stone', 37),
('Julie Jaan', 71),
('Aster Cruz', 86),
('Lama Lyn', 89),
('Avihai Bronn', 90),
('Daspika Sola', 35),
('Jerom Jimms', 71),
('Akela Croft', 84),
('Olivia Priez', 76);

