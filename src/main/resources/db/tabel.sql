
CREATE TABLE stadium (
                         stadium_id int primary key auto_increment,
                         stadium_name varchar(10),
                         stadium_created_at timestamp
);

CREATE TABLE team (
                      team_id int primary key auto_increment,
                      stadium_id int,
                      team_name varchar(10),
                      team_created_at timestamp
);

CREATE TABLE player (
                        player_id int primary key auto_increment,
                        team_id int,
                        player_name varchar(10),
                        player_position varchar(10),
                        player_created_at timestamp
);

CREATE TABLE out_player (
                            out_player_id int primary key auto_increment,
                            player_id int,
                            out_player_reason varchar(10),
                            out_player_created_at timestamp
);