CREATE TABLE "rest_server"
(
    "id"          integer NOT NULL PRIMARY KEY AUTOINCREMENT,
    "create_date" DATE,
    "update_date" DATE,
    "args"        TEXT,
    "data"        TEXT,
    "data_type"   TEXT    NOT NULL
);

CREATE
INDEX "idx_args"
ON "rest_server" (
  "args"
);

CREATE
INDEX "idx_data"
ON "rest_server" (
  "data"
);

CREATE
INDEX "idx_data_type"
ON "rest_server" (
  "data_type"
);
