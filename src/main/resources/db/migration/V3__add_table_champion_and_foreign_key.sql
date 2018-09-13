CREATE TABLE champion (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ability_power DOUBLE,
  attack_power DOUBLE,
  name VARCHAR(100),
  user_id BIGINT NOT NULL REFERENCES user(id)
) ;