insert into stadium (stadium_name, stadium_created_at) values ('사직',now());
insert into stadium (stadium_name, stadium_created_at) values ('잠실',now());
insert into stadium (stadium_name, stadium_created_at) values ('고척',now());

insert into team (stadium_id, team_name, team_created_at) values (1, '롯데',now());
insert into team (stadium_id, team_name, team_created_at) values (2, '두산',now());
insert into team (stadium_id, team_name, team_created_at) values (3, '키움',now());


INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '박권수', '좌익수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '안권수', '우익수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '김민수', '1루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '김권수', '2루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '정권수', '3루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '손성빈', '포수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '김진욱', '투수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '박진욱', '유격수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (1, '김진수', '중견수', now());

INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '박권', '좌익수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '안권', '우익수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '김민', '1루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '김권', '2루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '정권', '3루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '손성', '포수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '김진', '투수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '박진', '유격수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (2, '김진', '중견수', now());

INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '박수', '좌익수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '안수', '우익수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '김수', '1루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '김수', '2루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '정수', '3루수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '손빈', '포수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '김욱', '투수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '박욱', '유격수', now());
INSERT INTO player (team_id, player_name, player_position, player_created_at) VALUES (3, '김수', '중견수', now());