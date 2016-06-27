Audrey So

CREATE TABLE city (
    id integer NOT NULL,
    name text NOT NULL,
    countrycode character(3) NOT NULL,
    district text NOT NULL,
    population integer NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (id)
);
CREATE TABLE country (
    code character(3) NOT NULL,
    name text NOT NULL,
    continent text NOT NULL,
    region text NOT NULL,
    surfacearea real NOT NULL,
    indepyear smallint,
    population integer NOT NULL,
    lifeexpectancy real,
    gnp numeric(10,2),
    gnpold numeric(10,2),
    localname text NOT NULL,
    governmentform text NOT NULL,
    headofstate text,
    capital integer,
    code2 character(2) NOT NULL,
    CONSTRAINT country_continent_check CHECK ((((((((continent = 'Asia') OR (continent = 'Europe')) OR (continent = 'North America')) OR (continent = 'Africa')) OR (continent = 'Oceania')) OR (continent = 'Antarctica')) OR (continent = 'South America'))),
    CONSTRAINT country_pkey PRIMARY KEY (code),
    CONSTRAINT country_capital_fkey FOREIGN KEY (capital) REFERENCES city(id)
);
CREATE TABLE countrylanguage (
    countrycode character(3) NOT NULL,
    "language" text NOT NULL,
    isofficial boolean NOT NULL,
    percentage real NOT NULL,
    CONSTRAINT countrylanguage_pkey PRIMARY KEY (countrycode, "language"),
    CONSTRAINT countrylanguage_countrycode_fkey FOREIGN KEY (countrycode) REFERENCES country(code)
);


code|name|continent|region|surfacearea|indepyear|population|lifeexpectancy|gnp|gnpold|localname|governmentform|headofstate|capital|code2


-- Clue #1: We recently got word that someone fitting Carmen Sandiego's description has been
-- traveling through Southern Europe. She's most likely traveling someplace where she won't be noticed,
-- so find the least populated country in Southern Europe, and we'll start looking for her there.

SELECT name from country WHERE region LIKE 'Southern Europe' ORDER BY population;

Holy See (Vatican City State)


SELECT code from country WHERE name like 'Holy%';

VAT

-- Clue #2: Now that we're here, we have insight that Carmen was seen attending language classes in
-- this country's officially recognized language. Check our databases and find out what language is
-- spoken in this country, so we can call in a translator to work with you.

Parameters for countrylanguage = countrycode|language|isofficial|percentage

sqlite> SELECT isofficial FROM countrylanguage WHERE countrycode LIKE 'VAT';
t
sqlite> SELECT isofficial FROM countrylanguage WHERE countrycode LIKE 'VAT' ORDER BY language;
t
sqlite> SELECT language from countrylanguage where countrycode like 'VAT';
Italian


Italian


-- Clue #3: We have new news on the classes Carmen attended – our gumshoes tell us she's moved on
-- to a different country, a country where people speak only the language she was learning. Find out which
--  nearby country speaks nothing but that language.

SELECT * FROM countrylanguage where language LIKE 'Italian';

SMR|Italian|t|100.0

SELECT * FROM country where code LIKE 'SMR';
SMR|San Marino|Europe|Southern Europe|61.0|885|27000|81.099998|510|\N|San Marino|Republic|\N|3171|SM

San Marino

-- Clue #4: We're booking the first flight out – maybe we've actually got a chance to catch her this time.
 -- There are only two cities she could be flying to in the country. One is named the same as the country – that
 -- would be too obvious. We're following our gut on this one; find out what other city in that country she might
 --  be flying to.

 SELECT * FROM city where countrycode LIKE 'SMR';
3170|Serravalle|SMR|Serravalle/Dogano|4802

Serravalle



-- Clue #5: Oh no, she pulled a switch – there are two cities with very similar names, but in totally different
-- parts of the globe! She's headed to South America as we speak; go find a city whose name is like the one we were
-- headed to, but doesn't end the same. Find out the city, and do another search for what country it's in. Hurry!

SELECT * FROM city where name LIKE 'Serr%';
265|Serra|BRA|Esp�rito Santo|302666

SELECT * FROm country where code LIKE 'BRA';
BRA|Brazil|South America|South America|8547403.0|1822|170115000|62.900002|776739|804108|Brasil|Federal Republic|Fernando Henrique Cardoso|211|BR
sqlite> 

Brazil



-- Clue #6: We're close! Our South American agent says she just got a taxi at the airport, and is headed towards
 -- the capital! Look up the country's capital, and get there pronto! Send us the name of where you're headed and we'll
 -- follow right behind you!

SELECT * FROM country where code LIKE 'BRA';
BRA|Brazil|South America|South America|8547403.0|1822|170115000|62.900002|776739|804108|Brasil|Federal Republic|Fernando Henrique Cardoso|211|BR
sqlite> 

Capital  # 211

sqlite> SELECT * FROM city where id LIKE '211';
211|Bras�lia|BRA|Distrito Federal|1969868


-- Clue #7: She knows we're on to her – her taxi dropped her off at the international airport, and she beat us to
 -- the boarding gates. We have one chance to catch her, we just have to know where she's heading and beat her to the
 -- landing dock.

-- Clue #8: Lucky for us, she's getting cocky. She left us a note, and I'm sure she thinks she's very clever, but
-- if we can crack it, we can finally put her where she belongs – behind bars.

-- Our play date of late has been unusually fun –
-- As an agent, I'll say, you've been a joy to outrun.
-- And while the food here is great, and the people – so nice!
-- I need a little more sunshine with my slice of life.
-- So I'm off to add one to the population I find
-- In a city of ninety-one thousand and now, eighty five.


-- We're counting on you, gumshoe. Find out where she's headed, send us the info, and we'll be sure to meet her at the gates with bells on.

SELECT * FROM city where population = 91084;
4060|Santa Monica|USA|California|91084

-- She's in ________Santa Monica, CA____________________!
