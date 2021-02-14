CREATE TABLE IF NOT EXISTS tweets_data
(
  `id` BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR (200) NOT NULL,
  `tweet` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS top_hash_Tags
(
    `id` BIGINT(20)  NOT NULL AUTO_INCREMENT,
    `hash_tag` VARCHAR(200) NOT NULL,
    `frequency` BIGINT(20) NOT NULL,
    PRIMARY KEY(id),
    UNIQUE (hash_tag)
);