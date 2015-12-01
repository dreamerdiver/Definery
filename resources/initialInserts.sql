insert into entries values ('word', 'part_of_speech', 'pronunciation', 'pocket_definition', 'complete_definition', 'example_usage', 'variations', 'etymology_roots', 'submitter', NOW(), 0);

insert into entries values ('Assetious', 'adjective', 'as-see-SH-es', 'valuable; beneficial', 'Having the characteristics of an asset; to be of considerable value', 'Unique new skills made her an assetious addition to the team', 'assetiously', 'From Latin; see asset', 'meesh', NOW(), 0);

insert into entries values ('Begrin', 'verb', 'bee-grihn', 'to delight; please', 'To make (someone) smile; to bring happiness out in (someone)', 'His kind words begrin me.', 'begrint; begrinning', 'From Old English', 'meesh', NOW(), 0);

insert into entries values ('Inoften', 'adverb', 'in-awf-tuhn', 'seldom; infrequent', 'Not often', 'His attendance is inoften, and his grades reflect it', 'inoftenly', 'From Middle English', 'meesh', NOW(), 0);

insert into entries values ('Aquiescence', 'noun', 'ah-kwee-ES-sens', 'waterlike', 'The behavior appearance or qualities of liquid water', 'The undulating ripples in panes of old glass give them a sort of acquiescence', 'aquiesce; aquiescent', 'From Latin', 'meesh', NOW(), 0);

insert into entries values ('Benipitence', 'noun', 'beh-nip-eh-tens', 'aiming at goodness', 'The seeking of beauty in the substance and situations of everyday life; an unyielding search for goodness', 'The old man claimed that the secret to living a happy life is persistent benipitence', 'benipitent; benipitate; benipitant', 'From Latin', 'meesh', NOW(), 0);

insert into entries values ('Sonuphile', 'noun', 'sahn-yoo-fil', 'Lover of sound', 'A person with a fondness or affinity for any sound, including natural, industrial or musical', 'The sort of rhythmic trance that ensued when surrounded by the harmonic din of the subway station was a sure sign that she was a sonuphile', 'sonuphilic', 'From Latin', 'meesh', NOW(), 0);

insert into entries values ('Obtinence', 'noun', 'ahb-teh-nens', 'acquisition; claim', 'The process of obtaining (something)', 'The obtinence of wealth or fame does not equal happiness', 'obtinant', 'See obtain', 'meesh', NOW(), 0);

insert into entries values ('Lumiphile', 'part_of_speech', 'pronunciation', 'pocket_definition', 'complete_definition', 'example_usage', 'variations', 'etymology_roots', 'meesh', NOW(), 0);

insert into entries values ('Turnt', 'part_of_speech', 'pronunciation', 'pocket_definition', 'complete_definition', 'example_usage', 'variations', 'etymology_roots', 'meesh', NOW(), 0);

insert into entries values ('Explicite', 'part_of_speech', 'pronunciation', 'pocket_definition', 'complete_definition', 'example_usage', 'variations', 'etymology_roots', 'meesh', NOW(), 0);



CREATE TABLE entries
(
  word VARCHAR(30) PRIMARY KEY NOT NULL,
  part_of_speech VARCHAR(30),
  pronunciation VARCHAR(40),
  pocket_definition VARCHAR(50),
  complete_definition VARCHAR(200),
  example_usage VARCHAR(200),
  variations VARCHAR(70),
  etymology_roots VARCHAR(70),
  submitter VARCHAR(50),
  submitted_date DATE,
  vote_count INT
);
CREATE TABLE user_data
(
  account_age INT,
  submitted_entries LONGTEXT,
  user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  voted_entries LONGTEXT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (user_id)
);
CREATE UNIQUE INDEX unique_user_id ON user_data (user_id);
CREATE TABLE user_roles
(
  user_role VARCHAR(15),
  user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  FOREIGN KEY (user_id) REFERENCES users (user_id)
);
CREATE UNIQUE INDEX unique_user_id ON user_roles (user_id);
CREATE TABLE users
(
  user_name VARCHAR(15) NOT NULL,
  user_pass VARCHAR(15) NOT NULL,
  user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT
);
CREATE UNIQUE INDEX unique_user_id ON users (user_id);
