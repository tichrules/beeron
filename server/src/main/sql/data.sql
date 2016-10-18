DELETE FROM PERSON;
DELETE FROM LOCATION;
INSERT INTO PERSON(NAME, ACTING) VALUES ('Ragnar', 2);
INSERT INTO PERSON(NAME, ACTING) VALUES ('Lagertha', 4);
INSERT INTO PERSON(NAME, ACTING) VALUES ('Bjorn', 3);
INSERT INTO PERSON(NAME, ACTING) VALUES ('Floki', 5);
INSERT INTO PERSON(NAME, ACTING) VALUES ('Rollo', 5);
INSERT INTO PERSON(NAME, ACTING) VALUES ('Ecbert', 7);

INSERT INTO LOCATION(NAME) VALUES ('Denmark');
INSERT INTO LOCATION(NAME) VALUES ('Wessex');
INSERT INTO LOCATION(NAME) VALUES ('Northumbria');
INSERT INTO LOCATION(NAME) VALUES ('France');

INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Ragnar'), (SELECT ID FROM LOCATION WHERE NAME='Denmark'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Ragnar'), (SELECT ID FROM LOCATION WHERE NAME='Wessex'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Ragnar'), (SELECT ID FROM LOCATION WHERE NAME='Northumbria'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Ragnar'), (SELECT ID FROM LOCATION WHERE NAME='Northumbria'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Lagertha'), (SELECT ID FROM LOCATION WHERE NAME='Denmark'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Bjorn'), (SELECT ID FROM LOCATION WHERE NAME='Denmark'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Bjorn'), (SELECT ID FROM LOCATION WHERE NAME='France'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Floki'), (SELECT ID FROM LOCATION WHERE NAME='Denmark'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Floki'), (SELECT ID FROM LOCATION WHERE NAME='Northumbria'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Rollo'), (SELECT ID FROM LOCATION WHERE NAME='Denmark'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Rollo'), (SELECT ID FROM LOCATION WHERE NAME='France'));
INSERT INTO PERSON_WAS_IN_LOCATION(PERSON_ID, LOCATION_ID) VALUES ((SELECT ID FROM PERSON WHERE NAME='Ecbert'), (SELECT ID FROM LOCATION WHERE NAME='Wessex'));
commit;