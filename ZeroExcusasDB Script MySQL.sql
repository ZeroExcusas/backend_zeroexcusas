CREATE DATABASE zeroexcusas1;

CREATE TABLE zeroexcusas1.gender (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL
);

CREATE TABLE zeroexcusas1.country (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
  phonecode VARCHAR ( 50 ) UNIQUE NOT NULL
);

CREATE TABLE zeroexcusas1.goal (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	description VARCHAR ( 150 )
);

CREATE TABLE zeroexcusas1.activitylevel (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	description VARCHAR ( 150 )
);

CREATE TABLE zeroexcusas1.traininglevel (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL,
	description VARCHAR ( 150 )
);

CREATE TABLE zeroexcusas1.trainingplace (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	description VARCHAR ( 150 )
);

CREATE TABLE zeroexcusas1.trainingfocus (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	description VARCHAR ( 150 )
);

create table zeroexcusas1.user(
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NUll,
datecreated DATETIME NOT NULL,
username VARCHAR(50) UNIQUE,
email VARCHAR(50) NOT NULL,
password VARCHAR(200) NOT NULL,
profileimage VARCHAR(500),
phone VARCHAR(20),
birthday DATETIME NOT NULL,
biography VARCHAR(500),
dateleft DATETIME,
devicetoken VARCHAR(200),
subscribed boolean,
phoneverified boolean,
calories real,
bmr real,
bmractivity real,
macroprotein real,
macrofat real,
macrocarbohydrate real,
trainingdays int,
trainingduration int,
fk_gender int NOT NULL,
fk_country int NOT NULL,
fk_goal int NOT NULL,
fk_trainingplace int NOT NULL,
fk_trainingfocus int NOT NULL,
fk_traininglevel int NOT NULL,
fk_activitylevel int NOT NULL,
FOREIGN KEY (fk_gender)
REFERENCES gender (id),
FOREIGN KEY (fk_goal)
REFERENCES goal (id),
FOREIGN KEY (fk_country)
REFERENCES country (id),
FOREIGN KEY (fk_activitylevel)
REFERENCES activitylevel (id),
FOREIGN KEY (fk_traininglevel)
REFERENCES traininglevel (id),
FOREIGN KEY (fk_trainingplace)
REFERENCES trainingplace (id),
FOREIGN KEY (fk_trainingfocus)
REFERENCES trainingfocus (id)
      );

CREATE TABLE zeroexcusas1.suggestion (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	description VARCHAR ( 150 ),
  date DATETIME NOT NULL,
    fk_user int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id)
);

CREATE TABLE zeroexcusas1.invitation (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR ( 50 ) NOT NULL,
    date DATETIME NOT NULL,
    status boolean,
    fk_user int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id)
);

CREATE TABLE zeroexcusas1.notification (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	description VARCHAR ( 150 ) NOT NULL,
    date DATETIME NOT NULL,
    checked boolean,
    deleted boolean NOT NULL,
    fk_user int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id)
);

CREATE TABLE zeroexcusas1.progress (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    description VARCHAR ( 150 ),
    fk_user int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id)
);

CREATE TABLE zeroexcusas1.progresspicture (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    url VARCHAR ( 500 ) NOT NULL,
    fk_progress int NOT NULL,
    FOREIGN KEY (fk_progress)
      REFERENCES progress (id)
);

CREATE TABLE zeroexcusas1.unit (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    value real NOT NULL,
    type VARCHAR ( 50 ) NOT NULL,
    date DATETIME NOT NULL,
    systemunit VARCHAR ( 50 ) NOT NULL,
    fk_user int,
    fk_progress int,
    FOREIGN KEY (fk_user)
      REFERENCES user (id),
    FOREIGN KEY (fk_progress)
      REFERENCES progress (id)      
);

CREATE TABLE zeroexcusas1.mealbuilder (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    datecreated DATETIME NOT NULL,
    datemodified DATETIME,
    dateschedule DATETIME,
    numberofmeals int NOT NULL,
    completed boolean,
    editable boolean,
    waterconsumed real NOT NULL,
    calories real NOT NULL,
    fk_user int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id)      
);

CREATE TABLE zeroexcusas1.meal (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    datecreated DATETIME NOT NULL,
    datemodified DATETIME,
    completed boolean,
    deleted boolean NOT NULL,
    waterconsumed real NOT NULL,
    calories real NOT NULL,
    fk_mealbuilder int NOT NULL,
    FOREIGN KEY (fk_mealbuilder)
      REFERENCES mealbuilder (id)      
);

