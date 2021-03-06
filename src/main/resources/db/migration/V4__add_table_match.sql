CREATE TABLE game_match (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  match_date TIMESTAMP,
  loser_id BIGINT NOT NULL REFERENCES champion(id),
  winner_id BIGINT NOT NULL REFERENCES champion(id)
) ;

CREATE TABLE role (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR(100)
) ;

CREATE TABLE user_role (
  user_id BIGINT NOT NULL REFERENCES user(id),
  role_id BIGINT NOT NULL REFERENCES role(id)
) ;