CREATE TABLE champion (
  id BIGINT NOT NULL AUTO_INCREMENT,
  attack_power DOUBLE,
  ability_power DOUBLE,
  name VARCHAR(100),
  PRIMARY KEY (id),
  user_id_fk BIGINT NOT NULL REFERENCES user(id)
) ;