CREATE TABLE USER (
  ID         INTEGER PRIMARY KEY,
  FIRST_NAME VARCHAR(30),
  LAST_NAME VARCHAR(30),
  DISPLAY_NAME VARCHAR(30),
  EMAIL  VARCHAR(50),
  PASSWORD VARCHAR(30)
);

CREATE TABLE EXERCISE_TYPE (
  NAME VARCHAR(30) PRIMARY KEY,
  DESCRIPTION VARCHAR
);

CREATE TABLE SET (
  SEQUENCE_NUMBER INTEGER,
  DATE DATE,
  USER_ID INTEGER,
  EX_TYPE VARCHAR(30),
  REPS INTEGER,
  WEIGHT DOUBLE,
  TIME INTEGER,
  DISTANCE DOUBLE,
  FOREIGN KEY (USER_ID) REFERENCES USER(ID),
  FOREIGN KEY (EX_TYPE) REFERENCES EXERCISE_TYPE(NAME),
  PRIMARY KEY (SEQUENCE_NUMBER, DATE, USER_ID, EX_TYPE)
);