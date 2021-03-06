drop table if exists file_meta;

CREATE TABLE IF NOT EXISTS file_meta (
  id            INTEGER PRIMARY KEY AUTOINCREMENT,
  name          VARCHAR(50)   NOT NULL,
  path          VARCHAR(1000) NOT NULL,
  size          BIGINT        NOT NULL,
  is_directory  BOOLEAN        NOT NULL,
  pinyin        VARCHAR(50),
  pinyin_first  VARCHAR(50),
  last_modified TIMESTAMP     NOT NULL
);