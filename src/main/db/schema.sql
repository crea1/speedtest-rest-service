CREATE TABLE IF NOT EXISTS testen (
  id serial,
  brand varchar(32) NOT NULL,
  model varchar(32) NOT NULL,
  model_year varchar(4) NOT NULL,
  engine_cc varchar(5) NOT NULL,
  hp int NOT NULL,
  nm int,
  weight	 varchar(5) NOT NULL,
  passengers_num int NOT NULL,
  speed int NOT NULL,
  road_conditions varchar(32) NOT NULL,
  test_year varchar(4) NOT NULL,
  driver varchar(32) NOT NULL,
  PRIMARY KEY (id)
);
