CREATE TABLE game_match (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  champion_winner_id_fk BIGINT NOT NULL REFERENCES champion(id),
  champion_loser_id_fk BIGINT NOT NULL REFERENCES champion(id)
) ;