CREATE TABLE zeroexcusas1.nutrientclass (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE zeroexcusas1.basicunit (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE zeroexcusas1.foodtype (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL,
    datecreated DATETIME NOT NULL,
    datemodified DATETIME,
    value real NOT NULL,
    deleted boolean NOT NULL,
    proteinperunitgram real,
    fatperunitgram real,
    carbohydrateperunitgram real,
    fk_nutrientclass int NOT NULL,
    fk_basicunit int NOT NULL,
    FOREIGN KEY (fk_nutrientclass)
      REFERENCES nutrientclass (id),
    FOREIGN KEY (fk_basicunit)
      REFERENCES basicunit (id)      
);

CREATE TABLE zeroexcusas1.allergy (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR ( 150 ),
    datecreated DATETIME NOT NULL,
    deleted boolean NOT NULL,
    fk_user int NOT NULL,
    fk_foodtype int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id),
    FOREIGN KEY (fk_foodtype)
      REFERENCES foodtype (id)      
);

CREATE TABLE zeroexcusas1.mealunit (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    amount real NOT NULL,
    date DATETIME NOT NULL,
    deleted boolean NOT NULL,
    fk_meal int NOT NULL,
    fk_foodtype int NOT NULL,
    FOREIGN KEY (fk_meal)
      REFERENCES meal (id),
    FOREIGN KEY (fk_foodtype)
      REFERENCES foodtype (id)      
);

CREATE TABLE zeroexcusas1.program (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR ( 150 ),
    datecreated DATETIME NOT NULL,
    deleted boolean NOT NULL,
    url VARCHAR ( 500 ),
    days int NOT NULL,
    weeks int NOT NULL,
    fk_trainingplace int NOT NULL,
    fk_trainingfocus int NOT NULL,
    fk_traininglevel int NOT NULL,
    FOREIGN KEY (fk_trainingplace)
      REFERENCES trainingplace (id),
    FOREIGN KEY (fk_trainingfocus)
      REFERENCES trainingfocus (id), 
    FOREIGN KEY (fk_traininglevel)
      REFERENCES traininglevel (id)   
);

CREATE TABLE zeroexcusas1.week (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR ( 150 ),
    datecreated DATETIME NOT NULL,
    deleted boolean NOT NULL,
    fk_program int NOT NULL,
    FOREIGN KEY (fk_program)
      REFERENCES program (id)     
);

CREATE TABLE zeroexcusas1.userprogramlog (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    datecreated DATETIME NOT NULL,
    completed boolean NOT NULL,
    fk_user int NOT NULL,
    fk_program int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id),
    FOREIGN KEY (fk_program)
      REFERENCES program (id)
);

CREATE TABLE zeroexcusas1.trainingday (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL,
    datecreated DATETIME NOT NULL,
    description VARCHAR ( 150 ) NOT NULL,
    deleted boolean NOT NULL
);

CREATE TABLE zeroexcusas1.weektrainingday (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    datecreated DATETIME NOT NULL,
    description VARCHAR ( 150 ) NOT NULL,
    day VARCHAR ( 50 ) NOT NULL,
    fk_week int NOT NULL,
    fk_trainingday int NOT NULL,
    FOREIGN KEY (fk_week)
      REFERENCES week (id),
    FOREIGN KEY (fk_trainingday)
      REFERENCES trainingday (id)
);

CREATE TABLE zeroexcusas1.comments (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    datecreated DATETIME NOT NULL,
    comment VARCHAR ( 400 ) NOT NULL,
    fk_user int NOT NULL,
    fk_traingday int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id),
    FOREIGN KEY (fk_traingday)
      REFERENCES trainingday (id)
);

CREATE TABLE zeroexcusas1.usertrainingdaylog (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    datecreated DATETIME NOT NULL,
    completed boolean NOT NULL,
    fk_user int NOT NULL,
    fk_traingday int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id),
    FOREIGN KEY (fk_traingday)
      REFERENCES trainingday (id)
);

CREATE TABLE zeroexcusas1.exercise (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR ( 150 ) NOT NULL,
    date DATETIME NOT NULL,
    url VARCHAR ( 500 ),
    fk_trainingfocus int NOT NULL,
    FOREIGN KEY (fk_trainingfocus)
      REFERENCES trainingfocus (id)
);

CREATE TABLE zeroexcusas1.trainingdayexercise (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    datecreated DATETIME NOT NULL,
    reps int NOT NULL,
    fk_traingday int NOT NULL,
    fk_exercise int NOT NULL,
    FOREIGN KEY (fk_traingday)
      REFERENCES trainingday (id),
    FOREIGN KEY (fk_exercise)
      REFERENCES exercise (id)
);

CREATE TABLE zeroexcusas1.trainingdaylog (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    rep int NOT NULL,
    weight int not NULL,
    fk_user int NOT NULL,
    fk_trainingdayexercise int NOT NULL,
    FOREIGN KEY (fk_user)
      REFERENCES user (id),
    FOREIGN KEY (fk_trainingdayexercise)
      REFERENCES trainingdayexercise (id)
);

CREATE TABLE zeroexcusas1.level (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL,
    description VARCHAR ( 150 ),
    date DATETIME NOT NULL,
    points int NOT NULL
);

CREATE TABLE zeroexcusas1.objective (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL,
    description VARCHAR ( 150 ),
    date DATETIME NOT NULL,
    points int NOT NULL
);

CREATE TABLE zeroexcusas1.levelobjective (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR ( 150 ),
    fk_level int NOT NULL,
    fk_objective int NOT NULL,
    FOREIGN KEY (fk_level)
      REFERENCES level (id),
    FOREIGN KEY (fk_objective)
      REFERENCES objective (id)
);

CREATE TABLE zeroexcusas1.score (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    points int NOT NULL,
    fk_levelobjective int NOT NULL,
    fk_user int NOT NULL,
    FOREIGN KEY (fk_levelobjective)
      REFERENCES levelobjective (id),
    FOREIGN KEY (fk_user)
      REFERENCES user (id)
);